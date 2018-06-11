package ua.nure.mediaserver.domain.network;

public class JwtAuthenticationResposne {

    private String accessToken;
    private String tokenType = "Bearer";

    public JwtAuthenticationResposne(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }


}
