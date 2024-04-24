package cn.ctyun.ctapi.ctimage.listprivateimageimporttasks;

import cn.ctyun.ctapi.CTFile;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

/**
 * <一类节点-全局-镜像服务ctimage-查询创建私有镜像（镜像文件）任务列表>
 * Entity: ListPrivateImageImportTasksImageImportTasks
 */
public class ListPrivateImageImportTasksImageImportTasks {
    /**
     * imageName
     * 镜像名称。
     */
    private String imageName;
    /**
     * osType
     * 操作系统类型。取值范围（值：描述）：<br />linux：Linux 系操作系统<br />windows：Windows 系操作系统
     */
    private String osType;
    /**
     * taskID
     * 任务 ID。
     */
    private String taskID;
    /**
     * taskStatus
     * 任务状态。取值范围（值：描述）：<br />fail：失败<br />pending：创建中
     */
    private String taskStatus;

    /**
     * set imageName
     * @param imageName 镜像名称。
     * @return this
     */
    public ListPrivateImageImportTasksImageImportTasks withImageName(String imageName) {
        this.imageName = imageName;
        return this;
    }

    /**
     * set osType
     * @param osType 操作系统类型。取值范围（值：描述）：<br />linux：Linux 系操作系统<br />windows：Windows 系操作系统
     * @return this
     */
    public ListPrivateImageImportTasksImageImportTasks withOsType(String osType) {
        this.osType = osType;
        return this;
    }

    /**
     * set taskID
     * @param taskID 任务 ID。
     * @return this
     */
    public ListPrivateImageImportTasksImageImportTasks withTaskID(String taskID) {
        this.taskID = taskID;
        return this;
    }

    /**
     * set taskStatus
     * @param taskStatus 任务状态。取值范围（值：描述）：<br />fail：失败<br />pending：创建中
     * @return this
     */
    public ListPrivateImageImportTasksImageImportTasks withTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
        return this;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
}
