package com.claro.amx.sp.starterrestservice.service.impl;

import com.claro.amx.sp.starterrestservice.business.ParametersBO;
import com.claro.amx.sp.starterrestservice.model.ccard.Parameters;
import com.claro.amx.sp.starterrestservice.model.request.ParameterRequest;
import com.claro.amx.sp.starterrestservice.service.ParametersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ParametersServiceImpl implements ParametersService {

    private final ParametersBO parametersBO;

    @Override
    public List<Parameters> getParameter(ParameterRequest parameterRequest) {
        final var parameters = parametersBO.getParameters(parameterRequest.getParameterName());
        return List.of(parameters);
    }
}
