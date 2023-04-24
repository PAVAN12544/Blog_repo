package com.zensar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Comment")
public class CommentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="BlogId")
	private int blogId;
	@Column(name="Comment")
	private String comment;
	public CommentEntity(int id, int blogId, String comment) {
		super();
		this.id = id;
		this.blogId = blogId;
		this.comment = comment;
	}
	public CommentEntity(int blogId, String comment) {
		super();
		this.blogId = blogId;
		this.comment = comment;
	}
	public CommentEntity(String comment) {
		super();
		this.comment = comment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "CommentEntity [id=" + id + ", blogId=" + blogId + ", comment=" + comment + "]";
	}
	

}
