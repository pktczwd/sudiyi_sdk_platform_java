/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package cn.sudiyi.platform;

import cn.sudiyi.platform.common.auth.CredentialsProvider;
import cn.sudiyi.platform.common.auth.DefaultCredentialsProvider;
import cn.sudiyi.platform.common.comm.DefaultServiceClient;
import cn.sudiyi.platform.common.comm.ServiceClient;
import cn.sudiyi.platform.internal.*;
import cn.sudiyi.platform.model.Lattice;
import cn.sudiyi.platform.model.Province;
import cn.sudiyi.platform.model.request.*;
import cn.sudiyi.platform.model.response.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * 访问速递易开放平台服务的入口类.
 *
 * @author pankai
 *         Dec 4, 2015
 */
public class PlatformClient implements Platform {

    private CredentialsProvider credsProvider;
    private ServiceClient serviceClient;

    private PlatformAreaOperation areaOperation;
    private PlatformLatticeOperation latticeOperation;
    private PlatformDeviceOperation deviceOperation;
    private PlatformOrderOperation orderOperation;

    /**
     * 使用速递易颁发的Access Id/Access Key构造一个新的{@link PlatformClient}对象.
     *
     * @param accessKeyId     访问开放平台服务的Access Key Id.
     * @param secretAccessKey 访问开放平台服务的Secret Access Key.
     */
    public PlatformClient(String accessKeyId, String secretAccessKey) {
        this(PlatformConstants.DEFAULT_PLATFORM_ENDPOINT, new DefaultCredentialsProvider(accessKeyId, secretAccessKey), null);
    }

    /**
     * 使用速递易颁发的Access Id/Access Key和指定的客户端配置构造一个新的{@link PlatformClient}对象.
     *
     * @param accessKeyId     访问开放平台服务的Access Key Id.
     * @param secretAccessKey 访问开放平台服务的Secret Access Key.
     * @param config          客户端配置{@link ClientConfiguration}.如果为null会使用默认配置.
     */
    public PlatformClient(String accessKeyId, String secretAccessKey, ClientConfiguration config) {
        this(PlatformConstants.DEFAULT_PLATFORM_ENDPOINT, new DefaultCredentialsProvider(accessKeyId, secretAccessKey), config);
    }

    /**
     * 使用指定的速递易开放平台Endpoint和速递易颁发的Access Id/Access Key构造一个新的{@link PlatformClient}对象.
     *
     * @param endpoint        速递易开放平台服务的Endpoint.
     * @param accessKeyId     访问开放平台服务的Access Key Id.
     * @param secretAccessKey 访问开放平台服务的Secret Access Key.
     */
    public PlatformClient(String endpoint, String accessKeyId, String secretAccessKey) {
        this(endpoint, new DefaultCredentialsProvider(accessKeyId, secretAccessKey), null);
    }

    /**
     * 使用指定的速递易开放平台Endpoint,指定的{@link CredentialsProvider}及配置构造一个新的{@link PlatformClient}对象.
     *
     * @param endpoint      速递易开放平台服务的Endpoint.
     * @param credsProvider 访问开放平台服务的Access Key Id.
     * @param config        客户端配置{@link ClientConfiguration}.如果为null会使用默认配置.
     */
    public PlatformClient(String endpoint, CredentialsProvider credsProvider, ClientConfiguration config) {
        this.credsProvider = credsProvider;
        this.serviceClient = new DefaultServiceClient(config == null ? new ClientConfiguration() : config);
        initOperations();
        setEndpoint(endpoint);
    }

    private void initOperations() {
        areaOperation = new PlatformAreaOperation(this.serviceClient, this.credsProvider);
        latticeOperation = new PlatformLatticeOperation(this.serviceClient, this.credsProvider);
        deviceOperation = new PlatformDeviceOperation(this.serviceClient, this.credsProvider);
        orderOperation = new PlatformOrderOperation(this.serviceClient, this.credsProvider);
    }

    /**
     * 设置速递易开放平台的Endpoint.
     *
     * @param endpoint 速递易开放平台的Endpoint.
     */
    public synchronized void setEndpoint(String endpoint) {
        URI uri = toURI(endpoint);
        this.areaOperation.setEndpoint(uri);
        this.latticeOperation.setEndpoint(uri);
        this.deviceOperation.setEndpoint(uri);
        this.orderOperation.setEndpoint(uri);
    }

