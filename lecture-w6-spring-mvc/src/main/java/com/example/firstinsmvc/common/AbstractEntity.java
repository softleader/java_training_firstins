package com.example.firstinsmvc.common;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractEntity {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@Column
	private LocalDateTime createdTime;

	@Column
	private LocalDateTime updatedTime;

	@PrePersist
	protected void onCreate() {
		this.createdTime = LocalDateTime.now();
		this.updatedTime = this.createdTime;
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedTime = LocalDateTime.now();
	}

}
