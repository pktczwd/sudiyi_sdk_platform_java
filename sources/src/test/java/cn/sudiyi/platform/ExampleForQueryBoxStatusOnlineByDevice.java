package cn.sudiyi.platform;

import java.util.List;

import cn.sudiyi.platform.model.BoxAvailableStat;
import cn.sudiyi.platform.model.request.QueryBoxStatusRequest;
import cn.sudiyi.platform.model.response.QueryBoxStatusOnlineResponse;

/**
 * 根据设备查询箱格状态和设备在线状态的示例
 * @author pankai
 * 2016年3月11日
 */
public class ExampleForQueryBoxStatusOnlineByDevice {

    private static final String ACCESS_ID = "10963";
    private static final String ACCESS_KEY = "swtpfoct5fxvoygg";
    private static final String TEST_ENDPOINT = "http://121.196.244.197:8095";

    public static void main(String[] args) {
        //新建PlatformClient.测试时必须指定测试服的endpoint.生产环境时不必指定.
        PlatformClient client = new PlatformClient(TEST_ENDPOINT, ACCESS_ID, ACCESS_KEY);
        //新建一个查询请求
        QueryBoxStatusRequest request = new QueryBoxStatusRequest();
        //填入设备id
        request.setId(1000018);
        //发起一个查询请求,得到响应.
        List<QueryBoxStatusOnlineResponse> list = client.queryBoxStatusOnlineByDevice(request);
        //你的业务逻辑
        //输出可用的大箱数量
        for (QueryBoxStatusOnlineResponse response : list) {
            System.out.println("Device id:" + response.getDeviceId());
            BoxAvailableStat stat = response.getStatus();
            if (stat != null) {
                System.out.println("大箱数量:" + stat.getBig());
                System.out.println("中箱数量:" + stat.getMedium());
                System.out.println("小箱数量:" + stat.getSmall());
            }
        }
    }

}
