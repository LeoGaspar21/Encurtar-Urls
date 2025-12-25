package com.leogaspar.EncurtarURL.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leogaspar.EncurtarURL.entity.Url;
import com.leogaspar.EncurtarURL.services.UrlService;


@RestController
@RequestMapping("/api/urls")
public class UrlResource {
	
	@Autowired
	private UrlService service;
	
	
	@PostMapping
	public ResponseEntity<String> shorten(@RequestBody String originalUrl) {
		Url url = service.shorten(originalUrl);
		return ResponseEntity.ok("http://localhost:8080/api/urls/" + url.getShortCode());
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<Void> redirect(@PathVariable String code) {
		Url url = service.getOriginalUrl(code);
		
		return ResponseEntity.status(HttpStatus.FOUND).header(HttpHeaders.LOCATION, url.getOriginalUrl()).build();
	}
	
	
	
	
	
}
