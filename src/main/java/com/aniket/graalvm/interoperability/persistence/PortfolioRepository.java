package com.aniket.graalvm.interoperability.persistence;

import com.aniket.graalvm.interoperability.model.Portfolio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository
        extends CrudRepository<Portfolio, Long> { }
