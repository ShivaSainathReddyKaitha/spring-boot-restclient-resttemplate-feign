package com.project.LLM.service;

import java.util.Arrays;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import com.project.LLM.dto.Post;

@Service
public class RestClientService {
	
	private final RestClient restClient;

	public RestClientService(RestClient restClient) {
		this.restClient = restClient;
	}
	
	public List<Post> getPosts() {
		 return restClient.get()
				 			.uri("/posts")
				 			.retrieve()
				 			.body(new ParameterizedTypeReference<List<Post>>() {});
	}
	
	public Post getIndividualPost(@PathVariable Long id) {
		return restClient.get()
							.uri("/posts/{id}", id)
							.retrieve()
							.body(Post.class);
	}
	
	public List<Post> getIndividualPostbyuserId(@RequestParam Long userId) {
		return restClient.get()
							.uri("/posts?userId={userId}", userId)
							.retrieve()
							.body(new ParameterizedTypeReference<List<Post>>() {
							});
	}
	
	public Post createPost(@RequestBody Post post) {
		return restClient.post()
							.uri("/posts")
							.contentType(MediaType.APPLICATION_JSON)
							.body(post)
							.retrieve()
							.body(Post.class);
	}
	
	public void updatePost(@PathVariable Long id, @RequestBody Post post) {
		 restClient.put()
						.uri("/posts/{id}", id)
						.contentType(MediaType.APPLICATION_JSON)
						.body(post)
						.retrieve()
						.toBodilessEntity();
	}
	
	public Post updatePostTitle(@PathVariable Long id, @RequestBody Post post) {
		return restClient.patch()
					.uri("/posts/{id}", id)
					.contentType(MediaType.APPLICATION_JSON)
					.body(post)
					.retrieve()
					.body(Post.class);
	}
	
	public void deleteById(@PathVariable Long id) {
		restClient.delete()
					.uri("/posts/{id}", id)
					.retrieve()
					.toBodilessEntity();
	}
	
	
	
	

}
