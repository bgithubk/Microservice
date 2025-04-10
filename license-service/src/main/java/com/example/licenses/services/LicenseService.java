package com.example.licenses.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.licenses.config.ServiceConfig;
import com.example.licenses.models.License;
import com.example.licenses.repository.LicenseRepository;

@Service
public class LicenseService {
	 
	@Autowired
	private LicenseRepository licenseRepository;
	 
	@Autowired
	ServiceConfig config;
	 
	public License getLicense(String organizationId,String licenseId) {
	 
		License license = licenseRepository.findByOrganizationIdAndLicenseId(
				organizationId, licenseId);
		return license.withComment(config.getExampleProperty());
	 }
	 
	public List<License> getLicensesByOrg(String organizationId){
		return licenseRepository.findByOrganizationId( organizationId );
	}
	 
	public void saveLicense(License license){
		license.withId( UUID.randomUUID().toString()); 
		licenseRepository.save(license);
	}
}	