package com.example.licenses.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.licenses.clients.OrganizationDiscoveryClient;
import com.example.licenses.clients.OrganizationFeignClient;
import com.example.licenses.clients.OrganizationRestTemplateClient;
import com.example.licenses.config.ServiceConfig;
import com.example.licenses.models.License;
import com.example.licenses.models.Organization;
import com.example.licenses.repository.LicenseRepository;

@Service
public class LicenseService {

    private final OrganizationDiscoveryClient organizationDiscoveryClient_1;

	@Autowired
	private LicenseRepository licenseRepository;

	@Autowired
	ServiceConfig config;

	//@Autowired 
	private OrganizationFeignClient organizationFeignClient;

	@Autowired private OrganizationDiscoveryClient organizationDiscoveryClient;

	@Autowired private OrganizationRestTemplateClient organizationRestClient;

    LicenseService(OrganizationDiscoveryClient organizationDiscoveryClient_1) {
        this.organizationDiscoveryClient_1 = organizationDiscoveryClient_1;
    }

	public License getLicense(String organizationId, String licenseId) {

		License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
		return license.withComment(config.getExampleProperty());
	}

	public List<License> getLicensesByOrg(String organizationId) {
		return licenseRepository.findByOrganizationId(organizationId);
	}

	public void saveLicense(License license) {
		license.withId(UUID.randomUUID().toString());
		licenseRepository.save(license);
	}

	public License getLicense(String organizationId, String licenseId, String clientType) {
		
		License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
		Organization org = retrieveOrgInfo(organizationId, clientType);
		return license.withOrganizationName(org.getName()).withContactName(org.getContactName())
				.withContactEmail(org.getContactEmail()).withContactPhone(org.getContactPhone())
				.withComment(config.getExampleProperty());
	}
	

    private Organization retrieveOrgInfo(String organizationId, String clientType){
        Organization organization = null;

        switch (clientType) {
            case "feign":
                System.out.println("I am using the feign client");
                organization = organizationFeignClient.getOrganization(organizationId);
                break;
            case "rest":
                System.out.println("I am using the rest client");
                organization = organizationRestClient.getOrganization(organizationId);
                break;
            case "discovery":
                System.out.println("I am using the discovery client");
                organization = organizationDiscoveryClient.getOrganization(organizationId);
                break;
            default:
                organization = organizationRestClient.getOrganization(organizationId);
        }

        return organization;
    }
}