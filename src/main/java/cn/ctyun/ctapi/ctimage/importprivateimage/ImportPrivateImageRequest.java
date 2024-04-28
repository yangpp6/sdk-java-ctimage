package cn.ctyun.ctapi.ctimage.importprivateimage;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import cn.ctyun.ctapi.CTRequest;
import cn.ctyun.ctapi.CTFile;

/**
 * <一类节点-*-镜像服务ctimage-创建私有镜像（镜像文件）>
 * Request: ImportPrivateImageRequest
 */
public class ImportPrivateImageRequest extends CTRequest {
    public ImportPrivateImageRequest() {
        super("POST", "application/json", "/v4/image/import");
    }

    /**
     * set body entity
     * @param body body实体类
     * @return this
     */
    public ImportPrivateImageRequest withBody(ImportPrivateImageRequestBody body) {
        this.body = body;
        return this;
    }
}
