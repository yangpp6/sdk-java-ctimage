package cn.ctyun.ctapi.ctimage.reactivateprivateimage;

import com.alibaba.fastjson.JSONObject;
import cn.ctyun.ctapi.Credential;
import cn.ctyun.ctapi.CTResponse;
import cn.ctyun.ctapi.CTFile;
import java.util.*;
import cn.ctyun.ctapi.ctimage.CtimageClient;

/**
 * <一类节点-*-镜像服务ctimage-取消弃用私有镜像>
 * Example: ReactivatePrivateImageExample
 */
public class ReactivatePrivateImageExample {
    public static void main(String[] args) {
        String ak = "<YOUR AK>";
        String sk = "<YOUR SK>";
        String endingPoint = "<YOUR ENDINGPOINT>";
        System.out.println(run(ak, sk, endingPoint));
    }

    public static String run(String ak, String sk, String endingPoint) {
        Credential credential = new Credential().withAk(ak).withSk(sk);
        CtimageClient client = new CtimageClient();
        client.init(credential, endingPoint);
        try {
            ReactivatePrivateImageRequest request = new ReactivatePrivateImageRequest().withImageID("8d8e8888-8ed8-88b8-88cb-888f8b8cf8fa").withRegionID(
                    "88f8888888dd88ec888888888d888d8b");
            CTResponse<ReactivatePrivateImageResponseData> response = client.ReactivatePrivateImage(request);
            return JSONObject.toJSONString(response);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
