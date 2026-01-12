package com.leogaspar.EncurtarURL.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leogaspar.EncurtarURL.entity.Url;
import com.leogaspar.EncurtarURL.repository.UrlRepository;
import com.leogaspar.EncurtarURL.services.exceptions.UrlNotFoundException;

@Service
public class UrlService {
	@Autowired
	private UrlRepository repo;

	public Url shorten(String originalUrl) {
		String code = generateShortUrl();

		Url url = new Url();
		url.setOriginalUrl(originalUrl);
		url.setShortCode(code);

		return repo.save(url);
	}

	public Url getOriginalUrl(String shortCode) {
		Url url = repo.findByShortCode(shortCode).orElseThrow(() -> new UrlNotFoundException("Url não encontrada"));

		url.incrementClick();
		repo.save(url);

		return url;
	}

	private String generateShortUrl() {
		return UUID.randomUUID().toString().substring(0, 6);
	}

}
