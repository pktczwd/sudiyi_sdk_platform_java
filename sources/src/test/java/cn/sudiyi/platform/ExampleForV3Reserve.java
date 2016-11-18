package cn.sudiyi.platform;

import cn.sudiyi.platform.model.BoxType;
import cn.sudiyi.platform.model.request.ReserveRequestV3;
import cn.sudiyi.platform.model.response.ReservationResponse;

/**
 * 发起预约v3示例
 * Created by pktczwd on 2016/11/14.
 */
public class ExampleForV3Reserve {
    private static final String ACCESS_ID = "10963";
    private static final String ACCESS_KEY = "swtpfoct5fxvoygg";
    private static final String TEST_ENDPOINT = "http://121.196.244.197:8095";
    //private static final String TEST_ENDPOINT = "http://127.0.0.1:8080";

    public static void main(String[] args) {
        //新建PlatformClient.测试时必须指定测试服的endpoint.生产环境时不必指定.
        PlatformClient client = new PlatformClient(TEST_ENDPOINT, ACCESS_ID, ACCESS_KEY);
        //新建一个预约请求.请求字段的定义及要求请参照文档或者源码.
        ReserveRequestV3 request = new ReserveRequestV3();
        //填入预约请求所需要的参数.
        request.setDeviceId("1000081");
        request.setBoxType(BoxType.MEDIUM);
        request.setNotifyUrl("http://127.0.0.1/somewhere");
        request.setOrderNo("0028");
        request.setOpenCodeCount(12);
        request.setDuration(30);
        //发起一个预约请求,得到预约响应
        ReservationResponse response = client.reserveV3(request);
        //你的业务逻辑
        //输出(预约)订单号
        System.out.println(response.getReservationId());
    }
}
