package com.claro.amx.sp.starterrestservice.mapper.ccard;

import com.claro.amx.sp.starterrestservice.model.ccard.Parameters;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ParametersMapper {
    List<Parameters> getParametersData(String parameterName);
}