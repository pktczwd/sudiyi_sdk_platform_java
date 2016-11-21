package cn.sudiyi.platform;

import cn.sudiyi.platform.model.request.QueryBoxStatusRequest;
import cn.sudiyi.platform.model.response.QueryBoxStatusResponse;

/**
 * 根据网点查询箱格状态的示例
 * @author pankai
 * Dec 11, 2015
 */
public class ExampleForQueryBoxStatusByLattice {

    private static final String ACCESS_ID = "10963";
    private static final String ACCESS_KEY = "swtpfoct5fxvoygg";
    private static final String TEST_ENDPOINT = "http://121.196.244.197:8095";

    public static void main(String[] args) {
        //新建PlatformClient.测试时必须指定测试服的endpoint.生产环境时不必指定.
        PlatformClient client = new PlatformClient(TEST_ENDPOINT, ACCESS_ID, ACCESS_KEY);
        //新建一个查询请求
        QueryBoxStatusRequest request = new QueryBoxStatusRequest();
        //填入网点id
        request.setId(37746);
        //发起一个查询请求,得到响应.
        QueryBoxStatusResponse response = client.queryBoxStatusByLattice(request);
        //你的业务逻辑
        //输出可用的大箱数量
        System.out.println(response.getBig());
        //输出可用的中箱数量
        System.out.println(response.getMedium());
        //输出可用的小箱数量
        System.out.println(response.getSmall());
    }

}
