package ua.nure.mediaserver.domain.enums;

import org.springframework.security.core.GrantedAuthority;

public enum  UserAuthority implements GrantedAuthority {

    USER_AUTHORITY;

    @Override
    public String getAuthority() {
        return toString();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
