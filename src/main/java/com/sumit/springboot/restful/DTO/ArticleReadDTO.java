package com.sumit.springboot.restful.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ArticleReadDTO {

	@JsonProperty("articleId")
	private Long articleId;
	@JsonProperty("timeToRead")
	private TimeToReadDTO timeToRead;
	public Long getArticleId() {
		return articleId;
	}
	public void setArticleId(Long long1) {
		this.articleId = long1;
	}
	public TimeToReadDTO getTimeToRead() {
		return timeToRead;
	}
	public void setTimeToRead(TimeToReadDTO timeToRead) {
		this.timeToRead = timeToRead;
	}
	
	
}
