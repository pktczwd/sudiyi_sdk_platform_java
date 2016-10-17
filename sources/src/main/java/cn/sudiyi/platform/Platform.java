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

import java.util.List;

import cn.sudiyi.platform.model.Lattice;
import cn.sudiyi.platform.model.Province;
import cn.sudiyi.platform.model.request.CancelReservationRequest;
import cn.sudiyi.platform.model.request.DeliveryRequest;
import cn.sudiyi.platform.model.request.QueryBoxStatusRequest;
import cn.sudiyi.platform.model.request.QueryClosestDeviceRequest;
import cn.sudiyi.platform.model.request.QueryLatticeRequest;
import cn.sudiyi.platform.model.request.QueryReservationRequest;
import cn.sudiyi.platform.model.request.ReserveRequest;
import cn.sudiyi.platform.model.response.GetDeadlettersResponse;
import cn.sudiyi.platform.model.response.QueryBoxStatusOnlineResponse;
import cn.sudiyi.platform.model.response.QueryBoxStatusResponse;
import cn.sudiyi.platform.model.response.QueryClosestDeviceResponse;
import cn.sudiyi.platform.model.response.QueryReservationResponse;
import cn.sudiyi.platform.model.response.ReserveResponse;

/**
 * 速递易开放平台服务的访问接口
 * @author pankai
 * Dec 11, 2015
 */
public interface Platform {

    /**
     * 获取行政区划
     * @return 省份@{link Province}列表,省份中包含城市,城市中包含行政区.
     */
    public List<Province> getAdministrativeDivision();

    /**
     * 获取行政区内的所有网点
     * @param request 查询网点请求{@link QueryLatticeRequest}
     * @return 网点@{link Lattice}列表,网点中包含设备.
     */
    public List<Lattice> getLattices(QueryLatticeRequest request);

    /**
     * 发起预约
     * @param request 预约请求{@link ReserveRequest}
     * @return 预约响应{@link ReserveResponse}
     */
    public ReserveResponse reserve(ReserveRequest request);

    /**
     * 取消预约
     * @param request 取消预约请求{@link CancelReservationRequest}
     * @return 取消预约请求是否成功
     */
    public Boolean cancelReserve(CancelReservationRequest request);

    /**
     * 查询预约状态
     * @param request 查询预约请求{@link QueryReservationRequest}
     * @return 查询预约响应{@link QueryReservationResponse}
     */
    public QueryReservationResponse queryReservation(QueryReservationRequest request);

    /**
     * 根据设备ID查询可用箱格数量
     * @param request 查询箱格请求{@link QueryBoxStatusRequest}
     * @return 查询箱格响应{@link QueryBoxStatusResponse}
     */
    public QueryBoxStatusResponse queryBoxStatusByDevice(QueryBoxStatusRequest request);

    /**
     * 根据网点ID查询可用箱格数量
     * @param request 查询箱格请求{@link QueryBoxStatusRequest}
     * @return 查询箱格响应{@link QueryBoxStatusResponse}
     */
    public QueryBoxStatusResponse queryBoxStatusByLattice(QueryBoxStatusRequest request);

    /**
     * 根据设备ID查询可用箱格数量和在线状态
     * @param request 查询箱格请求{@link QueryBoxStatusRequest}
     * @return 查询箱格响应{@link QueryBoxStatusOnlineResponse}
     */
    public List<QueryBoxStatusOnlineResponse> queryBoxStatusOnlineByDevice(QueryBoxStatusRequest request);

    /**
     * 根据网点ID查询可用箱格数量和在线状态
     * @param request 查询箱格请求{@link QueryBoxStatusRequest}
     * @return 查询箱格状态和设备在线状态响应{@link QueryBoxStatusOnlineResponse}
     */
    public List<QueryBoxStatusOnlineResponse> queryBoxStatusOnlineByLattice(QueryBoxStatusRequest request);

    /**
     * 获取死信
     * @return 获取死信响应{@link GetDeadlettersResponse}
     */
    public GetDeadlettersResponse getDeadletters();

    /**
     * 获取附近设备,包括以给定坐标为中心,中心与四边相距各五公里的正方形内的所有设备.
     * @param request 查询附近设备请求
     * @return 查询附近设备响应
     */
    public List<QueryClosestDeviceResponse> queryClosestDevices(QueryClosestDeviceRequest request);

    public void delivery(DeliveryRequest request);

}
