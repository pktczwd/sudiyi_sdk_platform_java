package cn.sudiyi.platform;

import cn.sudiyi.platform.model.request.CodeEndRequest;

/**
 * 指定开箱码为结束码示例
 */
public class ExampleForCodeEnd {
    private static final String ACCESS_ID = "41";
    private static final String ACCESS_KEY = "nn7jznfknxp9z69h";
    private static final String TEST_ENDPOINT = "http://121.196.244.197:8095";
    //private static final String TEST_ENDPOINT = "http://127.0.0.1:8080";

    public static void main(String[] args) {
        PlatformClient client = new PlatformClient(TEST_ENDPOINT, ACCESS_ID, ACCESS_KEY);
        CodeEndRequest request = new CodeEndRequest();
        request.setReservationId(20161114000011L);
        request.setOpenCode("654321");
        client.codeEnd(request);
    }
}
