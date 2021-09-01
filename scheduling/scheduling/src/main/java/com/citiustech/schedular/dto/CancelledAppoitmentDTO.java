package com.citiustech.schedular.dto;

import java.time.LocalDate;

public class CancelledAppoitmentDTO {
		
			String phyId;
			
			LocalDate date;
			
			String time;

			public String getPhyId() {
				return phyId;
			}

			public void setPhyId(String phyId) {
				this.phyId = phyId;
			}

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
			
			
			
}
