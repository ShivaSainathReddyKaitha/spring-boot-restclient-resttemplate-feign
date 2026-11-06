package com.project.LLM.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.LLM.dto.Post;
import com.project.LLM.service.RestClientService;
import com.project.LLM.service.RestTemplateService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommunicationController {
	
	private final RestTemplateService service;
	
	@GetMapping("/posts")
	public List<Post> getPosts() {
		 return service.getPosts();
	}
	
	@GetMapping("/fetchById/{id}")
	public Post getIndividualPost(@PathVariable Long id) {
		return service.getIndividualPost(id);
	}
	
	@GetMapping("/fetchByUserId")
	public List<Post> getIndividualPostbyuserId(@RequestParam Long userId) {
		 return service.getIndividualPostbyuserId(userId);
	}
	
	@PostMapping("/post")
	public Post createPost(@RequestBody Post post) {
		return service.createPost(post);
	}
	
	@PutMapping("/update/{id}")
	public void updatePost(@PathVariable Long id, @RequestBody Post post) {
		service.updatePost(id, post);
	}
	
	
	@PatchMapping("/patch/{id}")
	public Post updatePostTitle(@PathVariable Long id, @RequestBody Post post) {
		return service.updatePostTitle(id, post);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable Long id) {
		service.deleteById(id);
	}

}
