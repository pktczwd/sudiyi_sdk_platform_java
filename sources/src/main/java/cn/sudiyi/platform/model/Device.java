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

/**
 * 速递易设备
 * @author pankai
 * Dec 11, 2015
 */
public class Device {

    /**
     * 设备id
     */
    private Integer id;
    /**
     * 设备名称
     */
    private String name;
    /**
     * 设备地址
     */
    private String address;

    /**
     * 返回设备id
     * @return 设备id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置设备id
     * @param id 设备id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 返回设备名称
     * @return 设备名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置设备名称
     * @param name 设备名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 返回设备地址
     * @return 设备地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置设备地址
     * @param address 设备地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

}
