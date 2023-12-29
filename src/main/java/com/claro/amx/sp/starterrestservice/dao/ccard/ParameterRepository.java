package com.claro.amx.sp.starterrestservice.dao.ccard;

import com.claro.amx.sp.starterrestservice.model.ccard.Parameters;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository de parameter para redis
 */
@Repository
public interface ParameterRepository extends CrudRepository<Parameters,String> {

    public Optional<Parameters> findById(String name);

    public Optional<List<Parameters>> findList();
}
