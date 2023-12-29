package com.claro.amx.sp.starterrestservice.model.response;

import com.claro.amx.sp.tecnoosrestclient.models.CustomerDetails;
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
public class CellularTN3Response extends ServiceResponse {
    @Schema(description = "Cellulars Data TN3")
    private CustomerDetails customerDetails;
}
