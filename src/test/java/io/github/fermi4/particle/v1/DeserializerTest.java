package io.github.fermi4.particle.v1;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import io.github.fermi4.particle.v1.domain.DeviceInformation;
import io.github.fermi4.particle.v1.domain.serde.ParticleDeserializer;

public class DeserializerTest {
    
    @Test
    public void testDeserializeDeviceInfo() throws JsonMappingException, JsonProcessingException {
        String test = "{\n" + //
                        "  \"id\": \"0123456789abcdef01234567\",\n" + //
                        "  \"name\": \"gongbot\",\n" + //
                        "  \"owner\": \"someone@particle.io\",\n" + //
                        "  \"last_ip_address\": \"176.83.211.237\",\n" + //
                        "  \"last_heard\": \"2015-07-17T22:28:40.907Z\",\n" + //
                        "  \"last_handshake_at\": \"2015-07-15T20:08:00.456Z\",\n" + //
                        "  \"product_id\": 13,\n" + //
                        "  \"online\": true,\n" + //
                        "  \"platform_id\": 13,\n" + //
                        "  \"cellular\": true,\n" + //
                        "  \"notes\": null,\n" + //
                        "  \"functions\": [\n" + //
                        "    \"gong\",\n" + //
                        "    \"goto\"\n" + //
                        "  ],\n" + //
                        "  \"variables\": {\n" + //
                        "    \"Gongs\": \"int32\"\n" + //
                        "  },\n" + //
                        "  \"status\": \"normal\",\n" + //
                        "  \"serial_number\": \"AAAAAA111111111\",\n" + //
                        "  \"iccid\": \"89314404000111111111\",\n" + //
                        "  \"imei\": \"357520000000000\",\n" + //
                        "  \"mac_wifi\": \"00:00:00:AA:BB:00\",\n" + //
                        "  \"mobile_secret\": \"NVYM5RK6AHCBELA\",\n" + //
                        "  \"system_firmware_version\": \"1.5.0\",\n" + //
                        "  \"firmware_updates_enabled\": true,\n" + //
                        "  \"firmware_updates_forced\": false,\n" + //
                        "  \"device_protection\": {\n" + //
                        "      \"status\": \"disabled\"\n" + //
                        "  }\n" + //
                        "}";
        assertDoesNotThrow(() -> ParticleDeserializer.getParticleDeserializer().readValue(test, DeviceInformation.class));
    }
}
