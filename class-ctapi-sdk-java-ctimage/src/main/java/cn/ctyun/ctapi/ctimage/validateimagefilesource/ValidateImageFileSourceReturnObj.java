package cn.ctyun.ctapi.ctimage.validateimagefilesource;

import cn.ctyun.ctapi.CTFile;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

/**
 * <一类节点-*-镜像服务ctimage-校验镜像文件地址>
 * Entity: ValidateImageFileSourceReturnObj
 */
public class ValidateImageFileSourceReturnObj {
    /**
     * archive
     * 是否处于归档冻结状态。
     */
    private Boolean archive;
    /**
     * bucket
     * 对象存储的桶是否存在。
     */
    private Boolean bucket;
    /**
     * encryption
     * 是否加密。
     */
    private Boolean encryption;
    /**
     * object
     * 文件是否存在。
     */
    private Boolean object;

    /**
     * set archive
     * @param archive 是否处于归档冻结状态。
     * @return this
     */
    public ValidateImageFileSourceReturnObj withArchive(Boolean archive) {
        this.archive = archive;
        return this;
    }

    /**
     * set bucket
     * @param bucket 对象存储的桶是否存在。
     * @return this
     */
    public ValidateImageFileSourceReturnObj withBucket(Boolean bucket) {
        this.bucket = bucket;
        return this;
    }

    /**
     * set encryption
     * @param encryption 是否加密。
     * @return this
     */
    public ValidateImageFileSourceReturnObj withEncryption(Boolean encryption) {
        this.encryption = encryption;
        return this;
    }

    /**
     * set object
     * @param object 文件是否存在。
     * @return this
     */
    public ValidateImageFileSourceReturnObj withObject(Boolean object) {
        this.object = object;
        return this;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public Boolean getBucket() {
        return bucket;
    }

    public void setBucket(Boolean bucket) {
        this.bucket = bucket;
    }

    public Boolean getEncryption() {
        return encryption;
    }

    public void setEncryption(Boolean encryption) {
        this.encryption = encryption;
    }

    public Boolean getObject() {
        return object;
    }

    public void setObject(Boolean object) {
        this.object = object;
    }
}
