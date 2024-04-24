package cn.ctyun.ctapi.ctimage.listprivateimageimporttasks;

import cn.ctyun.ctapi.CTFile;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

/**
 * <一类节点-全局-镜像服务ctimage-查询创建私有镜像（镜像文件）任务列表>
 * Entity: ListPrivateImageImportTasksReturnObj
 */
public class ListPrivateImageImportTasksReturnObj {
    /**
     * imageImportTasks
     * 创建私有镜像（镜像文件）任务列表。
     */
    private ListPrivateImageImportTasksImageImportTasks[] imageImportTasks;
    /**
     * pageNo
     * 当前页码。注意：此参数即将弃用。若有获取当前页码需要，则请使用 currentPage。
     */
    private Integer pageNo;
    /**
     * currentPage
     * 当前页码。
     */
    private Integer currentPage;
    /**
     * pageSize
     * 当前页记录数目。注意：此参数即将弃用。若有获取当前页记录数目需要，则请使用 currentCount。
     */
    private Integer pageSize;
    /**
     * currentCount
     * 当前页记录数目。
     */
    private Integer currentCount;
    /**
     * totalCount
     * 总记录数。
     */
    private Integer totalCount;

    /**
     * set imageImportTasks
     * @param imageImportTasks 创建私有镜像（镜像文件）任务列表。
     * @return this
     */
    public ListPrivateImageImportTasksReturnObj withImageImportTasks(ListPrivateImageImportTasksImageImportTasks[] imageImportTasks) {
        this.imageImportTasks = imageImportTasks;
        return this;
    }

    /**
     * set pageNo
     * @param pageNo 当前页码。注意：此参数即将弃用。若有获取当前页码需要，则请使用 currentPage。
     * @return this
     */
    public ListPrivateImageImportTasksReturnObj withPageNo(Integer pageNo) {
        this.pageNo = pageNo;
        return this;
    }

    /**
     * set currentPage
     * @param currentPage 当前页码。
     * @return this
     */
    public ListPrivateImageImportTasksReturnObj withCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
        return this;
    }

    /**
     * set pageSize
     * @param pageSize 当前页记录数目。注意：此参数即将弃用。若有获取当前页记录数目需要，则请使用 currentCount。
     * @return this
     */
    public ListPrivateImageImportTasksReturnObj withPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    /**
     * set currentCount
     * @param currentCount 当前页记录数目。
     * @return this
     */
    public ListPrivateImageImportTasksReturnObj withCurrentCount(Integer currentCount) {
        this.currentCount = currentCount;
        return this;
    }

    /**
     * set totalCount
     * @param totalCount 总记录数。
     * @return this
     */
    public ListPrivateImageImportTasksReturnObj withTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    public ListPrivateImageImportTasksImageImportTasks[] getImageImportTasks() {
        return imageImportTasks;
    }

    public void setImageImportTasks(ListPrivateImageImportTasksImageImportTasks[] imageImportTasks) {
        this.imageImportTasks = imageImportTasks;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(Integer currentCount) {
        this.currentCount = currentCount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
