package cn.ctyun.ctapi.ctimage.validateimagefilesource;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import cn.ctyun.ctapi.CTRequest;
import cn.ctyun.ctapi.CTFile;

/**
 * <一类节点-*-镜像服务ctimage-校验镜像文件地址>
 * Request: ValidateImageFileSourceRequest
 */
public class ValidateImageFileSourceRequest extends CTRequest {
    public ValidateImageFileSourceRequest() {
        super("GET", "application/json", "/v4/image/validate-file-source");
    }

    /**
     * <Query param> set imageFileSource
     * @param imageFileSource 镜像文件地址，格式应为 {internetEndpoint}/{bucket}/{key}。可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=9&api=7359&data=105" target="_blank">访问控制 endpoint 查询</a>接口来查询外网访问 endpoint，可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=9&api=6247&data=105" target="_blank">查询所有桶</a>接口来查询您拥有的桶的列表，可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=9&api=6273&data=105" target="_blank">查看对象列表</a>接口来查询存储桶内所有对象。
     * @return this
     */
    public ValidateImageFileSourceRequest withImageFileSource(String imageFileSource) {
        queryParam.put("imageFileSource", imageFileSource);
        return this;
    }

    /**
     * <Query param> set regionID
     * @param regionID 资源池 ID。可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=25&api=5851&data=87" target="_blank">资源池列表查询</a>接口来查询您可见的资源池的列表。
     * @return this
     */
    public ValidateImageFileSourceRequest withRegionID(String regionID) {
        queryParam.put("regionID", regionID);
        return this;
    }
}
