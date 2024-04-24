package cn.ctyun.ctapi.ctimage.importprivateimage;

import cn.ctyun.ctapi.CTFile;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

/**
 * <一类节点-*-镜像服务ctimage-创建私有镜像（镜像文件）>
 * Entity: ImportPrivateImageImage
 */
public class ImportPrivateImageImage {
    /**
     * architecture
     * 镜像系统架构，取值范围（值：描述）：<br />aarch64：AArch64 架构，仅支持 UEFI 启动方式<br />x86_64：x86_64 架构，支持 BIOS 和 UEFI 启动方式
     */
    private String architecture;
    /**
     * azName
     * 可用区名称。
     */
    private String azName;
    /**
     * bootMode
     * 启动方式，取值范围（值：描述）：<br />bios：BIOS 启动方式<br />uefi：UEFI 启动方式
     */
    private String bootMode;
    /**
     * containerFormat
     * 容器格式。
     */
    private String containerFormat;
    /**
     * createdTime
     * 镜像创建时间，epoch 秒数，即从 1970-01-01 00:00:00 UTC 到当前时间的秒数。
     */
    private Integer createdTime;
    /**
     * description
     * 镜像描述信息。
     */
    private String description;
    /**
     * destinationUser
     * 共享镜像的接受人。
     */
    private String destinationUser;
    /**
     * diskFormat
     * 磁盘格式，取值范围（值：描述）：<br />qcow2：QCOW2 格式<br />raw：RAW 格式<br />vhd：VHD 格式<br />vmdk：VMDK 格式
     */
    private String diskFormat;
    /**
     * diskID
     * 私有镜像来源的系统盘/数据盘 ID。
     */
    private String diskID;
    /**
     * diskSize
     * 磁盘容量，单位为 GB。
     */
    private Integer diskSize;
    /**
     * imageClass
     * 镜像类别，取值范围（值：描述）：<br />BMS：物理机<br />ECS：云主机
     */
    private String imageClass;
    /**
     * imageID
     * 镜像 ID。
     */
    private String imageID;
    /**
     * imageName
     * 镜像名称。
     */
    private String imageName;
    /**
     * imageType
     * 镜像类型，取值范围（值：描述）：<br />（空或空字符串）：系统盘镜像<br />data_disk_image：数据盘镜像
     */
    private String imageType;
    /**
     * maximumRAM
     * 最大内存。
     */
    private Integer maximumRAM;
    /**
     * minimumRAM
     * 最小内存。
     */
    private Integer minimumRAM;
    /**
     * osDistro
     * 操作系统的发行版名称。
     */
    private String osDistro;
    /**
     * osType
     * 操作系统类型，取值范围（值：描述）：<br />linux：Linux 系操作系统<br />windows：Windows 系操作系统
     */
    private String osType;
    /**
     * osVersion
     * 操作系统版本。
     */
    private String osVersion;
    /**
     * projectID
     * 项目 ID。
     */
    private String projectID;
    /**
     * sharedListLength
     * 私有镜像的共享列表的总记录数。
     */
    private Integer sharedListLength;
    /**
     * size
     * 镜像大小，单位为 byte。
     */
    private Integer size;
    /**
     * sourceServerID
     * 私有镜像来源的云主机/物理机 ID。
     */
    private String sourceServerID;
    /**
     * sourceUser
     * 共享镜像的发起人。
     */
    private String sourceUser;
    /**
     * status
     * 镜像状态，取值范围（值：描述）：<br />accepted：已接受共享镜像<br />active：正常<br />deactivated：已弃用<br />deactivating：弃用中<br />deleted：已删除<br />deleting：删除中<br />error：错误<br />importing：导入中<br />killed：上传出错，镜像不可读<br />pending_delete：等待删除中<br />queued：排队中<br />reactivating：取消弃用中<br />rejected：已拒绝共享镜像<br />saving：保存中<br />syncing：同步中<br />uploading：上传中<br />waiting：等待接受/拒绝共享镜像
     */
    private String status;
    /**
     * tags
     * 标签。一种场景是标记公共 GPU 镜像适用规格。
     */
    private String tags;
    /**
     * updatedTime
     * 镜像更新时间，epoch 秒数，即从 1970-01-01 00:00:00 UTC 到当前时间的秒数。
     */
    private Integer updatedTime;
    /**
     * visibility
     * 镜像可见类型，应始终为 private（私有镜像）。
     */
    private String visibility;

    /**
     * set architecture
     * @param architecture 镜像系统架构，取值范围（值：描述）：<br />aarch64：AArch64 架构，仅支持 UEFI 启动方式<br />x86_64：x86_64 架构，支持 BIOS 和 UEFI 启动方式
     * @return this
     */
    public ImportPrivateImageImage withArchitecture(String architecture) {
        this.architecture = architecture;
        return this;
    }

