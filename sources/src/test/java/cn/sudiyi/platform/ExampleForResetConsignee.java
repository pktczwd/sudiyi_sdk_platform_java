package cn.sudiyi.platform;

import cn.sudiyi.platform.model.request.ResetConsigneeRequest;

/**
 * 重新设置收件人示例
 */
public class ExampleForResetConsignee {

    private static final String ACCESS_ID = "41";
    private static final String ACCESS_KEY = "nn7jznfknxp9z69h";
    private static final String TEST_ENDPOINT = "http://127.0.0.1:8080";
    //private static final String TEST_ENDPOINT = "http://121.196.244.197:8095";

    public static void main(String[] args) {
        PlatformClient client = new PlatformClient(TEST_ENDPOINT, ACCESS_ID, ACCESS_KEY);
        ResetConsigneeRequest request = new ResetConsigneeRequest();
        request.setClientTel("18011314686");
        request.setUuid("f7f4fe0f-02d4-48bd-83aa-c80a06a27294");
        client.resetConsignee(request);
    }

}
