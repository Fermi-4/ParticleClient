package io.github.fermi4.particle.v1;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Credentials;
import okhttp3.HttpUrl;
import okhttp3.HttpUrl.Builder;

public class ParticleApiV1 {
        protected final static String PARTICLE_HOST_URL = "api.particle.io";
        protected final static String PARTICLE_SCHEME = "https";
        protected final static String PARTICLE_ACCESS_TOKEN_KEY = "access_token";
        protected final static String PARTICLE_API_VERSION = "v1";

        protected static HttpUrl getDevicesHttpUrl(String token) {
                Builder builder = new HttpUrl.Builder();

                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("devices")
                                .addQueryParameter(PARTICLE_ACCESS_TOKEN_KEY, token);

                return builder.build();
        }

        protected static HttpUrl getProductInfoHttpUrl(String token, String productIdOrSlug) {
                Builder builder = new HttpUrl.Builder();

                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("products")
                                .addPathSegment(productIdOrSlug)
                                .addQueryParameter(PARTICLE_ACCESS_TOKEN_KEY, token);

                return builder.build();
        }

        protected static HttpUrl getProductTeamHttpUrl(String token, String productIdOrSlug) {
                Builder builder = new HttpUrl.Builder();

                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("products")
                                .addPathSegment(productIdOrSlug)
                                .addPathSegment("team")
                                .addQueryParameter(PARTICLE_ACCESS_TOKEN_KEY, token);

                return builder.build();
        }

        protected static HttpUrl getUpdateProductTeamMemberTokenHttpUrl(String token, String productIdOrSlug,
                        String username) {
                Builder builder = new HttpUrl.Builder();

                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("products")
                                .addPathSegment(productIdOrSlug)
                                .addPathSegment("team")
                                .addPathSegment(username)
                                .addPathSegment("token")
                                .addQueryParameter(PARTICLE_ACCESS_TOKEN_KEY, token);

                return builder.build();
        }

        protected static HttpUrl getUpdateProductTeamMemberHttpUrl(String token, String productIdOrSlug,
                        String username) {
                Builder builder = new HttpUrl.Builder();

                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("products")
                                .addPathSegment(productIdOrSlug)
                                .addPathSegment("team")
                                .addPathSegment(username)
                                .addQueryParameter(PARTICLE_ACCESS_TOKEN_KEY, token);

                return builder.build();
        }

        protected static HttpUrl getDeviceVarHttpUrl(String token, String deviceId, String var) {
                Builder builder = new HttpUrl.Builder();

                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("devices")
                                .addPathSegment(deviceId)
                                .addPathSegment(var)
                                .addQueryParameter(PARTICLE_ACCESS_TOKEN_KEY, token);

                return builder.build();
        }

        protected static HttpUrl getDevicePingHttpUrl(String token, String deviceId) {
                Builder builder = new HttpUrl.Builder();

                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("devices")
                                .addPathSegment(deviceId)
                                .addPathSegment("ping")
                                .addQueryParameter(PARTICLE_ACCESS_TOKEN_KEY, token);

                return builder.build();
        }

        protected static HttpUrl getDeviceFunctionHttpUrl(String token, String deviceId, String function) {
                Builder builder = new HttpUrl.Builder();

                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("devices")
                                .addPathSegment(deviceId)
                                .addPathSegment(function)
                                .addQueryParameter(PARTICLE_ACCESS_TOKEN_KEY, token);

                return builder.build();
        }

        protected static HttpUrl getDevicesInProductHttpUrl(String token, String productIdOrSlug) {
                return getDevicesInProductHttpUrl(token, productIdOrSlug, new HashMap<String, String>());
        }

        protected static HttpUrl getDevicesInProductHttpUrl(String token, String productIdOrSlug,
                        Map<String, String> queryParameters) {
                Builder builder = new HttpUrl.Builder();

                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("products")
                                .addPathSegment(productIdOrSlug)
                                .addPathSegment("devices")
                                .addQueryParameter(PARTICLE_ACCESS_TOKEN_KEY, token);
                queryParameters.entrySet().stream().forEach(e -> builder.addQueryParameter(e.getKey(), e.getValue()));

                return builder.build();
        }

