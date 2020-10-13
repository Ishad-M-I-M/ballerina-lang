/*
 *   Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.ballerinalang.langlib.value;

import org.ballerinalang.jvm.JSONParser;
import org.ballerinalang.jvm.api.BErrorCreator;
import org.ballerinalang.jvm.api.BStringUtils;
import org.ballerinalang.jvm.api.values.BString;
import org.ballerinalang.jvm.util.exceptions.BallerinaException;

/**
 * Parse a string in JSON format and return the the value that it represents.
 * All numbers in the JSON will be represented as decimal values.
 */

public class FromJsonDecimalString {

    public static Object fromJsonDecimalString(BString value) {

        String str = value.getValue();
        if (str.equals("null")) {
            return null;
        }
        try {
            return JSONParser.parse(str, JSONParser.NonStringValueProcessingMode.FROM_JSON_DECIMAL_STRING);
        } catch (BallerinaException e) {
            return BErrorCreator
                    .createError(BStringUtils.fromString("{ballerina/lang.value}FromJsonDecimalStringError"),
                                 BStringUtils.fromString(e.getMessage()));
        }
    }
}