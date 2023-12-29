package com.claro.amx.sp.starterrestservice.dao.prod;


import com.claro.amx.sp.starterrestservice.annotations.log.LogDAO;
import com.claro.amx.sp.starterrestservice.config.MyBatisConfig;
import com.claro.amx.sp.starterrestservice.exception.impl.DataBaseException;
import com.claro.amx.sp.starterrestservice.mapper.prod.CellularsPlansMapper;
import com.claro.amx.sp.starterrestservice.model.prod.CellularsPlans;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

import static com.claro.amx.sp.starterrestservice.constants.Errors.ERROR_DATABASE_CELLULARS_PLANS;

@Component
@RequiredArgsConstructor
public class CellularsPlansDAO {

    @Qualifier(MyBatisConfig.PROD_SESSION_FACTORY)
    private final SqlSessionFactoryBean sessionFactoryBean;

    @Value("${cellulars.plans.dao.timeout:0.5}")
    private int timeout;

    @LogDAO
    public List<CellularsPlans> getCellularPlansData(String cellularNumber) {
        try (var sqlSession = Objects.requireNonNull(sessionFactoryBean.getObject()).openSession()) {
            sqlSession.getConfiguration().setDefaultStatementTimeout(timeout);
            return sqlSession.getMapper(CellularsPlansMapper.class).getCellularsPlansData(cellularNumber);
        } catch (Exception e) {
            throw new DataBaseException(ERROR_DATABASE_CELLULARS_PLANS.getCode(), String.format(ERROR_DATABASE_CELLULARS_PLANS.getMessage(), e.getClass().getSimpleName(), e.getCause()));
        }
    }

}