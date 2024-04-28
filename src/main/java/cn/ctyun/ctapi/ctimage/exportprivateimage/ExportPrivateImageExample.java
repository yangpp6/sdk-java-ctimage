package cn.ctyun.ctapi.ctimage.exportprivateimage;

import com.alibaba.fastjson.JSONObject;
import cn.ctyun.ctapi.Credential;
import cn.ctyun.ctapi.CTResponse;
import cn.ctyun.ctapi.CTFile;
import java.util.*;
import cn.ctyun.ctapi.ctimage.CtimageClient;

/**
 * <一类节点-*-镜像服务ctimage-导出私有镜像>
 * Example: ExportPrivateImageExample
 */
public class ExportPrivateImageExample {
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
            ExportPrivateImageRequestBody body = new ExportPrivateImageRequestBody().withBucket("bucket-fa88").withFilename("CentOS-test")
                    .withImageID("8d8e8888-8ed8-88b8-88cb-888f8b8cf8fa").withRegionID("88f8888888dd88ec888888888d888d8b").withImageFileFormat("raw");
            ExportPrivateImageRequest request = new ExportPrivateImageRequest().withBody(body);
            CTResponse<ExportPrivateImageResponseData> response = client.ExportPrivateImage(request);
            return JSONObject.toJSONString(response);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
