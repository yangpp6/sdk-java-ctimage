package cn.ctyun.ctapi.ctimage.detailimage;

import cn.ctyun.ctapi.CTFile;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

/**
 * <一类节点-*-镜像服务ctimage-查询镜像详细信息>
 * Entity: DetailImageReturnObj
 */
public class DetailImageReturnObj {
    /**
     * images
     * 镜像列表。应包含 1 个镜像。
     */
    private DetailImageImage[] images;

    /**
     * set images
     * @param images 镜像列表。应包含 1 个镜像。
     * @return this
     */
    public DetailImageReturnObj withImages(DetailImageImage[] images) {
        this.images = images;
        return this;
    }

    public DetailImageImage[] getImages() {
        return images;
    }

    public void setImages(DetailImageImage[] images) {
        this.images = images;
    }
}
