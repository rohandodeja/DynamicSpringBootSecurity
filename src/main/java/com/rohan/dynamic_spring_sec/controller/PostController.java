package com.rohan.dynamic_spring_sec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohan.dynamic_spring_sec.entity.Post;
import com.rohan.dynamic_spring_sec.service.PostService;

@RestController
@RequestMapping(value =  "/post" )
public class PostController {

	@Autowired
	private PostService postService;
	
	@PostMapping(value="/create")
    public ResponseEntity<Void> createPost(@RequestBody Post post){
       
		postService.createPost(post);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> getPostById(@PathVariable Long id){
		Post post = postService.findById(id);
		
		if(post== null) 
			return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Post>(post,HttpStatus.OK);
		
	}

}
