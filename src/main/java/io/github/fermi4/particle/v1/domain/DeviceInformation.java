package io.github.fermi4.particle.v1.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DeviceInformation {
    private String id;
    private String name;
    private String owner;
    private String lastIpAddress;
    private Date lastHeard;
    private Date lastHandshakeAt;
    private int productId;
    private boolean online;
    private boolean connected;
    private int platformId;
    private boolean cellular;
    private String notes;
    private List<String> functions = new ArrayList<>();
    private Map<String, Object> variables = new HashMap<>();
    private String serialNumber;
    private String status;
    private String iccid;
    private String lastIccid;
    private String imei;
    private String macWifi;
    private String systemFirmwareVersion;
    private String currentBuildTarget;
    private String pinnedBuildTarget;
    private String defaultBuildTarget;
    private boolean firmwareUpdatesEnabled;
    private boolean firmwareUpdatesForced;
    private String mobileSecret;
    private int firmwareProductId;
    private List<String> groups = new ArrayList<>();
    private int firmwareVersion;
    private int desiredFirmwareVersion;
    private int targetedFirmwareReleaseVersion;
    private boolean development;
    private boolean quarantined;
    private boolean denied;
    private String deviceProtectionStatus;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String getLastIpAddress() {
        return lastIpAddress;
    }
    public void setLastIpAddress(String lastIpAddress) {
        this.lastIpAddress = lastIpAddress;
    }
    public Date getLastHeard() {
        return lastHeard;
    }
    public void setLastHeard(Date lastHeard) {
        this.lastHeard = lastHeard;
    }
    public Date getLastHandshakeAt() {
        return lastHandshakeAt;
    }
    public void setLastHandshakeAt(Date lastHandshakeAt) {
        this.lastHandshakeAt = lastHandshakeAt;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public boolean isOnline() {
        return online;
    }
    public void setOnline(boolean online) {
        this.online = online;
    }
    public boolean isConnected() {
        return connected;
    }
    public void setConnected(boolean connected) {
        this.connected = connected;
    }
    public int getPlatformId() {
        return platformId;
    }
    public void setPlatformId(int platformId) {
        this.platformId = platformId;
    }
    public boolean isCellular() {
        return cellular;
    }
    public void setCellular(boolean cellular) {
        this.cellular = cellular;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public List<String> getFunctions() {
        return functions;
    }
    public void setFunctions(List<String> functions) {
        this.functions = functions;
    }
    public Map<String, Object> getVariables() {
        return variables;
    }
    public void setVariables(Map<String, Object> variables) {
        this.variables = variables;
    }
    public String getSerialNumber() {
        return serialNumber;
    }
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getIccid() {
        return iccid;
    }
    public void setIccid(String iccid) {
        this.iccid = iccid;
    }
    public String getLastIccid() {
        return lastIccid;
    }
    public void setLastIccid(String lastIccid) {
        this.lastIccid = lastIccid;
    }
    public String getImei() {
        return imei;
    }
    public void setImei(String imei) {
        this.imei = imei;
    }
    public String getMacWifi() {
        return macWifi;
    }
    public void setMacWifi(String macWifi) {
        this.macWifi = macWifi;
    }
    public String getSystemFirmwareVersion() {
        return systemFirmwareVersion;
    }
    public void setSystemFirmwareVersion(String systemFirmwareVersion) {
        this.systemFirmwareVersion = systemFirmwareVersion;
    }
    public String getCurrentBuildTarget() {
        return currentBuildTarget;
    }
    public void setCurrentBuildTarget(String currentBuildTarget) {
        this.currentBuildTarget = currentBuildTarget;
    }
    public String getPinnedBuildTarget() {
        return pinnedBuildTarget;
    }
    public void setPinnedBuildTarget(String pinnedBuildTarget) {
        this.pinnedBuildTarget = pinnedBuildTarget;
    }
    public String getDefaultBuildTarget() {
        return defaultBuildTarget;
    }
    public void setDefaultBuildTarget(String defaultBuildTarget) {
        this.defaultBuildTarget = defaultBuildTarget;
    }
    public boolean isFirmwareUpdatesEnabled() {
        return firmwareUpdatesEnabled;
    }
    public void setFirmwareUpdatesEnabled(boolean firmwareUpdatesEnabled) {
        this.firmwareUpdatesEnabled = firmwareUpdatesEnabled;
    }
    public boolean isFirmwareUpdatesForced() {
        return firmwareUpdatesForced;
    }
    public void setFirmwareUpdatesForced(boolean firmwareUpdatesForced) {
        this.firmwareUpdatesForced = firmwareUpdatesForced;
    }
    public String getMobileSecret() {
        return mobileSecret;
    }
    public void setMobileSecret(String mobileSecret) {
        this.mobileSecret = mobileSecret;
    }
    public int getFirmwareProductId() {
        return firmwareProductId;
    }
    public void setFirmwareProductId(int firmwareProductId) {
        this.firmwareProductId = firmwareProductId;
    }
    public List<String> getGroups() {
        return groups;
    }
    public void setGroups(List<String> groups) {
        this.groups = groups;
    }
    public int getFirmwareVersion() {
        return firmwareVersion;
    }
    public void setFirmwareVersion(int firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }
    public int getDesiredFirmwareVersion() {
        return desiredFirmwareVersion;
    }
    public void setDesiredFirmwareVersion(int desiredFirmwareVersion) {
        this.desiredFirmwareVersion = desiredFirmwareVersion;
    }
    public int getTargetedFirmwareReleaseVersion() {
        return targetedFirmwareReleaseVersion;
    }
    public void setTargetedFirmwareReleaseVersion(int targetedFirmwareReleaseVersion) {
        this.targetedFirmwareReleaseVersion = targetedFirmwareReleaseVersion;
    }
    public boolean isDevelopment() {
        return development;
    }
    public void setDevelopment(boolean development) {
        this.development = development;
    }
    public boolean isQuarantined() {
        return quarantined;
    }
    public void setQuarantined(boolean quarantined) {
        this.quarantined = quarantined;
    }
    public boolean isDenied() {
        return denied;
    }
    public void setDenied(boolean denied) {
        this.denied = denied;
    }
    public String getDeviceProtectionStatus() {
        return deviceProtectionStatus;
    }
    public void setDeviceProtectionStatus(String deviceProtectionStatus) {
        this.deviceProtectionStatus = deviceProtectionStatus;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(cellular, connected, currentBuildTarget, defaultBuildTarget, denied, desiredFirmwareVersion,
                development, deviceProtectionStatus, firmwareProductId, firmwareUpdatesEnabled, firmwareUpdatesForced,
                firmwareVersion, functions, groups, iccid, id, imei, lastHandshakeAt, lastHeard, lastIccid,
                lastIpAddress, macWifi, mobileSecret, name, notes, online, owner, pinnedBuildTarget, platformId,
                productId, quarantined, serialNumber, status, systemFirmwareVersion, targetedFirmwareReleaseVersion,
                variables);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceInformation)) {
            return false;
        }
        DeviceInformation other = (DeviceInformation) obj;
        return cellular == other.cellular && connected == other.connected
                && Objects.equals(currentBuildTarget, other.currentBuildTarget)
                && Objects.equals(defaultBuildTarget, other.defaultBuildTarget) && denied == other.denied
                && desiredFirmwareVersion == other.desiredFirmwareVersion && development == other.development
                && Objects.equals(deviceProtectionStatus, other.deviceProtectionStatus)
                && firmwareProductId == other.firmwareProductId
                && firmwareUpdatesEnabled == other.firmwareUpdatesEnabled
                && firmwareUpdatesForced == other.firmwareUpdatesForced && firmwareVersion == other.firmwareVersion
                && Objects.equals(functions, other.functions) && Objects.equals(groups, other.groups)
                && Objects.equals(iccid, other.iccid) && Objects.equals(id, other.id)
                && Objects.equals(imei, other.imei) && Objects.equals(lastHandshakeAt, other.lastHandshakeAt)
                && Objects.equals(lastHeard, other.lastHeard) && Objects.equals(lastIccid, other.lastIccid)
                && Objects.equals(lastIpAddress, other.lastIpAddress) && Objects.equals(macWifi, other.macWifi)
                && Objects.equals(mobileSecret, other.mobileSecret) && Objects.equals(name, other.name)
                && Objects.equals(notes, other.notes) && online == other.online && Objects.equals(owner, other.owner)
                && Objects.equals(pinnedBuildTarget, other.pinnedBuildTarget) && platformId == other.platformId
                && productId == other.productId && quarantined == other.quarantined
                && Objects.equals(serialNumber, other.serialNumber) && Objects.equals(status, other.status)
                && Objects.equals(systemFirmwareVersion, other.systemFirmwareVersion)
                && targetedFirmwareReleaseVersion == other.targetedFirmwareReleaseVersion
                && Objects.equals(variables, other.variables);
    }
    @Override
    public String toString() {
        return "DeviceInformation [id=" + id + ", name=" + name + ", owner=" + owner + ", lastIpAddress="
                + lastIpAddress + ", lastHeard=" + lastHeard + ", lastHandshakeAt=" + lastHandshakeAt + ", productId="
                + productId + ", online=" + online + ", connected=" + connected + ", platformId=" + platformId
                + ", cellular=" + cellular + ", notes=" + notes + ", functions=" + functions + ", variables="
                + variables + ", serialNumber=" + serialNumber + ", status=" + status + ", iccid=" + iccid
                + ", lastIccid=" + lastIccid + ", imei=" + imei + ", macWifi=" + macWifi + ", systemFirmwareVersion="
                + systemFirmwareVersion + ", currentBuildTarget=" + currentBuildTarget + ", pinnedBuildTarget="
                + pinnedBuildTarget + ", defaultBuildTarget=" + defaultBuildTarget + ", firmwareUpdatesEnabled="
                + firmwareUpdatesEnabled + ", firmwareUpdatesForced=" + firmwareUpdatesForced + ", mobileSecret="
                + mobileSecret + ", firmwareProductId=" + firmwareProductId + ", groups=" + groups
                + ", firmwareVersion=" + firmwareVersion + ", desiredFirmwareVersion=" + desiredFirmwareVersion
                + ", targetedFirmwareReleaseVersion=" + targetedFirmwareReleaseVersion + ", development=" + development
                + ", quarantined=" + quarantined + ", denied=" + denied + ", deviceProtectionStatus="
                + deviceProtectionStatus + "]";
    }
    
    
}