    /**
     * set azName
     * @param azName 可用区名称。
     * @return this
     */
    public ImportPrivateImageImage withAzName(String azName) {
        this.azName = azName;
        return this;
    }

    /**
     * set bootMode
     * @param bootMode 启动方式，取值范围（值：描述）：<br />bios：BIOS 启动方式<br />uefi：UEFI 启动方式
     * @return this
     */
    public ImportPrivateImageImage withBootMode(String bootMode) {
        this.bootMode = bootMode;
        return this;
    }

    /**
     * set containerFormat
     * @param containerFormat 容器格式。
     * @return this
     */
    public ImportPrivateImageImage withContainerFormat(String containerFormat) {
        this.containerFormat = containerFormat;
        return this;
    }

    /**
     * set createdTime
     * @param createdTime 镜像创建时间，epoch 秒数，即从 1970-01-01 00:00:00 UTC 到当前时间的秒数。
     * @return this
     */
    public ImportPrivateImageImage withCreatedTime(Integer createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    /**
     * set description
     * @param description 镜像描述信息。
     * @return this
     */
    public ImportPrivateImageImage withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * set destinationUser
     * @param destinationUser 共享镜像的接受人。
     * @return this
     */
    public ImportPrivateImageImage withDestinationUser(String destinationUser) {
        this.destinationUser = destinationUser;
        return this;
    }

    /**
     * set diskFormat
     * @param diskFormat 磁盘格式，取值范围（值：描述）：<br />qcow2：QCOW2 格式<br />raw：RAW 格式<br />vhd：VHD 格式<br />vmdk：VMDK 格式
     * @return this
     */
    public ImportPrivateImageImage withDiskFormat(String diskFormat) {
        this.diskFormat = diskFormat;
        return this;
    }

    /**
     * set diskID
     * @param diskID 私有镜像来源的系统盘/数据盘 ID。
     * @return this
     */
    public ImportPrivateImageImage withDiskID(String diskID) {
        this.diskID = diskID;
        return this;
    }

    /**
     * set diskSize
     * @param diskSize 磁盘容量，单位为 GB。
     * @return this
     */
    public ImportPrivateImageImage withDiskSize(Integer diskSize) {
        this.diskSize = diskSize;
        return this;
    }

    /**
     * set imageClass
     * @param imageClass 镜像类别，取值范围（值：描述）：<br />BMS：物理机<br />ECS：云主机
     * @return this
     */
    public ImportPrivateImageImage withImageClass(String imageClass) {
        this.imageClass = imageClass;
        return this;
    }

    /**
     * set imageID
     * @param imageID 镜像 ID。
     * @return this
     */
    public ImportPrivateImageImage withImageID(String imageID) {
        this.imageID = imageID;
        return this;
    }

    /**
     * set imageName
     * @param imageName 镜像名称。
     * @return this
     */
    public ImportPrivateImageImage withImageName(String imageName) {
        this.imageName = imageName;
        return this;
    }

    /**
     * set imageType
     * @param imageType 镜像类型，取值范围（值：描述）：<br />（空或空字符串）：系统盘镜像<br />data_disk_image：数据盘镜像
     * @return this
     */
    public ImportPrivateImageImage withImageType(String imageType) {
        this.imageType = imageType;
        return this;
    }

    /**
     * set maximumRAM
     * @param maximumRAM 最大内存。
     * @return this
     */
    public ImportPrivateImageImage withMaximumRAM(Integer maximumRAM) {
        this.maximumRAM = maximumRAM;
        return this;
    }

    /**
     * set minimumRAM
     * @param minimumRAM 最小内存。
     * @return this
     */
    public ImportPrivateImageImage withMinimumRAM(Integer minimumRAM) {
        this.minimumRAM = minimumRAM;
        return this;
    }

    /**
     * set osDistro
     * @param osDistro 操作系统的发行版名称。
     * @return this
     */
    public ImportPrivateImageImage withOsDistro(String osDistro) {
        this.osDistro = osDistro;
        return this;
    }

    /**
     * set osType
     * @param osType 操作系统类型，取值范围（值：描述）：<br />linux：Linux 系操作系统<br />windows：Windows 系操作系统
     * @return this
     */
    public ImportPrivateImageImage withOsType(String osType) {
        this.osType = osType;
        return this;
    }

    /**
     * set osVersion
     * @param osVersion 操作系统版本。
     * @return this
     */
    public ImportPrivateImageImage withOsVersion(String osVersion) {
        this.osVersion = osVersion;
        return this;
    }

    /**
     * set projectID
     * @param projectID 项目 ID。
     * @return this
     */
    public ImportPrivateImageImage withProjectID(String projectID) {
        this.projectID = projectID;
        return this;
    }

    /**
     * set sharedListLength
     * @param sharedListLength 私有镜像的共享列表的总记录数。
     * @return this
     */
    public ImportPrivateImageImage withSharedListLength(Integer sharedListLength) {
        this.sharedListLength = sharedListLength;
        return this;
    }

    /**
     * set size
     * @param size 镜像大小，单位为 byte。
     * @return this
     */
    public ImportPrivateImageImage withSize(Integer size) {
        this.size = size;
        return this;
    }

    /**
     * set sourceServerID
     * @param sourceServerID 私有镜像来源的云主机/物理机 ID。
     * @return this
     */
    public ImportPrivateImageImage withSourceServerID(String sourceServerID) {
        this.sourceServerID = sourceServerID;
        return this;
    }

    /**
     * set sourceUser
     * @param sourceUser 共享镜像的发起人。
     * @return this
     */
    public ImportPrivateImageImage withSourceUser(String sourceUser) {
        this.sourceUser = sourceUser;
        return this;
    }

    /**
     * set status
     * @param status 镜像状态，取值范围（值：描述）：<br />accepted：已接受共享镜像<br />active：正常<br />deactivated：已弃用<br />deactivating：弃用中<br />deleted：已删除<br />deleting：删除中<br />error：错误<br />importing：导入中<br />killed：上传出错，镜像不可读<br />pending_delete：等待删除中<br />queued：排队中<br />reactivating：取消弃用中<br />rejected：已拒绝共享镜像<br />saving：保存中<br />syncing：同步中<br />uploading：上传中<br />waiting：等待接受/拒绝共享镜像
     * @return this
     */
    public ImportPrivateImageImage withStatus(String status) {
        this.status = status;
        return this;
    }

    /**
     * set tags
     * @param tags 标签。一种场景是标记公共 GPU 镜像适用规格。
     * @return this
     */
    public ImportPrivateImageImage withTags(String tags) {
        this.tags = tags;
        return this;
    }

    /**
     * set updatedTime
     * @param updatedTime 镜像更新时间，epoch 秒数，即从 1970-01-01 00:00:00 UTC 到当前时间的秒数。
     * @return this
     */
    public ImportPrivateImageImage withUpdatedTime(Integer updatedTime) {
        this.updatedTime = updatedTime;
        return this;
    }

    /**
     * set visibility
     * @param visibility 镜像可见类型，应始终为 private（私有镜像）。
     * @return this
     */
    public ImportPrivateImageImage withVisibility(String visibility) {
        this.visibility = visibility;
        return this;
    }

    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    public String getAzName() {
        return azName;
    }

    public void setAzName(String azName) {
        this.azName = azName;
    }

    public String getBootMode() {
        return bootMode;
    }

    public void setBootMode(String bootMode) {
        this.bootMode = bootMode;
    }

    public String getContainerFormat() {
        return containerFormat;
    }

    public void setContainerFormat(String containerFormat) {
        this.containerFormat = containerFormat;
    }

    public Integer getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Integer createdTime) {
        this.createdTime = createdTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDestinationUser() {
        return destinationUser;
    }

    public void setDestinationUser(String destinationUser) {
        this.destinationUser = destinationUser;
    }

    public String getDiskFormat() {
        return diskFormat;
    }

    public void setDiskFormat(String diskFormat) {
        this.diskFormat = diskFormat;
    }

    public String getDiskID() {
        return diskID;
    }

    public void setDiskID(String diskID) {
        this.diskID = diskID;
    }

    public Integer getDiskSize() {
        return diskSize;
    }

    public void setDiskSize(Integer diskSize) {
        this.diskSize = diskSize;
    }

    public String getImageClass() {
        return imageClass;
    }

    public void setImageClass(String imageClass) {
        this.imageClass = imageClass;
    }

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
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

    public String getOsDistro() {
        return osDistro;
    }

    public void setOsDistro(String osDistro) {
        this.osDistro = osDistro;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    public Integer getSharedListLength() {
        return sharedListLength;
    }

    public void setSharedListLength(Integer sharedListLength) {
        this.sharedListLength = sharedListLength;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSourceServerID() {
        return sourceServerID;
    }

    public void setSourceServerID(String sourceServerID) {
        this.sourceServerID = sourceServerID;
    }

    public String getSourceUser() {
        return sourceUser;
    }

    public void setSourceUser(String sourceUser) {
        this.sourceUser = sourceUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Integer getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Integer updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }
}
