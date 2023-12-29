package com.claro.amx.sp.starterrestservice.dao.ccard;

import com.claro.amx.sp.starterrestservice.annotations.log.LogDAO;
import com.claro.amx.sp.starterrestservice.config.MyBatisConfig;
import com.claro.amx.sp.starterrestservice.exception.impl.DataBaseException;
import com.claro.amx.sp.starterrestservice.mapper.ccard.ParametersMapper;
import com.claro.amx.sp.starterrestservice.model.ccard.Parameters;
import lombok.AllArgsConstructor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

import static com.claro.amx.sp.starterrestservice.constants.Errors.ERROR_DATABASE_PARAMETERS;

@Component
@AllArgsConstructor
public class ParametersDAO {

    @Qualifier(MyBatisConfig.CCARD_SESSION_FACTORY)
    private final SqlSessionFactoryBean sessionFactoryBean;

    @LogDAO
    public List<Parameters> getParametersData(String parameterName) {
        try (var sqlSession = Objects.requireNonNull(sessionFactoryBean.getObject()).openSession()) {
            return sqlSession.getMapper(ParametersMapper.class).getParametersData(parameterName);
        } catch (Exception e) {
            throw new DataBaseException(ERROR_DATABASE_PARAMETERS.getCode(), String.format(ERROR_DATABASE_PARAMETERS.getMessage(), e.getClass().getSimpleName(), e.getCause()));
        }
    }
}
