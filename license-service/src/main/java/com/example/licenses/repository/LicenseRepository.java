package com.example.licenses.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.licenses.models.License;

@Repository
public interface LicenseRepository extends JpaRepository<License, String> {

	List<License> findByOrganizationId(String organizationId);
	 
	License findByOrganizationIdAndLicenseId (String organizationId,String licenseId);
	
}
