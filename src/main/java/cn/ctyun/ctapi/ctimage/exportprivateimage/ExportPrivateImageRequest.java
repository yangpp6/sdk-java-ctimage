package cn.ctyun.ctapi.ctimage.exportprivateimage;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import cn.ctyun.ctapi.CTRequest;
import cn.ctyun.ctapi.CTFile;

/**
 * <一类节点-*-镜像服务ctimage-导出私有镜像>
 * Request: ExportPrivateImageRequest
 */
public class ExportPrivateImageRequest extends CTRequest {
    public ExportPrivateImageRequest() {
        super("POST", "application/json", "/v4/image/export");
    }

    /**
     * set body entity
     * @param body body实体类
     * @return this
     */
    public ExportPrivateImageRequest withBody(ExportPrivateImageRequestBody body) {
        this.body = body;
        return this;
    }
}
