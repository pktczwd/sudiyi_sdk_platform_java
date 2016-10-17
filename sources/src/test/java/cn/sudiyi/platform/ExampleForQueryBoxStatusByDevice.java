package cn.sudiyi.platform;

import cn.sudiyi.platform.model.request.QueryBoxStatusRequest;
import cn.sudiyi.platform.model.response.QueryBoxStatusResponse;

/**
 * 根据设备查询箱格状态的示例
 * @author pankai
 * Dec 11, 2015
 */
public class ExampleForQueryBoxStatusByDevice {

    private static final String ACCESS_ID = "41";
    private static final String ACCESS_KEY = "nn7jznfknxp9z69h";
    private static final String TEST_ENDPOINT = "http://121.196.244.197:8095";

    public static void main(String[] args) {
        //新建PlatformClient.测试时必须指定测试服的endpoint.生产环境时不必指定.
        PlatformClient client = new PlatformClient(TEST_ENDPOINT, ACCESS_ID, ACCESS_KEY);
        //新建一个查询请求
        QueryBoxStatusRequest request = new QueryBoxStatusRequest();
        //填入设备id
        request.setId(1000081);
        //发起一个查询请求,得到响应.
        QueryBoxStatusResponse response = client.queryBoxStatusByDevice(request);
        //你的业务逻辑
        //输出可用的大箱数量
        System.out.println(response.getBig());
        //输出可用的 中箱数量
        System.out.println(response.getMedium());
        //输出可用的小箱数量
        System.out.println(response.getSmall());
    }

}
