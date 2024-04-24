package cn.ctyun.ctapi.ctimage.importprivateimage;

import cn.ctyun.ctapi.CTFile;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

/**
 * <一类节点-*-镜像服务ctimage-创建私有镜像（镜像文件）>
 * Entity: ImportPrivateImageImageProperties
 */
public class ImportPrivateImageImageProperties {
    /**
     * imageName
     * 镜像名称。注意：长度为 2~32 个字符，只能由数字、字母、- 组成，不能以数字、- 开头，且不能以 - 结尾。
     */
    private String imageName;
    /**
     * osDistro
     * 操作系统的发行版名称。注意：对于 Windows 系操作系统，应确保参数值是 windows，否则视作 Linux 系操作系统；对于 Linux 系操作系统，参数值的取值应根据系统实际情况，建议参照 cloud-init 的配置文件（/etc/cloud/cloud.cfg）中 system_info.distro 的取值或以下取值：<br />anolis<br />centos<br />ctyunos<br />debian<br />fedora<br />kylin<br />openEuler<br />ubuntu<br />UnionTech<br />windows
     */
    private String osDistro;
    /**
     * osVersion
     * 操作系统版本。注意：参数值的取值应根据系统实际情况，建议参考（以下列出 osDistro 所列取值对应的 osVersion 参考取值）：<br />anolis: 7.9<br />centos: 7.8<br />ctyunos: 2.0.1<br />debian: 9.0.0<br />fedora: 36<br />kylin: V10_sp1<br />openEuler: 20.03<br />ubuntu: 18.04<br />UnionTech: V20_1050u1e<br />windows: 2008
     */
    private String osVersion;
    /**
     * architecture
     * 镜像系统架构取值范围（值：描述）：<br />aarch64：AArch64 架构，仅支持 UEFI 启动方式<br />x86_64：x86_64 架构，支持 BIOS 和 UEFI 启动方式<br />注意：所指定的镜像系统架构应受所指定的资源池支持。
     */
    private String architecture;
    /**
     * bootMode
     * 启动方式，取值范围（值：描述）：<br />bios：BIOS 启动方式<br />uefi：UEFI 启动方式<br />注意：若镜像系统架构为 aarch64，则对启动方式的指定不生效。此参数无默认值，不指定则表示使用镜像系统架构的默认启动方式（x86_64 架构的默认启动方式为 BIOS）。
     */
    private String bootMode;
    /**
     * description
     * 镜像描述信息。注意：长度为 1~128 个字符。
     */
    private String description;
    /**
     * diskSize
     * 磁盘容量，单位为 GB，取值范围：最小 5（默认值），最大 1024。注意：磁盘容量不能小于镜像文件的大小；若小于镜像文件的大小，则实际的磁盘容量将使用镜像文件的大小。
     */
    private Integer diskSize;
    /**
     * imageType
     * 镜像种类，取值范围（值：描述）：<br />（空或空字符串）：系统盘镜像<br />data_disk_image：数据盘镜像
     */
    private String imageType;
    /**
     * maximumRAM
     * 最大内存，单位为 GB，取值范围：0（默认值，即不限制）/ 1 / 2 / 4 / 8 / 16 / 32 / 64 / 128 / 256 / 512。注意：若取值不为 0 且所指定的最小内存也不为不限制时，则取值应大于或等于所指定的最小内存。
     */
    private Integer maximumRAM;
    /**
     * minimumRAM
     * 最小内存，单位为 GB，取值范围：0（默认值，即不限制）/ 1 / 2 / 4 / 8 / 16 / 32 / 64 / 128 / 256 / 512。注意：若取值不为 0 且所指定的最大内存也不为不限制时，则取值应小于或等于所指定的最大内存。
     */
    private Integer minimumRAM;

    /**
     * set imageName
     * @param imageName 镜像名称。注意：长度为 2~32 个字符，只能由数字、字母、- 组成，不能以数字、- 开头，且不能以 - 结尾。
     * @return this
     */
    public ImportPrivateImageImageProperties withImageName(String imageName) {
        this.imageName = imageName;
        return this;
    }

