package cn.ctyun.ctapi.ctimage.validateimagefilesource;

import com.alibaba.fastjson.JSONObject;
import cn.ctyun.ctapi.Credential;
import cn.ctyun.ctapi.CTResponse;
import cn.ctyun.ctapi.CTFile;
import java.util.*;
import cn.ctyun.ctapi.ctimage.CtimageClient;

/**
 * <一类节点-*-镜像服务ctimage-校验镜像文件地址>
 * Example: ValidateImageFileSourceExample
 */
public class ValidateImageFileSourceExample {
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
            ValidateImageFileSourceRequest request = new ValidateImageFileSourceRequest().withImageFileSource("https://xxx.zos.ctyun.cn/bucket-xxx/image-xxx")
                    .withRegionID("88f8888888dd88ec888888888d888d8b");
            CTResponse<ValidateImageFileSourceResponseData> response = client.ValidateImageFileSource(request);
            return JSONObject.toJSONString(response);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
