package cn.ctyun.ctapi.ctimage.deleteprivateimage;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import cn.ctyun.ctapi.CTRequest;
import cn.ctyun.ctapi.CTFile;

/**
 * <一类节点-*-镜像服务ctimage-删除私有镜像>
 * Request: DeletePrivateImageRequest
 */
public class DeletePrivateImageRequest extends CTRequest {
    public DeletePrivateImageRequest() {
        super("POST", "application/json", "/v4/image/delete");
    }

    /**
     * set body entity
     * @param body body实体类
     * @return this
     */
    public DeletePrivateImageRequest withBody(DeletePrivateImageRequestBody body) {
        this.body = body;
        return this;
    }
}
