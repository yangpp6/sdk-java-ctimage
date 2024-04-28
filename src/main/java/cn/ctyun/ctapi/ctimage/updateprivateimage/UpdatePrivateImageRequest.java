package cn.ctyun.ctapi.ctimage.updateprivateimage;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import cn.ctyun.ctapi.CTRequest;
import cn.ctyun.ctapi.CTFile;

/**
 * <一类节点-*-镜像服务ctimage-修改私有镜像属性>
 * Request: UpdatePrivateImageRequest
 */
public class UpdatePrivateImageRequest extends CTRequest {
    public UpdatePrivateImageRequest() {
        super("POST", "application/json", "/v4/image/update");
    }

    /**
     * set body entity
     * @param body body实体类
     * @return this
     */
    public UpdatePrivateImageRequest withBody(UpdatePrivateImageRequestBody body) {
        this.body = body;
        return this;
    }
}
