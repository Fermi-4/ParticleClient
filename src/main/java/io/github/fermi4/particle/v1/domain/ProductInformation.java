package io.github.fermi4.particle.v1.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductInformation {
    private int id;
    private int platformId;
    private String name;
    private String slugOrProductId;
    private String description;
    private int subscriptionId;
    private String user;
    private List<String> groups = new ArrayList<>();
    private Map<String, Object> settings = new HashMap<>();
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPlatformId() {
        return platformId;
    }
    public void setPlatformId(int platformId) {
        this.platformId = platformId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSlugOrProductId() {
        return slugOrProductId;
    }
    public void setSlugOrProductId(String slugOrProductId) {
        this.slugOrProductId = slugOrProductId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getSubscriptionId() {
        return subscriptionId;
    }
    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public List<String> getGroups() {
        return groups;
    }
    public void setGroups(List<String> groups) {
        this.groups = groups;
    }
    public Map<String, Object> getSettings() {
        return settings;
    }
    public void setSettings(Map<String, Object> settings) {
        this.settings = settings;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + platformId;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((slugOrProductId == null) ? 0 : slugOrProductId.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + subscriptionId;
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        result = prime * result + ((groups == null) ? 0 : groups.hashCode());
        result = prime * result + ((settings == null) ? 0 : settings.hashCode());
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
        ProductInformation other = (ProductInformation) obj;
        if (id != other.id)
            return false;
        if (platformId != other.platformId)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (slugOrProductId == null) {
            if (other.slugOrProductId != null)
                return false;
        } else if (!slugOrProductId.equals(other.slugOrProductId))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (subscriptionId != other.subscriptionId)
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        if (groups == null) {
            if (other.groups != null)
                return false;
        } else if (!groups.equals(other.groups))
            return false;
        if (settings == null) {
            if (other.settings != null)
                return false;
        } else if (!settings.equals(other.settings))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "ProductInformation [id=" + id + ", platformId=" + platformId + ", name=" + name + ", slugOrProductId="
                + slugOrProductId + ", description=" + description + ", subscriptionId=" + subscriptionId + ", user="
                + user + ", groups=" + groups + ", settings=" + settings + "]";
    }
    
    
    
}
