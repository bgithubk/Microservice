package com.example.licenses.clients;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.licenses.models.Organization;

//@FeignClient("organizationservice")
public interface OrganizationFeignClient {
    @GetMapping(
            value="/v1/organizations/{organizationId}",
            consumes="application/json")
    Organization getOrganization(@PathVariable("organizationId") String organizationId);
}
