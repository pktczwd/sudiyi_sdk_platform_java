package cn.sudiyi.platform;

import cn.sudiyi.platform.model.DeadletterPostMessage;
import cn.sudiyi.platform.model.DeadletterPutMessage;
import cn.sudiyi.platform.model.response.GetDeadlettersResponse;

/**
 * 获取死信的示例
 * @author pankai
 * 2016年1月20日
 */
public class ExampleForGetDeadletters {

    private static final String ACCESS_ID = "10963";
    private static final String ACCESS_KEY = "swtpfoct5fxvoygg";
    private static final String TEST_ENDPOINT = "http://121.196.244.197:8095";

    public static void main(String[] args) {
        //新建PlatformClient.测试时必须指定测试服的endpoint.生产环境时不必指定.
        PlatformClient client = new PlatformClient(TEST_ENDPOINT, ACCESS_ID, ACCESS_KEY);
        //发起一个获取死信的请求,得到响应
        GetDeadlettersResponse response = client.getDeadletters();
        //你的业务逻辑
        System.out.println("Post message size:" + response.getPost().size());
        for (DeadletterPostMessage postMessage : response.getPost()) {
            System.out.println("========Post Message======");
            System.out.println(postMessage.getResult());
            System.out.println(postMessage.getUpgraded());
            System.out.println(postMessage.getReserveOrderId());
            System.out.println(postMessage.getBoxType());
            System.out.println(postMessage.getBoxNo());
            System.out.println(postMessage.getReservationCode());
            System.out.println(postMessage.getOrderNo());
        }
        System.out.println("Put message size:" + response.getPut().size());
        for (DeadletterPutMessage putMessage : response.getPut()) {
            System.out.println("=========Put Message======");
            System.out.println(putMessage.getOrderStatus());
            System.out.println(putMessage.getReserveOrderId());
            System.out.println(putMessage.getOpenCode());
        }
    }

}
