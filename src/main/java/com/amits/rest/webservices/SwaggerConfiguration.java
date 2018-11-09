package com.amits.rest.webservices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Amit Sadafule
 *
 *         08-Nov-2018
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	public static final Contact DEFAULT_CONTACT = new Contact("Amit Sadafule",
			"", "amit.sadafule@gmail.com");
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
			"Restful Web Service Documentation",
			"Restful Web Service Desctription", "1.0", "urn:tos",
			DEFAULT_CONTACT, "Apache 2.0",
			"http://www.apache.org/licenses/LICENSE-2.0",
			new ArrayList<VendorExtension>());

	private static final Set<String> DEFAULT_ACCEPT_TYPES = new HashSet<String>(
			Arrays.asList("application/json", "application/xml"));
	
	private static final Set<String> DEFAULT_PRODUCE_TYPES = new HashSet<String>(
			Arrays.asList("application/json", "application/xml"));

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO)
				.produces(DEFAULT_ACCEPT_TYPES)
				.consumes(DEFAULT_PRODUCE_TYPES);
	}
}
