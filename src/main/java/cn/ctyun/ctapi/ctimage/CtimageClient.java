package cn.ctyun.ctapi.ctimage;

import cn.ctyun.ctapi.CTClient;
import cn.ctyun.ctapi.CTResponse;
import cn.ctyun.ctapi.ctimage.listimages.*;
import cn.ctyun.ctapi.ctimage.detailimage.*;
import cn.ctyun.ctapi.ctimage.createecssystemdiskimage.*;
import cn.ctyun.ctapi.ctimage.deleteprivateimage.*;
import cn.ctyun.ctapi.ctimage.importprivateimage.*;
import cn.ctyun.ctapi.ctimage.updateprivateimage.*;
import cn.ctyun.ctapi.ctimage.shareprivateimage.*;
import cn.ctyun.ctapi.ctimage.acceptsharedimage.*;
import cn.ctyun.ctapi.ctimage.rejectsharedimage.*;
import cn.ctyun.ctapi.ctimage.unshareprivateimage.*;
import cn.ctyun.ctapi.ctimage.createecsdatadiskimage.*;
import cn.ctyun.ctapi.ctimage.validateimagefilesource.*;
import cn.ctyun.ctapi.ctimage.exportprivateimage.*;
import cn.ctyun.ctapi.ctimage.reactivateprivateimage.*;
import cn.ctyun.ctapi.ctimage.deactivateprivateimage.*;
import cn.ctyun.ctapi.ctimage.showsharedlist.*;
import cn.ctyun.ctapi.ctimage.listprivateimageimporttasks.*;
import cn.ctyun.ctapi.ctimage.deleteprivateimageimporttask.*;

public class CtimageClient extends CTClient {
    /**
     * 一类节点-*-镜像服务ctimage-查询可以使用的镜像资源
     * 根据云主机规格、镜像可见类型等，查询可以使用的镜像资源。<br />准备：<br />1. 在调用前需了解如何构造请求，可参见：如何调用 API - 构造请求。<br />2. OpenAPI 请求需进行加密调用，可参见：如何调用 API - 认证鉴权。<br />注意：<br />1. 推荐使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=16&api=4577&data=97" target="_blank">查询物理机镜像</a>接口来查询物理机镜像。<br />2. 在调用前，请您认真阅读此文档，包括但不限于参数描述中的“注意”部分。
     */
    public CTResponse<ListImagesResponseData> ListImages(ListImagesRequest request) {
        return request(request, ListImagesResponseData.class);
    }

    /**
     * 一类节点-*-镜像服务ctimage-查询镜像详细信息
     * 根据镜像 ID，查询一份镜像的详细信息。<br />准备：<br />1. 在调用前需了解如何构造请求，可参见：如何调用 API - 构造请求。<br />2. OpenAPI 请求需进行加密调用，可参见：如何调用 API - 认证鉴权。<br />注意：<br />1. 推荐使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=16&api=4577&data=97" target="_blank">查询物理机镜像</a>接口来查询物理机镜像。<br />2. 在调用前，请您认真阅读此文档，包括但不限于参数描述中的“注意”部分。
     */
    public CTResponse<DetailImageResponseData> DetailImage(DetailImageRequest request) {
        return request(request, DetailImageResponseData.class);
    }

    /**
     * 一类节点-*-镜像服务ctimage-创建私有镜像（云主机系统盘）
     * 使用指定的云主机的系统盘来创建一份私有镜像。
     */
    public CTResponse<CreateEcsSystemDiskImageResponseData> CreateEcsSystemDiskImage(CreateEcsSystemDiskImageRequest request) {
        return request(request, CreateEcsSystemDiskImageResponseData.class);
    }

    /**
     * 一类节点-*-镜像服务ctimage-删除私有镜像
     * 删除一份私有镜像。
     */
    public CTResponse<DeletePrivateImageResponseData> DeletePrivateImage(DeletePrivateImageRequest request) {
        return request(request, DeletePrivateImageResponseData.class);
    }

    /**
     * 一类节点-*-镜像服务ctimage-创建私有镜像（镜像文件）
     * 使用指定的存在对象存储（原生版）Ⅰ 型的镜像文件来创建一份私有镜像。
     */
    public CTResponse<ImportPrivateImageResponseData> ImportPrivateImage(ImportPrivateImageRequest request) {
        return request(request, ImportPrivateImageResponseData.class);
    }

    /**
     * 一类节点-*-镜像服务ctimage-修改私有镜像属性
     * 修改一份私有镜像的名称、描述信息。
     */
    public CTResponse<UpdatePrivateImageResponseData> UpdatePrivateImage(UpdatePrivateImageRequest request) {
        return request(request, UpdatePrivateImageResponseData.class);
    }

