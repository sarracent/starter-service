package com.claro.amx.sp.starterrestservice.business.impl;

import com.claro.amx.sp.starterrestservice.annotations.log.LogBO;
import com.claro.amx.sp.starterrestservice.business.ParametersBO;
import com.claro.amx.sp.starterrestservice.dao.ccard.ParameterRepository;
import com.claro.amx.sp.starterrestservice.dao.ccard.ParametersDAO;
import com.claro.amx.sp.starterrestservice.exception.impl.TechnicalException;
import com.claro.amx.sp.starterrestservice.model.ccard.Parameters;
import com.claro.amx.sp.starterrestservice.utility.Util;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.claro.amx.sp.starterrestservice.constants.Errors.*;


@Component
@AllArgsConstructor
public class ParametersBOImpl implements ParametersBO {

    private final ParametersDAO parametersDAO;
    @Autowired
    private ParameterRepository parameterRepository;

    @Override
    @LogBO
    public Parameters getParameters(String parameter) {
        //busco en la cache
        var param =parameterRepository.findById(parameter);
        //si existe devuelvo el obj
        if(param.isPresent()) {
            return param.get();
        }
            final var parametersList = parametersDAO.getParametersData(parameter);


        if (parametersList == null || parametersList.isEmpty())
            throw new TechnicalException(ERROR_DATABASE_PARAMETERS_NOT_FOUND.getCode(), String.format(ERROR_DATABASE_PARAMETERS_NOT_FOUND.getMessage(), parameter));
        if (parametersList.size() > 1)
            throw new TechnicalException(ERROR_DATABASE_PARAMETERS_DUPLICATE.getCode(), String.format(ERROR_DATABASE_PARAMETERS_DUPLICATE.getMessage(), parameter));
        if (Util.isNullOrEmpty(parametersList.get(0).getValue()))
            throw new TechnicalException(ERROR_DATABASE_PARAMETERS_NOT_VALUE.getCode(), String.format(ERROR_DATABASE_PARAMETERS_NOT_VALUE.getMessage(), parameter));
       //guardo en la cache el resultado traido de la bd.
        parameterRepository.save(parametersList.get(0));
        return parametersList.get(0);

}
}
