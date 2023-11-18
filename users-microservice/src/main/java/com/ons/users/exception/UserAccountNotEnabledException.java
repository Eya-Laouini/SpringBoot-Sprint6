package com.ons.users.exception;
import javax.naming.AuthenticationException;

public class UserAccountNotEnabledException extends AuthenticationException {
    public UserAccountNotEnabledException(String msg) {
        super(msg);
    }
}
