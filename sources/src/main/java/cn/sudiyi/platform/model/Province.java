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

package cn.sudiyi.platform.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 省
 * @author pankai
 * Dec 11, 2015
 */
public class Province {

    /**
     * id
     */
    private Integer id;
    @JsonProperty("n")
    /**
     * 省名
     */
    private String name;
    @JsonProperty("c")
    /**
     * 下属城市列表
     */
    private List<City> cities;

    /**
     * 返回id
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 返回省名
     * @return 省名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置省名
     * @param name 省名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 返回下属城市{@link City}列表
     * @return 下属城市{@link City}列表
     */
    public List<City> getCities() {
        return cities;
    }

    /**
     * 设置下属城市{@link City}列表
     * @param cities 下属城市{@link City}列表
     */
    public void setCities(List<City> cities) {
        this.cities = cities;
    }

}
