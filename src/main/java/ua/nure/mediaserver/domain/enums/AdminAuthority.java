package ua.nure.mediaserver.domain.enums;

import org.springframework.security.core.GrantedAuthority;

public enum  AdminAuthority implements GrantedAuthority {

    ADMIN_AUTHORITY;

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String getAuthority() {
        return toString();
    }
}
