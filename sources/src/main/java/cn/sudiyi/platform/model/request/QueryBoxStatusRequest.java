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

package cn.sudiyi.platform.model.request;

import cn.sudiyi.platform.Platform;

/**
 * 查询剩余箱格数量请求.传入网点id或者设备id来查询网点下或设备下剩余可用的箱格数量.
 * @see Platform#queryBoxStatusByDevice(QueryBoxStatusRequest)
 * @see Platform#queryBoxStatusByLattice(QueryBoxStatusRequest)
 * @see Platform#queryBoxStatusOnlineByDevice(QueryBoxStatusRequest)
 * @see Platform#queryBoxStatusOnlineByLattice(QueryBoxStatusRequest)
 * @author pankai
 * Dec 10, 2015
 */
public class QueryBoxStatusRequest {

    /**
     * 网点id或者设备id
     */
    private Integer id;

    /**
     * 返回网点id或者设备id
     * @return 网点id或者设备id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置网点id或者设备id
     * @param id 网点id或者设备id
     */
    public void setId(Integer id) {
        this.id = id;
    }

}
