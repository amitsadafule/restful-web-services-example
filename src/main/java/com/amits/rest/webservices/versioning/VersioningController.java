package com.amits.rest.webservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Amit Sadafule
 *
 * 09-Nov-2018
 */
@RestController
public class VersioningController {

	//Path versioning - 
	//Pros : easy for caching, use and documentation
	//Cons : API flood
	@GetMapping("/v1/person")
	public PersonV1 getPersonV1() {
		return new PersonV1("Amit Sadafule");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getPersonV2() {
		return new PersonV2("Amit", "Sadafule");
	}
	
	//Parameter Versioning - 
	//Pros : easy for caching, use and documentation
	//Cons : API flood
	@GetMapping(path="/person/param", params="version=1")
	public PersonV1 getPersonV1Param() {
		return new PersonV1("Amit Sadafule");
	}
	
	@GetMapping(path="/person/param", params="version=2")
	public PersonV2 getPersonV2Param() {
		return new PersonV2("Amit", "Sadafule");
	}
	
	//Header versioning - 
	//Pros : Single API over time
	//Cons : tricky for caching and documentation
	@GetMapping(path="/person/header", headers="X-API-VERSION=1")
	public PersonV1 getPersonV1Header() {
		return new PersonV1("Amit Sadafule");
	}
	
	@GetMapping(path="/person/header", headers="X-API-VERSION=2")
	public PersonV2 getPersonV2Header() {
		return new PersonV2("Amit", "Sadafule");
	}
	
	//Content negotiation/accept header versioning - 
	//Pros : Single API over time
	//Cons : tricky for caching and documentation
	@GetMapping(path="/person/produces", produces="application/vnd.company.app-v1+json")
	public PersonV1 getPersonV1Produces() {
		return new PersonV1("Amit Sadafule");
	}
	
	@GetMapping(path="/person/produces", produces="application/vnd.company.app-v2+json")
	public PersonV2 getPersonV2Produces() {
		return new PersonV2("Amit", "Sadafule");
	}
}
