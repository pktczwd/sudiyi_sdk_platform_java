package cn.sudiyi.platform;

import cn.sudiyi.platform.model.request.QueryReservationRequest;
import cn.sudiyi.platform.model.response.QueryReservationResponse;

/**
 * 查询预约订单示例
 * @author pankai
 * Dec 10, 2015
 */
public class ExampleForQueryReservation {

    private static final String ACCESS_ID = "41";
    private static final String ACCESS_KEY = "nn7jznfknxp9z69h";
    private static final String TEST_ENDPOINT = "http://112.124.50.175:8095";

    public static void main(String[] args) {
        //新建PlatformClient.测试时必须指定测试服的endpoint.生产环境时不必指定.
        PlatformClient client = new PlatformClient(TEST_ENDPOINT, ACCESS_ID, ACCESS_KEY);
        //新建一个查询预约订单的请求.请求字段的定义及要求请参照文档或者源码.
        QueryReservationRequest request = new QueryReservationRequest();
        //填入请求的(预约)订单号
        request.setReserveOrderId(20151222000014L);
        //发起一个查询预约订单请求,得到查询结果.
        QueryReservationResponse response = client.queryReservation(request);
        //你的业务逻辑
        //输出(预约)订单号
        System.out.println(response.getReserveOrderId());
        //输出(预约)订单状态
        System.out.println(response.getOrderStatus());
        //输出开箱码(如果有)
        System.out.println(response.getOpenCode());
    }

}
