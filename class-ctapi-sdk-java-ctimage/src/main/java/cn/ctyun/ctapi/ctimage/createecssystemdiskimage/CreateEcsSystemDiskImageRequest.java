package cn.ctyun.ctapi.ctimage.createecssystemdiskimage;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import cn.ctyun.ctapi.CTRequest;
import cn.ctyun.ctapi.CTFile;

/**
 * <一类节点-*-镜像服务ctimage-创建私有镜像（云主机系统盘）>
 * Request: CreateEcsSystemDiskImageRequest
 */
public class CreateEcsSystemDiskImageRequest extends CTRequest {
    public CreateEcsSystemDiskImageRequest() {
        super("POST", "application/json", "/v4/image/create");
    }

    /**
     * set body entity
     * @param body body实体类
     * @return this
     */
    public CreateEcsSystemDiskImageRequest withBody(CreateEcsSystemDiskImageRequestBody body) {
        this.body = body;
        return this;
    }
}
