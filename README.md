<p align="center">
  <a href="https://docs.particle.io/" target="_blank">
    <img src="https://aws-logs-744494115018-us-west-1.s3.us-west-1.amazonaws.com/particle_logo_512x512.png" alt="ParticleKafkaConnectorLogo" width="300" height="300">
  </a>
</p>

# Particle Client

ParticleClient is a java library which provides a client class for interacting with [Particle API](https://www.particle.io/)

See [Maven Central](https://central.sonatype.com/artifact/io.github.fermi-4/particle-client)

# Getting started

Add dependency to maven pom.xml:

~~~xml
<dependency>
    <groupId>io.github.fermi-4</groupId>
    <artifactId>particle-client</artifactId>
    <version>1.0.3</version>
</dependency>
~~~

# Usage

Create instance using:

~~~java
ParticleClient client = ParticleClient.builder()
                            .withToken(token)
                            .build();

// or optionally provide user/pass for 
// endpoints requiring it like the generate token endpoint
ParticleClient client = ParticleClient.builder()
                            .withUsername(username)
                            .withPassword(password)
                            .withToken(token)
                            .build();
~~~

List all device id (parse json using jackson):

~~~java
// jackson mapper
ObjectMapper mapper = new ObjectMapper();

// get the response (see https://docs.particle.io/reference/cloud-apis/api/)
Response response = client.listDevices();

// parse and print out each id
JsonNode rootNode = mapper.readTree(response.body().string());
for (JsonNode deviceNode : rootNode) {
    System.out.println(deviceNode.get("id"));
}
~~~

Open a device event stream:

~~~java
client.openEventStream("temperature", new EventSourceListener() {
            @Override
            public void onEvent(EventSource eventSource, String id, String type, String data) {
                System.out.println("Got temperature event: " + data);
            }
        });
~~~
