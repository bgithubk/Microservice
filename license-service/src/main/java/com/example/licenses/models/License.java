package com.example.licenses.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "licenses")
public class License {

	@Id
	private String licenseId;

	@Column(name = "organization_id", nullable = false)
	private String organizationId;

	@Column(name = "product_name", nullable = false)
	private String productName;

	@Column(name = "license_type", nullable = false)
	private String licenseType;
	
	@Transient
	private String comment;
	
	@Transient
	private String organizationName ="";

	@Transient
	private String contactName ="";
		
	@Transient
	private String contactPhone ="";
		
	@Transient
	private String contactEmail ="";

	public String getLicenseId() {
		return licenseId;
	}

	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public License withId(String id) {
		this.setLicenseId(id);
		return this;
	}

	public License withOrganizationId(String organizationId) {
		this.setOrganizationId(organizationId);
		return this;
	}

	public License withProductName(String productName) {
		this.setProductName(productName);
		return this;
	}

	public License withLicenseType(String licenseType) {
		this.setLicenseType(licenseType);
		return this;
	}

	public License withComment(String exampleProperty) {
		this.setComment(exampleProperty);
		return this;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public License withOrganizationName(String name) {
		this.setOrganizationName(name);
		return this;
	}

	public License withContactName(String contactName2) {
		this.setContactName(contactName2);
		return this;
	}

	public License withContactEmail(String contactEmail2) {
		this.setContactEmail(contactEmail2);
		return this;
	}

	public License withContactPhone(String contactPhone2) {
		this.setContactPhone(contactPhone2);
		return this;
	}
	
	

}
