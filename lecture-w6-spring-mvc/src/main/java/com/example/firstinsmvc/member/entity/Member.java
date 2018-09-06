package com.example.firstinsmvc.member.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.example.firstinsmvc.common.AbstractEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member extends AbstractEntity {

	@Column(precision = 3)
	private BigDecimal empNo;

	@Column(length = 20)
	private String name;

}
