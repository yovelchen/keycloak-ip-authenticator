package com.github.lukaszbudnik.keycloak.ipauthenticator;

import java.util.Collections;
import java.util.Map;

import org.jboss.logging.Logger;
import org.keycloak.authentication.AuthenticationFlowContext;
import org.keycloak.authentication.Authenticator;
import org.keycloak.models.*;
import org.keycloak.models.credential.OTPCredentialModel;

public class userAuthenticator implements Authenticator {

    private static final Logger logger = Logger.getLogger(userAuthenticator.class);
    private static final String CONDITIONAL_USER_ATTRIBUTE = "user_based_conditional";

    @Override
    public void authenticate(AuthenticationFlowContext context) {
        KeycloakSession session = context.getSession();
        RealmModel realm = context.getRealm();
        UserModel user = context.getUser();


        if (!"yovel".equals(user.getUsername())){
            logger.infof("user name do not match. Realm: %s expected user: yovel current user: %s ", realm.getName(), user.getUsername());
            context.failure(AuthenticationFlowError.INVALID_USER);
            return;
        } 
        context.success();
    }

    // private String getAllowedIPAddress(AuthenticationFlowContext context) {
    //     AuthenticatorConfigModel configModel = context.getAuthenticatorConfig();
    //     Map<String, String> config = configModel.getConfig();
    //     return config.get(IPAuthenticatorFactory.ALLOWED_IP_ADDRESS_CONFIG);
    // }

    // @Override
    // public void action(AuthenticationFlowContext context) {
    // }

    // @Override
    // public boolean requiresUser() {
    //     return true;
    // }

    // @Override
    // public boolean configuredFor(KeycloakSession session, RealmModel realm, UserModel user) {
    //     return true;
    // }

    // @Override
    // public void setRequiredActions(KeycloakSession session, RealmModel realm, UserModel user) {
    // }

    // @Override
    // public void close() {
    // }

}
