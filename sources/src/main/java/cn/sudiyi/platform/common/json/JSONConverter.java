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

package cn.sudiyi.platform.common.json;

import java.io.IOException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JSONConverter {

    private final static ObjectMapper INSTANCE = new ObjectMapper();

    static {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        INSTANCE.setDateFormat(dateFormat);
        INSTANCE.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX, true);
    }

    public static <T> T fromJson(Class<T> targetClass, String value, Class<?>... elementClasses) {
        try {
            if ((elementClasses == null) || (elementClasses.length == 0)) {
                return INSTANCE.readValue(value, targetClass);
            } else {
                return INSTANCE.readValue(value, INSTANCE.getTypeFactory().constructParametrizedType(targetClass, targetClass, elementClasses));
            }
        } catch (IOException e) {
            throw new RuntimeIOException(e);
        }
    }

    public static String toJson(Object value) {
        try {
            return INSTANCE.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new RuntimeIOException(e);
        }
    }
}
