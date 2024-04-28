package cn.ctyun.ctapi.ctimage.exportprivateimage;

import cn.ctyun.ctapi.CTFile;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

/**
 * <一类节点-*-镜像服务ctimage-导出私有镜像>
 * Entity: ExportPrivateImageRequestBody
 */
public class ExportPrivateImageRequestBody {
    /**
     * bucket
     * 对象存储的桶。可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=9&api=6247&data=105" target="_blank">查询所有桶</a>接口来查询您拥有的桶的列表。
     */
    private String bucket;
    /**
     * filename
     * 在对象存储的桶中的存储名称。注意：长度为 2~100 个字符，只能由数字、字母、- 组成，不能以数字、- 开头，且不能以 - 结尾。建议不要与已有文件名重复。若对象存储的桶未开启版本控制，则使用重复的文件名将覆盖原同名文件。
     */
    private String filename;
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
     * imageFileFormat
     * 镜像文件格式，取值范围（值：描述）：<br />qcow2：QCOW2 格式<br />raw：RAW 格式（默认值）<br />vhd：VHD 格式<br />vmdk：VMDK 格式<br />注意：仅在多可用区资源池下生效。可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=25&api=5860&data=87" target="_blank">资源池概况信息查询</a>接口来确认所指定的资源池是否是多可用区资源池。
     */
    private String imageFileFormat;

    /**
     * set bucket
     * @param bucket 对象存储的桶。可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=9&api=6247&data=105" target="_blank">查询所有桶</a>接口来查询您拥有的桶的列表。
     * @return this
     */
    public ExportPrivateImageRequestBody withBucket(String bucket) {
        this.bucket = bucket;
        return this;
    }

    /**
     * set filename
     * @param filename 在对象存储的桶中的存储名称。注意：长度为 2~100 个字符，只能由数字、字母、- 组成，不能以数字、- 开头，且不能以 - 结尾。建议不要与已有文件名重复。若对象存储的桶未开启版本控制，则使用重复的文件名将覆盖原同名文件。
     * @return this
     */
    public ExportPrivateImageRequestBody withFilename(String filename) {
        this.filename = filename;
        return this;
    }

    /**
     * set imageID
     * @param imageID 镜像 ID。可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=23&api=4763&data=89" target="_blank">查询可以使用的镜像资源</a>接口来查询您可使用的镜像资源。
     * @return this
     */
    public ExportPrivateImageRequestBody withImageID(String imageID) {
        this.imageID = imageID;
        return this;
    }

    /**
     * set regionID
     * @param regionID 资源池 ID。可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=25&api=5851&data=87" target="_blank">资源池列表查询</a>接口来查询您可见的资源池的列表。
     * @return this
     */
    public ExportPrivateImageRequestBody withRegionID(String regionID) {
        this.regionID = regionID;
        return this;
    }

    /**
     * set imageFileFormat
     * @param imageFileFormat 镜像文件格式，取值范围（值：描述）：<br />qcow2：QCOW2 格式<br />raw：RAW 格式（默认值）<br />vhd：VHD 格式<br />vmdk：VMDK 格式<br />注意：仅在多可用区资源池下生效。可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=25&api=5860&data=87" target="_blank">资源池概况信息查询</a>接口来确认所指定的资源池是否是多可用区资源池。
     * @return this
     */
    public ExportPrivateImageRequestBody withImageFileFormat(String imageFileFormat) {
        this.imageFileFormat = imageFileFormat;
        return this;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
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

    public String getImageFileFormat() {
        return imageFileFormat;
    }

    public void setImageFileFormat(String imageFileFormat) {
        this.imageFileFormat = imageFileFormat;
    }
}
