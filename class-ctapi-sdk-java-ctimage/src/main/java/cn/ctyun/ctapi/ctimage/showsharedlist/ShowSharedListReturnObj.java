package cn.ctyun.ctapi.ctimage.showsharedlist;

import cn.ctyun.ctapi.CTFile;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

/**
 * <一类节点-*-镜像服务ctimage-查询私有镜像的共享列表>
 * Entity: ShowSharedListReturnObj
 */
public class ShowSharedListReturnObj {
    /**
     * images
     * 镜像列表。
     */
    private ShowSharedListImage[] images;
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
     * set images
     * @param images 镜像列表。
     * @return this
     */
    public ShowSharedListReturnObj withImages(ShowSharedListImage[] images) {
        this.images = images;
        return this;
    }

    /**
     * set pageNo
     * @param pageNo 当前页码。注意：此参数即将弃用。若有获取当前页码需要，则请使用 currentPage。
     * @return this
     */
    public ShowSharedListReturnObj withPageNo(Integer pageNo) {
        this.pageNo = pageNo;
        return this;
    }

    /**
     * set currentPage
     * @param currentPage 当前页码。
     * @return this
     */
    public ShowSharedListReturnObj withCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
        return this;
    }

    /**
     * set pageSize
     * @param pageSize 当前页记录数目。注意：此参数即将弃用。若有获取当前页记录数目需要，则请使用 currentCount。
     * @return this
     */
    public ShowSharedListReturnObj withPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    /**
     * set currentCount
     * @param currentCount 当前页记录数目。
     * @return this
     */
    public ShowSharedListReturnObj withCurrentCount(Integer currentCount) {
        this.currentCount = currentCount;
        return this;
    }

    /**
     * set totalCount
     * @param totalCount 总记录数。
     * @return this
     */
    public ShowSharedListReturnObj withTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    public ShowSharedListImage[] getImages() {
        return images;
    }

    public void setImages(ShowSharedListImage[] images) {
        this.images = images;
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
