package cn.ctyun.ctapi.ctimage.listimages;

import cn.ctyun.ctapi.CTFile;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

/**
 * <一类节点-*-镜像服务ctimage-查询可以使用的镜像资源>
 * Entity: ListImagesReturnObj
 */
public class ListImagesReturnObj {
    /**
     * images
     * 镜像列表。
     */
    private ListImagesImage[] images;
    /**
     * currentPage
     * 当前页码。
     */
    private Integer currentPage;
    /**
     * pageNo
     * 当前页码（同 currentPage 参数）。注意：pageNo 参数已弃用，目前仍会返回，但会在合适的时机移除，因此请您尽快切换至 currentPage 参数。
     */
    private Integer pageNo;
    /**
     * currentCount
     * 当前页记录数。
     */
    private Integer currentCount;
    /**
     * pageSize
     * 当前页记录数（同 currentCount 参数）。注意：pageSize 参数已弃用，目前仍会返回，但会在合适的时机移除，因此请您尽快切换至 currentCount 参数。
     */
    private Integer pageSize;
    /**
     * totalPage
     * 总页数。
     */
    private Integer totalPage;
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
    public ListImagesReturnObj withImages(ListImagesImage[] images) {
        this.images = images;
        return this;
    }

    /**
     * set currentPage
     * @param currentPage 当前页码。
     * @return this
     */
    public ListImagesReturnObj withCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
        return this;
    }

    /**
     * set pageNo
     * @param pageNo 当前页码（同 currentPage 参数）。注意：pageNo 参数已弃用，目前仍会返回，但会在合适的时机移除，因此请您尽快切换至 currentPage 参数。
     * @return this
     */
    public ListImagesReturnObj withPageNo(Integer pageNo) {
        this.pageNo = pageNo;
        return this;
    }

    /**
     * set currentCount
     * @param currentCount 当前页记录数。
     * @return this
     */
    public ListImagesReturnObj withCurrentCount(Integer currentCount) {
        this.currentCount = currentCount;
        return this;
    }

    /**
     * set pageSize
     * @param pageSize 当前页记录数（同 currentCount 参数）。注意：pageSize 参数已弃用，目前仍会返回，但会在合适的时机移除，因此请您尽快切换至 currentCount 参数。
     * @return this
     */
    public ListImagesReturnObj withPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    /**
     * set totalPage
     * @param totalPage 总页数。
     * @return this
     */
    public ListImagesReturnObj withTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
        return this;
    }

    /**
     * set totalCount
     * @param totalCount 总记录数。
     * @return this
     */
    public ListImagesReturnObj withTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    public ListImagesImage[] getImages() {
        return images;
    }

    public void setImages(ListImagesImage[] images) {
        this.images = images;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(Integer currentCount) {
        this.currentCount = currentCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
