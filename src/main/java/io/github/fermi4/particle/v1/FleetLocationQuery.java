package io.github.fermi4.particle.v1;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class FleetLocationQuery {
    Instant startDate;              // Start and end date in ISO8601 format, separated by comma, to query. Omitting date_range will return last known location.
    Instant endDate;                // Start and end date in ISO8601 format, separated by comma, to query. Omitting date_range will return last known location.
    String geoRectBottomLeftLatLng; // Bottom left of the rectangular bounding box to query. Latitude and longitude separated by comma.
    String geoRectTopRightLatLng;   // Top right of the rectangular bounding box to query. Latitude and longitude separated by comma.
    String deviceId;                // Device ID prefix to include in the query
    String deviceName;              // Device name prefix to include in the query
    List<String> groups;            // Array of group names to include in the query
    int page;                       // Page of results to display. Defaults to 1
    int resultsPerPage;             // Number of results per page. Defaults to 20. Maximum of 100

    public FleetLocationQuery(Instant startDate, Instant endDate, String geoRectBottomLeftLatLng,
            String geoRectTopRightLatLng, String deviceId, String deviceName, List<String> groups, int page,
            int resultsPerPage) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.geoRectBottomLeftLatLng = geoRectBottomLeftLatLng;
        this.geoRectTopRightLatLng = geoRectTopRightLatLng;
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.groups = groups;
        this.page = page;
        this.resultsPerPage = resultsPerPage;
    }
    
    public static FleetLocationQueryBuilder builder() {
        return new FleetLocationQueryBuilder();
    }
    
    static class FleetLocationQueryBuilder {
        private Instant startDate;
        private Instant endDate;
        private String geoRectBottomLeftLatLng;
        private String geoRectTopRightLatLng;
        private String deviceId;   
        private String deviceName;
        private List<String> groups;
        private int page;
        private int resultsPerPage;
        
        public FleetLocationQueryBuilder() {
            this.groups = new ArrayList<>();
        }

        public FleetLocationQueryBuilder withStartDate(Instant startDate) {
            this.startDate = startDate;
            return this;
        }
        
        public FleetLocationQueryBuilder withEndDate(Instant endDate) {
            this.endDate = endDate;
            return this;
        }
        
        public FleetLocationQueryBuilder withGroup(String group) {
            this.groups.add(group);
            return this;
        }
        
        public FleetLocationQueryBuilder withPage(int page) {
            this.page = page;
            return this;
        }
        
        public FleetLocationQueryBuilder withResultsPerPage(int resultsPerPage) {
            this.resultsPerPage = resultsPerPage;
            return this;
        }
        
        public FleetLocationQueryBuilder withGeoRectBottomLeftLatLng(String geoRectBottomLeftLatLng) {
            this.geoRectBottomLeftLatLng = geoRectBottomLeftLatLng;
            return this;
        }
        
        public FleetLocationQueryBuilder withGeoRectTopRightLatLng(String geoRectTopRightLatLng) {
            this.geoRectTopRightLatLng = geoRectTopRightLatLng;
            return this;
        }
        
        public FleetLocationQueryBuilder withDeviceName(String deviceName) {
            this.deviceName = deviceName;
            return this;
        }
        
        public FleetLocationQueryBuilder withDeviceId(String deviceId) {
            this.deviceId = deviceId;
            return this;
        }
        
        public FleetLocationQuery build() {
            return new FleetLocationQuery(
                    this.startDate,
                    this.endDate,
                    this.geoRectBottomLeftLatLng,
                    this.geoRectTopRightLatLng,
                    this.deviceId,
                    this.deviceName,
                    this.groups,
                    this.page,
                    this.resultsPerPage
            );
        }
        
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
        result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
        result = prime * result + ((geoRectBottomLeftLatLng == null) ? 0 : geoRectBottomLeftLatLng.hashCode());
        result = prime * result + ((geoRectTopRightLatLng == null) ? 0 : geoRectTopRightLatLng.hashCode());
        result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
        result = prime * result + ((deviceName == null) ? 0 : deviceName.hashCode());
        result = prime * result + ((groups == null) ? 0 : groups.hashCode());
        result = prime * result + page;
        result = prime * result + resultsPerPage;
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
        FleetLocationQuery other = (FleetLocationQuery) obj;
        if (startDate == null) {
            if (other.startDate != null)
                return false;
        } else if (!startDate.equals(other.startDate))
            return false;
        if (endDate == null) {
            if (other.endDate != null)
                return false;
        } else if (!endDate.equals(other.endDate))
            return false;
        if (geoRectBottomLeftLatLng == null) {
            if (other.geoRectBottomLeftLatLng != null)
                return false;
        } else if (!geoRectBottomLeftLatLng.equals(other.geoRectBottomLeftLatLng))
            return false;
        if (geoRectTopRightLatLng == null) {
            if (other.geoRectTopRightLatLng != null)
                return false;
        } else if (!geoRectTopRightLatLng.equals(other.geoRectTopRightLatLng))
            return false;
        if (deviceId == null) {
            if (other.deviceId != null)
                return false;
        } else if (!deviceId.equals(other.deviceId))
            return false;
        if (deviceName == null) {
            if (other.deviceName != null)
                return false;
        } else if (!deviceName.equals(other.deviceName))
            return false;
        if (groups == null) {
            if (other.groups != null)
                return false;
        } else if (!groups.equals(other.groups))
            return false;
        if (page != other.page)
            return false;
        if (resultsPerPage != other.resultsPerPage)
            return false;
        return true;
    }
    public Instant getStartDate() {
        return startDate;
    }
    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }
    public Instant getEndDate() {
        return endDate;
    }
    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }
    public String getGeoRectBottomLeftLatLng() {
        return geoRectBottomLeftLatLng;
    }
    public void setGeoRectBottomLeftLatLng(String geoRectBottomLeftLatLng) {
        this.geoRectBottomLeftLatLng = geoRectBottomLeftLatLng;
    }
    public String getGeoRectTopRightLatLng() {
        return geoRectTopRightLatLng;
    }
    public void setGeoRectTopRightLatLng(String geoRectTopRightLatLng) {
        this.geoRectTopRightLatLng = geoRectTopRightLatLng;
    }
    public String getDeviceId() {
        return deviceId;
    }
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    public String getDeviceName() {
        return deviceName;
    }
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
    public List<String> getGroups() {
        return groups;
    }
    public void setGroups(List<String> groups) {
        this.groups = groups;
    }
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getResultsPerPage() {
        return resultsPerPage;
    }
    public void setResultsPerPage(int resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }

    
}
