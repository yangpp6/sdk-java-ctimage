package cn.ctyun.ctapi.ctimage.reactivateprivateimage;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import cn.ctyun.ctapi.CTRequest;
import cn.ctyun.ctapi.CTFile;

/**
 * <一类节点-*-镜像服务ctimage-取消弃用私有镜像>
 * Request: ReactivatePrivateImageRequest
 */
public class ReactivatePrivateImageRequest extends CTRequest {
    public ReactivatePrivateImageRequest() {
        super("POST", "application/json", "/v4/image/reactivate");
    }

    /**
     * <Query param> set imageID
     * @param imageID 镜像 ID。可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=23&api=4763&data=89" target="_blank">查询可以使用的镜像资源</a>接口来查询您可使用的镜像资源。
     * @return this
     */
    public ReactivatePrivateImageRequest withImageID(String imageID) {
        queryParam.put("imageID", imageID);
        return this;
    }

    /**
     * <Query param> set regionID
     * @param regionID 资源池 ID。可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=25&api=5851&data=87" target="_blank">资源池列表查询</a>接口来查询您可见的资源池的列表。
     * @return this
     */
    public ReactivatePrivateImageRequest withRegionID(String regionID) {
        queryParam.put("regionID", regionID);
        return this;
    }
}
