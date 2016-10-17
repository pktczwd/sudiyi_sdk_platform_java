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

import cn.sudiyi.platform.common.comm.Protocol;
import cn.sudiyi.platform.common.utils.ResourceManager;
import cn.sudiyi.platform.internal.PlatformConstants;

/**
 * 访问速递易开放平台服务的客户端配置.
 *
 * @author pankai
 *         Dec 3, 2015
 */
public class ClientConfiguration {

    private static final int DEFAULT_MAX_RETRIES = 3;

    private static final int DEFAULT_MAX_CONNECTIONS = 1024;

    private int maxConnections = DEFAULT_MAX_CONNECTIONS;

    private int maxErrorRetry = DEFAULT_MAX_RETRIES;

    private Protocol protocol = Protocol.HTTP;

    private int maxConnectionIdleTime = 30;

    /**
     * 返回允许打开的最大http连接数.
     *
     * @return 最大http连接数.
     */
    public int getMaxConnections() {
        return maxConnections;
    }

    /**
     * 设置允许打开的最大http连接数.
     *
     * @param maxConnections 最大http连接数.
     */
    public void setMaxConnections(int maxConnections) {
        if (maxConnections <= 0) {
            throw new ClientException(ResourceManager.getInstance(PlatformConstants.RESOURCE_NAME_COMMON).getFormattedString("ParameterIsInvalid", maxConnections));
        }
        this.maxConnections = maxConnections;
    }

    /**
     * 获取连接速递易开放平台服务所采用的协议(http/https).
     *
     * @return 速递易开放平台服务所采用的协议(http/https).
     */
    public Protocol getProtocol() {
        return protocol;
    }

    /**
     * 设置连接速递易开放平台服务所采用的协议(http/https).
     *
     * @param protocol 速递易开放平台服务所采用的协议(http/https).
     */
    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
        //TODO 待实现.
        throw new UnsupportedOperationException("Unsupported!");
    }

    /**
     * 返回可重试的请求失败后最大的重试次数.(默认值为3)
     *
     * @return 可重试的请求失败后最大的重试次数.(默认值为3)
     */
    public int getMaxErrorRetry() {
        return maxErrorRetry;
    }

    /**
     * 设置可重试的请求失败后最大的重试次数.(默认值为3)
     *
     * @param maxErrorRetry 可重试的请求失败后最大的重试次数.(默认值为3)
     */
    public void setMaxErrorRetry(int maxErrorRetry) {
        this.maxErrorRetry = maxErrorRetry;
    }

    public int getMaxConnectionIdleTime() {
        return maxConnectionIdleTime;
    }

    public void setMaxConnectionIdleTime(int maxConnectionIdleTime) {
        this.maxConnectionIdleTime = maxConnectionIdleTime;
    }
}
