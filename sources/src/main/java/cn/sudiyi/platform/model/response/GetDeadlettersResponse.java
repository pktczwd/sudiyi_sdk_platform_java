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

import java.util.List;

import cn.sudiyi.platform.Platform;
import cn.sudiyi.platform.model.DeadletterPostMessage;
import cn.sudiyi.platform.model.DeadletterPutMessage;

/**
 * 获取死信响应
 * @see Platform#getDeadletters()
 * @see DeadletterPostMessage
 * @see DeadletterPutMessage
 * @author pankai
 * 2016年1月20日
 */
public class GetDeadlettersResponse {

    /**
     * 失败的预约成功的消息{@link DeadletterPostMessage}
     */
    private List<DeadletterPostMessage> post;
    /**
     * 失败的箱格状态变化的消息{@link DeadletterPutMessage}
     */
    private List<DeadletterPutMessage> put;

    /**
     * 返回失败的预约成功的消息{@link DeadletterPostMessage}
     * @return 失败的预约成功的消息{@link DeadletterPostMessage}
     */
    public List<DeadletterPostMessage> getPost() {
        return post;
    }

    /**
     * 设置失败的预约成功的消息{@link DeadletterPostMessage}
     * @param post 失败的预约成功的消息{@link DeadletterPostMessage}
     */
    public void setPost(List<DeadletterPostMessage> post) {
        this.post = post;
    }

    /**
     * 返回失败的箱格状态变化的消息{@link DeadletterPutMessage}
     * @return 失败的箱格状态变化的消息{@link DeadletterPutMessage}
     */
    public List<DeadletterPutMessage> getPut() {
        return put;
    }

    /**
     * 设置失败的箱格状态变化的消息{@link DeadletterPutMessage}
     * @param put 失败的箱格状态变化的消息{@link DeadletterPutMessage}
     */
    public void setPut(List<DeadletterPutMessage> put) {
        this.put = put;
    }

}
