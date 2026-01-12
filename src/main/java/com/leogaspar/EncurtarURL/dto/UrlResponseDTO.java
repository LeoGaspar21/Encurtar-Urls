package com.leogaspar.EncurtarURL.dto;

public class UrlResponseDTO {

	private String shortUrl;

	private Integer clicks;

	public UrlResponseDTO() {

	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public Integer getClicks() {
		return clicks;
	}

	public void setClicks(Integer clicks) {
		this.clicks = clicks;
	}

}
