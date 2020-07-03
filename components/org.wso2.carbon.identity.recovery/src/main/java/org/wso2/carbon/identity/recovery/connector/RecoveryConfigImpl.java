/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations und
 */
package org.wso2.carbon.identity.recovery.connector;

import org.apache.commons.lang.StringUtils;
import org.wso2.carbon.identity.core.util.IdentityUtil;
import org.wso2.carbon.identity.governance.IdentityGovernanceException;
import org.wso2.carbon.identity.governance.common.IdentityConnectorConfig;
import org.wso2.carbon.identity.recovery.IdentityRecoveryConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Class which contains account recovery configs.
 */
public class RecoveryConfigImpl implements IdentityConnectorConfig {

    private static final String connectorName = "account-recovery";

    @Override
    public String getName() {
        return connectorName;
    }

    @Override
    public String getFriendlyName() {
        return "Account recovery";
    }

    @Override
    public String getCategory() {
        return "Account Management";
    }

    @Override
    public String getSubCategory() {
        return "DEFAULT";
    }

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public Map<String, String> getPropertyNameMapping() {

        Map<String, String> nameMapping = new HashMap<>();
        nameMapping.put(IdentityRecoveryConstants.ConnectorConfig.NOTIFICATION_BASED_PW_RECOVERY,
                "Notification based password recovery");
        nameMapping.put(IdentityRecoveryConstants.ConnectorConfig.NOTIFICATION_INTERNALLY_MANAGE,
                "Manage notifications sending internally");
        nameMapping.put(IdentityRecoveryConstants.ConnectorConfig.PASSWORD_RECOVERY_RECAPTCHA_ENABLE,
                "Enable reCaptcha for password recovery");
        nameMapping.put(IdentityRecoveryConstants.ConnectorConfig.QUESTION_BASED_PW_RECOVERY,
                "Security question based password recovery");
        nameMapping.put(IdentityRecoveryConstants.ConnectorConfig.CHALLENGE_QUESTION_ANSWER_REGEX,
                "Security question answer regex");
        nameMapping.put(IdentityRecoveryConstants.ConnectorConfig.ENFORCE_CHALLENGE_QUESTION_ANSWER_UNIQUENESS,
                "Enforce security question answer uniqueness");
        nameMapping.put(IdentityRecoveryConstants.ConnectorConfig.QUESTION_MIN_NO_ANSWER, "Number of questions " +
                "Required for password recovery");
        nameMapping.put(IdentityRecoveryConstants.ConnectorConfig.USERNAME_RECOVERY_ENABLE, "Username recovery");
        nameMapping.put(IdentityRecoveryConstants.ConnectorConfig.USERNAME_RECOVERY_RECAPTCHA_ENABLE,
                "Enable reCaptcha for username recovery");
        nameMapping.put(IdentityRecoveryConstants.ConnectorConfig.EXPIRY_TIME, "Recovery link expiry time");
        nameMapping.put(IdentityRecoveryConstants.ConnectorConfig.PASSWORD_RECOVERY_SMS_OTP_EXPIRY_TIME,
                "SMS OTP expiry time");
        nameMapping.put(IdentityRecoveryConstants.ConnectorConfig.NOTIFICATION_SEND_RECOVERY_NOTIFICATION_SUCCESS,
                "Notify when recovery success");
        nameMapping.put(IdentityRecoveryConstants.ConnectorConfig.NOTIFICATION_SEND_RECOVERY_SECURITY_START,
                "Notify when security questions based recovery starts");

        nameMapping.put(IdentityRecoveryConstants.ConnectorConfig.RECOVERY_QUESTION_PASSWORD_RECAPTCHA_ENABLE,
                "Enable reCaptcha for security questions based password recovery");
        nameMapping.put(
                IdentityRecoveryConstants.ConnectorConfig.RECOVERY_QUESTION_PASSWORD_RECAPTCHA_MAX_FAILED_ATTEMPTS,
                "Max failed attempts for reCaptcha");
        nameMapping.put(IdentityRecoveryConstants.ConnectorConfig.FORCE_ADD_PW_RECOVERY_QUESTION, "Enable forced " +
                "security questions");
        nameMapping.put(IdentityRecoveryConstants.ConnectorConfig.FORCE_MIN_NO_QUESTION_ANSWERED,
                "Minimum number of forced security questions to be answered");
        nameMapping.put(IdentityRecoveryConstants.ConnectorConfig.RECOVERY_CALLBACK_REGEX,
                "Recovery callback URL regex");
        return nameMapping;
    }

