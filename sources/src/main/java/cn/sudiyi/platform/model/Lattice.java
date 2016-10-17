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

/**
 * 速递易网点
 * @author pankai
 * Dec 11, 2015
 */
public class Lattice {

    /**
     * 网点id
     */
    private Integer id;
    /**
     * 网点名称
     */
    private String name;
    /**
     * 网点下属的设备列表
     */
    private List<Device> devices;

    /**
     * 返回网点id
     * @return 网点id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置网点id
     * @param id 网点id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 返回网点名称
     * @return 网点名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置网点名称
     * @param name 网点名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 返回设备{@link Device}列表
     * @return 设备{@link Device}列表
     */
    public List<Device> getDevices() {
        return devices;
    }

    /**
     * 设置设备{@link Device}列表
     * @param devices 设备{@link Device}列表
     */
    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

}
