package cn.ctyun.ctapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CTRequest {
    protected String method;
    protected String contentType;
    protected String uri;
    protected Map<String, Object> uriParam = new HashMap();
    protected Map<String, Object> queryParam = new HashMap();
    protected Map<String, Object> headerParam = new HashMap();
    protected byte[] bodyByteArr;
    protected Map<String, Object> bodyParam = new HashMap();
    protected Object body;

    protected CTRequest(String method, String contentType, String uri) {
        this.method = method;
        this.contentType = contentType;
        this.uri = uri;
    }

    public String getMethod() {
        return method;
    }

    public String getContentType() {
        return contentType;
    }

    public Map<String, Object> getUriParam() {
        return uriParam;
    }

    public Map<String, Object> getQueryParam() {
        return queryParam;
    }

    public Map<String, Object> getHeaderParam() {
        return headerParam;
    }

    public byte[] getBodyByteArr() {
        return bodyByteArr;
    }

    public Map<String, Object> getBodyParam() {
        return bodyParam;
    }

    public Object getBody() {
        return body;
    }

    public String buildUri() {
        String ret = uri;
        String[] arr4Uri = uri.split("/");
        for (int i = 0; i < arr4Uri.length; i++) {
            String str = arr4Uri[i];
            if (str.length() > 2 && str.charAt(0) == '{' && str.charAt(str.length() - 1) == '}') {
                ret = ret.replace(str, uriParam.get(str.substring(1, str.length() - 1)).toString());
            }
        }
        return ret;
    }
}
