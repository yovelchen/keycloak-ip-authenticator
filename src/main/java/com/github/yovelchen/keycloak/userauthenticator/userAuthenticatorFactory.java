package com.github.lukaszbudnik.keycloak.ipauthenticator;

import static org.keycloak.provider.ProviderConfigProperty.STRING_TYPE;

import java.util.Collections;
import java.util.List;

import org.keycloak.Config;
import org.keycloak.authentication.Authenticator;
import org.keycloak.authentication.AuthenticatorFactory;
import org.keycloak.models.AuthenticationExecutionModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.provider.ProviderConfigProperty;

public class UserAuthenticatorFactory implements AuthenticatorFactory {

    @Override
    public String getId() {
        return "user-authenticator";
    }

    @Override
    public String getReferenceCategory() {
        return null;
    }

    @Override
    public boolean isConfigurable() {
        return false;
    }

    @Override
    public AuthenticationExecutionModel.Requirement[] getRequirementChoices() {
        return new AuthenticationExecutionModel.Requirement[]{
                AuthenticationExecutionModel.Requirement.REQUIRED
        };
    }

    @Override
    public boolean isUserSetupAllowed() {
        return false;
    }

    @Override
    public String getHelpText() {
        return "Custom User Authenticator";
    }

    @Override
    public String getDisplayType() {
        return "User Authenticator";
    }

    @Override
    public String getReferenceDisplayType() {
        return null;
    }

    @Override
    public Authenticator create(KeycloakSession session) {
        return new UserAuthenticator();
    }

    @Override
    public void init(Config.Scope config) {
        // Initialization logic if needed
    }

    @Override
    public void postInit(KeycloakSessionFactory factory) {
        // Post-initialization logic if needed
    }

    @Override
    public void close() {
        // Closing logic if needed
    }
}