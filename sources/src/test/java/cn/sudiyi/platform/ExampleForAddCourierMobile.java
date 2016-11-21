package cn.sudiyi.platform;

import cn.sudiyi.platform.model.request.AddCourierMobileRequest;

/**
 * 取消预约的示例
 *
 * @author pankai
 *         Dec 10, 2015
 */
public class ExampleForAddCourierMobile {

    private static final String ACCESS_ID = "10963";
    private static final String ACCESS_KEY = "swtpfoct5fxvoygg";
    private static final String TEST_ENDPOINT = "http://121.196.244.197:8095";

    public static void main(String[] args) {
        Platform client = new PlatformClient(TEST_ENDPOINT, ACCESS_ID, ACCESS_KEY);
        AddCourierMobileRequest request = new AddCourierMobileRequest();
        request.setReservationId(20161115000001L);
        request.setCourierMobile("18011314686");
        client.addCourierMobile(request);
    }

}
