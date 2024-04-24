package cn.ctyun.ctapi.ctimage.shareprivateimage;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import cn.ctyun.ctapi.CTRequest;
import cn.ctyun.ctapi.CTFile;

/**
 * <一类节点-*-镜像服务ctimage-共享私有镜像>
 * Request: SharePrivateImageRequest
 */
public class SharePrivateImageRequest extends CTRequest {
    public SharePrivateImageRequest() {
        super("POST", "application/json", "/v4/image/shared-image/create");
    }

    /**
     * set body entity
     * @param body body实体类
     * @return this
     */
    public SharePrivateImageRequest withBody(SharePrivateImageRequestBody body) {
        this.body = body;
        return this;
    }
}
