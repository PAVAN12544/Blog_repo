package com.zensar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDto {
	
	private int id;
	private String title;
	private String content;
	public BlogDto(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	

}
