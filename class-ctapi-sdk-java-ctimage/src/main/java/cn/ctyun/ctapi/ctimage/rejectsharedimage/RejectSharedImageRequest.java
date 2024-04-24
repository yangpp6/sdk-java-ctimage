package cn.ctyun.ctapi.ctimage.rejectsharedimage;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import cn.ctyun.ctapi.CTRequest;
import cn.ctyun.ctapi.CTFile;

/**
 * <一类节点-*-镜像服务ctimage-拒绝共享镜像>
 * Request: RejectSharedImageRequest
 */
public class RejectSharedImageRequest extends CTRequest {
    public RejectSharedImageRequest() {
        super("POST", "application/json", "/v4/image/shared-image/reject");
    }

    /**
     * set body entity
     * @param body body实体类
     * @return this
     */
    public RejectSharedImageRequest withBody(RejectSharedImageRequestBody body) {
        this.body = body;
        return this;
    }
}
