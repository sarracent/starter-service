package com.claro.amx.sp.starterrestservice.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum BusinessType {
    CO("CO", "REGULAR/PA"),
    PP("PP", "PREPAGO2"),
    CR("CR", "COMBINADO/REGULAR"),
    CP("CP", "COMBINADO/PREPAGO"),
    LD("LD", "LARGA DISTANCIA"),
    LP("LP", "L. DIST. PREPAGO"),
    LF("LF", "LINEA FICTICIA LD"),
    PU("PU", "L DIST. PUBLICO"),
    PU1("PU1", "L DIST. PUBLICO"),
    PRA("PRA", "PRA"),
    DTH("DTH", "TELEVISION SATELITAL"),
    IF("IF", "INTERNET FIJA"),
    TF("TF", "TELEFONIA FIJA"),
    IPTV("IPTV", "TELEVISION POR IP");

    private static final Map<String, BusinessType> INSTANCES;

    static {
        Map<String, BusinessType> tmp = new HashMap<>();
        for (BusinessType businessType : values()) {
            tmp.put(businessType.id, businessType);
        }
        INSTANCES = Collections.unmodifiableMap(tmp);
    }

    private final String id;
    private final String description;

    public static BusinessType searchBusinessType(String id) {
        return INSTANCES.get(id);
    }
}
