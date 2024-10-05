package io.github.fermi4.particle.v1.domain.resource;

import java.util.ArrayList;
import java.util.List;

import io.github.fermi4.particle.v1.domain.ProductInformation;

public class ProductApiResponse {
    List<ProductInformation> products = new ArrayList<>();

    public List<ProductInformation> getProducts() {
        return products;
    }

    public void setProducts(List<ProductInformation> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ProductApiResponse [products=" + products + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((products == null) ? 0 : products.hashCode());
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
        ProductApiResponse other = (ProductApiResponse) obj;
        if (products == null) {
            if (other.products != null)
                return false;
        } else if (!products.equals(other.products))
            return false;
        return true;
    }
    
    

}
