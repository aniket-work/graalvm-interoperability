package com.aniket.graalvm.interoperability.controller;

import com.aniket.graalvm.interoperability.model.Portfolio;
import com.aniket.graalvm.interoperability.model.AskAdvice;
import com.aniket.graalvm.interoperability.service.PortfolioService;
import com.aniket.graalvm.interoperability.service.LanguageBridgeAdviceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PortfolioController {

    @GetMapping("/portfolios")
    Iterable<Portfolio> findAll() {
        return portfolioService.findAll();
    }

    @PostMapping("/pushPortfolio")
    Portfolio save(@RequestBody Portfolio portfolio) {
        return portfolioService.save(portfolio);
    }

    @PostMapping("/portfolio/advice")
    List<Portfolio> getRecommendation(@RequestBody AskAdvice askAdvice) {
        return recommendationService.advise(
                askAdvice,
                portfolioService.findAll()
        );
    }

    public PortfolioController(PortfolioService portfolioService, LanguageBridgeAdviceService recommendationService) {
        this.portfolioService = portfolioService; this.recommendationService = recommendationService;
    }

    PortfolioService portfolioService;
    LanguageBridgeAdviceService recommendationService;
}
