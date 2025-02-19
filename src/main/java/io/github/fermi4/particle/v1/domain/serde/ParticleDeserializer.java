package io.github.fermi4.particle.v1.domain.serde;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import io.github.fermi4.particle.v1.domain.DeviceInformation;
import io.github.fermi4.particle.v1.domain.ProductInformation;
import io.github.fermi4.particle.v1.domain.resource.DeviceApiResponse;
import io.github.fermi4.particle.v1.domain.resource.ProductApiResponse;

public class ParticleDeserializer {
    public static ObjectMapper getParticleDeserializer() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new SimpleModule()
                .addDeserializer(DeviceInformation.class, new DeviceInformationDeserializer(DeviceInformation.class))
                .addDeserializer(ProductInformation.class, new ProductInformationDeserializer(ProductInformation.class))
                .addDeserializer(ProductApiResponse.class, new ProductApiResponseDeserializer(ProductApiResponse.class))
                .addDeserializer(DeviceApiResponse.class, new DeviceApiResponseDeserializer(DeviceApiResponse.class)));
        return mapper;
    }
}
