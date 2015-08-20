package be.ordina.servletdemo.domain.authentication;

import be.ordina.servletdemo.exception.AuthenticationFailedException;

/**
 * Created by stevedezitter on 15/08/15.
 */
public class Authenticator {

    public static final String SESSION_KEY_PRINCIPAL = "principal";
    public static final String ROLE_AUTHENTICATED = "Authenticated";

    private String username;
    private String password;

    public Authenticator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Principal authenticate() {
        if("steve".equals(username) && "passwordSteve".equals(password)) {
            return new PrincipalBuilder().withUsername(username).withRole(ROLE_AUTHENTICATED).build();
        }
        throw new AuthenticationFailedException("Failed login attempt for user: " + username);
    }
}