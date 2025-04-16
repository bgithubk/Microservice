package com.example.org.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.org.models.Organization;

public interface OrganizationRepository extends JpaRepository<Organization,String> {

	public Optional<Organization> findById(String organizationId);
	
}
