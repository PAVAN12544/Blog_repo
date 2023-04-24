package com.zensar.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.zensar.dto.BlogDto;

public interface BlogService {
	
	public BlogDto createBlog(BlogDto blogDto);
	public ResponseEntity<BlogDto> blogId(int id);
	public ResponseEntity<List<BlogDto>> getAll();
	public ResponseEntity<Boolean> delAll(int id);
	public ResponseEntity<BlogDto> upId(int id,BlogDto blogDto);

}
