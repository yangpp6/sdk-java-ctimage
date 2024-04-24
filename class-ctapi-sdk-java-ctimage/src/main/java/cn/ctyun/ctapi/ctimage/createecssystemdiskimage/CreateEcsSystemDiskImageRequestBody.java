package cn.ctyun.ctapi.ctimage.createecssystemdiskimage;

import cn.ctyun.ctapi.CTFile;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

/**
 * <一类节点-*-镜像服务ctimage-创建私有镜像（云主机系统盘）>
 * Entity: CreateEcsSystemDiskImageRequestBody
 */
public class CreateEcsSystemDiskImageRequestBody {
    /**
     * imageName
     * 镜像名称。注意：长度为 2~32 个字符，只能由数字、字母、- 组成，不能以数字、- 开头，且不能以 - 结尾。
     */
    private String imageName;
    /**
     * instanceID
     * 云主机 ID。可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=25&api=8309&data=87" target="_blank">查询云主机列表</a>接口来查询您的云主机列表。
     */
    private String instanceID;
    /**
     * regionID
     * 资源池 ID。可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=25&api=5851&data=87" target="_blank">资源池列表查询</a>接口来查询您可见的资源池的列表。
     */
    private String regionID;
    /**
     * description
     * 镜像描述信息。注意：长度为 1~128 个字符。
     */
    private String description;
    /**
     * projectID
     * 企业项目 ID，默认值 0。
     */
    private String projectID;

    /**
     * set imageName
     * @param imageName 镜像名称。注意：长度为 2~32 个字符，只能由数字、字母、- 组成，不能以数字、- 开头，且不能以 - 结尾。
     * @return this
     */
    public CreateEcsSystemDiskImageRequestBody withImageName(String imageName) {
        this.imageName = imageName;
        return this;
    }

    /**
     * set instanceID
     * @param instanceID 云主机 ID。可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=25&api=8309&data=87" target="_blank">查询云主机列表</a>接口来查询您的云主机列表。
     * @return this
     */
    public CreateEcsSystemDiskImageRequestBody withInstanceID(String instanceID) {
        this.instanceID = instanceID;
        return this;
    }

    /**
     * set regionID
     * @param regionID 资源池 ID。可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=25&api=5851&data=87" target="_blank">资源池列表查询</a>接口来查询您可见的资源池的列表。
     * @return this
     */
    public CreateEcsSystemDiskImageRequestBody withRegionID(String regionID) {
        this.regionID = regionID;
        return this;
    }

    /**
     * set description
     * @param description 镜像描述信息。注意：长度为 1~128 个字符。
     * @return this
     */
    public CreateEcsSystemDiskImageRequestBody withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * set projectID
     * @param projectID 企业项目 ID，默认值 0。
     * @return this
     */
    public CreateEcsSystemDiskImageRequestBody withProjectID(String projectID) {
        this.projectID = projectID;
        return this;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getInstanceID() {
        return instanceID;
    }

    public void setInstanceID(String instanceID) {
        this.instanceID = instanceID;
    }

    public String getRegionID() {
        return regionID;
    }

    public void setRegionID(String regionID) {
        this.regionID = regionID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }
}
