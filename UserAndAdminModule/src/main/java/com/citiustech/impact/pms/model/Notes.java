package com.citiustech.impact.pms.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="notes")
@NoArgsConstructor @Data @AllArgsConstructor
public class Notes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String reciever;
	private String message;
	private Boolean isUrgent;
	private LocalDateTime sentTime;
	private LocalDateTime recieveTime;	
	private String sender;
	
	
	
}
