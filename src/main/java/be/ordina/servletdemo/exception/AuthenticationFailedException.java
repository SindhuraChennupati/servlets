package be.ordina.servletdemo.exception;

/**
 * Created by stevedezitter on 15/08/15.
 */
public class AuthenticationFailedException extends RuntimeException {
    public AuthenticationFailedException() {
        super("Authentication failed");
    }

    public AuthenticationFailedException(String message) {
        super(message);
    }
}
