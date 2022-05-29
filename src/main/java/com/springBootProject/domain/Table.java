package com.springBootProject.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.Builder;

@EntityScan
public class Table {
	
	private int index;
	private String title;
	private String content;	
	public int getIndex() {
		return index;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Builder
	public Table() {
		this.index = index;
		this.title = title;
		this.content = content;
	}
	
	
}
