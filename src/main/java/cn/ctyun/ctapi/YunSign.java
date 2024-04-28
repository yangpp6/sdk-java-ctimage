package cn.ctyun.ctapi;


import cn.ctyun.ctapi.httpWith.HttpDeleteWithBody;
import cn.ctyun.ctapi.httpWith.HttpGetWithEntity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.json.JSONException;
import org.json.XML;
import org.springframework.web.util.UriUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class YunSign {
    private static final int TEMP = 0; //0:绕过ssl证书   1：验证ssl证书

    private static final SimpleDateFormat TIME_FORMATTER = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");

    private static final char[] HEXES = {
            '0', '1', '2', '3',
            '4', '5', '6', '7',
            '8', '9', 'a', 'b',
            'c', 'd', 'e', 'f'
    };

    private String ak;
    private String sk;
    private String method;
    private String contentType;
    private String url;
    private String queryStr;
    private String afterQuery;//encode后的queryStr
    private Map<String, Object> headerMap;
    private String body;
    private byte[] bodyByteArr;
    private Map<String, Object> dataMap;//multipart/form-data 中使用
    private Map<String, Object> fileMap;//multipart/form-data 中使用
    private String uuId;

    private boolean getNoBodyMark = false;//get接口无body参数  不需要contentType

    public YunSign(String ak, String sk, String endingPoint, String uri, String method, String contentType, Map<String, Object> headerParam, Map<String, Object> queryParam, Object body, Map<String, Object> bodyParam, byte[] bodyByteArr) {
        if (body != null && !body.equals("")) {
            try {
                Map map = JSONObject.parseObject(JSON.toJSONString(body), HashMap.class);
                int num = 0;
                for (Object key : map.keySet()) {
                    num = num + 1;
                }
                if (num == 1) {
                    if (map.get("parame") != null) {
                        body = map.get("parame");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        this.ak = ak;

        this.sk = sk;

        String hostPoint[] = endingPoint.split(":");
        String afterPoint = hostPoint[0].replaceAll("\\.", "");
        Pattern pattern = Pattern.compile("^[\\d]+$");
        if (pattern.matcher(afterPoint).matches()) {
            this.url = "http://" + endingPoint + uri;
        } else {
            this.url = "https://" + endingPoint + uri;
        }

        this.method = method;

        this.contentType = contentType;

        if (headerParam != null) {
            this.headerMap = headerParam;
        }
        this.headerMap.put("User-Agent", "Mozilla/5.0(javasdk)");

        String queryStr = "";
        if (queryParam != null) {
            for (String key : queryParam.keySet()) {
                queryStr += key + "=" + queryParam.get(key) + "&";
            }
            if (queryStr.length() > 0) {
                queryStr = queryStr.substring(0, queryStr.length() - 1);
            }
        }
        this.queryStr = queryStr;

        this.uuId = UUID.randomUUID().toString();

        switch (contentType) {
            case "application/xml":
                if (body != null && !body.equals("")) {
                    String xmlBody = "";
                    List<Element> elements = null;
                    try {
                        ObjectMapper xmlMapper = new XmlMapper();
                        xmlBody = xmlMapper.writeValueAsString(body);
                        Document document = DocumentHelper.parseText(xmlBody);
                        Element rootElement = document.getRootElement();
                        Iterator<Node> it = rootElement.nodeIterator();
                        String nodeName = "";
                        while (it.hasNext()) {
                            Node node = it.next();
                            nodeName = node.getName();
                            break;
                        }
                        elements = rootElement.elements(nodeName);
                        if (elements.size() > 0) {
                            xmlBody = elements.get(0).asXML();
                        }
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }
                    this.body = xmlBody;
                } else {
                    this.body = "";
                }
                break;
            case "application/json":
                if (body != null && !body.equals("")) {
                    this.body = JSON.toJSONString(body);
                } else {
                    this.body = "";
                }
                break;
            case "application/x-www-form-urlencoded":
                String bodyStr = "";
                if (bodyParam != null) {
                    for (String key : bodyParam.keySet()) {
                        bodyStr += key + "=" + bodyParam.get(key) + "&";
                    }
                    if (bodyStr.length() > 0) {
                        bodyStr = bodyStr.substring(0, bodyStr.length() - 1);
                    }
                }
                this.body = bodyStr;
                break;
            case "multipart/form-data":
                if (bodyParam != null) {
                    Map<String, Object> ctFilesParama = new HashMap();
                    Map<String, Object> bodyParama = new HashMap();
                    for (String key : bodyParam.keySet()) {
                        if (bodyParam.get(key) instanceof CTFile) {
                            CTFile ctFile = JSONObject.parseObject(JSONObject.toJSONString(bodyParam.get(key)), CTFile.class);
                            if (ctFile.getPath() != null && !ctFile.getPath().equals("")) {
                                ctFilesParama.put(key, bodyParam.get(key));
                            } else {
                                bodyParama.put(key, bodyParam.get(key));
                            }
                        } else {
                            bodyParama.put(key, bodyParam.get(key));
                        }
                    }
                    this.dataMap = bodyParama;
                    this.fileMap = ctFilesParama;
                }
                break;
            case "application/octet-stream":
                if (body != null && !body.equals("")) {
                    Map bodyMap = JSONObject.parseObject(JSONObject.toJSONString(body), Map.class);
                    StringBuffer bodyStream = new StringBuffer();
                    if (bodyMap != null) {
                        for (Object key : bodyMap.keySet()) {
                            bodyStream.append(key + "=" + bodyMap.get(key) + "&");
                        }
                        if (bodyStream.length() > 0) {
                            this.body = bodyStream.substring(0, bodyStream.length() - 1);
                        }
                    } else {
                        this.body = "";
                    }
                } else {
                    this.body = "";
                }
                break;
            default:
                this.bodyByteArr = bodyByteArr;
        }
    }

    public <T> CTResponse<T> toDo(Class<T> clazz) {
        return closeableHttpClient(clazz);
    }


    private String getSign(Date eopDate) {
        String calculateContentHash = getSHA256(body, bodyByteArr); //报文原封不动进行sha256摘要
//        System.out.println("calculateContentHash:" + calculateContentHash);

        SimpleDateFormat TIME_FORMATTER = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");

        SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyyMMdd");

        String singerDate = TIME_FORMATTER.format(eopDate);

        String singerDd = DATE_FORMATTER.format(eopDate);

        //header的key按照26字母进行排序, 以&作为连接符连起来
        try {
            String CampmocalHeader = String.format("ctyun-eop-request-id:%s\neop-date:%s\n", this.uuId, singerDate);

            String sigture = CampmocalHeader + "\n" + this.afterQuery + "\n" + calculateContentHash;
//            System.out.println("sigture:" + sigture);

            byte[] ktime = HmacSHA256(singerDate.getBytes(), sk.getBytes());
//            System.out.println("ktime:" + bytes2Hex(ktime));
            byte[] kAk = HmacSHA256(ak.getBytes(), ktime);
//            System.out.println("kAk:" + bytes2Hex(kAk));
            byte[] kdate = HmacSHA256(singerDd.getBytes(), kAk);
//            System.out.println("kdate:" + bytes2Hex(kdate));

            String Signature = Base64.getEncoder().encodeToString(HmacSHA256(sigture.getBytes("UTF-8"), kdate));
//            System.out.println("---Signature:" + Signature);
            String signHeader = String.format("%s Headers=ctyun-eop-request-id;eop-date Signature=%s", ak, Signature);
//            System.out.println("---signHeader:" + signHeader);
            return signHeader;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getSignByByMultipartFormDataBoundary(Date eopDate, byte[] bodyArr) {
        String calculateContentHash = getSHA256(bodyArr);
//        System.out.println("calculateContentHash:" + calculateContentHash);

        SimpleDateFormat TIME_FORMATTER = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");

        SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyyMMdd");

        String singerDate = TIME_FORMATTER.format(eopDate);

        String singerDd = DATE_FORMATTER.format(eopDate);

        //header的key按照26字母进行排序, 以&作为连接符连起来
        try {
            String CampmocalHeader = String.format("ctyun-eop-request-id:%s\neop-date:%s\n", this.uuId, singerDate);

            String sigture = CampmocalHeader + "\n" + this.afterQuery + "\n" + calculateContentHash;
//            System.out.println("sigture:" + sigture);

            byte[] ktime = HmacSHA256(singerDate.getBytes(), sk.getBytes());
//            System.out.println("ktime:" + bytes2Hex(ktime));
            byte[] kAk = HmacSHA256(ak.getBytes(), ktime);
//            System.out.println("kAk:" + bytes2Hex(kAk));
            byte[] kdate = HmacSHA256(singerDd.getBytes(), kAk);
//            System.out.println("kdate:" + bytes2Hex(kdate));

            String signature = Base64.getEncoder().encodeToString(HmacSHA256(sigture.getBytes("UTF-8"), kdate));
//            System.out.println("---Signature:" + signature);
            String signHeader = String.format("%s Headers=ctyun-eop-request-id;eop-date Signature=%s", ak, signature);
//            System.out.println("---signHeader:" + signHeader);
            return signHeader;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static CloseableHttpClient sslClient() {
        try {
            // 在调用SSL之前需要重写验证方法，取消检测SSL
            X509TrustManager trustManager = new X509TrustManager() {
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkClientTrusted(X509Certificate[] xcs, String str) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] xcs, String str) {
                }
            };
            SSLContext ctx = SSLContext.getInstance(SSLConnectionSocketFactory.TLS);
            ctx.init(null, new TrustManager[]{trustManager}, null);
            SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(ctx, NoopHostnameVerifier.INSTANCE);
            // 创建Registry
            RequestConfig requestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD_STRICT)
                    .setExpectContinueEnabled(Boolean.TRUE).setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST))
                    .setProxyPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC)).build();
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.INSTANCE)
                    .register("https", socketFactory).build();
            // 创建ConnectionManager，添加Connection配置信息
            PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            CloseableHttpClient closeableHttpClient = HttpClients.custom().setConnectionManager(connectionManager)
                    .setDefaultRequestConfig(requestConfig).build();
            return closeableHttpClient;
        } catch (KeyManagementException ex) {
            throw new RuntimeException(ex);
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }

    public <T> CTResponse<T> closeableHttpClient(Class<T> clazz) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        CTResponse<T> result = new CTResponse<T>();
        try {
            Date eopDate = new Date();
            // 设置配置请求参数
            RequestConfig requestConfig = RequestConfig.custom().build();
            // 通过址默认配置创建一个httpClient实例
            if (TEMP == 0) {//绕过SSL
                httpClient = sslClient();
            } else {
                httpClient = HttpClients.createDefault();
            }
            String query = this.queryStr;
            this.afterQuery = encodeQueryStr(query);

            switch (method.toUpperCase()) {
                case "POST":
                    if (this.contentType.equals("multipart/form-data")) {
                        response = postByMultipartFormDataBoundary(eopDate, requestConfig, httpClient);
                    } else {
                        response = httpPost(eopDate, requestConfig, httpClient);
                    }
                    break;
                case "GET":
                    if (this.body != null && !this.body.equals("")) {
                        response = httpGetWithEntity(eopDate, requestConfig, httpClient);
                    } else {
                        getNoBodyMark = true;
                        response = httpGet(eopDate, requestConfig, httpClient);
                    }
                    break;
                case "DELETE":
                    if (this.body != null && !this.body.equals("")) {
                        response = httpDeleteWithBody(eopDate, requestConfig, httpClient);
                    } else {
                        response = httpDelete(eopDate, requestConfig, httpClient);
                    }
                    break;
                case "PUT":
                    response = httpPut(eopDate, requestConfig, httpClient);
                    break;
                case "PATCH":
                    response = httpPatch(eopDate, requestConfig, httpClient);
                    break;
                case "HEAD":
                    response = httpHead(eopDate, requestConfig, httpClient);
                    break;
                case "OPTIONS":
                    response = httpOptions(eopDate, requestConfig, httpClient);
                    break;
            }
            // 通过返回对象获取返回数据
            HttpEntity entity = response.getEntity();

            result.setHttpCode(response.getStatusLine().getStatusCode());
            Map<String, String> headerMap = new HashMap<String, String>();
            for (Header header : response.getAllHeaders()) {
                headerMap.put(header.getName(), header.getValue());
            }
            result.setHeaders(headerMap);

            if (entity != null) {
                String entityStr = EntityUtils.toString(entity, "UTF-8");
                if (entityStr != null && entityStr.length() > 0) {
                    try {
                        if (entityStr.startsWith("<") && entityStr.endsWith(">")) {
                            T t = convertXmlIntoJSONObject(entityStr, clazz);
                            result.setData(t);
                        } else if (entityStr.startsWith("{") && entityStr.endsWith("}")) {
                            T t = JSONObject.parseObject(entityStr, clazz);
                            result.setData(t);
                        } else {
                            result.setByteArr(entityStr.getBytes());
                        }
                    } catch (Exception e) {
                        result.setData(null);
                        result.setByteArr(entityStr.getBytes());
                    }
                } else {
                    result.setData(null);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != response) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public CloseableHttpResponse httpGet(Date eopDate, RequestConfig requestConfig, CloseableHttpClient httpClient) throws IOException {
        CloseableHttpResponse response = null;
        HttpGet httpGet;
        if (this.afterQuery != null && !this.afterQuery.equals("")) {
            httpGet = new HttpGet(this.url + "?" + this.afterQuery);
        } else {
            httpGet = new HttpGet(this.url);
        }
        Header[] headers = getHeaderBySign(eopDate);
        httpGet.setHeaders(headers);

        httpGet.setConfig(requestConfig);
        response = httpClient.execute(httpGet);
        return response;
    }

    public CloseableHttpResponse httpGetWithEntity(Date eopDate, RequestConfig requestConfig, CloseableHttpClient httpClient) throws IOException {
        CloseableHttpResponse response = null;
        HttpGetWithEntity httpGetWithEntity;
        if (this.afterQuery != null && !this.afterQuery.equals("")) {
            httpGetWithEntity = new HttpGetWithEntity(this.url + "?" + this.afterQuery);
        } else {
            httpGetWithEntity = new HttpGetWithEntity(this.url);
        }

        Header[] headers = getHeaderBySign(eopDate);
        httpGetWithEntity.setHeaders(headers);

        httpGetWithEntity.setConfig(requestConfig);

        HttpEntity httpEntity = new StringEntity(body, Charset.forName("UTF-8"));
        httpGetWithEntity.setEntity(httpEntity);
        return response;
    }

    public CloseableHttpResponse httpPost(Date eopDate, RequestConfig requestConfig, CloseableHttpClient httpClient) throws IOException {
        CloseableHttpResponse response = null;
        HttpPost httpPost;
        if (this.afterQuery != null && !this.afterQuery.equals("")) {
            httpPost = new HttpPost(this.url + "?" + this.afterQuery);
        } else {
            httpPost = new HttpPost(this.url);
        }
        httpPost.setConfig(requestConfig);

        Header[] headers = getHeaderBySign(eopDate);
        httpPost.setHeaders(headers);

        StringEntity data = new StringEntity(body, Charset.forName("UTF-8"));
        httpPost.setEntity(data);
        response = httpClient.execute(httpPost);
        return response;
    }

    public CloseableHttpResponse postByMultipartFormDataBoundary(Date eopDate, RequestConfig requestConfig, CloseableHttpClient httpClient) throws IOException {
        CloseableHttpResponse response = null;
        HttpPost httpPost;
        if (this.afterQuery != null && !this.afterQuery.equals("")) {
            httpPost = new HttpPost(this.url + "?" + this.afterQuery);
        } else {
            httpPost = new HttpPost(this.url);
        }
        httpPost.setConfig(requestConfig);

        HttpEntity data = null;
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        //获取文件key名称、路径
        for (String key : this.fileMap.keySet()) {
            CTFile ctFile = JSONObject.parseObject(JSONObject.toJSONString(this.fileMap.get(key)), CTFile.class);
            File file = new File(ctFile.getPath());
            if (file.isFile() && file.exists()) {
                FileBody fileBody = new FileBody(file);
                builder.addPart(key, fileBody);
            }
        }
        for (Object key : this.dataMap.keySet()) {
            builder.addTextBody(key.toString(), this.dataMap.get(key).toString());
        }

        data = builder.build();

        //拼接加密body
        List<byte[]> byteList = new ArrayList<>();

        String contentType = data.getContentType().getValue();
        String boundary = contentType.substring(contentType.indexOf("=") + 1);
        boundary = boundary.split(";")[0];
        //获取boundary 进行加密
        boundary = "--" + boundary;

        for (String key : this.fileMap.keySet()) {
            CTFile ctFile = JSONObject.parseObject(JSONObject.toJSONString(this.fileMap.get(key)), CTFile.class);
            File file = new File(ctFile.getPath());
            if (file.isFile() && file.exists()) {
                long size = file.length();
                if (size >= 1048576) {// 文件大小限制 1048576bytes = 1024kb = 1M
                    System.out.println("----------------文件过大----------------");
                }

                String body1 = boundary + "\r\n" +
                        "Content-Disposition: form-data; name=\"" + key + "\"; filename=\"" + file.getName() + "\"\r\n" +
                        "Content-Type: application/octet-stream" + "\r\n" + "\r\n";
                String body3 = "\r\n";
                byte[] order1 = body1.getBytes();
                byte[] order2 = readByte(ctFile.getPath());
                byte[] order3 = body3.getBytes();

                byte[] bodyArr = new byte[order1.length + order2.length + order3.length];
                for (int i = 0; i < order1.length; i++) {
                    bodyArr[i] = order1[i];
                }
                for (int i = 0; i < order2.length; i++) {
                    bodyArr[order1.length + i] = order2[i];
                }
                for (int i = 0; i < order3.length; i++) {
                    bodyArr[order1.length + order2.length + i] = order3[i];
                }
                byteList.add(bodyArr);
            }
        }

        Integer lengths = 0;
        for (byte[] b : byteList) {
            lengths += b.length;
        }

        byte[] bodyArrs = new byte[lengths];
        int num = 0;
        for (byte[] list : byteList) {
            for (int j = 0; j < list.length; j++) {
                bodyArrs[num] = list[j];
                num = num + 1;
            }
        }
        System.out.println("bodyArrs 总长度:" + bodyArrs.length);


        //dataMap值拼接
        StringBuffer dataStr = new StringBuffer();
        if (this.dataMap != null && this.dataMap.size() > 0) {
            for (Object key : this.dataMap.keySet()) {
                String body = "Content-Disposition: form-data; name=\"" + key + "\"\r\n" + "\r\n";
                String nameVal = this.dataMap.get(key).toString() + "\r\n";

                dataStr.append(boundary + "\r\n");
                dataStr.append(body);
                dataStr.append(nameVal);
            }
            System.out.println("dataStr长度:" + dataStr.length());
        }
        byte[] dataStrByte = dataStr.toString().getBytes();

        //结尾
        String body4 = boundary + "--\r\n";
        byte[] order4 = body4.getBytes();
        System.out.println("order4 长度:" + order4.length);

        //拼接最终的值（头 文件内容  data内容 尾）
        byte[] lastBodyArr = new byte[bodyArrs.length + dataStrByte.length + order4.length];
        for (int i = 0; i < bodyArrs.length; i++) {
            lastBodyArr[i] = bodyArrs[i];
        }
        for (int i = 0; i < dataStrByte.length; i++) {
            lastBodyArr[bodyArrs.length + i] = dataStrByte[i];
        }
        for (int i = 0; i < order4.length; i++) {
            lastBodyArr[bodyArrs.length + dataStrByte.length + i] = order4[i];
        }
        System.out.println("lastBodyArr 长度:" + lastBodyArr.length);

        Header[] headers = setHeaderBypostMultipartFormDataBoundary(eopDate, lastBodyArr);
        httpPost.setHeaders(headers);

        httpPost.setEntity(data);

        response = httpClient.execute(httpPost);
        return response;
    }

    public CloseableHttpResponse httpDelete(Date eopDate, RequestConfig requestConfig, CloseableHttpClient httpClient) throws IOException {
        CloseableHttpResponse response = null;
        HttpDelete httpDelete;
        if (this.afterQuery != null && !this.afterQuery.equals("")) {
            httpDelete = new HttpDelete(this.url + "?" + this.afterQuery);
        } else {
            httpDelete = new HttpDelete(this.url);
        }
        httpDelete.setConfig(requestConfig);

        Header[] headers = getHeaderBySign(eopDate);
        httpDelete.setHeaders(headers);

        response = httpClient.execute(httpDelete);
        return response;
    }

    public CloseableHttpResponse httpDeleteWithBody(Date eopDate, RequestConfig requestConfig, CloseableHttpClient httpClient) throws IOException {
        CloseableHttpResponse response = null;
        HttpDeleteWithBody httpDeleteWithBody;
        if (this.afterQuery != null && !this.afterQuery.equals("")) {
            httpDeleteWithBody = new HttpDeleteWithBody(this.url + "?" + this.afterQuery);
        } else {
            httpDeleteWithBody = new HttpDeleteWithBody(this.url);
        }
        httpDeleteWithBody.setConfig(requestConfig);

        Header[] headers = getHeaderBySign(eopDate);
        httpDeleteWithBody.setHeaders(headers);

        HttpEntity httpEntity = new StringEntity(body, Charset.forName("UTF-8"));
        httpDeleteWithBody.setEntity(httpEntity);

        response = httpClient.execute(httpDeleteWithBody);
        return response;
    }

    public CloseableHttpResponse httpPut(Date eopDate, RequestConfig requestConfig, CloseableHttpClient httpClient) throws IOException {
        CloseableHttpResponse response = null;
        HttpPut httpPut;
        if (this.afterQuery != null && !this.afterQuery.equals("")) {
            httpPut = new HttpPut(this.url + "?" + this.afterQuery);
        } else {
            httpPut = new HttpPut(this.url);
        }
        httpPut.setConfig(requestConfig);

        Header[] headers = getHeaderBySign(eopDate);
        httpPut.setHeaders(headers);

        StringEntity data = new StringEntity(body, Charset.forName("UTF-8"));
        httpPut.setEntity(data);

        response = httpClient.execute(httpPut);
        return response;
    }

    public CloseableHttpResponse httpPatch(Date eopDate, RequestConfig requestConfig, CloseableHttpClient httpClient) throws IOException {
        CloseableHttpResponse response = null;
        HttpPatch httpPatch;
        if (this.afterQuery != null && !this.afterQuery.equals("")) {
            httpPatch = new HttpPatch(this.url + "?" + this.afterQuery);
        } else {
            httpPatch = new HttpPatch(this.url);
        }
        httpPatch.setConfig(requestConfig);

        Header[] headers = getHeaderBySign(eopDate);
        httpPatch.setHeaders(headers);

        StringEntity data = new StringEntity(body, Charset.forName("UTF-8"));
        httpPatch.setEntity(data);

        response = httpClient.execute(httpPatch);
        return response;
    }

    public CloseableHttpResponse httpHead(Date eopDate, RequestConfig requestConfig, CloseableHttpClient httpClient) throws IOException {
        CloseableHttpResponse response = null;
        HttpHead httpHead;
        if (this.afterQuery != null && !this.afterQuery.equals("")) {
            httpHead = new HttpHead(this.url + "?" + this.afterQuery);
        } else {
            httpHead = new HttpHead(this.url);
        }

        Header[] headers = getHeaderBySign(eopDate);
        httpHead.setHeaders(headers);

        httpHead.setConfig(requestConfig);
        response = httpClient.execute(httpHead);
        return response;
    }

    public CloseableHttpResponse httpOptions(Date eopDate, RequestConfig requestConfig, CloseableHttpClient httpClient) throws IOException {
        CloseableHttpResponse response = null;
        HttpOptions httpOptions;
        if (this.afterQuery != null && !this.afterQuery.equals("")) {
            httpOptions = new HttpOptions(this.url + "?" + this.afterQuery);
        } else {
            httpOptions = new HttpOptions(this.url);
        }

        Header[] headers = getHeaderBySign(eopDate);
        httpOptions.setHeaders(headers);

        httpOptions.setConfig(requestConfig);
        response = httpClient.execute(httpOptions);
        return response;
    }

    public Header[] getHeaderBySign(Date eopDate) {
        Header[] headerResult;
        Map<String, Object> headerMap = new HashMap<>();
        if (!getNoBodyMark) {
            headerMap.put("Content-Type", this.contentType);
        }
        headerMap.put("ctyun-eop-request-id", this.uuId);
        headerMap.put("Eop-Authorization", getSign(eopDate));
        headerMap.put("Eop-date", TIME_FORMATTER.format(eopDate));
        if (this.headerMap != null) {
            for (String key : this.headerMap.keySet()) {
                headerMap.put(key, this.headerMap.get(key).toString());
            }
        }
        headerResult = new Header[headerMap.size()];
        int num = 0;
        System.out.println("请求头部 ----- ");
        for (String key : headerMap.keySet()) {
            BasicHeader basicHeader = new BasicHeader(key, headerMap.get(key).toString());
            headerResult[num] = basicHeader;
            num = num + 1;
            System.out.println(key + ":" + headerMap.get(key).toString());
        }
        System.out.println();
        return headerResult;
    }

    public Header[] setHeaderBypostMultipartFormDataBoundary(Date eopDate, byte[] lastBodyArr) {
        Header[] headerResult;
        Map<String, Object> headers = new HashMap<>();
        headers.put("ctyun-eop-request-id", this.uuId);
        headers.put("Eop-Authorization", getSignByByMultipartFormDataBoundary(eopDate, lastBodyArr));
        headers.put("Eop-date", TIME_FORMATTER.format(eopDate));
        if (this.headerMap != null) {
            for (String key : this.headerMap.keySet()) {
                headers.put(key, this.headerMap.get(key).toString());
            }
        }
        headerResult = new Header[headers.size()];
        int num = 0;
        for (String key : headers.keySet()) {
            BasicHeader basicHeader = new BasicHeader(key, headers.get(key).toString());
            headerResult[num] = basicHeader;
            num = num + 1;
            System.out.println("请求头部 ----- ");
            System.out.println(key + ":" + headers.get(key).toString());
        }
        System.out.println();
        return headerResult;
    }

    private String toHex(byte[] data) {
        StringBuilder sb = new StringBuilder(data.length * 2);
        byte[] var2 = data;
        int var3 = data.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            byte b = var2[var4];
            String hex = Integer.toHexString(b);
            if (hex.length() == 1) {
                sb.append("0");
            } else if (hex.length() == 8) {
                hex = hex.substring(6);
            }

            sb.append(hex);
        }

        return sb.toString().toLowerCase(Locale.getDefault());
    }

    private String getSHA256(String text, byte[] bodyByteArr) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            if (bodyByteArr != null && bodyByteArr.length > 0) {
                md.update(bodyByteArr);
            } else {
                md.update(text.getBytes());
            }
            return toHex(md.digest());
        } catch (NoSuchAlgorithmException var3) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private String getSHA256(byte[] byteArr) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(byteArr);
            return toHex(md.digest());
        } catch (NoSuchAlgorithmException var3) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public byte[] HmacSHA256(byte[] data, byte[] key) throws Exception {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(key, "HmacSHA256"));
            return mac.doFinal(data);
        } catch (Exception e) {
            return null;
        }
    }

    public String encodeQueryStr(String query) {
        String afterQuery = "";
        try {
            if (query != null && !query.equals("")) {
                String param[] = query.split("&");
                Arrays.sort(param);
                for (String str : param) {
                    if (str.contains("=")) {
                        String[] s = str.split("=");
                        String encodeStr = "";
                        if (s.length == 2) {
                            encodeStr = UriUtils.encode(s[1], "utf-8");
                        }
                        String lastStr = s[0] + "=" + encodeStr;
                        afterQuery = afterQuery + "&" + lastStr;
                    } else {
                        afterQuery = afterQuery + "&" + str;
                    }
                }
                afterQuery = afterQuery.substring(1, afterQuery.length());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return afterQuery;
    }

    private static byte[] readByte(String fileName) {
        String str = "";
        File file = new File(fileName);
        try {
            FileInputStream in = new FileInputStream(file);
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            in.close();
            str = new String(buffer, "utf-8");
            return buffer;
        } catch (IOException e) {
            return null;
        }
    }

    public static String bytes2Hex(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }

        StringBuilder hex = new StringBuilder();

        for (byte b : bytes) {
            hex.append(HEXES[(b >> 4) & 0x0F]);
            hex.append(HEXES[b & 0x0F]);
        }

        return hex.toString();
    }


    /**
     * 传入字符串格式的xml
     * 将xml格式<a/>装换成<a></a>
     * 再将xml装换成属性没有带"@"的JSONObject格式
     */
    public static <T> T convertXmlIntoJSONObject(String xml, Class<T> clazz) {
        try {
            Document xmlDocument = DocumentHelper.parseText(xml);
            OutputFormat format = new OutputFormat();
            format.setEncoding("UTF-8");
            format.setExpandEmptyElements(true);
            StringWriter out = new StringWriter();
            XMLWriter writer = new XMLWriter(out, format);
            try {
                writer.write(xmlDocument);
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //out.toString() 此结果为xml的<a></a>格式
            org.json.JSONObject jsonObject = XML.toJSONObject(out.toString());
            T t = JSONObject.parseObject(jsonObject.toString(), clazz);
            return t;
        } catch (DocumentException e1) {
            e1.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}


