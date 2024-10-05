package io.github.fermi4.particle.v1;

import java.io.IOException;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import io.github.fermi4.particle.v1.domain.DeviceInformation;
import io.github.fermi4.particle.v1.domain.ProductInformation;
import io.github.fermi4.particle.v1.domain.resource.DeviceApiResponse;
import io.github.fermi4.particle.v1.domain.resource.ProductApiResponse;
import io.github.fermi4.particle.v1.domain.serde.DeviceApiResponseDeserializer;
import io.github.fermi4.particle.v1.domain.serde.DeviceInformationDeserializer;
import io.github.fermi4.particle.v1.domain.serde.ProductApiResponseDeserializer;
import io.github.fermi4.particle.v1.domain.serde.ProductInformationDeserializer;
import okhttp3.Credentials;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;
import okhttp3.sse.EventSources;

public class ParticleClient {
    
    private final ObjectMapper mapper;
    private OkHttpClient client;
    private String token;
    private String username;
    private String password;

    private ParticleClient(ParticleClientV1Builder builder) {
        this.mapper = builder.mapper;
        this.client = builder.client;
        this.token  = builder.token;
        this.username = builder.username;
        this.password = builder.password;
    }

    public static class ParticleClientV1Builder {
        private ObjectMapper mapper;
        private OkHttpClient client;
        private String token;
        private String username;
        private String password;
        private ParticleClientV1Builder() {
            this.client = getClient();
            this.mapper = getMapper();
            this.token = null;
            this.username = null;
            this.password = null;
        }

        public ParticleClientV1Builder withMapper(ObjectMapper mapper) {
            this.mapper = mapper;
            return this;
        }

        public ParticleClientV1Builder withClient(OkHttpClient client) {
            this.client = client;
            return this;
        }

        public ParticleClientV1Builder withToken(String token) {
            this.token = token;
            return this;
        }

        public ParticleClientV1Builder withPassword(String password) {
            this.password = password;
            return this;
        }
        
        public ParticleClientV1Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public ParticleClient build() {
            return new ParticleClient(this);
        }
    }
    public static ParticleClientV1Builder builder() {
        return new ParticleClientV1Builder();
    }

