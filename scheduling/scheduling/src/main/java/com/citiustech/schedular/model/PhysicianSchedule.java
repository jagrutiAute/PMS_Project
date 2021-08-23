package com.citiustech.schedular.model;



import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "schedular_physician")
public class PhysicianSchedule {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		private LocalDate date;
		
		@Column(columnDefinition="tinyint(1) default 1")
		private boolean morning;
		
		@Column(columnDefinition="tinyint(1) default 1")
		private boolean evening;
		
		private String phyid;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public boolean isMorning() {
			return morning;
		}

		public void setMorning(boolean morning) {
			this.morning = morning;
		}

		public boolean isEvening() {
			return evening;
		}

		public void setEvening(boolean evening) {
			this.evening = evening;
		}

		

		public LocalDate getDate() {
			return date;
		}

		public void setDate(LocalDate  date) {
			this.date = date;
		}

		public String getPhyid() {
			return phyid;
		}

		public void setPhyid(String phyid) {
			this.phyid = phyid;
		}

		@Override
		public String toString() {
			return "PhysicianSchedule [id=" + id + ", date=" + date + ", morning=" + morning + ", evening=" + evening
					+ ", phyid=" + phyid + "]";
		}

		
		
		
		
}
