package com.zensar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.dto.BlogDto;
import com.zensar.service.BlogService;

@RestController
@RequestMapping( value="/blogmenu")
@CrossOrigin(origins = "*")
public class BlogController {
	@Autowired
	BlogService blogService;
	
	@PostMapping(value="/post")
	public ResponseEntity<BlogDto> createBlogDto(@RequestBody BlogDto blogDto)
	{
		 BlogDto blog = blogService.createBlog(blogDto);
		 if(blog.getTitle()!=""||blog.getTitle()!=null)
		 {
			 if(blog.getContent()!=""||blog.getContent()!=null) {
			 return new ResponseEntity<BlogDto>(blog,HttpStatus.OK);}
		 }
		return new ResponseEntity<BlogDto>(HttpStatus.BAD_REQUEST);
		
	}
	
	@GetMapping(value="/omg/{id}")
	public ResponseEntity<BlogDto> blogId(@PathVariable int id)
	{
		ResponseEntity<BlogDto> id2 = blogService.blogId(id);
		
		return new ResponseEntity (id2,HttpStatus.OK);
		
	}
	@GetMapping(value="/omg")
	public ResponseEntity<List<BlogDto>> getAll()
	{
		ResponseEntity<List<BlogDto>> all = blogService.getAll();
		return new ResponseEntity(all,HttpStatus.OK);
		
	}
	@DeleteMapping(value="oh/{id}")
	public ResponseEntity<Boolean> delAll(@PathVariable int id)
	{
		blogService.delAll( id);
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		
	}
	@PutMapping(value="omg/{id}")
	public ResponseEntity<BlogDto> upId(@PathVariable int id, @RequestBody BlogDto blogDto)
	{
		ResponseEntity<BlogDto> upId = blogService.upId(id, blogDto);
		return new ResponseEntity(upId, HttpStatus.OK);
		
	}
	


}
