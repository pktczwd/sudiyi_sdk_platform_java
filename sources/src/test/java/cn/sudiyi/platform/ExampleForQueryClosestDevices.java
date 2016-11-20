package cn.sudiyi.platform;

import cn.sudiyi.platform.model.request.QueryClosestDeviceRequest;
import cn.sudiyi.platform.model.response.QueryClosestDeviceResponse;

import java.util.List;

public class ExampleForQueryClosestDevices {

    private static final String ACCESS_ID = "14075";
    private static final String ACCESS_KEY = "27ah0gtjahmrc2ax";
    //private static final String TEST_ENDPOINT = "http://121.196.244.197:8095";
    private static final String TEST_ENDPOINT = "http://127.0.0.1:8080";

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
            System.out.println("距离:" + response.getDistance());
        }
    }

}