    @Override
    public Map<String, String> getPropertyDescriptionMapping() {
        Map<String, String> descriptionMapping = new HashMap<>();
        descriptionMapping.put(IdentityRecoveryConstants.ConnectorConfig.NOTIFICATION_INTERNALLY_MANAGE,
                "Disable if the client application handles notification sending");
        descriptionMapping.put(IdentityRecoveryConstants.ConnectorConfig.CHALLENGE_QUESTION_ANSWER_REGEX,
                "Security question answer regex");
        descriptionMapping.put(IdentityRecoveryConstants.ConnectorConfig.ENFORCE_CHALLENGE_QUESTION_ANSWER_UNIQUENESS,
                "Enforce Security question answer uniqueness");
        descriptionMapping.put(IdentityRecoveryConstants.ConnectorConfig.RECOVERY_QUESTION_PASSWORD_RECAPTCHA_ENABLE,
                "Prompt reCaptcha for security question based password recovery");
        descriptionMapping.put(IdentityRecoveryConstants.ConnectorConfig.FORCE_ADD_PW_RECOVERY_QUESTION,
                "Force users to provide answers to security questions during sign in");
        descriptionMapping.put(IdentityRecoveryConstants.ConnectorConfig.FORCE_MIN_NO_QUESTION_ANSWERED,
                "Force users to provide answers to security questions during sign in " +
                        "if user has answered lesser than this value");
        descriptionMapping.put(IdentityRecoveryConstants.ConnectorConfig.RECOVERY_CALLBACK_REGEX,
                "Recovery callback URL regex");
        descriptionMapping.put(IdentityRecoveryConstants.ConnectorConfig.PASSWORD_RECOVERY_SMS_OTP_EXPIRY_TIME,
                "Expiration time of the SMS OTP code for password recovery");
        return descriptionMapping;
    }

    @Override
    public String[] getPropertyNames() {

        List<String> properties = new ArrayList<>();
        properties.add(IdentityRecoveryConstants.ConnectorConfig.NOTIFICATION_BASED_PW_RECOVERY);
        properties.add(IdentityRecoveryConstants.ConnectorConfig.PASSWORD_RECOVERY_RECAPTCHA_ENABLE);
        properties.add(IdentityRecoveryConstants.ConnectorConfig.QUESTION_BASED_PW_RECOVERY);
        properties.add(IdentityRecoveryConstants.ConnectorConfig.QUESTION_MIN_NO_ANSWER);
        properties.add(IdentityRecoveryConstants.ConnectorConfig.CHALLENGE_QUESTION_ANSWER_REGEX);
        properties.add(IdentityRecoveryConstants.ConnectorConfig.ENFORCE_CHALLENGE_QUESTION_ANSWER_UNIQUENESS);
        properties.add(IdentityRecoveryConstants.ConnectorConfig.RECOVERY_QUESTION_PASSWORD_RECAPTCHA_ENABLE);
        properties.add(IdentityRecoveryConstants.ConnectorConfig.RECOVERY_QUESTION_PASSWORD_RECAPTCHA_MAX_FAILED_ATTEMPTS);
        properties.add(IdentityRecoveryConstants.ConnectorConfig.USERNAME_RECOVERY_ENABLE);
        properties.add(IdentityRecoveryConstants.ConnectorConfig.USERNAME_RECOVERY_RECAPTCHA_ENABLE);
        properties.add(IdentityRecoveryConstants.ConnectorConfig.NOTIFICATION_INTERNALLY_MANAGE);
        properties.add(IdentityRecoveryConstants.ConnectorConfig.NOTIFICATION_SEND_RECOVERY_NOTIFICATION_SUCCESS);
        properties.add(IdentityRecoveryConstants.ConnectorConfig.NOTIFICATION_SEND_RECOVERY_SECURITY_START);
        properties.add(IdentityRecoveryConstants.ConnectorConfig.EXPIRY_TIME);
        properties.add(IdentityRecoveryConstants.ConnectorConfig.PASSWORD_RECOVERY_SMS_OTP_EXPIRY_TIME);
        properties.add(IdentityRecoveryConstants.ConnectorConfig.FORCE_ADD_PW_RECOVERY_QUESTION);
        properties.add(IdentityRecoveryConstants.ConnectorConfig.FORCE_MIN_NO_QUESTION_ANSWERED);
        properties.add(IdentityRecoveryConstants.ConnectorConfig.RECOVERY_CALLBACK_REGEX);
        return properties.toArray(new String[0]);
    }

