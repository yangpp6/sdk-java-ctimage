package cn.ctyun.ctapi.ctimage.updateprivateimage;

import cn.ctyun.ctapi.CTFile;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

/**
 * <一类节点-*-镜像服务ctimage-修改私有镜像属性>
 * Entity: UpdatePrivateImageRequestBody
 */
public class UpdatePrivateImageRequestBody {
    /**
     * imageID
     * 镜像 ID。可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=23&api=4763&data=89" target="_blank">查询可以使用的镜像资源</a>接口来查询您可使用的镜像资源。
     */
    private String imageID;
    /**
     * regionID
     * 资源池 ID。可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=25&api=5851&data=87" target="_blank">资源池列表查询</a>接口来查询您可见的资源池的列表。
     */
    private String regionID;
    /**
     * bootMode
     * 启动方式，取值范围（值：描述）：<br />bios：BIOS 启动方式<br />uefi：UEFI 启动方式<br />注意：若镜像系统架构为 aarch64 且当前启动方式为 uefi，则对启动方式的修改不生效。
     */
    private String bootMode;
    /**
     * description
     * 镜像描述信息。注意：长度为 1~128 个字符。
     */
    private String description;
    /**
     * imageName
     * 镜像名称。注意：长度为 2~32 个字符，只能由数字、字母、- 组成，不能以数字、- 开头，且不能以 - 结尾。
     */
    private String imageName;
    /**
     * maximumRAM
     * 最大内存，单位为 GB，取值范围：0（即不限制）/ 1 / 2 / 4 / 8 / 16 / 32 / 64 / 128 / 256 / 512。注意：若取值不为 0 且当前或要修改成的最小内存也不为不限制时，则取值应大于或等于当前或要修改成的最小内存。
     */
    private Integer maximumRAM;
    /**
     * minimumRAM
     * 最小内存，单位为 GB，取值范围：0（即不限制）/ 1 / 2 / 4 / 8 / 16 / 32 / 64 / 128 / 256 / 512。注意：若取值不为 0 且当前或要修改成的最大内存也不为不限制时，则取值应小于或等于当前或要修改成的最大内存。
     */
    private Integer minimumRAM;

    /**
     * set imageID
     * @param imageID 镜像 ID。可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=23&api=4763&data=89" target="_blank">查询可以使用的镜像资源</a>接口来查询您可使用的镜像资源。
     * @return this
     */
    public UpdatePrivateImageRequestBody withImageID(String imageID) {
        this.imageID = imageID;
        return this;
    }

    /**
     * set regionID
     * @param regionID 资源池 ID。可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=25&api=5851&data=87" target="_blank">资源池列表查询</a>接口来查询您可见的资源池的列表。
     * @return this
     */
    public UpdatePrivateImageRequestBody withRegionID(String regionID) {
        this.regionID = regionID;
        return this;
    }

    /**
     * set bootMode
     * @param bootMode 启动方式，取值范围（值：描述）：<br />bios：BIOS 启动方式<br />uefi：UEFI 启动方式<br />注意：若镜像系统架构为 aarch64 且当前启动方式为 uefi，则对启动方式的修改不生效。
     * @return this
     */
    public UpdatePrivateImageRequestBody withBootMode(String bootMode) {
        this.bootMode = bootMode;
        return this;
    }

    /**
     * set description
     * @param description 镜像描述信息。注意：长度为 1~128 个字符。
     * @return this
     */
    public UpdatePrivateImageRequestBody withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * set imageName
     * @param imageName 镜像名称。注意：长度为 2~32 个字符，只能由数字、字母、- 组成，不能以数字、- 开头，且不能以 - 结尾。
     * @return this
     */
    public UpdatePrivateImageRequestBody withImageName(String imageName) {
        this.imageName = imageName;
        return this;
    }

    /**
     * set maximumRAM
     * @param maximumRAM 最大内存，单位为 GB，取值范围：0（即不限制）/ 1 / 2 / 4 / 8 / 16 / 32 / 64 / 128 / 256 / 512。注意：若取值不为 0 且当前或要修改成的最小内存也不为不限制时，则取值应大于或等于当前或要修改成的最小内存。
     * @return this
     */
    public UpdatePrivateImageRequestBody withMaximumRAM(Integer maximumRAM) {
        this.maximumRAM = maximumRAM;
        return this;
    }

    /**
     * set minimumRAM
     * @param minimumRAM 最小内存，单位为 GB，取值范围：0（即不限制）/ 1 / 2 / 4 / 8 / 16 / 32 / 64 / 128 / 256 / 512。注意：若取值不为 0 且当前或要修改成的最大内存也不为不限制时，则取值应小于或等于当前或要修改成的最大内存。
     * @return this
     */
    public UpdatePrivateImageRequestBody withMinimumRAM(Integer minimumRAM) {
        this.minimumRAM = minimumRAM;
        return this;
    }

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public String getRegionID() {
        return regionID;
    }

    public void setRegionID(String regionID) {
        this.regionID = regionID;
    }

    public String getBootMode() {
        return bootMode;
    }

    public void setBootMode(String bootMode) {
        this.bootMode = bootMode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Integer getMaximumRAM() {
        return maximumRAM;
    }

    public void setMaximumRAM(Integer maximumRAM) {
        this.maximumRAM = maximumRAM;
    }

    public Integer getMinimumRAM() {
        return minimumRAM;
    }

    public void setMinimumRAM(Integer minimumRAM) {
        this.minimumRAM = minimumRAM;
    }
}
