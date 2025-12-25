package com.leogaspar.EncurtarURL.services.exceptions;

public class UrlNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public UrlNotFoundException(String msg) {
		super(msg);
	}
	

}
