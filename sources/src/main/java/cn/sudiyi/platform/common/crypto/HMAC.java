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

package cn.sudiyi.platform.common.crypto;

import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import cn.sudiyi.platform.common.utils.StringUtils;

public class HMAC {
    private byte[] key;
    private Hash hash = Hash.MD5;

    public byte[] digest(String message) {
        if (StringUtils.isBlank(message)) {
            throw new RuntimeException("key should not be null");
        }
        try {
            String algorithm = "Hmac" + hash.value;
            Mac mac = Mac.getInstance(algorithm);
            SecretKey secretKey = new SecretKeySpec(key, algorithm);
            mac.init(secretKey);
            return mac.doFinal(message.getBytes(Charset.defaultCharset()));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        } catch (InvalidKeyException e) {
            throw new IllegalStateException(e);
        }
    }

    public void setSecretKey(byte[] key) {
        this.key = key;
    }

    public void setHash(Hash hash) {
        this.hash = hash;
    }

    public static enum Hash {
        MD5("MD5"), SHA1("SHA1"), SHA512("SHA512");

        Hash(String value) {
            this.value = value;
        }

        final String value;
    }
}
