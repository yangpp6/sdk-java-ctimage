package cn.ctyun.ctapi.ctimage.showsharedlist;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import cn.ctyun.ctapi.CTRequest;
import cn.ctyun.ctapi.CTFile;

/**
 * <一类节点-*-镜像服务ctimage-查询私有镜像的共享列表>
 * Request: ShowSharedListRequest
 */
public class ShowSharedListRequest extends CTRequest {
    public ShowSharedListRequest() {
        super("GET", "application/json", "/v4/image/show-shared-list");
    }

    /**
     * <Query param> set imageID
     * @param imageID 镜像 ID。可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=23&api=4763&data=89" target="_blank">查询可以使用的镜像资源</a>接口来查询您可使用的镜像资源。
     * @return this
     */
    public ShowSharedListRequest withImageID(String imageID) {
        queryParam.put("imageID", imageID);
        return this;
    }

    /**
     * <Query param> set regionID
     * @param regionID 资源池 ID。可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=25&api=5851&data=87" target="_blank">资源池列表查询</a>接口来查询您可见的资源池的列表。
     * @return this
     */
    public ShowSharedListRequest withRegionID(String regionID) {
        queryParam.put("regionID", regionID);
        return this;
    }

    /**
     * <Query param> set pageNo
     * @param pageNo 页码，取值范围：最小 1（默认值）。
     * @return this
     */
    public ShowSharedListRequest withPageNo(String pageNo) {
        queryParam.put("pageNo", pageNo);
        return this;
    }

    /**
     * <Query param> set pageSize
     * @param pageSize 每页记录数目，取值范围：最小 1，最大 50，默认值 10。
     * @return this
     */
    public ShowSharedListRequest withPageSize(String pageSize) {
        queryParam.put("pageSize", pageSize);
        return this;
    }
}
