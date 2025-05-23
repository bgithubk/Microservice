package com.example.org.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.org.models.Organization;
import com.example.org.repository.OrganizationRepository;

@Service
public class OrganizationService {
    
	@Autowired
    private OrganizationRepository orgRepository;

    public Organization getOrg(String organizationId) {
    	return orgRepository.findById(organizationId).orElse(null);
    }

    public void saveOrg(Organization org){
        org.setId( UUID.randomUUID().toString());

        orgRepository.save(org);

    }

    public void updateOrg(Organization org){
        orgRepository.save(org);
    }

    public void deleteOrg(Organization org){
        orgRepository.deleteById( org.getId());
    }
}