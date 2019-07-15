package com.rohan.dynamic_spring_sec.service;

import java.util.List;

import com.rohan.dynamic_spring_sec.entity.Post;

public interface PostService {

	public void createPost(Post post);

	public List<Post> getPost();

	public Post findById(Long id);

}
