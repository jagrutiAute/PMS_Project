package com.citiustech.schedular.model;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "schedular_patient")
public class Schedular {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private LocalDate date;

	private String time;

	private String phyid;
	
	private String pid;
	
	@Column(columnDefinition="tinyint(1) default 0")
	private boolean iscancelled;
	
	

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	@Column(columnDefinition="tinyint(1) default 1")
	private boolean booked;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	

	public String getPhyid() {
		return phyid;
	}

	public void setPhyid(String phyid) {
		this.phyid = phyid;
	}

	public boolean isBooked() {
		return booked;
	}

	public void setBooked(boolean booked) {
		this.booked = booked;
	}
	
	

	public boolean isCancelled() {
		return iscancelled;
	}

	public void setCancelled(boolean isCancelled) {
		this.iscancelled = isCancelled;
	}

	@Override
	public String toString() {
		return "Schedular [id=" + id + ", date=" + date + ", time=" + time + ", phyid=" + phyid + ", pid=" + pid
				+ ", iscancelled=" + iscancelled + ", booked=" + booked + "]";
	}

	

	


	

	

}
