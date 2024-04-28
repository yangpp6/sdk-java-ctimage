package cn.ctyun.ctapi.ctimage.createecsdatadiskimage;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import cn.ctyun.ctapi.CTRequest;
import cn.ctyun.ctapi.CTFile;

/**
 * <一类节点-*-镜像服务ctimage-创建私有镜像（云主机数据盘）>
 * Request: CreateEcsDataDiskImageRequest
 */
public class CreateEcsDataDiskImageRequest extends CTRequest {
    public CreateEcsDataDiskImageRequest() {
        super("POST", "application/json", "/v4/image/create-from-data-disk");
    }

    /**
     * set body entity
     * @param body body实体类
     * @return this
     */
    public CreateEcsDataDiskImageRequest withBody(CreateEcsDataDiskImageRequestBody body) {
        this.body = body;
        return this;
    }
}
