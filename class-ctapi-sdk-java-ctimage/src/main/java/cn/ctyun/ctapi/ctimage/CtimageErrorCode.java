package cn.ctyun.ctapi.ctimage;

public enum CtimageErrorCode {
    IMAGE_IMAGEADMIN_ACCESSFAILED_200(200, "Image_ImageAdmin_AccessFailed", "900", "完成请求失败，原因可参考响应状态描述。"),

    IMAGE_IMAGEWORKORDER_ACCESSFAILED_200(200, "Image_ImageWorkorder_AccessFailed", "900", "完成请求失败，原因可参考响应状态描述。"),

    OPENAPI_FLAVORADMIN_ACCESSFAILED_200(200, "Openapi_FlavorAdmin_AccessFailed", "900", "完成请求失败，原因可参考响应状态描述。"),

    OPENAPI_FLAVORADMINFORMAT_FORMATERROR_200(200, "Openapi_FlavorAdminFormat_FormatError", "900", "完成请求失败，原因可参考响应状态描述。"),

    IMAGE_ORDERCHECK_INVALIDPROJECTID_200(200, "Image_OrderCheck_InvalidProjectID", "900", "企业项目 ID 不存在。"),

    IMAGE_PARAMETER_INVALIDAZNAME_200(200, "Image_Parameter_InvalidAzName", "900", "请求参数错误：资源池中不存在该 azName。"),

    IMAGE_REGIONINFO_ACCESSFAILED_200(200, "Image_RegionInfo_AccessFailed", "900", "查询资源池失败。"),

    IMAGE_REGIONINFO_DATADAMAGED_200(200, "Image_RegionInfo_DataDamaged", "900", "资源池信息不符预期。"),

    IMAGE_REGIONINFO_EMPTY_200(200, "Image_RegionInfo_Empty", "900", "资源池信息为空或资源池不存在。"),

    IMAGE_USERPERMISSION_ACCESSFAILED_200(200, "Image_UserPermission_AccessFailed", "900", "查询用户权限失败。"),

    IMAGE_USERPERMISSION_DATADAMAGED_200(200, "Image_UserPermission_DataDamaged", "900", "用户权限信息不符预期。"),

    IMAGE_USERPERMISSION_EMPTY_200(200, "Image_UserPermission_Empty", "900", "用户权限信息为空。"),

    OPENAPI_FLAVORCHECK_NOTFOUND_200(200, "Openapi_FlavorCheck_NotFound", "900", "未找到对应的云主机规格，请确认输入的云主机规格信息是否有效。"),

    OPENAPI_PATTERNCHECK_NOTVALID_200(200, "Openapi_PatternCheck_NotValid", "900", "请求参数无效。"),

    IMAGE_IMAGECHECK_NOTFOUND_200(200, "Image_ImageCheck_NotFound", "900", "镜像不存在或不符合要求，请确认镜像信息是否正确。"),

    ECS_INSTANCE_NOTFOUND_200(200, "Ecs_Instance_NotFound", "900", "云主机不存在，请确认云主机 ID 是否有效。"),

    IMAGE_IMAGECHECK_UNKNOWNERROR_200(200, "Image_ImageCheck_UnknownError", "900", "完成请求失败，原因可参考响应状态描述。"),

    OPENAPI_ECSCHECK_UNKNOWNERROR_200(200, "Openapi_EcsCheck_UnknownError", "900", "完成请求失败，原因可参考响应状态描述。"),

    OPENAPI_ECSFORMAT_FORMATERROR_200(200, "Openapi_EcsFormat_FormatError", "900", "完成请求失败，原因可参考响应状态描述。"),

    OPENAPI_ECSWORKORDER_ACCESSFAILED_200(200, "Openapi_EcsWorkorder_AccessFailed", "900", "完成请求失败，原因可参考响应状态描述。"),

    IMAGE_IMAGEWORKORDER_CREATEERROR_200(200, "Image_ImageWorkorder_CreateError", "900", "创建私有镜像失败，原因可参考响应状态描述。"),

    OPENAPI_USERQUOTA_ACCESSFAILED_200(200, "Openapi_UserQuota_AccessFailed", "900", "查询用户配额信息失败。"),

    OPENAPI_USERQUOTA_DATADAMAGED_200(200, "Openapi_UserQuota_DataDamaged", "900", "用户配额信息不符预期。"),

    OPENAPI_USERQUOTA_EMPTY_200(200, "Openapi_UserQuota_Empty", "900", "用户配额信息为空。"),

    IMAGE_IMAGEWORKORDER_DELETEERROR_200(200, "Image_ImageWorkorder_DeleteError", "900", "删除私有镜像失败，原因可参考响应状态描述。"),

    IMAGE_IMAGEYACOS_ACCESSFAILED_200(200, "Image_ImageYacos_AccessFailed", "900", "完成请求失败，原因可参考响应状态描述。"),

    IMAGE_IMAGEYACOS_CREATEERROR_200(200, "Image_ImageYacos_CreateError", "900", "创建私有镜像失败，原因可参考响应状态描述。"),

    IMAGE_IMAGEWORKORDER_UPDATEFAILED_200(200, "Image_ImageWorkorder_UpdateFailed", "900", "修改私有镜像属性失败，原因可参考响应状态描述。"),

    IMAGE_SHAREDIMAGE_ACCEPTFAILED_200(200, "Image_SharedImage_AcceptFailed", "900", "接受共享镜像失败。"),

    IMAGE_USERINFO_CHECKFAILED_200(200, "Image_UserInfo_CheckFailed", "900", "获取当前用户信息失败。"),

    IMAGE_SHAREDIMAGE_REJECTFAILED_200(200, "Image_SharedImage_RejectFailed", "900", "拒绝共享镜像失败。"),

    IMAGE_IMAGEFORMAT_FORMATERROR_200(200, "Image_ImageFormat_FormatError", "900", "完成请求失败，原因可参考响应状态描述。"),

    IMAGE_IMAGEWORKORDER_DEACTIVATEFAILED_200(200, "Image_ImageWorkorder_DeactivateFailed", "900", "弃用私有镜像失败。"),

    IMAGE_IMAGEWORKORDER_REACTIVATEFAILED_200(200, "Image_ImageWorkorder_ReactivateFailed", "900", "取消弃用私有镜像失败。"),

    IMAGE_IMAGEYACOS_DELETEERROR_200(200, "Image_ImageYacos_DeleteError", "900", "删除创建私有镜像（镜像文件）任务失败，原因可参考响应状态描述。");
    CtimageErrorCode(int stateCode, String errorCode, String errorCodeInfo, String errorCodeDescribe) {
        this.stateCode = stateCode;
        this.errorCode = errorCode;
        this.errorCodeInfo = errorCodeInfo;
        this.errorCodeDescribe = errorCodeDescribe;
    }

    private int stateCode;
    private String errorCode;
    private String errorCodeInfo;
    private String errorCodeDescribe;

    public int getStateCode() {
        return stateCode;
    }

    public void setStateCode(int stateCode) {
        this.stateCode = stateCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCodeInfo() {
        return errorCodeInfo;
    }

    public void setErrorCodeInfo(String errorCodeInfo) {
        this.errorCodeInfo = errorCodeInfo;
    }

    public String getErrorCodeDescribe() {
        return errorCodeDescribe;
    }

    public void setErrorCodeDescribe(String errorCodeDescribe) {
        this.errorCodeDescribe = errorCodeDescribe;
    }
}
