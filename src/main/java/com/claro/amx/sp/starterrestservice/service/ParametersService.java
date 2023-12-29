package com.claro.amx.sp.starterrestservice.service;

import com.claro.amx.sp.starterrestservice.model.ccard.Parameters;
import com.claro.amx.sp.starterrestservice.model.request.ParameterRequest;

import java.util.List;

public interface ParametersService {
    List<Parameters> getParameter(ParameterRequest parameterRequest);
}
