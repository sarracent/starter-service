package com.claro.amx.sp.starterrestservice.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Object containing ParameterRequest")
public class ParameterRequest {
    private String parameterName;
}
