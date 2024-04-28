package cn.ctyun.ctapi.ctimage.createecssystemdiskimage;

import cn.ctyun.ctapi.CTFile;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

/**
 * <一类节点-*-镜像服务ctimage-创建私有镜像（云主机系统盘）>
 * Entity: CreateEcsSystemDiskImageReturnObj
 */
public class CreateEcsSystemDiskImageReturnObj {
    /**
     * images
     * 镜像列表。
     */
    private CreateEcsSystemDiskImageImage[] images;

    /**
     * set images
     * @param images 镜像列表。
     * @return this
     */
    public CreateEcsSystemDiskImageReturnObj withImages(CreateEcsSystemDiskImageImage[] images) {
        this.images = images;
        return this;
    }

    public CreateEcsSystemDiskImageImage[] getImages() {
        return images;
    }

    public void setImages(CreateEcsSystemDiskImageImage[] images) {
        this.images = images;
    }
}
