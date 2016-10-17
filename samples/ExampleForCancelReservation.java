package cn.sudiyi.platform;

import cn.sudiyi.platform.model.request.CancelReservationRequest;

/**
 * 取消预约的示例
 * @author pankai
 * Dec 10, 2015
 */
public class ExampleForCancelReservation {

    private static final String ACCESS_ID = "41";
    private static final String ACCESS_KEY = "nn7jznfknxp9z69h";
    private static final String TEST_ENDPOINT = "http://112.124.50.175:8095";

    public static void main(String[] args) {
        //新建PlatformClient.测试时必须指定测试服的endpoint.生产环境时不必指定.
        Platform client = new PlatformClient(TEST_ENDPOINT, ACCESS_ID, ACCESS_KEY);
        //新建一个取消预约的请求
        CancelReservationRequest request = new CancelReservationRequest();
        //填入需要取消的(预约)订单号
        request.setReserveOrderId(20151222000014L);
        //发起取消预约的请求.
        Boolean b = client.cancelReserve(request);
        //取消成功返回true,取消失败返回false.建议通过直接查询订单来确定状态,而不是在这里判断.
        System.out.println(b);
    }

}
