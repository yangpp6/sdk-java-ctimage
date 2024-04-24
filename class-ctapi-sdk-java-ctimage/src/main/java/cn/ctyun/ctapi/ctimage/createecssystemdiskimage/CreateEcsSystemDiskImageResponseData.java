package cn.ctyun.ctapi.ctimage.createecssystemdiskimage;

import cn.ctyun.ctapi.CTFile;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

/**
 * <一类节点-*-镜像服务ctimage-创建私有镜像（云主机系统盘）>
 * Entity: CreateEcsSystemDiskImageResponseData
 */
public class CreateEcsSystemDiskImageResponseData {
    /**
     * statusCode
     * 返回状态码，取值范围（值：描述）：<br />800：成功<br />900：失败
     */
    private Integer statusCode;
    /**
     * error
     * 错误码（product.module.code 三段式码）。
     */
    private String error;
    /**
     * errorCode
     * 同“error”参数。
     */
    private String errorCode;
    /**
     * message
     * 响应状态描述（一般为英文）。
     */
    private String message;
    /**
     * description
     * 响应状态描述（一般为中文）。
     */
    private String description;
    /**
     * returnObj
     * 返回参数。
     */
    private CreateEcsSystemDiskImageReturnObj returnObj;

    /**
     * set statusCode
     * @param statusCode 返回状态码，取值范围（值：描述）：<br />800：成功<br />900：失败
     * @return this
     */
    public CreateEcsSystemDiskImageResponseData withStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    /**
     * set error
     * @param error 错误码（product.module.code 三段式码）。
     * @return this
     */
    public CreateEcsSystemDiskImageResponseData withError(String error) {
        this.error = error;
        return this;
    }

    /**
     * set errorCode
     * @param errorCode 同“error”参数。
     * @return this
     */
    public CreateEcsSystemDiskImageResponseData withErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    /**
     * set message
     * @param message 响应状态描述（一般为英文）。
     * @return this
     */
    public CreateEcsSystemDiskImageResponseData withMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * set description
     * @param description 响应状态描述（一般为中文）。
     * @return this
     */
    public CreateEcsSystemDiskImageResponseData withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * set returnObj
     * @param returnObj 返回参数。
     * @return this
     */
    public CreateEcsSystemDiskImageResponseData withReturnObj(CreateEcsSystemDiskImageReturnObj returnObj) {
        this.returnObj = returnObj;
        return this;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CreateEcsSystemDiskImageReturnObj getReturnObj() {
        return returnObj;
    }

    public void setReturnObj(CreateEcsSystemDiskImageReturnObj returnObj) {
        this.returnObj = returnObj;
    }
}
