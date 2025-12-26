package com.leogaspar.EncurtarURL.dto;

import jakarta.validation.constraints.NotBlank;

public class UrlRequestDTO {
	
	@NotBlank(message = "A Url original é obrigatória")
	private String originalUrl;
	
	public UrlRequestDTO() {
		
	}

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	
	
	
}
