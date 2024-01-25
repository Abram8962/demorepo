package com.ltim.demoapp.handler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class ExampleHandler {

	@Value("${dbname}")
	private String dbname;
	
	@Value("${dbusername}")
	private String dbusername;
	
	@Value("${dbpassword}")
	private String dbpassword;

	public Mono<ServerResponse> hello(ServerRequest request) {
		String secrets = " { dbname : "+dbname +" || dbusername : "+ dbusername +" || dbpassword : "+dbpassword +" }";
		return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
				.body(BodyInserters.fromObject("Secret manager values : "+ secrets));
	}
}