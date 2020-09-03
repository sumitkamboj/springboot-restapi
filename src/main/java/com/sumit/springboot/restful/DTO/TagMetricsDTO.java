package com.sumit.springboot.restful.DTO;

import javax.persistence.Entity;

public class TagMetricsDTO {
private String tag;
private int occurence;

/*public TagMetricsDTO(String tag, int occurence) {
	this.tag = tag;
    this.occurence  = occurence;
}*/

public String getTag() {
	return tag;
}
public void setTag(String tag) {
	this.tag = tag;
}
public int getOccurence() {
	return occurence;
}
public void setOccurence(int occurence) {
	this.occurence = occurence;
}
	
}
