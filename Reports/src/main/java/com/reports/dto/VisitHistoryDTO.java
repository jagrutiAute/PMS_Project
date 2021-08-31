package com.reports.dto;

import java.time.LocalDate;


public class VisitHistoryDTO {

	
		LocalDate date;
		
		String phyId;
			
		public VisitHistoryDTO(){}
		public LocalDate getDate() {
			return date;
		}

		public void setDate(LocalDate date) {
			this.date = date;
		}

		public String getPhyId() {
			return phyId;
		}

		public void setPhyId(String phyId) {
			this.phyId = phyId;
		}

		@Override
		public String toString() {
			return "VisitHistoryDTO [date=" + date + ", phyId=" + phyId + "]";
		}
		
		
		
}
