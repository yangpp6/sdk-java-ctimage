package cn.ctyun.ctapi.ctimage.deleteprivateimageimporttask;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import cn.ctyun.ctapi.CTRequest;
import cn.ctyun.ctapi.CTFile;

/**
 * <一类节点-全局-镜像服务ctimage-删除创建私有镜像（镜像文件）任务>
 * Request: DeletePrivateImageImportTaskRequest
 */
public class DeletePrivateImageImportTaskRequest extends CTRequest {
    public DeletePrivateImageImportTaskRequest() {
        super("POST", "application/json", "/v4/image/delete-import-task");
    }

    /**
     * <Query param> set regionID
     * @param regionID 资源池 ID。可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=25&api=5851&data=87" target="_blank">资源池列表查询</a>接口来查询您可见的资源池的列表。
     * @return this
     */
    public DeletePrivateImageImportTaskRequest withRegionID(String regionID) {
        queryParam.put("regionID", regionID);
        return this;
    }

    /**
     * <Query param> set taskID
     * @param taskID 任务 ID。可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=23&api=7488&data=89" target="_blank">查询创建私有镜像（镜像文件）任务列表</a>接口来查询使用镜像文件来创建私有镜像的任务列表。
     * @return this
     */
    public DeletePrivateImageImportTaskRequest withTaskID(String taskID) {
        queryParam.put("taskID", taskID);
        return this;
    }
}
