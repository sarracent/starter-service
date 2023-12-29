package com.claro.amx.sp.starterrestservice.model.ccard;

import com.claro.amx.sp.starterrestservice.constants.Constants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(hidden = true)
/**
 * Tiempo de vida de  300 segundos
 */
@RedisHash(value= Constants.PREFIJO_CACHE_PARAMETER, timeToLive = 300)
public class Parameters {
    @Id
    private String name;
    private String value;
}