    /**
     * 一类节点-*-镜像服务ctimage-共享私有镜像
     * 与指定用户共享一份私有镜像。
     */
    public CTResponse<SharePrivateImageResponseData> SharePrivateImage(SharePrivateImageRequest request) {
        return request(request, SharePrivateImageResponseData.class);
    }

    /**
     * 一类节点-*-镜像服务ctimage-接受共享镜像
     * 接受一份共享镜像。
     */
    public CTResponse<AcceptSharedImageResponseData> AcceptSharedImage(AcceptSharedImageRequest request) {
        return request(request, AcceptSharedImageResponseData.class);
    }

    /**
     * 一类节点-*-镜像服务ctimage-拒绝共享镜像
     * 拒绝一份共享镜像。
     */
    public CTResponse<RejectSharedImageResponseData> RejectSharedImage(RejectSharedImageRequest request) {
        return request(request, RejectSharedImageResponseData.class);
    }

    /**
     * 一类节点-*-镜像服务ctimage-取消共享私有镜像
     * 取消共享一份私有镜像给指定用户。
     */
    public CTResponse<UnsharePrivateImageResponseData> UnsharePrivateImage(UnsharePrivateImageRequest request) {
        return request(request, UnsharePrivateImageResponseData.class);
    }

    /**
     * 一类节点-*-镜像服务ctimage-创建私有镜像（云主机数据盘）
     * 使用指定的云主机数据盘来创建一份私有镜像。
     */
    public CTResponse<CreateEcsDataDiskImageResponseData> CreateEcsDataDiskImage(CreateEcsDataDiskImageRequest request) {
        return request(request, CreateEcsDataDiskImageResponseData.class);
    }

    /**
     * 一类节点-*-镜像服务ctimage-校验镜像文件地址
     * 校验一个镜像文件地址。
     */
    public CTResponse<ValidateImageFileSourceResponseData> ValidateImageFileSource(ValidateImageFileSourceRequest request) {
        return request(request, ValidateImageFileSourceResponseData.class);
    }

    /**
     * 一类节点-*-镜像服务ctimage-导出私有镜像
     * 导出一份私有镜像到指定的对象存储（原生版）Ⅰ 型的桶。
     */
    public CTResponse<ExportPrivateImageResponseData> ExportPrivateImage(ExportPrivateImageRequest request) {
        return request(request, ExportPrivateImageResponseData.class);
    }

    /**
     * 一类节点-*-镜像服务ctimage-取消弃用私有镜像
     * 取消弃用一份私有镜像。
     */
    public CTResponse<ReactivatePrivateImageResponseData> ReactivatePrivateImage(ReactivatePrivateImageRequest request) {
        return request(request, ReactivatePrivateImageResponseData.class);
    }

    /**
     * 一类节点-*-镜像服务ctimage-弃用私有镜像
     * 弃用一份私有镜像。
     */
    public CTResponse<DeactivatePrivateImageResponseData> DeactivatePrivateImage(DeactivatePrivateImageRequest request) {
        return request(request, DeactivatePrivateImageResponseData.class);
    }

    /**
     * 一类节点-*-镜像服务ctimage-查询私有镜像的共享列表
     * 查询一份私有镜像的共享列表。<br />在您将一份私有镜像共享给其他用户之后，此接口可用于查询该私有镜像的共享列表。若需要查询您的共享镜像（其他用户共享给您），则可使用<a href="https://eop.ctyun.cn/ebp/ctapiDocument/search?sid=23&api=4763&data=89" target="_blank">查询可以使用的镜像资源</a>接口。
     */
    public CTResponse<ShowSharedListResponseData> ShowSharedList(ShowSharedListRequest request) {
        return request(request, ShowSharedListResponseData.class);
    }

    /**
     * 一类节点-全局-镜像服务ctimage-查询创建私有镜像（镜像文件）任务列表
     * 查询使用镜像文件来创建私有镜像的任务列表。
     */
    public CTResponse<ListPrivateImageImportTasksResponseData> ListPrivateImageImportTasks(ListPrivateImageImportTasksRequest request) {
        return request(request, ListPrivateImageImportTasksResponseData.class);
    }

    /**
     * 一类节点-全局-镜像服务ctimage-删除创建私有镜像（镜像文件）任务
     * 删除一个使用镜像文件来创建私有镜像的失败任务。
     */
    public CTResponse<DeletePrivateImageImportTaskResponseData> DeletePrivateImageImportTask(DeletePrivateImageImportTaskRequest request) {
        return request(request, DeletePrivateImageImportTaskResponseData.class);
    }

}
