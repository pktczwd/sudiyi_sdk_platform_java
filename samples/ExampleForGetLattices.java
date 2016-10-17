package cn.sudiyi.platform;

import java.util.List;

import cn.sudiyi.platform.model.Device;
import cn.sudiyi.platform.model.Lattice;
import cn.sudiyi.platform.model.request.QueryLatticeRequest;

/**
 * 获取网点信息的示例
 * @author pankai
 * Dec 9, 2015
 */
public class ExampleForGetLattices {

    private static final String ACCESS_ID = "41";
    private static final String ACCESS_KEY = "nn7jznfknxp9z69h";
    private static final String TEST_ENDPOINT = "http://112.124.50.175:8095";

    public static void main(String[] args) {
        //新建PlatformClient.测试时必须指定测试服的endpoint.生产环境时不必指定.
        PlatformClient client = new PlatformClient(TEST_ENDPOINT, ACCESS_ID, ACCESS_KEY);
        //新建一个查询网点请求
        QueryLatticeRequest request = new QueryLatticeRequest();
        request.setDistrictId(510109);
        //获取该行政区下的所有网点
        List<Lattice> lattices = client.getLattices(request);
        //你的业务逻辑
        //输出获得的网点信息及其下属的设备信息.
        for (Lattice lattice : lattices) {
            System.out.println("网点:" + lattice.getId() + ":" + lattice.getName());
            for (Device device : lattice.getDevices()) {
                System.out.println("设备:" + device.getId() + ":" + device.getName());
            }
        }
    }
}
