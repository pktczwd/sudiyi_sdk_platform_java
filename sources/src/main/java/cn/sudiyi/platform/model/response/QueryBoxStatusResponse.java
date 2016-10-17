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

package cn.sudiyi.platform.model.response;

import cn.sudiyi.platform.Platform;

/**
 * 查询箱格状态响应
 * @see Platform#queryBoxStatusByDevice(QueryBoxStatusRequest)
 * @see Platform#queryBoxStatusByLattice(QueryBoxStatusRequest)
 * @author pankai
 * Dec 10, 2015
 */
public class QueryBoxStatusResponse {
    /**
     * 小箱数量
     */
    private Integer small;
    /**
     * 中箱数量
     */
    private Integer medium;
    /**
     * 大箱数量
     */
    private Integer big;

    /**
     * 返回小箱数量
     * @return 小箱数量
     */
    public Integer getSmall() {
        return small;
    }

    /**
     * 设置小箱数量
     * @param small 小箱数量
     */
    public void setSmall(Integer small) {
        this.small = small;
    }

    /**
     * 返回中箱数量
     * @return 中箱数量
     */
    public Integer getMedium() {
        return medium;
    }

    /**
     * 设置中箱数量
     * @param medium 返回中箱数量
     */
    public void setMedium(Integer medium) {
        this.medium = medium;
    }

    /**
     * 返回大箱数量
     * @return 大箱数量
     */
    public Integer getBig() {
        return big;
    }

    /**
     * 设置大箱数量
     * @param big 大箱数量
     */
    public void setBig(Integer big) {
        this.big = big;
    }

}