    /**
     * set osDistro
     * @param osDistro 操作系统的发行版名称。注意：对于 Windows 系操作系统，应确保参数值是 windows，否则视作 Linux 系操作系统；对于 Linux 系操作系统，参数值的取值应根据系统实际情况，建议参照 cloud-init 的配置文件（/etc/cloud/cloud.cfg）中 system_info.distro 的取值或以下取值：<br />anolis<br />centos<br />ctyunos<br />debian<br />fedora<br />kylin<br />openEuler<br />ubuntu<br />UnionTech<br />windows
     * @return this
     */
    public ImportPrivateImageImageProperties withOsDistro(String osDistro) {
        this.osDistro = osDistro;
        return this;
    }

    /**
     * set osVersion
     * @param osVersion 操作系统版本。注意：参数值的取值应根据系统实际情况，建议参考（以下列出 osDistro 所列取值对应的 osVersion 参考取值）：<br />anolis: 7.9<br />centos: 7.8<br />ctyunos: 2.0.1<br />debian: 9.0.0<br />fedora: 36<br />kylin: V10_sp1<br />openEuler: 20.03<br />ubuntu: 18.04<br />UnionTech: V20_1050u1e<br />windows: 2008
     * @return this
     */
    public ImportPrivateImageImageProperties withOsVersion(String osVersion) {
        this.osVersion = osVersion;
        return this;
    }

    /**
     * set architecture
     * @param architecture 镜像系统架构取值范围（值：描述）：<br />aarch64：AArch64 架构，仅支持 UEFI 启动方式<br />x86_64：x86_64 架构，支持 BIOS 和 UEFI 启动方式<br />注意：所指定的镜像系统架构应受所指定的资源池支持。
     * @return this
     */
    public ImportPrivateImageImageProperties withArchitecture(String architecture) {
        this.architecture = architecture;
        return this;
    }

    /**
     * set bootMode
     * @param bootMode 启动方式，取值范围（值：描述）：<br />bios：BIOS 启动方式<br />uefi：UEFI 启动方式<br />注意：若镜像系统架构为 aarch64，则对启动方式的指定不生效。此参数无默认值，不指定则表示使用镜像系统架构的默认启动方式（x86_64 架构的默认启动方式为 BIOS）。
     * @return this
     */
    public ImportPrivateImageImageProperties withBootMode(String bootMode) {
        this.bootMode = bootMode;
        return this;
    }

    /**
     * set description
     * @param description 镜像描述信息。注意：长度为 1~128 个字符。
     * @return this
     */
    public ImportPrivateImageImageProperties withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * set diskSize
     * @param diskSize 磁盘容量，单位为 GB，取值范围：最小 5（默认值），最大 1024。注意：磁盘容量不能小于镜像文件的大小；若小于镜像文件的大小，则实际的磁盘容量将使用镜像文件的大小。
     * @return this
     */
    public ImportPrivateImageImageProperties withDiskSize(Integer diskSize) {
        this.diskSize = diskSize;
        return this;
    }

    /**
     * set imageType
     * @param imageType 镜像种类，取值范围（值：描述）：<br />（空或空字符串）：系统盘镜像<br />data_disk_image：数据盘镜像
     * @return this
     */
    public ImportPrivateImageImageProperties withImageType(String imageType) {
        this.imageType = imageType;
        return this;
    }

    /**
     * set maximumRAM
     * @param maximumRAM 最大内存，单位为 GB，取值范围：0（默认值，即不限制）/ 1 / 2 / 4 / 8 / 16 / 32 / 64 / 128 / 256 / 512。注意：若取值不为 0 且所指定的最小内存也不为不限制时，则取值应大于或等于所指定的最小内存。
     * @return this
     */
    public ImportPrivateImageImageProperties withMaximumRAM(Integer maximumRAM) {
        this.maximumRAM = maximumRAM;
        return this;
    }

    /**
     * set minimumRAM
     * @param minimumRAM 最小内存，单位为 GB，取值范围：0（默认值，即不限制）/ 1 / 2 / 4 / 8 / 16 / 32 / 64 / 128 / 256 / 512。注意：若取值不为 0 且所指定的最大内存也不为不限制时，则取值应小于或等于所指定的最大内存。
     * @return this
     */
    public ImportPrivateImageImageProperties withMinimumRAM(Integer minimumRAM) {
        this.minimumRAM = minimumRAM;
        return this;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getOsDistro() {
        return osDistro;
    }

    public void setOsDistro(String osDistro) {
        this.osDistro = osDistro;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
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

    public Integer getDiskSize() {
        return diskSize;
    }

    public void setDiskSize(Integer diskSize) {
        this.diskSize = diskSize;
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
}
