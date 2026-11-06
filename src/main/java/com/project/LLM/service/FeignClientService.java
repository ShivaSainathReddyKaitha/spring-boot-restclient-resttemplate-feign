package com.project.LLM.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.LLM.configuration.FeignClientConfig;
import com.project.LLM.dto.Post;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FeignClientService {
	
	private final FeignClientConfig feignClient;
	
	public List<Post> getPosts() {
		return feignClient.getPosts();
	}
	
	public Post getIndividualPost(@PathVariable Long id) {
		return feignClient.getIndividualPost(id);
	}
	
	public List<Post> getIndividualPostbyuserId(@RequestParam Long userId) {
		return feignClient.getIndividualPostbyuserId(userId);
	}
	
	public Post createPost(@RequestBody Post post) {
		return feignClient.createPost(post);
	}
	
	public void updatePost(@PathVariable Long id, @RequestBody Post post) {
		feignClient.updatePost(id, post);
	}
	
	public Post updatePostTitle(@PathVariable Long id, @RequestBody Post post) {
		return feignClient.updatePostTitle(id, post);
	}
	
	public void deleteById(@PathVariable Long id) {
		feignClient.deleteById(id);
	}

}
