package com.project.LLM.service;

import java.util.Arrays;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
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
import org.springframework.web.client.RestTemplate;

import com.project.LLM.dto.Post;

@Service
public class RestTemplateService {

	private final RestTemplate restTemplate;

	public RestTemplateService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public List<Post> getPosts() {
		 Post[] posts = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts",
				 Post[].class);
		 return posts != null ? Arrays.asList(posts):List.of();
	}
	
	public Post getIndividualPost(@PathVariable Long id) {
		return restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/{id}",
				Post.class, id);
	}
	
	public List<Post> getIndividualPostbyuserId(@RequestParam Long userId) {
		 Post[] posts = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts?userId={userId}",
				Post[].class, userId);
		 return Arrays.asList(posts);
	}
	
	public Post createPost(@RequestBody Post post) {
		return restTemplate.postForObject("https://jsonplaceholder.typicode.com/posts", post, Post.class);
	}
	
	public void updatePost(@PathVariable Long id, @RequestBody Post post) {
		restTemplate.put("https://jsonplaceholder.typicode.com/posts/{id}", post, id);
	}
	
	public Post updatePostTitle(@PathVariable Long id, @RequestBody Post post) {
		return restTemplate.patchForObject("https://jsonplaceholder.typicode.com/posts/{id}", post, Post.class, id);
	}
	
	public void deleteById(@PathVariable Long id) {
		restTemplate.delete("https://jsonplaceholder.typicode.com/posts/{id}", id);
	}
	
	
}
