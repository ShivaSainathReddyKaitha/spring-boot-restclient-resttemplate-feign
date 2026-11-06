package com.project.LLM.configuration;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.LLM.dto.Post;

@FeignClient(name = "FeignClient-configuration", url = "https://jsonplaceholder.typicode.com")
public interface FeignClientConfig {

	@GetMapping("/posts")
	List<Post> getPosts();
	
	@GetMapping("/posts/{id}")
	Post getIndividualPost(@PathVariable Long id);
	
	@GetMapping("/posts?userId={userId}")
	public List<Post> getIndividualPostbyuserId(@RequestParam Long userId);
	
	@PostMapping("/posts")
	public Post createPost(@RequestBody Post post);
	
	@PutMapping("/posts/{id}")
	public void updatePost(@PathVariable Long id, @RequestBody Post post);
	
	@PatchMapping("/posts/{id}")
	public Post updatePostTitle(@PathVariable Long id, @RequestBody Post post);
	
	@DeleteMapping("/posts/{id}")
	public void deleteById(@PathVariable Long id);
}