    private static OkHttpClient getClient() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.readTimeout(30000, TimeUnit.MILLISECONDS);
        httpClientBuilder.connectTimeout(30000, TimeUnit.MILLISECONDS);
        return httpClientBuilder.build();
    }
    
    private static ObjectMapper getMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new SimpleModule()
                .addDeserializer(DeviceInformation.class, new DeviceInformationDeserializer(DeviceInformation.class))
                .addDeserializer(ProductInformation.class, new ProductInformationDeserializer(ProductInformation.class))
                .addDeserializer(ProductApiResponse.class, new ProductApiResponseDeserializer(ProductApiResponse.class))
                .addDeserializer(DeviceApiResponse.class, new DeviceApiResponseDeserializer(DeviceApiResponse.class)));
        return mapper;
    }

    private Response get(HttpUrl url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        return client.newCall(request).execute();
    }
    
    private Response get(Request request) throws IOException {
        return client.newCall(request).execute();
    }
    
    private Response post(HttpUrl url, Map<?, ?> payloadData) throws IOException  {
        String jsonPayload = mapper.writeValueAsString(payloadData);
        return post(url, jsonPayload);
    }
    
    private Response post(Request request) throws IOException {
        return client.newCall(request).execute();
    }

    private Response post(HttpUrl url, String payload) throws IOException {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(payload, mediaType);
        Request request = new Request.Builder().post(body).url(url).build();
        return client.newCall(request).execute();
    }
    
    private Response post(HttpUrl url, RequestBody body) throws IOException {
        Request request = new Request.Builder()
                .post(body)
                .url(url)
                .build();
        return client.newCall(request).execute();
    }

    private Response post(HttpUrl url) throws IOException {
        RequestBody body = RequestBody.create(new byte[0]);
        Request request = new Request.Builder().post(body).url(url).build();
        return client.newCall(request).execute();
    }
    
    private Response put(HttpUrl url) throws IOException {
        RequestBody body = RequestBody.create(new byte[0]);
        Request request = new Request.Builder().put(body).url(url).build();
        return client.newCall(request).execute();
    }
    
    private Response put(HttpUrl url, Map<?, ?> payloadData) throws IOException {
        String jsonPayload = mapper.writeValueAsString(payloadData);
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(jsonPayload, mediaType);
        Request request = new Request.Builder().put(body).url(url).build();
        return client.newCall(request).execute();
    }
    
    private Response put(Request request) throws IOException {
        return client.newCall(request).execute();
    }
    
    private Response delete(HttpUrl url) throws IOException {
        Request request = new Request.Builder().delete().url(url).build();
        return client.newCall(request).execute();
    }

    private Request getSseRequest(HttpUrl url) {
        return new Request.Builder()
                .addHeader("Content-Type", "text/event-stream")
                .addHeader("Connection", "keep-alive")
                .addHeader("Cache-Control", "no-cache")
                .url(url)
                .build();
    }
    
    private EventSource createEventSource(Request request, EventSourceListener listener) {
        return EventSources.createFactory(client).newEventSource(request, listener);
    }


    public Response createToken(CreateTokenRequest requestParameters) throws IOException {
        RequestBody formBody = new FormBody.Builder()
            .add("grant_type", requestParameters.getGrantType())
            .add("username", requestParameters.getUsername())
            .add("password", requestParameters.getPassword())
            .add("client_id", requestParameters.getClientdId())
            .add("client_secret", requestParameters.getClientSecret())
            .add("expires_in", requestParameters.getExpiresIn())
            .add("expires_at", requestParameters.getExpiresAt())
            .build();

        Request request = new Request.Builder()
            .url(ParticleApiV1.getCreateAccessTokenHttpUrl())
            .header("Authorization", Credentials.basic("particle", "particle"))
            .post(formBody)
            .build();

        return client.newCall(request).execute();
    }

    public Response deleteAllActiveTokens() throws IOException {
        return delete(ParticleApiV1.getAccessTokensHttpUrl(token));
    }

    public Response deleteCurrentToken() throws IOException {
        return delete(ParticleApiV1.getCurrentAccessTokenHttpUrl(token));
    }

    public Response deleteToken(String accessToken) throws IOException {
        return delete(ParticleApiV1.getDeleteAccessTokenHttpUrl(accessToken));
    }

    public Response getCurrentTokenInfo() throws IOException {
        return get(ParticleApiV1.getCurrentAccessTokenHttpUrl(token));
    }

    public Response listTokens() throws IOException {
        String auth = Credentials.basic(username, password);
        Request request = new Request.Builder()
                .header("Authorization", auth)
                .url(ParticleApiV1.getListAccessTokensHttpUrl())
                .build();
        return get(request);
    }

    public Response listDevices() throws IOException {
        return get(ParticleApiV1.getDevicesHttpUrl(token));
    }

    public Response getDeviceInformation(String deviceId) throws IOException {
        return get(ParticleApiV1.getDeviceHttpUrl(token, deviceId));
    }
    
    public Response addDeviceNotes(String deviceId, String notes) throws IOException {
        RequestBody formBody = new FormBody.Builder().add("notes", notes).build();
        Request request = new Request.Builder()
                .put(formBody)
                .url(ParticleApiV1.getDeviceHttpUrl(token, deviceId))
                .build();
        return put(request);
    }

    public Response getDeviceBySerialNumber(String serialNumber) throws IOException {
        return get(ParticleApiV1.getDeviceBySerialNumberHttpUrl(token, serialNumber));
    }

    public Response renameDevice(String deviceId, String name) throws IOException {
        Map<String, String> payloadData = new HashMap<>();
        payloadData.put("name", name);
        return put(ParticleApiV1.getDeviceHttpUrl(token, deviceId), payloadData);
    }

    public Response unclaimDevice(String deviceId) throws IOException {
        return delete(ParticleApiV1.getDeviceHttpUrl(token, deviceId));
    }

    public Response forceEnableOTAUpdates(String deviceId, boolean forceUpdates) throws IOException {
        Map<String, Boolean> payloadData = new HashMap<>();
        payloadData.put("firmware_updates_forced", forceUpdates);
        return put(ParticleApiV1.getDeviceHttpUrl(token, deviceId), payloadData);
    }

    public Response removeDeviceFromProduct(String deviceId, String productIdOrSlug) throws IOException {
        return delete(ParticleApiV1.getDeviceInProductHttpUrl(token, productIdOrSlug, deviceId));
    }

    public Response listDevicesInProduct(String productIdOrSlug) throws IOException {
        return get(ParticleApiV1.getDevicesInProductHttpUrl(token, productIdOrSlug));
    }

    public Response getProductDeviceInformation(String productIdOrSlug, String deviceId) throws IOException {
        return get(ParticleApiV1.getDeviceInProductHttpUrl(token, productIdOrSlug, deviceId));
    }

    public Response getDeviceVariable(String deviceId, String variable) throws IOException {
        return get(ParticleApiV1.getDeviceVarHttpUrl(token, deviceId, variable));
    }

    public Response callFunction(String deviceId, String function, String arg, String format) throws IOException {
        Map<String, String> payloadData = new HashMap<>();
        payloadData.put("arg", arg);
        payloadData.put("format", format);
        return post(ParticleApiV1.getDeviceFunctionHttpUrl(token, deviceId, function), payloadData);
    }

    public Response signal(String deviceId, boolean signal) throws IOException {
        Map<String, Integer> payloadData = new HashMap<>();
        payloadData.put("signal", signal ? 1 : 0);
        return put(ParticleApiV1.getDeviceHttpUrl(token, deviceId), payloadData);
    }

    public Response ping(String deviceId) throws IOException {
        return put(ParticleApiV1.getDevicePingHttpUrl(token, deviceId));
    }

    public Response getLastVitals(String deviceId) throws IOException {
        return get(ParticleApiV1.getLastDeviceVitalsHttpUrl(token, deviceId));
    }

    public Response refreshVitals(String deviceId) throws IOException {
        return post(ParticleApiV1.getUpdateDeviceVitalsHttpUrl(token, deviceId));
    }

    public Response getHistoricalVitals(String deviceId, Instant startDate, Instant endDate) throws IOException {
        return get(ParticleApiV1.getHistoricalDeviceVitalsHttpUrl(token, deviceId, startDate, endDate));
    }

    public Response getCellNetworkStatus(String iccid) throws IOException {
        return get(ParticleApiV1.getCellNetworkStatusHttpUrl(iccid, iccid));
    }

    public Response listSIMCards(Map<String, String> query) throws IOException {
        return get(ParticleApiV1.getListSIMsHttpUrl(token, query));
    }

    public Response getSIMInformation(String iccid) throws IOException {
        return get(ParticleApiV1.getSIMInformationHttpUrl(token, iccid));
    }

    public Response getSIMDataUsage(String iccid) throws IOException {
        return get(ParticleApiV1.getSIMDataUsageHttpUrl(token, iccid));
    }

    public Response activate(String iccid) throws IOException {
        Map<String, Object> payloadData = new HashMap<>();
        payloadData.put("action", "activate");
        return post(ParticleApiV1.getSIMActionHttpUrl(token, iccid), payloadData);
    }

    public Response deactivate(String iccid) throws IOException {
        Map<String, Object> payloadData = new HashMap<>();
        payloadData.put("action", "deactivate");
        return post(ParticleApiV1.getSIMActionHttpUrl(token, iccid), payloadData);
    }

    public Response reactivate(String iccid) throws IOException {
        Map<String, Object> payloadData = new HashMap<>();
        payloadData.put("action", "reactivate");
        return post(ParticleApiV1.getSIMActionHttpUrl(token, iccid), payloadData);
    }

    public Response release(String iccid) throws IOException {
        return delete(ParticleApiV1.getSIMActionHttpUrl(token, iccid));
    }

    public Response getSIMDataUsageForProductFleet(String productOrSlugId) throws IOException {
        return get(ParticleApiV1.getProductSIMDataUsageHttpUrl(token, productOrSlugId));
    }

    public Response importAndActivateProductSIM(String productOrSlugId, List<String> sims) throws IOException {
        Map<String, Object> payloadData = new HashMap<>();
        payloadData.put("sims", sims);
        return post(ParticleApiV1.getProductTeamHttpUrl(token, productOrSlugId), payloadData);
    }
    
    public EventSource openEventStream(String eventPrefix, EventSourceListener listener) {
        Request request = getSseRequest(ParticleApiV1.getAllEventsFiltered(token, eventPrefix));
        return createEventSource(request, listener);
    }
    
    public EventSource openAllDeviceEventStream(EventSourceListener listener) {
        Request request = getSseRequest(ParticleApiV1.getAllDeviceEvents(token));
        return createEventSource(request, listener);
    }
    
    public EventSource openAllDeviceEventStream(String eventPrefix, EventSourceListener listener) {
        Request request = getSseRequest(ParticleApiV1.getAllDeviceEventsFiltered(token, eventPrefix));
        return createEventSource(request, listener);
    }
    
    public EventSource openDeviceEventStream(String deviceId, EventSourceListener listener) {
        Request request = getSseRequest(ParticleApiV1.getDeviceEvents(token, deviceId));
        return createEventSource(request, listener);
    }
    
    public EventSource openDeviceEventStream(String deviceId, String eventPrefix, EventSourceListener listener) {
        Request request = getSseRequest(ParticleApiV1.getDeviceEventsFiltered(token, deviceId, eventPrefix));
        return createEventSource(request, listener);
    }
    
    public EventSource openProductEventStream(String productIdOrSlug, EventSourceListener listener) {
        Request request = getSseRequest(ParticleApiV1.getProductEvents(token, productIdOrSlug));
        return createEventSource(request, listener);
    }
    
    public EventSource openProductEventStream(String productIdOrSlug, String eventPrefix, EventSourceListener listener) {
        Request request = getSseRequest(ParticleApiV1.getProductEventsFiltered(token, productIdOrSlug, eventPrefix));
        return createEventSource(request, listener);
    }

    public Response publishEvent(Event event) throws IOException {
        RequestBody body = new FormBody.Builder()
                .add("name", event.getName())
                .add("data", event.getData())
                .add("ttl", String.valueOf(event.getTtl()))
                .build();
        return post(ParticleApiV1.getPublishEventHttpUrl(token), body);
    }

    public Response publishProductEvent(String productIdOrSlug, Event event) throws IOException {
        return post(ParticleApiV1.getProductEvents(token, productIdOrSlug), mapper.writeValueAsString(event));
    }

    public Response listProducts() throws IOException {
        return get(ParticleApiV1.getUserProductsHttpUrl(token));
    }

    public Response getProduct(String productIdOrSlug) throws IOException {
        return get(ParticleApiV1.getProductInfoHttpUrl(token, productIdOrSlug));
    }

    public Response getProductTeamMembers(String productIdOrSlug) throws IOException {
        return get(ParticleApiV1.getProductTeamHttpUrl(token, productIdOrSlug));
    }

    public Response inviteTeamMemberToProduct(String productIdOrSlug, String username, String role) throws IOException {
        Map<String, String> payloadData = new HashMap<>();
        payloadData.put("username", username);
        payloadData.put("role", role);
        return post(ParticleApiV1.getProductTeamHttpUrl(token, productIdOrSlug), payloadData);
    }

    public Response createProductUser(String productIdOrSlug, String name, List<String> scopes) throws IOException {
        Map<String, Object> payloadData = new HashMap<>();
        payloadData.put("friendly_name", name);
        payloadData.put("scopes", scopes);
        return post(ParticleApiV1.getProductTeamHttpUrl(token, productIdOrSlug), payloadData);
    }

    public Response updateProductUser(String productIdOrSlug, String username, Map<?, ?> payload) throws IOException {
        return post(ParticleApiV1.getUpdateProductTeamMemberHttpUrl(token, productIdOrSlug, username), payload);
    }

    public Response regenerateUserToken(String productIdOrSlug, String username) throws IOException {
        return put(ParticleApiV1.getUpdateProductTeamMemberTokenHttpUrl(token, productIdOrSlug, username));
    }

    public Response removeProductUser(String productIdOrSlug, String username) throws IOException {
        return delete(ParticleApiV1.getUpdateProductTeamMemberHttpUrl(token, productIdOrSlug, username));
    }
    
    public String getToken() {
        return token;
    }
    
    public void setToken(String token) {
        this.token = token;
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

    public void setClient(OkHttpClient client) {
        this.client = client;
    }
}
