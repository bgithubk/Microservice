package com.example.licenses.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.licenses.models.License;

@RestController
@RequestMapping(value="/v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {

	@GetMapping("/{licenseId}")
	public License getLicenses(
	@PathVariable String organizationId,
	@PathVariable String licenseId) {
	 return new License()
	 .withId(licenseId)
	 .withProductName("Teleco")
	 .withLicenseType("Seat")
	 .withOrganizationId("TestOrg");
	 }
}