    private URI toURI(String endpoint) throws IllegalArgumentException {
        if (!endpoint.contains("://")) {
            ClientConfiguration conf = this.serviceClient.getClientConfiguration();
            endpoint = conf.getProtocol().toString() + "://" + endpoint;
        }
        try {
            return new URI(endpoint);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * 获取行政区划
     *
     * @return 省份{@link Province}列表,省份中包含城市,城市中包含行政区.
     */
    @Override
    public List<Province> getAdministrativeDivision() {
        return areaOperation.getAdministrativeDivision();
    }

    /**
     * 获取行政区内的所有网点
     *
     * @param request 查询网点请求{@link QueryLatticeRequest}
     * @return 网点{@link Lattice}列表,网点中包含设备.
     */
    @Override
    public List<Lattice> getLattices(QueryLatticeRequest request) {
        return latticeOperation.getLattices(request);
    }

    /**
     * 发起预约
     *
     * @param request 预约请求{@link ReserveRequest}
     * @return 预约响应{@link ReserveResponse}
     */
    @Override
    public ReserveResponse reserve(ReserveRequest request) {
        return orderOperation.reserve(request);
    }

    /**
     * 取消预约
     *
     * @param request 取消预约请求{@link CancelReservationRequest}
     * @return 取消预约请求是否成功
     */
    @Override
    public Boolean cancelReserve(CancelReservationRequest request) {
        return orderOperation.cancelReserve(request);
    }

    /**
     * 查询预约状态
     *
     * @param request 查询预约请求{@link QueryReservationRequest}
     * @return 查询预约响应{@link QueryReservationResponse}
     */
    @Override
    public QueryReservationResponse queryReservation(QueryReservationRequest request) {
        return orderOperation.queryReservation(request);
    }

    /**
     * 根据设备ID查询可用箱格数量
     *
     * @param request 查询箱格请求{@link QueryBoxStatusRequest}
     * @return 查询箱格响应{@link QueryBoxStatusResponse}
     */
    @Override
    public QueryBoxStatusResponse queryBoxStatusByDevice(QueryBoxStatusRequest request) {
        return deviceOperation.queryBoxStatus(request);
    }

    /**
     * 根据网点ID查询可用箱格数量
     *
     * @param request 查询箱格请求{@link QueryBoxStatusRequest}
     * @return 查询箱格响应{@link QueryBoxStatusResponse}
     */
    @Override
    public QueryBoxStatusResponse queryBoxStatusByLattice(QueryBoxStatusRequest request) {
        return latticeOperation.queryBoxStatus(request);
    }

    /**
     * 根据设备ID查询可用箱格数量和在线状态
     *
     * @param request 查询箱格请求{@link QueryBoxStatusRequest}
     * @return 查询箱格响应{@link QueryBoxStatusOnlineResponse}
     */
    @Override
    public List<QueryBoxStatusOnlineResponse> queryBoxStatusOnlineByDevice(QueryBoxStatusRequest request) {
        return deviceOperation.queryBoxStatusOnline(request);
    }

    /**
     * 根据网点ID查询可用箱格数量
     *
     * @param request 查询箱格请求{@link QueryBoxStatusRequest}
     * @return 查询箱格状态和设备在线状态响应{@link QueryBoxStatusOnlineResponse}
     */
    @Override
    public List<QueryBoxStatusOnlineResponse> queryBoxStatusOnlineByLattice(QueryBoxStatusRequest request) {
        return latticeOperation.queryBoxStatusOnline(request);
    }

    /**
     * 获取死信
     *
     * @return 获取死信响应{@link GetDeadlettersResponse}
     */
    @Override
    public GetDeadlettersResponse getDeadletters() {
        return orderOperation.getDeadletters();
    }

    /**
     * 获取附近设备,包括以给定坐标为中心,中心与四边相距各五公里的正方形内的所有设备.
     *
     * @param request 查询附近设备请求
     * @return 查询附近设备响应
     */
    @Override
    public List<QueryClosestDeviceResponse> queryClosestDevices(QueryClosestDeviceRequest request) {
        return deviceOperation.queryClosest(request);
    }

    /**
     * 配送到柜,达达提供运力支持
     *
     * @param request 配送请求
     */
    @Override
    public DeliveryResponse delivery(DeliveryRequest request) {
        return orderOperation.delivery(request);
    }

}
