package com.leogaspar.EncurtarURL.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leogaspar.EncurtarURL.entity.Url;

public interface UrlRepository extends JpaRepository<Url, Long>{
	Optional<Url> finfindByShortCode(String shortCode);
}
