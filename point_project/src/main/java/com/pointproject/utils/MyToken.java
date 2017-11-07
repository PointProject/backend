package com.pointproject.utils;

import com.google.common.base.Objects;

public final class MyToken {
    private final String token;

    public MyToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyToken)) return false;
        MyToken myToken = (MyToken) o;
        return Objects.equal(token, myToken.token);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(token);
    }

    @Override
    public String toString() {
        return "MyToken{" +
                "token='" + token + '\'' +
                '}';
    }
}
