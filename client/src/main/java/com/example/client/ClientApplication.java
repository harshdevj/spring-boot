package com.example.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
public class ClientApplication {

	static {
		javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(new javax.net.ssl.HostnameVerifier() {
			public boolean verify(String hostname, javax.net.ssl.SSLSession sslSession) {
				if (hostname.equals("localhost")) {
					return true;
				}
				return false;
			}
		});

		System.setProperty("javax.net.ssl.trustStore", "classpath:truststore.jks");
		System.setProperty("javax.net.ssl.trustStorePassword", "keypassword");
		//System.setProperty("javax.net.ssl.keyStore", "classpath:keystore.jks");
		//System.setProperty("javax.net.ssl.keyStorePassword", "keypassword");
	}

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

}
