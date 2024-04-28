package cn.ctyun.ctapi.ctimage.importprivateimage;

import com.alibaba.fastjson.JSONObject;
import cn.ctyun.ctapi.Credential;
import cn.ctyun.ctapi.CTResponse;
import cn.ctyun.ctapi.CTFile;
import java.util.*;
import cn.ctyun.ctapi.ctimage.CtimageClient;

/**
 * <一类节点-*-镜像服务ctimage-创建私有镜像（镜像文件）>
 * Example: ImportPrivateImageExample
 */
public class ImportPrivateImageExample {
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
            ImportPrivateImageImageProperties imageProperties = new ImportPrivateImageImageProperties().withImageName("CentOS-test").withOsDistro("centos")
                    .withOsVersion("7.8").withArchitecture("x86_64").withBootMode("bios").withDescription("Test CentOS").withDiskSize(5).withImageType("")
                    .withMaximumRAM(0).withMinimumRAM(0);
            ImportPrivateImageRequestBody body = new ImportPrivateImageRequestBody().withImageFileSource("https://xxx.zos.ctyun.cn/bucket-xxx/image-xxx")
                    .withImageProperties(imageProperties).withRegionID("88f8888888dd88ec888888888d888d8b").withProjectID("0");
            ImportPrivateImageRequest request = new ImportPrivateImageRequest().withBody(body);
            CTResponse<ImportPrivateImageResponseData> response = client.ImportPrivateImage(request);
            return JSONObject.toJSONString(response);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
