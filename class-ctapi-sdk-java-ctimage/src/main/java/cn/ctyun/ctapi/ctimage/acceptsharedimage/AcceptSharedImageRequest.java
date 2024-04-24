package cn.ctyun.ctapi.ctimage.acceptsharedimage;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import cn.ctyun.ctapi.CTRequest;
import cn.ctyun.ctapi.CTFile;

/**
 * <一类节点-*-镜像服务ctimage-接受共享镜像>
 * Request: AcceptSharedImageRequest
 */
public class AcceptSharedImageRequest extends CTRequest {
    public AcceptSharedImageRequest() {
        super("POST", "application/json", "/v4/image/shared-image/accept");
    }

    /**
     * set body entity
     * @param body body实体类
     * @return this
     */
    public AcceptSharedImageRequest withBody(AcceptSharedImageRequestBody body) {
        this.body = body;
        return this;
    }
}
