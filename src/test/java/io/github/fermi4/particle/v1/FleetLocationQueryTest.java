package io.github.fermi4.particle.v1;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;

import org.junit.jupiter.api.Test;

public class FleetLocationQueryTest {
    
    @Test
    public void testBuilder() {
        String group = "group1";
        String deviceName = "deviceName";
        String deviceId = "deviceId";
        String bottomLatLng = "bottomLeft";
        String topLatLng = "bottomLeft";
        int page = 0;
        int resultsPerPage = 0;
        Instant startDate = Instant.now();
        Instant endDate = Instant.now();

        FleetLocationQuery query = FleetLocationQuery.builder()
            .withDeviceId(deviceId)
            .withDeviceName(deviceName)
            .withGroup(group)
            .withGeoRectBottomLeftLatLng(bottomLatLng)
            .withGeoRectTopRightLatLng(topLatLng)
            .withPage(page)
            .withResultsPerPage(resultsPerPage)
            .withStartDate(startDate)
            .withEndDate(endDate)
            .build();

        assertTrue(query.deviceId.equals(deviceId));
        assertTrue(query.deviceName.equals(deviceName));
        assertTrue(query.groups.contains(group));
        assertTrue(query.geoRectBottomLeftLatLng.equals(bottomLatLng));
        assertTrue(query.geoRectTopRightLatLng.equals(topLatLng));
        assertTrue(query.page == page);
        assertTrue(query.resultsPerPage == resultsPerPage);
        assertTrue(query.endDate.equals(endDate));
        assertTrue(query.startDate.equals(startDate));
    }
}
