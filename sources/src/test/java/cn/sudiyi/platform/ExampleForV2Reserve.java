package cn.sudiyi.platform;

import cn.sudiyi.platform.model.BoxType;
import cn.sudiyi.platform.model.request.ReserveRequestV2;
import cn.sudiyi.platform.model.response.ReserveResponse;

/**
 * 发起v1预约的示例
 *
 * @author pankai
 *         Dec 10, 2015
 */
public class ExampleForV2Reserve {

    private static final String ACCESS_ID = "41";
    private static final String ACCESS_KEY = "nn7jznfknxp9z69h";
    private static final String TEST_ENDPOINT = "http://121.196.244.197:8095";

    public static void main(String[] args) {
        //新建PlatformClient.测试时必须指定测试服的endpoint.生产环境时不必指定.
        PlatformClient client = new PlatformClient(TEST_ENDPOINT, ACCESS_ID, ACCESS_KEY);
        //新建一个预约请求.请求字段的定义及要求请参照文档或者源码.
        ReserveRequestV2 request = new ReserveRequestV2();
        //填入预约请求所需要的参数.
        request.setDeviceId("1000081");
        request.setBoxType(BoxType.SMALL);
        request.setNotifyUrl("http://127.0.0.1/somewhere");
        request.setSenderMobile("18011314686");
        request.setOrderNo("111");
        //发起一个预约请求,得到预约响应
        ReserveResponse response = client.reserveV2(request);
        //你的业务逻辑
        //输出(预约)订单号
        System.out.println(response.getReserveOrderId());
    }

}
