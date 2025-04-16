package com.example.org.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.org.models.Organization;
import com.example.org.services.OrganizationService;

@RestController
@RequestMapping(value="v1/organizations")
public class OrganizationServiceController {
    @Autowired
    private OrganizationService orgService;


    @GetMapping("/{organizationId}")
    public Organization getOrganization( @PathVariable String organizationId) {
        return orgService.getOrg(organizationId);
    }

    @PutMapping("/{organizationId}")
    public void updateOrganization( @PathVariable("organizationId") String orgId, @RequestBody Organization org) {
        orgService.updateOrg( org );
    }

    @PostMapping
    public void saveOrganization(@RequestBody Organization org) {
       orgService.saveOrg( org );
    }

    @DeleteMapping("/{organizationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrganization( @PathVariable String orgId,  @RequestBody Organization org) {
        orgService.deleteOrg( org );
    }
}
