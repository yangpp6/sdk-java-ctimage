package cn.ctyun.ctapi.ctimage.detailimage;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import cn.ctyun.ctapi.CTRequest;
import cn.ctyun.ctapi.CTFile;

/**
 * <一类节点-*-镜像服务ctimage-查询镜像详细信息>
 * Request: DetailImageRequest
 */
public class DetailImageRequest extends CTRequest {
    public DetailImageRequest() {
        super("GET", "application/json", "/v4/image/detail");
    }

    /**
     * <Query param> set imageID
     * @param imageID 镜像 ID。可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=23&api=4763&data=89" target="_blank">查询可以使用的镜像资源</a>接口来查询您可使用的镜像资源。
     * @return this
     */
    public DetailImageRequest withImageID(String imageID) {
        queryParam.put("imageID", imageID);
        return this;
    }

    /**
     * <Query param> set regionID
     * @param regionID 资源池 ID。可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=25&api=5851&data=87" target="_blank">资源池列表查询</a>接口来查询您可见的资源池的列表。
     * @return this
     */
    public DetailImageRequest withRegionID(String regionID) {
        queryParam.put("regionID", regionID);
        return this;
    }

    /**
     * <Query param> set errorFree
     * @param errorFree 用于设置是否期望特定场景“零错误”响应的标识。默认值 true。注意：<br />1. 特定场景是指通过 imageID 指定的镜像在您通过 regionID 指定的资源池中不存在。<br />2. 对于特定场景，若此参数设置为 false（推荐），则此接口会响应失败 statusCode、相应的 error/errorCode 等；否则，此接口会响应成功 statusCode 等，但 returnObj 中的 images 是空的镜像列表。<br />3. 此参数已弃用，目前仍可使用，但会在合适的时机移除而不再允许设置。移除后，此接口的响应行为等效于将此参数设置为 false（目前默认 true 是为了在移除前的过度阶段仍保持旧有行为），因此请您尽快适配设置此参数为 false 的情形。
     * @return this
     */
    public DetailImageRequest withErrorFree(Boolean errorFree) {
        queryParam.put("errorFree", errorFree);
        return this;
    }
}
