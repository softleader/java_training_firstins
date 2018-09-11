package com.example.firstins.member.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.example.firstins.common.AbstractEntity;

@Entity
public class Member extends AbstractEntity {

	@Column(length = 20)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
