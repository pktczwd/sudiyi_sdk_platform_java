package cn.sudiyi.platform;

import java.util.List;

import cn.sudiyi.platform.model.City;
import cn.sudiyi.platform.model.District;
import cn.sudiyi.platform.model.Province;

/**
 * 获取行政区划的示例.
 * @author pankai
 * Dec 9, 2015
 */
public class ExampleForGetAdministrativeDivision {

    private static final String ACCESS_ID = "41";
    private static final String ACCESS_KEY = "nn7jznfknxp9z69h";
    //private static final String TEST_ENDPOINT = "http://121.196.244.197:8095";
    private static final String TEST_ENDPOINT = "http://127.0.0.1:8080";

    public static void main(String[] args) {
        //新建PlatformClient.测试时必须指定测试服的endpoint.生产环境时不必指定.
        PlatformClient client = new PlatformClient(TEST_ENDPOINT, ACCESS_ID, ACCESS_KEY);
        //发起一个获取行政区划的请求,得到包含省市区的响应
        List<Province> provinces = client.getAdministrativeDivision();
        //你的业务逻辑
        //输出省市区
        System.out.println(provinces.size());
        for (Province province : provinces) {
            System.out.println(province.getName());
            for (City city : province.getCities()) {
                System.out.println(city.getName());
                for (District district : city.getDistricts()) {
                    System.out.println(district.getId() + ":" + district.getName());
                }
            }
        }
    }

}