    @Override
    public Properties getDefaultPropertyValues(String tenantDomain) throws IdentityGovernanceException {

        String enableNotificationBasedPasswordRecovery = "false";
        String enableQuestionBasedPasswordRecovery = "false";
        String minimumAnswers = "2";
        String challengeQuestionAnswerRegex = IdentityRecoveryConstants.DEFAULT_REGEX;
        String enforceChallengeQuestionAnswerUniqueness = "false";
        String enableRecoveryQuestionPasswordReCaptcha = "true";
        String recoveryQuestionPasswordReCaptchaMaxFailedAttempts = "2";
        String enableUsernameRecovery = "false";
        String enableNotificationInternallyManage = "true";
        String expiryTime = "1440";
        String expiryTimeSMSOTP = "1";
        String notifySuccess = "false";
        String notifyStart = "false";
        String enableForceChallengeQuestions = "false";
        String enablePasswordRecoveryReCaptcha = "false";
        String enableUsernameRecoveryReCaptcha = "false";
        String minimumForcedChallengeQuestionsAnswered = StringUtils.EMPTY;
        String recoveryCallbackRegex = IdentityRecoveryConstants.DEFAULT_CALLBACK_REGEX;

        String notificationBasedPasswordRecovery = IdentityUtil.getProperty(
                IdentityRecoveryConstants.ConnectorConfig.NOTIFICATION_BASED_PW_RECOVERY);
        String questionBasedPasswordRecovery = IdentityUtil.getProperty(
                IdentityRecoveryConstants.ConnectorConfig.QUESTION_BASED_PW_RECOVERY);
        String miniMumAnswerProperty = IdentityUtil.getProperty(
                IdentityRecoveryConstants.ConnectorConfig.QUESTION_MIN_NO_ANSWER);
        String challengeQuestionAnswerRegexProperty = IdentityUtil.getProperty(
                IdentityRecoveryConstants.ConnectorConfig.CHALLENGE_QUESTION_ANSWER_REGEX);
        String challengeQuestionAnswerUniquenessProperty = IdentityUtil.getProperty(
                IdentityRecoveryConstants.ConnectorConfig.ENFORCE_CHALLENGE_QUESTION_ANSWER_UNIQUENESS);
        String recoveryQuestionPasswordReCaptcha = IdentityUtil.getProperty(
                IdentityRecoveryConstants.ConnectorConfig.RECOVERY_QUESTION_PASSWORD_RECAPTCHA_ENABLE);
        String passwordReCaptchaMaxFailedAttempts = IdentityUtil.getProperty(IdentityRecoveryConstants.
                ConnectorConfig.RECOVERY_QUESTION_PASSWORD_RECAPTCHA_MAX_FAILED_ATTEMPTS);
        String usernameRecovery = IdentityUtil.getProperty(
                IdentityRecoveryConstants.ConnectorConfig.USERNAME_RECOVERY_ENABLE);
        String notificationInternallyManged = IdentityUtil.getProperty(
                IdentityRecoveryConstants.ConnectorConfig.NOTIFICATION_INTERNALLY_MANAGE);
        String expiryTimeProperty = IdentityUtil.getProperty(IdentityRecoveryConstants.ConnectorConfig.EXPIRY_TIME);
        String expiryTimeSMSOTPProperty = IdentityUtil
                .getProperty(IdentityRecoveryConstants.ConnectorConfig.PASSWORD_RECOVERY_SMS_OTP_EXPIRY_TIME);
        String notifySuccessProperty = IdentityUtil.getProperty(
                IdentityRecoveryConstants.ConnectorConfig.NOTIFICATION_SEND_RECOVERY_NOTIFICATION_SUCCESS);
        String notifyStartProperty = IdentityUtil.getProperty(
                IdentityRecoveryConstants.ConnectorConfig.NOTIFICATION_SEND_RECOVERY_SECURITY_START);
        String forceChallengeQuestionsProperty = IdentityUtil.getProperty(
                IdentityRecoveryConstants.ConnectorConfig.FORCE_ADD_PW_RECOVERY_QUESTION);
        String minimumForcedChallengeQuestionsAnsweredProperty = IdentityUtil
                .getProperty(IdentityRecoveryConstants.ConnectorConfig.FORCE_MIN_NO_QUESTION_ANSWERED);
        String passwordRecoveryReCaptcha = IdentityUtil.getProperty(IdentityRecoveryConstants.ConnectorConfig.
                PASSWORD_RECOVERY_RECAPTCHA_ENABLE);
        String userNameRecoveryReCaptcha = IdentityUtil.getProperty(IdentityRecoveryConstants.ConnectorConfig.
                USERNAME_RECOVERY_RECAPTCHA_ENABLE);
        String recoveryCallbackRegexProperty = IdentityUtil.getProperty(
                IdentityRecoveryConstants.ConnectorConfig.RECOVERY_CALLBACK_REGEX);

        if (StringUtils.isNotEmpty(expiryTimeSMSOTPProperty)) {
            expiryTimeSMSOTP = expiryTimeSMSOTPProperty;
        }
        if (StringUtils.isNotEmpty(notificationBasedPasswordRecovery)) {
            enableNotificationBasedPasswordRecovery = notificationBasedPasswordRecovery;
        }
        if (StringUtils.isNotEmpty(questionBasedPasswordRecovery)) {
            enableQuestionBasedPasswordRecovery = questionBasedPasswordRecovery;
        }
        if (StringUtils.isNotEmpty(challengeQuestionAnswerRegexProperty)) {
            challengeQuestionAnswerRegex = challengeQuestionAnswerRegexProperty;
        }
        if (StringUtils.isNotEmpty(challengeQuestionAnswerUniquenessProperty)) {
            enforceChallengeQuestionAnswerUniqueness = challengeQuestionAnswerUniquenessProperty;
        }
        if (StringUtils.isNotEmpty(notificationInternallyManged)) {
            enableNotificationInternallyManage = notificationInternallyManged;
        }
        if (StringUtils.isNotEmpty(miniMumAnswerProperty)) {
            minimumAnswers = miniMumAnswerProperty;
        }
        if (StringUtils.isNotEmpty(recoveryQuestionPasswordReCaptcha)) {
            enableRecoveryQuestionPasswordReCaptcha = recoveryQuestionPasswordReCaptcha;
        }
        if (StringUtils.isNotEmpty(passwordReCaptchaMaxFailedAttempts)) {
            recoveryQuestionPasswordReCaptchaMaxFailedAttempts = passwordReCaptchaMaxFailedAttempts;
        }
        if (StringUtils.isNotEmpty(usernameRecovery)) {
            enableUsernameRecovery = usernameRecovery;
        }
        if (StringUtils.isNotEmpty(expiryTimeProperty)) {
            expiryTime = expiryTimeProperty;
        }
        if (StringUtils.isNotEmpty(notifySuccessProperty)) {
            notifySuccess = notifySuccessProperty;
        }
        if (StringUtils.isNotEmpty(notifyStartProperty)) {
            notifyStart = notifyStartProperty;
        }
        if (StringUtils.isNotEmpty(forceChallengeQuestionsProperty)) {
            enableForceChallengeQuestions = forceChallengeQuestionsProperty;
        }
        if (StringUtils.isNotEmpty(minimumForcedChallengeQuestionsAnsweredProperty)) {
            minimumForcedChallengeQuestionsAnswered = minimumForcedChallengeQuestionsAnsweredProperty;
        }
        if (StringUtils.isNotEmpty(passwordRecoveryReCaptcha)) {
            enablePasswordRecoveryReCaptcha = passwordRecoveryReCaptcha;
        }
        if (StringUtils.isNotEmpty(userNameRecoveryReCaptcha)) {
            enableUsernameRecoveryReCaptcha = userNameRecoveryReCaptcha;
        }
        if (StringUtils.isNotEmpty(recoveryCallbackRegexProperty)) {
            recoveryCallbackRegex = recoveryCallbackRegexProperty;
        }

        Map<String, String> defaultProperties = new HashMap<>();
        defaultProperties.put(IdentityRecoveryConstants.ConnectorConfig.NOTIFICATION_BASED_PW_RECOVERY,
                enableNotificationBasedPasswordRecovery);
        defaultProperties.put(IdentityRecoveryConstants.ConnectorConfig.PASSWORD_RECOVERY_RECAPTCHA_ENABLE,
                enablePasswordRecoveryReCaptcha);
        defaultProperties.put(IdentityRecoveryConstants.ConnectorConfig.QUESTION_BASED_PW_RECOVERY,
                enableQuestionBasedPasswordRecovery);
        defaultProperties.put(IdentityRecoveryConstants.ConnectorConfig.QUESTION_MIN_NO_ANSWER,
                minimumAnswers);
        defaultProperties.put(IdentityRecoveryConstants.ConnectorConfig.CHALLENGE_QUESTION_ANSWER_REGEX,
                challengeQuestionAnswerRegex);
        defaultProperties.put(IdentityRecoveryConstants.ConnectorConfig.ENFORCE_CHALLENGE_QUESTION_ANSWER_UNIQUENESS,
                enforceChallengeQuestionAnswerUniqueness);
        defaultProperties.put(IdentityRecoveryConstants.ConnectorConfig.RECOVERY_QUESTION_PASSWORD_RECAPTCHA_ENABLE,
                enableRecoveryQuestionPasswordReCaptcha);
        defaultProperties.put(IdentityRecoveryConstants.ConnectorConfig
                        .RECOVERY_QUESTION_PASSWORD_RECAPTCHA_MAX_FAILED_ATTEMPTS,
                recoveryQuestionPasswordReCaptchaMaxFailedAttempts);
        defaultProperties.put(IdentityRecoveryConstants.ConnectorConfig.USERNAME_RECOVERY_ENABLE,
                enableUsernameRecovery);
        defaultProperties.put(IdentityRecoveryConstants.ConnectorConfig.USERNAME_RECOVERY_RECAPTCHA_ENABLE,
                enableUsernameRecoveryReCaptcha);
        defaultProperties.put(IdentityRecoveryConstants.ConnectorConfig.NOTIFICATION_INTERNALLY_MANAGE,
                enableNotificationInternallyManage);
        defaultProperties.put(IdentityRecoveryConstants.ConnectorConfig.EXPIRY_TIME, expiryTime);
        defaultProperties
                .put(IdentityRecoveryConstants.ConnectorConfig.PASSWORD_RECOVERY_SMS_OTP_EXPIRY_TIME, expiryTimeSMSOTP);
        defaultProperties.put(IdentityRecoveryConstants.ConnectorConfig.NOTIFICATION_SEND_RECOVERY_NOTIFICATION_SUCCESS,
                notifySuccess);
        defaultProperties.put(IdentityRecoveryConstants.ConnectorConfig.NOTIFICATION_SEND_RECOVERY_SECURITY_START,
                notifyStart);
        defaultProperties.put(IdentityRecoveryConstants.ConnectorConfig.FORCE_ADD_PW_RECOVERY_QUESTION,
                enableForceChallengeQuestions);
        defaultProperties.put(IdentityRecoveryConstants.ConnectorConfig.FORCE_MIN_NO_QUESTION_ANSWERED,
                minimumForcedChallengeQuestionsAnswered);
        defaultProperties.put(IdentityRecoveryConstants.ConnectorConfig.RECOVERY_CALLBACK_REGEX, recoveryCallbackRegex);

        Properties properties = new Properties();
        properties.putAll(defaultProperties);
        return properties;
    }

    @Override
    public Map<String, String> getDefaultPropertyValues(String[] propertyNames, String tenantDomain)
            throws IdentityGovernanceException {
        return null;
    }

}
