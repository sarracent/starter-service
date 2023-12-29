package com.claro.amx.sp.starterrestservice.model.prod;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(hidden = true)
public class CellularsPlans {
    private String cellularNumber;
    private String billNumber;
    private String businessType;
    private String planId;
    private String cluType;
}