        protected static HttpUrl getDeviceInProductHttpUrl(String token, String productIdOrSlug, String deviceId) {
                Builder builder = new HttpUrl.Builder();

                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("products")
                                .addPathSegment(productIdOrSlug)
                                .addPathSegment("devices")
                                .addPathSegment(deviceId)
                                .addQueryParameter(PARTICLE_ACCESS_TOKEN_KEY, token);

                return builder.build();
        }

        protected static HttpUrl getDeviceHttpUrl(String token, String deviceId) {
                Builder builder = new HttpUrl.Builder();

                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("devices")
                                .addPathSegment(deviceId)
                                .addQueryParameter(PARTICLE_ACCESS_TOKEN_KEY, token);

                return builder.build();
        }

        protected static HttpUrl getDeviceBySerialNumberHttpUrl(String token, String serialNumber) {
                Builder builder = new HttpUrl.Builder();

                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("serial_numbers")
                                .addPathSegment(serialNumber)
                                .addQueryParameter(PARTICLE_ACCESS_TOKEN_KEY, token);

                return builder.build();
        }

        /**
         * 
         * Open a stream of Server Sent Events for all public events and private events
         * for your devices matching the filter.
         * 
         * @apiNote As of April 2018, the event prefix filter is required. It was
         *          optional before.
         *          <br>
         *          <br>
         * 
         * @param accessToken - Particle Cloud API access token
         * @param eventPrefix - Prefix to filter events on (required)
         * 
         * @return {@link HttpUrl}
         * 
         * @see <a href=
         *      "https://docs.particle.io/reference/cloud-apis/api/#get-a-stream-of-events">Particle
         *      Cloud API Docs</a>
         *
         */
        protected static HttpUrl getAllEventsFiltered(String accessToken, String eventPrefix) {
                Builder builder = new HttpUrl.Builder();

                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("events")
                                .addPathSegment(eventPrefix)
                                .addQueryParameter(PARTICLE_ACCESS_TOKEN_KEY, accessToken);

                return builder.build();
        }

        /**
         * 
         * Open a stream of Server Sent Events for all public and private events for
         * your devices. Filters event stream on events matching the event prefix.
         * 
         * @param accessToken - Particle Cloud API access token
         * @param eventPrefix - Prefix to filter events on
         * 
         * @return {@link HttpUrl}
         * 
         * @see <a href=
         *      "https://docs.particle.io/reference/cloud-apis/api/#get-a-stream-of-your-events">Particle
         *      Cloud API Docs</a>
         *
         */
        protected static HttpUrl getAllDeviceEventsFiltered(String accessToken, String eventPrefix) {
                Builder builder = new HttpUrl.Builder();

                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("devices")
                                .addPathSegment("events")
                                .addPathSegment(eventPrefix)
                                .addQueryParameter(PARTICLE_ACCESS_TOKEN_KEY, accessToken);

                return builder.build();
        }

        /**
         * 
         * Open a stream of Server Sent Events for all public and private events for
         * your devices.
         * 
         * @param accessToken - Particle Cloud API access token
         * 
         * @return {@link HttpUrl}
         * 
         * @see <a href=
         *      "https://docs.particle.io/reference/cloud-apis/api/#get-a-stream-of-your-events">Particle
         *      Cloud API Docs</a>
         */
        protected static HttpUrl getAllDeviceEvents(String accessToken) {
                Builder builder = new HttpUrl.Builder();

                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("devices")
                                .addPathSegment("events")
                                .addQueryParameter(PARTICLE_ACCESS_TOKEN_KEY, accessToken);

                return builder.build();
        }

        /**
         * 
         * Open a stream of Server Sent Events for all public and private events for
         * your specific devices.
         * <br>
         * <br>
         * Returns only events matching deviceId.
         * 
         * @param accessToken - Particle Cloud API access token
         * @param deviceId    - Device id to filter events from
         * 
         * @see <a href=
         *      "https://docs.particle.io/reference/cloud-apis/api/#get-a-stream-of-events-for-a-device">Particle
         *      Cloud API Docs</a>
         * 
         * @return {@link HttpUrl}
         */
        protected static HttpUrl getDeviceEvents(String accessToken, String deviceId) {
                Builder builder = new HttpUrl.Builder();

                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("devices")
                                .addPathSegment(deviceId)
                                .addPathSegment("events")
                                .addQueryParameter(PARTICLE_ACCESS_TOKEN_KEY, accessToken);

                return builder.build();
        }

