package com.alibou.security.auth;

public class TokenValidationResponse {
    private boolean valid;

    public TokenValidationResponse(boolean valid) {
        this.valid = valid;
    }

    public boolean isValid() {
        return valid;
    }
}
