package com.citiustech.schedular.dto;

import java.time.LocalDate;

public class ScheduleDTO {
		
		String phid;
		String time;
		LocalDate date;
		String pid;
		public String getPid() {
			return pid;
		}
		public void setPid(String pid) {
			this.pid = pid;
		}
		public String getPhid() {
			return phid;
		}
		public void setPhid(String phid) {
			this.phid = phid;
		}
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public LocalDate getDate() {
			return date;
		}
		public void setDate(LocalDate date) {
			this.date = date;
		}
		@Override
		public String toString() {
			return "ScheduleDTO [phid=" + phid + ", time=" + time + ", date=" + date + ", pid=" + pid + "]";
		}
		
	
		
}
