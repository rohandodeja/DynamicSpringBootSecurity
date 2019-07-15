package com.rohan.dynamic_spring_sec.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Post")
@Table(name = "post")
public class Post {
	
	@Id
	private Long Id;
	private String title;
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval = true,mappedBy="post")
	private List<PostComment> postComments;
	
	public void addComment(PostComment comment) {
		comment.setPost(this);
		postComments.add(comment);
    }
 
    public void removeComment(PostComment comment) {
        comment.setPost(null);
        postComments.remove(comment);
    }

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<PostComment> getPostComments() {
		return postComments;
	}

	public void setPostComments(List<PostComment> postComments) {
		this.postComments = postComments;
	}
	
	
	

}
