package cn.ctyun.ctapi.ctimage.createecsdatadiskimage;

import com.alibaba.fastjson.JSONObject;
import cn.ctyun.ctapi.Credential;
import cn.ctyun.ctapi.CTResponse;
import cn.ctyun.ctapi.CTFile;
import java.util.*;
import cn.ctyun.ctapi.ctimage.CtimageClient;

/**
 * <一类节点-*-镜像服务ctimage-创建私有镜像（云主机数据盘）>
 * Example: CreateEcsDataDiskImageExample
 */
public class CreateEcsDataDiskImageExample {
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
            CreateEcsDataDiskImageRequestBody body = new CreateEcsDataDiskImageRequestBody().withDataDiskID("8888a888-b888-8888-a888-baee8d8ce88c")
                    .withImageName("CentOS-test").withInstanceID("88f888ea-88ff-88ec-a8bc-888888888fe8").withRegionID("88f8888888dd88ec888888888d888d8b")
                    .withDescription("Test CentOS").withProjectID("0");
            CreateEcsDataDiskImageRequest request = new CreateEcsDataDiskImageRequest().withBody(body);
            CTResponse<CreateEcsDataDiskImageResponseData> response = client.CreateEcsDataDiskImage(request);
            return JSONObject.toJSONString(response);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
