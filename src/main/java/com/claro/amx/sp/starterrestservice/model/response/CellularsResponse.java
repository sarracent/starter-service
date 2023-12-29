package com.claro.amx.sp.starterrestservice.model.response;


import com.claro.amx.sp.starterrestservice.model.prod.CellularsPlans;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Object containing CellularsResponse")
public class CellularsResponse extends ServiceResponse {
    @Schema(description = "Cellulars Plans")
    private CellularsPlans cellularsPlans;

}

