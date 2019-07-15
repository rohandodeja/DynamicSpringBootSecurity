package com.rohan.dynamic_spring_sec.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohan.dynamic_spring_sec.entity.Post;
import com.rohan.dynamic_spring_sec.repository.PostRepository;

@Service
@Transactional
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	public void createPost(Post post) {
		postRepository.save(post);
	}

	public List<Post> getPost() {

		return (List<Post>) postRepository.findAll();
	}

	@Override
	public Post findById(Long id) {
		Optional<Post> optionalPost = postRepository.findById(id);
		if (optionalPost.isPresent())
			return optionalPost.get();
		else
			return null;
	}

}
