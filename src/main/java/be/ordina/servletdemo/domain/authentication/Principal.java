package be.ordina.servletdemo.domain.authentication;

/**
 * Created by stevedezitter on 15/08/15.
 */
public class Principal {
    private String username;
    private String role;

    protected Principal() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