        /**
         * 
         * Open a stream of Server Sent Events for all public and private events for
         * your specific devices.
         * <br>
         * <br>
         * Returns only events matching deviceId and eventPrefix.
         * 
         * @param accessToken - Particle Cloud API access token
         * @param eventPrefix - Prefix to filter events on
         * @param deviceId    - Device id to filter events from
         * 
         * @see <a href=
         *      "https://docs.particle.io/reference/cloud-apis/api/#get-a-stream-of-events-for-a-device">Particle
         *      Cloud API Docs</a>
         * 
         * @return {@link HttpUrl}
         */
        protected static HttpUrl getDeviceEventsFiltered(String accessToken, String deviceId, String eventPrefix) {
                Builder builder = new HttpUrl.Builder();

                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("devices")
                                .addPathSegment(deviceId)
                                .addPathSegment("events")
                                .addPathSegment(eventPrefix)
                                .addQueryParameter(PARTICLE_ACCESS_TOKEN_KEY, accessToken);

                return builder.build();
        }

        /**
         * 
         * Open a stream of Server Sent Events for all public and private events for a
         * product.
         * <br>
         * <br>
         * Returns events for products matching productIdOrSlug and eventPrefix.
         * 
         * @param accessToken     - Particle Cloud API access token
         * @param productIdOrSlug - Product ID or slug
         * @param eventPrefix     - Prefix to filter events on
         * 
         * @see <a href=
         *      "https://docs.particle.io/reference/cloud-apis/api/#product-event-stream">Particle
         *      Cloud API Docs</a>
         * 
         * @return {@link HttpUrl}
         */
        protected static HttpUrl getProductEventsFiltered(String accessToken, String productIdOrSlug,
                        String eventPrefix) {
                Builder builder = new HttpUrl.Builder();

                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("products")
                                .addPathSegment(productIdOrSlug)
                                .addPathSegment("events")
                                .addPathSegment(eventPrefix)
                                .addQueryParameter(PARTICLE_ACCESS_TOKEN_KEY, accessToken);

                return builder.build();
        }

        protected static HttpUrl getProductEvents(String accessToken, String productIdOrSlug) {
                Builder builder = new HttpUrl.Builder();

                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("products")
                                .addPathSegment(productIdOrSlug)
                                .addPathSegment("events")
                                .addQueryParameter(PARTICLE_ACCESS_TOKEN_KEY, accessToken);

                return builder.build();
        }

        protected static HttpUrl getPublishEventHttpUrl(String accessToken) {
                Builder builder = new HttpUrl.Builder();

                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("devices")
                                .addPathSegment("events")
                                .addQueryParameter(PARTICLE_ACCESS_TOKEN_KEY, accessToken);

                return builder.build();
        }

        protected static HttpUrl getUserProductsHttpUrl(String accessToken) {
                Builder builder = new HttpUrl.Builder();

                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("user")
                                .addPathSegment("products")
                                .addQueryParameter(PARTICLE_ACCESS_TOKEN_KEY, accessToken);

                return builder.build();
        }

        protected static HttpUrl getUpdateDeviceVitalsHttpUrl(String accessToken, String deviceId) {
                Builder builder = new HttpUrl.Builder();

                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("diagnostics")
                                .addPathSegment(deviceId)
                                .addPathSegment("update")
                                .addQueryParameter(PARTICLE_ACCESS_TOKEN_KEY, accessToken);

                return builder.build();
        }

        protected static HttpUrl getLastDeviceVitalsHttpUrl(String accessToken, String deviceId) {
                Builder builder = new HttpUrl.Builder();

                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("diagnostics")
                                .addPathSegment(deviceId)
                                .addPathSegment("last")
                                .addQueryParameter(PARTICLE_ACCESS_TOKEN_KEY, accessToken);

                return builder.build();
        }

