package com.pe.pichincha.demo.application.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.pichincha.demo.domain.dto.CurrencyDTO;
import com.pe.pichincha.demo.domain.service.ICurrencyService;

@RestController
@RequestMapping(path = "api/v1/currency")
public class CurrencyController {

	@Autowired
	private ICurrencyService currencyService;

	@GetMapping("/{id}")
	public ResponseEntity<CurrencyDTO> getMethod(@PathVariable Long id) {
		CurrencyDTO currency = currencyService.getCurrency(id);
		return new ResponseEntity<>(currency, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Object> postMethod(@RequestBody CurrencyDTO currency) {
		currencyService.addCurrency(currency);
		return ResponseEntity.ok("Currency saved successfully");
	}

	@PutMapping
	public ResponseEntity<Object> putMethod(@RequestBody CurrencyDTO currency) {
		currencyService.updateCurrency(currency);
		return ResponseEntity.ok("Currency updated successfully");
	}
}
