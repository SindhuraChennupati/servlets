package be.ordina.servletdemo.domain.authentication;

import be.ordina.servletdemo.domain.authentication.Principal;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by stevedezitter on 15/08/15.
 */
public class PrincipalBuilder {
    private Principal principal;

    public PrincipalBuilder() {
        this.principal = new Principal();
    }

    public PrincipalBuilder withUsername(String username) {
        if(StringUtils.isEmpty(username)) {
            throw new IllegalArgumentException("username parameter shouldn't be empty!");
        }

        principal.setUsername(username);
        return this;
    }

    public PrincipalBuilder withRole(String role) {
        if(StringUtils.isEmpty(role)) {
            throw new IllegalArgumentException("role parameter shouldn't be empty!");
        }

        principal.setRole(role);
        return this;
    }

    public Principal build() {
        return principal;
    }
}