        protected static HttpUrl getHistoricalDeviceVitalsHttpUrl(String accessToken, String deviceId, Instant start,
                        Instant end) {
                Builder builder = new HttpUrl.Builder();

                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("diagnostics")
                                .addPathSegment(deviceId)
                                .addQueryParameter("start_date", start.toString())
                                .addQueryParameter("end_date", end.toString())
                                .addQueryParameter(PARTICLE_ACCESS_TOKEN_KEY, accessToken);

                return builder.build();
        }

        protected static HttpUrl getCellNetworkStatusHttpUrl(String accessToken, String iccid) {
                Builder builder = new HttpUrl.Builder();

                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("sims")
                                .addPathSegment(iccid)
                                .addPathSegment("status")
                                .addQueryParameter(PARTICLE_ACCESS_TOKEN_KEY, accessToken);

                return builder.build();
        }

        protected static HttpUrl getSIMInformationHttpUrl(String accessToken, String iccid) {
                Builder builder = new HttpUrl.Builder();
                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("sims")
                                .addPathSegment(iccid)
                                .addQueryParameter(PARTICLE_ACCESS_TOKEN_KEY, accessToken);
                return builder.build();
        }

        protected static HttpUrl getSIMDataUsageHttpUrl(String accessToken, String iccid) {
                Builder builder = new HttpUrl.Builder();
                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("sims")
                                .addPathSegment(iccid)
                                .addPathSegment("data_usage")
                                .addQueryParameter(PARTICLE_ACCESS_TOKEN_KEY, accessToken);
                return builder.build();
        }

        protected static HttpUrl getSIMActionHttpUrl(String accessToken, String iccid) {
                Builder builder = new HttpUrl.Builder();
                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("sims")
                                .addPathSegment(iccid)
                                .addQueryParameter(PARTICLE_ACCESS_TOKEN_KEY, accessToken);
                return builder.build();
        }

        protected static HttpUrl getListSIMsHttpUrl(String accessToken, Map<String, String> query) {
                Builder builder = new HttpUrl.Builder();
                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("sims")
                                .addQueryParameter(PARTICLE_ACCESS_TOKEN_KEY, accessToken);
                query.entrySet().stream().forEach(e -> builder.addQueryParameter(e.getKey(), e.getValue()));
                return builder.build();
        }

        protected static HttpUrl getProductSIMDataUsageHttpUrl(String accessToken, String productIdOrSlug) {
                Builder builder = new HttpUrl.Builder();
                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("products")
                                .addPathSegment(productIdOrSlug)
                                .addPathSegment("sims")
                                .addPathSegment("data_usage")
                                .addQueryParameter(PARTICLE_ACCESS_TOKEN_KEY, accessToken);
                return builder.build();
        }

        protected static HttpUrl getAccessTokensHttpUrl(String accessToken) {
                Builder builder = new HttpUrl.Builder();
                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("access_tokens")
                                .addQueryParameter(PARTICLE_ACCESS_TOKEN_KEY, accessToken);
                return builder.build();
        }

        protected static HttpUrl getListAccessTokensHttpUrl() {
                Builder builder = new HttpUrl.Builder();
                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("access_tokens");
                return builder.build();
        }

        protected static HttpUrl getDeleteAccessTokenHttpUrl(String accessToken) {
                Builder builder = new HttpUrl.Builder();
                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("access_tokens")
                                .addPathSegment(accessToken);
                return builder.build();
        }

        protected static HttpUrl getCurrentAccessTokenHttpUrl(String accessToken) {
                Builder builder = new HttpUrl.Builder();
                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("access_tokens")
                                .addPathSegment("current")
                                .addQueryParameter(PARTICLE_ACCESS_TOKEN_KEY, accessToken);
                return builder.build();
        }

        protected static HttpUrl getCreateAccessTokenHttpUrl() {
                Builder builder = new HttpUrl.Builder();
                builder.scheme(PARTICLE_SCHEME)
                                .host(PARTICLE_HOST_URL)
                                .addPathSegment(PARTICLE_API_VERSION)
                                .addPathSegment("oauth")
                                .addPathSegment("token");
                return builder.build();
        }
}
