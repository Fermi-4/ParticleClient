package io.github.fermi4.particle.v1;

public class CreateTokenRequest {
    private String clientdId;
    private String clientSecret;
    private String grantType;
    private String username;
    private String password;
    private String expiresIn;
    private String expiresAt;
    
    public CreateTokenRequest(String clientdId, String clientSecret, String grantType, String username, String password,
            String expiresIn, String expiresAt) {
        this.clientdId = clientdId;
        this.clientSecret = clientSecret;
        this.grantType = grantType;
        this.username = username;
        this.password = password;
        this.expiresIn = expiresIn;
        this.expiresAt = expiresAt;
    }
    
    public String getClientdId() {
        return clientdId;
    }
    public void setClientdId(String clientdId) {
        this.clientdId = clientdId;
    }
    public String getClientSecret() {
        return clientSecret;
    }
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
    public String getGrantType() {
        return grantType;
    }
    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getExpiresIn() {
        return expiresIn;
    }
    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }
    public String getExpiresAt() {
        return expiresAt;
    }
    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clientdId == null) ? 0 : clientdId.hashCode());
        result = prime * result + ((clientSecret == null) ? 0 : clientSecret.hashCode());
        result = prime * result + ((grantType == null) ? 0 : grantType.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((expiresIn == null) ? 0 : expiresIn.hashCode());
        result = prime * result + ((expiresAt == null) ? 0 : expiresAt.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CreateTokenRequest other = (CreateTokenRequest) obj;
        if (clientdId == null) {
            if (other.clientdId != null)
                return false;
        } else if (!clientdId.equals(other.clientdId))
            return false;
        if (clientSecret == null) {
            if (other.clientSecret != null)
                return false;
        } else if (!clientSecret.equals(other.clientSecret))
            return false;
        if (grantType == null) {
            if (other.grantType != null)
                return false;
        } else if (!grantType.equals(other.grantType))
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (expiresIn == null) {
            if (other.expiresIn != null)
                return false;
        } else if (!expiresIn.equals(other.expiresIn))
            return false;
        if (expiresAt == null) {
            if (other.expiresAt != null)
                return false;
        } else if (!expiresAt.equals(other.expiresAt))
            return false;
        return true;
    }
}
