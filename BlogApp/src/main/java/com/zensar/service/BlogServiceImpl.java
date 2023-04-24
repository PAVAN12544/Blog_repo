package com.zensar.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.zensar.dto.BlogDto;
import com.zensar.entity.BlogEntity;
import com.zensar.repository.BlogRepository;
@Service
public class BlogServiceImpl implements BlogService{

	@Autowired
	BlogRepository blogRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public BlogDto createBlog(BlogDto blogDto) {
		
		BlogEntity blogEntity = this.modelMapper.map(blogDto, BlogEntity.class);
		blogEntity = blogRepository.save(blogEntity);
	    blogDto = this.modelMapper.map(blogEntity, BlogDto.class);
		
		return blogDto;
	}

	@Override
	public ResponseEntity<BlogDto> blogId(int id) {
		Optional<BlogEntity> byId = blogRepository.findById(id);
		if(byId.isPresent())
		{
			BlogEntity blogEntity=byId.get();
			return new ResponseEntity(blogEntity,HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST) ;
	}

	@Override
	public ResponseEntity<List<BlogDto>> getAll() {
		List<BlogEntity> all = blogRepository.findAll();
		return  new ResponseEntity(all,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Boolean> delAll(int id) {
		blogRepository.deleteById(id);
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<BlogDto> upId(int id, BlogDto blogDto) {
		Optional<BlogEntity> optional = blogRepository.findById(id);
		if(optional.isPresent())
		{
			BlogEntity blogEntity = optional.get();
			if(blogEntity.getTitle()!=null||blogEntity.getTitle( )!= "")
			{
				blogEntity.setTitle(blogDto.getTitle());
			}
		 blogEntity = blogRepository.save(blogEntity);
		 this.modelMapper.map(blogEntity, BlogDto.class);
		}
		return new ResponseEntity<BlogDto>(blogDto, HttpStatus.OK);
	}

}
