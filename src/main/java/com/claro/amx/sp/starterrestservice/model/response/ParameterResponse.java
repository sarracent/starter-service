package com.claro.amx.sp.starterrestservice.model.response;

import com.claro.amx.sp.starterrestservice.model.ccard.Parameters;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Object containing ParameterResponse")
public class ParameterResponse extends ServiceResponse {
    @Schema(description = "List of parameters")
    private List<Parameters> parametersList;

}

