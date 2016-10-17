package cn.sudiyi.platform;

import java.math.BigDecimal;
import java.util.Calendar;

import cn.sudiyi.platform.model.BoxType;
import cn.sudiyi.platform.model.request.DeliveryRequest;

/**
 * 发起配送到柜的示例
 * @author pankai
 * Dec 10, 2015
 */
public class ExampleForDelivery {

    private static final String ACCESS_ID = "41";
    private static final String ACCESS_KEY = "nn7jznfknxp9z69h";
    private static final String TEST_ENDPOINT = "http://121.196.244.197:8095";
    //private static final String TEST_ENDPOINT = "http://127.0.0.1:8080";

    public static void main(String[] args) {
        //新建PlatformClient.测试时必须指定测试服的endpoint.生产环境时不必指定.
        PlatformClient client = new PlatformClient(TEST_ENDPOINT, ACCESS_ID, ACCESS_KEY);

        DeliveryRequest request = new DeliveryRequest();
        //填入预约请求所需要的参数.
        request.setDeviceId("1000115");
        request.setBoxType(BoxType.SMALL);
        request.setNotifyUrl("http://127.0.0.1:8095/v1/dada/dummy/callback");
        //request.setNotifyUrl("http://www.yoursite.com/somewhere");
        request.setOrderNo("13213213");
        request.setConsigneeMobile("18011314686");
        Calendar calendar = Calendar.getInstance();
        //calendar.add(Calendar.MINUTE, 120);
        request.setExpectedFetchTime(calendar.getTime().getTime());
        request.setCargoPrice(new BigDecimal(5.2));
        client.delivery(request);
    }

}
