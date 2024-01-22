package com.pe.pichincha.demo.application.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.pichincha.demo.application.request.ConvertorRequest;
import com.pe.pichincha.demo.application.response.ConvertorResponse;
import com.pe.pichincha.demo.domain.dto.OperationDTO;
import com.pe.pichincha.demo.domain.service.ICurrencyConverterService;
import com.pe.pichincha.demo.domain.service.IOperationService;
import com.pe.pichincha.demo.infrastructure.security.util.JwtUtil;

@RestController
@RequestMapping(path = "api/v1/converter")
public class ConverterController {
	@Autowired
	private ICurrencyConverterService currencyConverterService;

	@Autowired
	private IOperationService operationService;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping()
	public ResponseEntity<ConvertorResponse> convert(@RequestHeader(name = "Authorization") String token,
			@RequestBody ConvertorRequest convertorRequest) {
		Double currencyExchange = currencyConverterService.convert(convertorRequest);
		registerOperation(jwtUtil.getUsernameFromToken(token.substring(7)), convertorRequest, currencyExchange);
		return new ResponseEntity<>(new ConvertorResponse(currencyExchange), HttpStatus.OK);
	}

	void registerOperation(String username, ConvertorRequest request, Double exchange) {
		OperationDTO operation = new OperationDTO();
		operation.setUsername(username);
		operation.setSymbolFrom(request.getSymbolFrom());
		operation.setSymbolTo(request.getSymbolTo());
		operation.setAmountFrom(request.getAmountFrom());
		operation.setAmountTo(exchange);
		operationService.saveOperation(operation);
	}

}
