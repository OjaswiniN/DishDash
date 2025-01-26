package com.dishdash.backend.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Utility class to hold latitude and longitude.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GeoLocation
        implements Serializable
{

    @NotNull private Double latitude;
    @NotNull private Double longitude;

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        if (getLatitude() != null) {
            stringBuilder.append(getLatitude()).append(" ");
        }
        if (getLongitude() != null) {
            stringBuilder.append(getLongitude());
        }
        return stringBuilder.toString();
    }

    public boolean equals(Object obj)
    {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        GeoLocation geoLocationB = (GeoLocation) obj;
        return getLatitude().equals(geoLocationB.getLatitude()) && getLongitude().equals(geoLocationB.getLongitude());
    }

    public int hashCode()
    {
        return super.hashCode();
    }

    @JsonIgnore
    public boolean isValidGeoLocation()
    {
        return getLatitude() != null && getLatitude() >= -90.0D && getLatitude() <= 90.0D && getLongitude() != null && getLongitude() >= -180.0D && getLongitude() <= 180.0D;
    }
}
