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

/**
 * 当访问速递易开放平台服务失败时抛出该异常类的实例.
 * @author pankai
 * Dec 15, 2015
 */
public class PlatformException extends ServiceException {

    private static final long serialVersionUID = 1023055783603906605L;

    public PlatformException(Exception e) {
        super(e);
    }

    public PlatformException(String errorMessage, String errorCode, Throwable cause) {
        super(errorMessage, errorCode, cause);
    }

    public PlatformException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlatformException(String message) {
        super(message);
    }

}
