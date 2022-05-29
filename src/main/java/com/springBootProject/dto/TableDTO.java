package com.springBootProject.dto;

import com.springBootProject.domain.Table;

import lombok.Builder;

public class TableDTO {
	private int index;
	private String title;
	private String content;
	private String writer;
	private String date;
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "TableDTO [index=" + index + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", date=" + date + "]";
	}

    
    @Builder
    public TableDTO(int index, String title, String content, String writer, String date) {
        this.index = index;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.date = date;
    }
	

	
}
