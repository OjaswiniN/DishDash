package com.dishdash.backend.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
@NoArgsConstructor
public class GetRestaurantsRequest
{

    @Min(value = -90) @Max(value = 90) private Double latitude;

    @Min(value = -180) @Max(value = 180) private Double longitude;
}

