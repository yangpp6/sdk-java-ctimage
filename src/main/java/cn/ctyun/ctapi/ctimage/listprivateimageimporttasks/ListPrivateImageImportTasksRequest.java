package cn.ctyun.ctapi.ctimage.listprivateimageimporttasks;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import cn.ctyun.ctapi.CTRequest;
import cn.ctyun.ctapi.CTFile;

/**
 * <一类节点-全局-镜像服务ctimage-查询创建私有镜像（镜像文件）任务列表>
 * Request: ListPrivateImageImportTasksRequest
 */
public class ListPrivateImageImportTasksRequest extends CTRequest {
    public ListPrivateImageImportTasksRequest() {
        super("GET", "application/json", "/v4/image/list-import-tasks");
    }

    /**
     * <Query param> set regionID
     * @param regionID 资源池 ID。可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=25&api=5851&data=87" target="_blank">资源池列表查询</a>接口来查询您可见的资源池的列表。
     * @return this
     */
    public ListPrivateImageImportTasksRequest withRegionID(String regionID) {
        queryParam.put("regionID", regionID);
        return this;
    }

    /**
     * <Query param> set pageNo
     * @param pageNo 页码，取值范围：最小 1（默认值）。
     * @return this
     */
    public ListPrivateImageImportTasksRequest withPageNo(Integer pageNo) {
        queryParam.put("pageNo", pageNo);
        return this;
    }

    /**
     * <Query param> set pageSize
     * @param pageSize 每页记录数目，取值范围：最小 1，最大 50，默认值 10。
     * @return this
     */
    public ListPrivateImageImportTasksRequest withPageSize(Integer pageSize) {
        queryParam.put("pageSize", pageSize);
        return this;
    }
}
