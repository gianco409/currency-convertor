package com.pe.pichincha.demo.infrastructure.repository.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "operation")
@Getter
@Setter
public class Operation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String symbolFrom;
	private String symbolTo;
	private Double amountFrom;
	private Double amountTo;
	private Boolean success;
	private Date createdAt;
}
