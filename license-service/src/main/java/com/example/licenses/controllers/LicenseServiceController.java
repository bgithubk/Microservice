package com.example.licenses.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.licenses.config.ServiceConfig;
import com.example.licenses.models.License;
import com.example.licenses.services.LicenseService;

@RestController
@RequestMapping(value = "/v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {

	@Autowired
	private ServiceConfig config;
	
	@Autowired
	private LicenseService licenseService;

	@GetMapping("/{licenseId}")
	public License getLicenses(@PathVariable String organizationId, @PathVariable String licenseId) {
		return new License().withId(licenseId).withProductName("Teleco").withLicenseType("Seat")
				.withOrganizationId("TestOrg").withComment(config.getExampleProperty());
	}

	@GetMapping("/{licenseId}/{clientType}")
	public License getLicensesWithClient(@PathVariable String organizationId,
			@PathVariable String licenseId, @PathVariable String clientType) {
		return licenseService.getLicense(organizationId, licenseId, clientType);
	}

}