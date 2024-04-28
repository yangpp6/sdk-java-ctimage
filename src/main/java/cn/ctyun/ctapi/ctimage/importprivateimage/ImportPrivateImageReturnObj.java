package cn.ctyun.ctapi.ctimage.importprivateimage;

import cn.ctyun.ctapi.CTFile;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

/**
 * <一类节点-*-镜像服务ctimage-创建私有镜像（镜像文件）>
 * Entity: ImportPrivateImageReturnObj
 */
public class ImportPrivateImageReturnObj {
    /**
     * images
     * 镜像列表。注意：当前暂仅在多可用区资源池下返回。
     */
    private ImportPrivateImageImage[] images;

    /**
     * set images
     * @param images 镜像列表。注意：当前暂仅在多可用区资源池下返回。
     * @return this
     */
    public ImportPrivateImageReturnObj withImages(ImportPrivateImageImage[] images) {
        this.images = images;
        return this;
    }

    public ImportPrivateImageImage[] getImages() {
        return images;
    }

    public void setImages(ImportPrivateImageImage[] images) {
        this.images = images;
    }
}
