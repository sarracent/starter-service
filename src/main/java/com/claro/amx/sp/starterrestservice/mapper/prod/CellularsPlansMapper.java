package com.claro.amx.sp.starterrestservice.mapper.prod;

import com.claro.amx.sp.starterrestservice.model.prod.CellularsPlans;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CellularsPlansMapper {
    List<CellularsPlans> getCellularsPlansData(String cellularNumber);
}
