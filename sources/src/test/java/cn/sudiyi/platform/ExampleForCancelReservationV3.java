package cn.sudiyi.platform;

import cn.sudiyi.platform.model.request.CancelReservationRequestV3;

/**
 * 取消预约的示例
 *
 * @author pankai
 *         Dec 10, 2015
 */
public class ExampleForCancelReservationV3 {

    private static final String ACCESS_ID = "10963";
    private static final String ACCESS_KEY = "swtpfoct5fxvoygg";
    private static final String TEST_ENDPOINT = "http://121.196.244.197:8095";

    public static void main(String[] args) {
        Platform client = new PlatformClient(TEST_ENDPOINT, ACCESS_ID, ACCESS_KEY);
        CancelReservationRequestV3 request = new CancelReservationRequestV3();
        request.setReservationId(20161118000250L);
        client.cancelReserve(request);
    }

}
