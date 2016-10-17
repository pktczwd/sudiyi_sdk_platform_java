package cn.sudiyi.platform;

import java.util.List;

import cn.sudiyi.platform.model.request.QueryClosestDeviceRequest;
import cn.sudiyi.platform.model.response.QueryClosestDeviceResponse;

public class ExampleForQueryClosestDevices {

    private static final String ACCESS_ID = "41";
    private static final String ACCESS_KEY = "nn7jznfknxp9z69h";
    private static final String TEST_ENDPOINT = "http://112.124.50.175:8095";

    public static void main(String[] args) {
        //新建PlatformClient.测试时必须指定测试服的endpoint.生产环境时不必指定.
        PlatformClient client = new PlatformClient(TEST_ENDPOINT, ACCESS_ID, ACCESS_KEY);
        //新建一个查询请求
        QueryClosestDeviceRequest request = new QueryClosestDeviceRequest();
        request.setLatitude(new Double(30.5452));
        request.setLongitude(new Double(104.065));
        List<QueryClosestDeviceResponse> list = client.queryClosestDevices(request);
        for (QueryClosestDeviceResponse response : list) {
            System.out.println("设备id:" + response.getDeviceId());
            System.out.println("设备名称:" + response.getDeivceName());
            System.out.println("设备地址:" + response.getAddress());
            System.out.println("设备经度:" + response.getLongitude());
            System.out.println("设备纬度:" + response.getLatitude());
        }
    }

}
