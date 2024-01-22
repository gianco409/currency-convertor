package com.pe.pichincha.demo.infrastructure.repository.sql;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pe.pichincha.demo.infrastructure.repository.entity.Currency;

public interface SpringDataCurrencyRepository extends JpaRepository<Currency, Long> {
	Optional<Currency> findBySymbolAndBase(String symbol, String base);

}
