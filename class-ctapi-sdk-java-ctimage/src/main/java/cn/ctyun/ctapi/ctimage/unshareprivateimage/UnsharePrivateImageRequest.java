package cn.ctyun.ctapi.ctimage.unshareprivateimage;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import cn.ctyun.ctapi.CTRequest;
import cn.ctyun.ctapi.CTFile;

/**
 * <一类节点-*-镜像服务ctimage-取消共享私有镜像>
 * Request: UnsharePrivateImageRequest
 */
public class UnsharePrivateImageRequest extends CTRequest {
    public UnsharePrivateImageRequest() {
        super("POST", "application/json", "/v4/image/shared-image/delete");
    }

    /**
     * set body entity
     * @param body body实体类
     * @return this
     */
    public UnsharePrivateImageRequest withBody(UnsharePrivateImageRequestBody body) {
        this.body = body;
        return this;
    }
}
