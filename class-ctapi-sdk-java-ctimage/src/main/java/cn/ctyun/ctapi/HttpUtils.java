package cn.ctyun.ctapi;

import java.util.Map;
public class HttpUtils {
    public static <T> CTResponse<T> request(Credential credential, String endingPoint, CTRequest request, Class<T> clazz) {
        YunSign sign = new YunSign(credential.getAk(), credential.getSk(), endingPoint, request.buildUri(), request.getMethod(), request.getContentType(), request.getHeaderParam(), request.getQueryParam(), request.getBody(), request.getBodyParam(),request.getBodyByteArr());

        CTResponse<T> response = sign.toDo(clazz);

//        System.out.println("应答头部 ----- ");
//        for (Map.Entry entry : response.getHeaders().entrySet()) {
//            System.out.println(entry.getKey().toString() + ":" + entry.getValue().toString());
//        }
//        System.out.println();
//        System.out.println("请求结果 ----- ");
//        System.out.println(response.getHttpCode());
//        System.out.println(response.getData());
        return response;
    }
}
