package io.github.fermi4.particle.v1;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class ParticleClientTest {

    @Test
    public void testInstantiateV1UsingToken() throws IOException {
        String token = "123456789";
        ParticleClient client = ParticleClient.builder()
                                    .withToken(token)
                                    .build();
        
        assertTrue(client.getToken().equals(token));
    }

    @Test
    public void testInstantiateV1UsingUsernamePassword() {
        String password = "123456789";
        String username = "user";
        ParticleClient client = ParticleClient.builder()
                                    .withUsername(username)
                                    .withPassword(password)
                                    .build();
        
        assertTrue(client.getUsername().equals(username));
        assertTrue(client.getPassword().equals(password));
    }

}
