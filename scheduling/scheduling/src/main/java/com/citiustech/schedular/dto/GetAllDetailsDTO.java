package com.citiustech.schedular.dto;

import java.time.LocalDate;

public class GetAllDetailsDTO {

		private String phyid;
		
		private LocalDate date;

		public String getPhyid() {
			return phyid;
		}

		public void setPhyid(String phyid) {
			this.phyid = phyid;
		}

		

		public LocalDate getDate() {
			return date;
		}

		public void setDate(LocalDate date) {
			this.date = date;
		}

		@Override
		public String toString() {
			return "GetAllDetailsDTO [phyid=" + phyid + ", date=" + date + "]";
		}
		
		
}
