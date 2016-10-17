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
 * 查询网点请求
 * @see Platform#getLattices(QueryLatticeRequest)
 * @author pankai
 * Jan 5, 2016
 */
public class QueryLatticeRequest {

    /**
     * 行政区id
     */
    private Integer districtId;

    /**
     * 返回行政区id
     * @return 行政区id
     */
    public Integer getDistrictId() {
        return districtId;
    }

    /**
     * 设置行政区id
     * @param districtId 行政区id
     */
    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

}
