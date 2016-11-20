package cn.sudiyi.platform;

import cn.sudiyi.platform.model.request.FreeRequest;

/**
 * 取消预约的示例
 *
 * @author pankai
 *         Dec 10, 2015
 */
public class ExampleForFreeDevice {

    private static final String ACCESS_ID = "10963";
    private static final String ACCESS_KEY = "swtpfoct5fxvoygg";
    private static final String TEST_ENDPOINT = "http://127.0.0.1:8080";

    public static void main(String[] args) {
        Platform client = new PlatformClient(ACCESS_ID, ACCESS_KEY);
        FreeRequest freeRequest = new FreeRequest();
        freeRequest.setCityName("北京市");
        freeRequest.setThirdpartyId(14075);
        freeRequest.setThreshold(9);
        client.freeDevice(freeRequest);
    }

}
