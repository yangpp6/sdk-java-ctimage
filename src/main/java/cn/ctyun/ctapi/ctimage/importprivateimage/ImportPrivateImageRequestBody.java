package cn.ctyun.ctapi.ctimage.importprivateimage;

import cn.ctyun.ctapi.CTFile;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

/**
 * <一类节点-*-镜像服务ctimage-创建私有镜像（镜像文件）>
 * Entity: ImportPrivateImageRequestBody
 */
public class ImportPrivateImageRequestBody {
    /**
     * imageFileSource
     * 镜像文件地址，格式应为 {internetEndpoint}/{bucket}/{key}。可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=9&api=7359&data=105" target="_blank">访问控制 endpoint 查询</a>接口来查询外网访问 endpoint，可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=9&api=6247&data=105" target="_blank">查询所有桶</a>接口来查询您拥有的桶的列表，可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=9&api=6273&data=105" target="_blank">查看对象列表</a>接口来查询存储桶内所有对象。
     */
    private String imageFileSource;
    /**
     * imageProperties
     * 镜像属性。注意：对启动方式、最大和最小内存的指定仅在镜像属性中镜像种类的取值为空或空字符串（系统盘镜像）时生效。此外，当前对启动方式、最大和最小内存的指定在多可用区资源池下不生效。可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=25&api=5860&data=87" target="_blank">资源池概况信息查询</a>接口来确认所指定的资源池是否是多可用区资源池。
     */
    private ImportPrivateImageImageProperties imageProperties;
    /**
     * regionID
     * 资源池 ID。可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=25&api=5851&data=87" target="_blank">资源池列表查询</a>接口来查询您可见的资源池的列表。
     */
    private String regionID;
    /**
     * projectID
     * 企业项目 ID，默认值 0。
     */
    private String projectID;

    /**
     * set imageFileSource
     * @param imageFileSource 镜像文件地址，格式应为 {internetEndpoint}/{bucket}/{key}。可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=9&api=7359&data=105" target="_blank">访问控制 endpoint 查询</a>接口来查询外网访问 endpoint，可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=9&api=6247&data=105" target="_blank">查询所有桶</a>接口来查询您拥有的桶的列表，可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=9&api=6273&data=105" target="_blank">查看对象列表</a>接口来查询存储桶内所有对象。
     * @return this
     */
    public ImportPrivateImageRequestBody withImageFileSource(String imageFileSource) {
        this.imageFileSource = imageFileSource;
        return this;
    }

    /**
     * set imageProperties
     * @param imageProperties 镜像属性。注意：对启动方式、最大和最小内存的指定仅在镜像属性中镜像种类的取值为空或空字符串（系统盘镜像）时生效。此外，当前对启动方式、最大和最小内存的指定在多可用区资源池下不生效。可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=25&api=5860&data=87" target="_blank">资源池概况信息查询</a>接口来确认所指定的资源池是否是多可用区资源池。
     * @return this
     */
    public ImportPrivateImageRequestBody withImageProperties(ImportPrivateImageImageProperties imageProperties) {
        this.imageProperties = imageProperties;
        return this;
    }

    /**
     * set regionID
     * @param regionID 资源池 ID。可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=25&api=5851&data=87" target="_blank">资源池列表查询</a>接口来查询您可见的资源池的列表。
     * @return this
     */
    public ImportPrivateImageRequestBody withRegionID(String regionID) {
        this.regionID = regionID;
        return this;
    }

    /**
     * set projectID
     * @param projectID 企业项目 ID，默认值 0。
     * @return this
     */
    public ImportPrivateImageRequestBody withProjectID(String projectID) {
        this.projectID = projectID;
        return this;
    }

    public String getImageFileSource() {
        return imageFileSource;
    }

    public void setImageFileSource(String imageFileSource) {
        this.imageFileSource = imageFileSource;
    }

    public ImportPrivateImageImageProperties getImageProperties() {
        return imageProperties;
    }

    public void setImageProperties(ImportPrivateImageImageProperties imageProperties) {
        this.imageProperties = imageProperties;
    }

    public String getRegionID() {
        return regionID;
    }

    public void setRegionID(String regionID) {
        this.regionID = regionID;
    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }
}
