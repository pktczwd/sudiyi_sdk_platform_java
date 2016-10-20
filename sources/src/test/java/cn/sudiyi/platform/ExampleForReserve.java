package cn.sudiyi.platform;

import cn.sudiyi.platform.model.BoxType;
import cn.sudiyi.platform.model.request.ReserveRequest;
import cn.sudiyi.platform.model.response.ReserveResponse;

/**
 * 发起预约的示例
 * @author pankai
 * Dec 10, 2015
 */
public class ExampleForReserve {

    private static final String ACCESS_ID = "41";
    private static final String ACCESS_KEY = "nn7jznfknxp9z69h";
    private static final String TEST_ENDPOINT = "http://121.196.244.197:8095";

    public static void main(String[] args) {
        //新建PlatformClient.测试时必须指定测试服的endpoint.生产环境时不必指定.
        PlatformClient client = new PlatformClient(TEST_ENDPOINT, ACCESS_ID, ACCESS_KEY);
        //新建一个预约请求.请求字段的定义及要求请参照文档或者源码.
        ReserveRequest request = new ReserveRequest();
        //填入预约请求所需要的参数.
        //request.setDeviceId("1000018");
        request.setBoxType(BoxType.MEDIUM);
        request.setNotifyUrl("http://127.0.0.1/somewhere");
        //request.setNotifyUrl("http://www.yoursite.com/somewhere");
        request.setSenderMobile("18011314686");
        request.setOrderNo("111");
        request.setConsigneeMobile("18011314686");
        //发起一个预约请求,得到预约响应
        ReserveResponse response = client.reserve(request);
        //你的业务逻辑
        //输出(预约)订单号
        System.out.println(response.getReserveOrderId());
    }

}
