package cn.sudiyi.platform;

import cn.sudiyi.platform.model.BoxType;
import cn.sudiyi.platform.model.request.DeliveryRequest;

import java.math.BigDecimal;
import java.util.Calendar;

/**
 * 发起配送到柜的示例
 *
 * @author pankai
 */
public class ExampleForDelivery {

    private static final String ACCESS_ID = "10963";
    private static final String ACCESS_KEY = "swtpfoct5fxvoygg";
    private static final String TEST_ENDPOINT = "http://121.196.244.197:8095";

    public static void main(String[] args) {
        //新建PlatformClient.测试时必须指定测试服的endpoint.生产环境时不必指定.
        PlatformClient client = new PlatformClient(TEST_ENDPOINT, ACCESS_ID, ACCESS_KEY);

        DeliveryRequest request = new DeliveryRequest();
        //填入配送请求所需要的参数.
        request.setDeviceId("1000184");
        request.setBoxType(BoxType.MEDIUM);
        request.setNotifyUrl("http://www.yoursite.com/somewhere");
        request.setOrderNo("12345");
        request.setConsigneeMobile("18011314686");
        request.setShopNo(11047059);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 120);
        request.setExpectedFetchTime(calendar.getTime().getTime());
        request.setCargoPrice(new BigDecimal(5.2));
        client.delivery(request);
    }

}
