package com.citiustech.schedular.dto;

public class GetAllDetailsDTO {

		private String phyid;
		
		private String date;

		public String getPhyid() {
			return phyid;
		}

		public void setPhyid(String phyid) {
			this.phyid = phyid;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		@Override
		public String toString() {
			return "GetAllDetailsDTO [phyid=" + phyid + ", date=" + date + "]";
		}
		
		
}
