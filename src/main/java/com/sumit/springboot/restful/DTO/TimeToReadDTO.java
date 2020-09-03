package com.sumit.springboot.restful.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeToReadDTO {

	@JsonProperty("mins")
	private int mins ;
	@JsonProperty("seconds")
	private int seconds;
	public int getMins() {
		return mins;
	}
	public void setMins(int mins) {
		this.mins = mins;
	}
	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
	
}
