/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.carbon.identity.captcha.connector.recaptcha;

import org.apache.commons.lang.StringUtils;
import org.wso2.carbon.identity.captcha.connector.CaptchaConnector;
import org.wso2.carbon.identity.captcha.exception.CaptchaClientException;
import org.wso2.carbon.identity.captcha.exception.CaptchaException;
import org.wso2.carbon.identity.captcha.util.CaptchaUtil;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Abstract ReCaptcha Connector.
 */
public abstract class AbstractReCaptchaConnector implements CaptchaConnector {

    @Override
    public boolean verifyCaptcha(ServletRequest servletRequest, ServletResponse servletResponse)
            throws CaptchaException {

        if (((HttpServletRequest) servletRequest).getMethod().equalsIgnoreCase("GET")) {
            throw new CaptchaClientException("reCaptcha response must send in a POST request.");
        }

        String reCaptchaResponse = servletRequest.getParameter("g-recaptcha-response");
        if (StringUtils.isBlank(reCaptchaResponse)) {
            throw new CaptchaClientException("reCaptcha response is not available in the request.");
        }

        return CaptchaUtil.isValidCaptcha(reCaptchaResponse);
    }
}
