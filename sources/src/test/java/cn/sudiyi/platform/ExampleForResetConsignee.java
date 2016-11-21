package cn.sudiyi.platform;

import cn.sudiyi.platform.model.request.ResetConsigneeRequest;

/**
 * 重新设置收件人示例
 */
public class ExampleForResetConsignee {

    private static final String ACCESS_ID = "10963";
    private static final String ACCESS_KEY = "swtpfoct5fxvoygg";
    private static final String TEST_ENDPOINT = "http://121.196.244.197:8095";

    public static void main(String[] args) {
        PlatformClient client = new PlatformClient(TEST_ENDPOINT, ACCESS_ID, ACCESS_KEY);
        ResetConsigneeRequest request = new ResetConsigneeRequest();
        request.setClientTel("18011314686");
        request.setUuid("45233c5f-2e1f-41ea-a926-0c74e61ad592");
        client.resetConsignee(request);
    }

}
