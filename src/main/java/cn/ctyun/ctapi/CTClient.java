package cn.ctyun.ctapi;


public class CTClient {

    private Credential credential;
    private String endingPoint;

    public void init(Credential credential, String endingPoint) {
        this.credential = credential;
        this.endingPoint = endingPoint;
    }

    protected <T> CTResponse<T> request(CTRequest request, Class<T> clazz) {
        return  HttpUtils.request(credential, endingPoint, request, clazz);
    }


}
