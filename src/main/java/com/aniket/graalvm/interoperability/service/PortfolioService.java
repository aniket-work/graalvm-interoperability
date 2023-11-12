package com.aniket.graalvm.interoperability.service;

import com.aniket.graalvm.interoperability.model.Portfolio;
import com.aniket.graalvm.interoperability.persistence.PortfolioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PortfolioService {
    PortfolioRepository portfolioRepository;

    public PortfolioService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    public Iterable<Portfolio> findAll() {
        return portfolioRepository.findAll();
    }

    public Optional<Portfolio> findById(Long id) {
        return portfolioRepository.findById(id);
    }

    public Portfolio save(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    public void deleteById(Long id) {
        portfolioRepository.deleteById(id);
    }
}
