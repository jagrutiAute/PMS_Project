package com.citiustech.schedular.dto;

public class PhysicianUpdateDTO {

		public String date;
		
		public boolean morning;
		
		public boolean evening;

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public boolean getMorning() {
			return morning;
		}

		public void setMorning(boolean morning) {
			this.morning = morning;
		}

		public boolean getEvening() {
			return evening;
		}

		public void setEvening(boolean evening) {
			this.evening = evening;
		}

		@Override
		public String toString() {
			return "PhysicianUpdateDTO [date=" + date + ", morning=" + morning + ", evening=" + evening + "]";
		}
		
		
		
}
