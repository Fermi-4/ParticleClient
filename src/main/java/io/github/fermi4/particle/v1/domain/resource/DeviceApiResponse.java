package io.github.fermi4.particle.v1.domain.resource;

import java.util.ArrayList;
import java.util.List;

import io.github.fermi4.particle.v1.domain.DeviceInformation;

public class DeviceApiResponse {

    int currentPage;
    int totalPages;
    List<DeviceInformation> devices = new ArrayList<>();
    List<Customer> customers = new ArrayList<>();

    public static class Customer {
        private String id;
        private String username;
        public Customer(String id, String username) {
            super();
            this.id = id;
            this.username = username;
        }
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getUsername() {
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }
        @Override
        public String toString() {
            return "Customer [id=" + id + ", username=" + username + "]";
        }
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<DeviceInformation> getDevices() {
        return devices;
    }

    public void setDevices(List<DeviceInformation> devices) {
        this.devices = devices;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + currentPage;
        result = prime * result + totalPages;
        result = prime * result + ((devices == null) ? 0 : devices.hashCode());
        result = prime * result + ((customers == null) ? 0 : customers.hashCode());
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
        DeviceApiResponse other = (DeviceApiResponse) obj;
        if (currentPage != other.currentPage)
            return false;
        if (totalPages != other.totalPages)
            return false;
        if (devices == null) {
            if (other.devices != null)
                return false;
        } else if (!devices.equals(other.devices))
            return false;
        if (customers == null) {
            if (other.customers != null)
                return false;
        } else if (!customers.equals(other.customers))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DeviceApiResponse [currentPage=" + currentPage + ", totalPages=" + totalPages + ", devices=" + devices
                + ", customers=" + customers + "]";
    }
}
