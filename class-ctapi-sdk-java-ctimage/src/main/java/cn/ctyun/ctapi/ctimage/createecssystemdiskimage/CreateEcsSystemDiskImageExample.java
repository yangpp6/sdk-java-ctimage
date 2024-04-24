package cn.ctyun.ctapi.ctimage.createecssystemdiskimage;

import com.alibaba.fastjson.JSONObject;
import cn.ctyun.ctapi.Credential;
import cn.ctyun.ctapi.CTResponse;
import cn.ctyun.ctapi.CTFile;
import java.util.*;
import cn.ctyun.ctapi.ctimage.CtimageClient;

/**
 * <一类节点-*-镜像服务ctimage-创建私有镜像（云主机系统盘）>
 * Example: CreateEcsSystemDiskImageExample
 */
public class CreateEcsSystemDiskImageExample {
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
            CreateEcsSystemDiskImageRequestBody body = new CreateEcsSystemDiskImageRequestBody().withImageName("CentOS-test")
                    .withInstanceID("88f888ea-88ff-88ec-a8bc-888888888fe8").withRegionID("88f8888888dd88ec888888888d888d8b").withDescription("Test CentOS")
                    .withProjectID("0");
            CreateEcsSystemDiskImageRequest request = new CreateEcsSystemDiskImageRequest().withBody(body);
            CTResponse<CreateEcsSystemDiskImageResponseData> response = client.CreateEcsSystemDiskImage(request);
            return JSONObject.toJSONString(response);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
