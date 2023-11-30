package com.example.springmysqldemo.repository;

import com.example.springmysqldemo.model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Integer> {
    ExchangeRate findBySourceCurrencyAndTargetCurrency(String sourceCurrency, String targetCurrency);
}
