package cn.ctyun.ctapi.ctimage.listimages;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import cn.ctyun.ctapi.CTRequest;
import cn.ctyun.ctapi.CTFile;

/**
 * <一类节点-*-镜像服务ctimage-查询可以使用的镜像资源>
 * Request: ListImagesRequest
 */
public class ListImagesRequest extends CTRequest {
    public ListImagesRequest() {
        super("GET", "application/json", "/v4/image/list");
    }

    /**
     * <Query param> set regionID
     * @param regionID 资源池 ID。可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=25&api=5851&data=87" target="_blank">资源池列表查询</a>接口来查询您可见的资源池的列表。
     * @return this
     */
    public ListImagesRequest withRegionID(String regionID) {
        queryParam.put("regionID", regionID);
        return this;
    }

    /**
     * <Query param> set azName
     * @param azName 可用区名称。注意：<br />1. 仅在多可用区资源池下对物理机镜像生效，在单可用区资源池下无需指定此参数。<br />2. 可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=25&api=5855&data=87" target="_blank">资源池可用区查询</a>接口查询多可用区资源池的可用区信息。若响应的 returnObj 中的 zoneList 是空的可用区列表，则所指定的资源池是单可用区资源池。
     * @return this
     */
    public ListImagesRequest withAzName(String azName) {
        queryParam.put("azName", azName);
        return this;
    }

    /**
     * <Query param> set flavorName
     * @param flavorName 云主机规格名称。可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=25&api=8327&data=87" target="_blank">查询一个或多个云主机规格资源</a>接口来查询您可以使用的云主机规格。
     * @return this
     */
    public ListImagesRequest withFlavorName(String flavorName) {
        queryParam.put("flavorName", flavorName);
        return this;
    }

    /**
     * <Query param> set imageStatus
     * @param imageStatus 镜像状态。取值范围（值：描述）：<br />accepted：已接受共享镜像<br />rejected：已拒绝共享镜像<br />waiting：等待接受/拒绝共享镜像<br /><br />注意：仅在 imageVisibilityCode/visibility 的取值为 2（共享镜像）时生效，未指定镜像状态时默认显示镜像状态为 accepted 或 waiting 的共享镜像。
     * @return this
     */
    public ListImagesRequest withImageStatus(String imageStatus) {
        queryParam.put("imageStatus", imageStatus);
        return this;
    }

    /**
     * <Query param> set imageVisibilityCode
     * @param imageVisibilityCode 镜像可见类型代码。取值范围（值：描述）：<br />0：私有镜像<br />1：公共镜像（默认值）<br />2：共享镜像<br />3：安全产品镜像<br />4：甄选应用镜像<br />5：应用镜像
     * @return this
     */
    public ListImagesRequest withImageVisibilityCode(Integer imageVisibilityCode) {
        queryParam.put("imageVisibilityCode", imageVisibilityCode);
        return this;
    }

    /**
     * <Query param> set pageNo
     * @param pageNo 页码。取值范围：最小 1（默认值）。
     * @return this
     */
    public ListImagesRequest withPageNo(Integer pageNo) {
        queryParam.put("pageNo", pageNo);
        return this;
    }

    /**
     * <Query param> set pageSize
     * @param pageSize 每页记录数目。取值范围：最小 1，最大 50，默认值 10。
     * @return this
     */
    public ListImagesRequest withPageSize(Integer pageSize) {
        queryParam.put("pageSize", pageSize);
        return this;
    }

    /**
     * <Query param> set projectID
     * @param projectID 企业项目 ID。注意：仅在 imageVisibilityCode/visibility 的取值为 0（私有镜像）时生效。
     * @return this
     */
    public ListImagesRequest withProjectID(String projectID) {
        queryParam.put("projectID", projectID);
        return this;
    }

    /**
     * <Query param> set queryContent
     * @param queryContent 查询内容。基于镜像名称的搜索，大小写不敏感。
     * @return this
     */
    public ListImagesRequest withQueryContent(String queryContent) {
        queryParam.put("queryContent", queryContent);
        return this;
    }

    /**
     * <Query param> set status
     * @param status 镜像状态（同 imageStatus 参数）。注意：<br />1. status 参数已弃用，目前仍可使用，但会在合适的时机移除，因此请您尽快切换至 imageStatus 参数。<br />2. 若使用此弃用参数，则应传入在取值范围内的值。<br />3. 若同时使用了推荐的参数和此弃用参数，则推荐的参数的值将优先。
     * @return this
     */
    public ListImagesRequest withStatus(String status) {
        queryParam.put("status", status);
        return this;
    }

    /**
     * <Query param> set visibility
     * @param visibility 镜像可见类型代码（同 imageVisibilityCode 参数）。注意：<br />1. visibility 参数已弃用，目前仍可使用，但会在合适的时机移除，因此请您尽快切换至 imageVisibilityCode 参数。<br />2. 若使用此弃用参数，则应传入在取值范围内的值。<br />3. 若同时使用了推荐的参数和此弃用参数，则推荐的参数的值将优先。
     * @return this
     */
    public ListImagesRequest withVisibility(Integer visibility) {
        queryParam.put("visibility", visibility);
        return this;
    }
}
