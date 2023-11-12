package com.aniket.graalvm.interoperability.service;

import com.aniket.graalvm.interoperability.model.AskAdvice;
import com.aniket.graalvm.interoperability.model.Portfolio;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LanguageBridgeAdviceService {
    List<Portfolio> advise(
            AskAdvice askAdvice,
            Iterable<Portfolio> portfolios
    );

    void pythonConstructor();
}
