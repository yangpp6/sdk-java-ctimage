package cn.ctyun.ctapi.ctimage.createecsdatadiskimage;

import cn.ctyun.ctapi.CTFile;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

/**
 * <一类节点-*-镜像服务ctimage-创建私有镜像（云主机数据盘）>
 * Entity: CreateEcsDataDiskImageReturnObj
 */
public class CreateEcsDataDiskImageReturnObj {
    /**
     * images
     * 镜像列表。
     */
    private CreateEcsDataDiskImageImage[] images;

    /**
     * set images
     * @param images 镜像列表。
     * @return this
     */
    public CreateEcsDataDiskImageReturnObj withImages(CreateEcsDataDiskImageImage[] images) {
        this.images = images;
        return this;
    }

    public CreateEcsDataDiskImageImage[] getImages() {
        return images;
    }

    public void setImages(CreateEcsDataDiskImageImage[] images) {
        this.images = images;
    }
}
