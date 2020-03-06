package com.hcl.ecom.rolebasedoauth2.dto;

import java.util.List;

import org.springframework.data.annotation.Transient;

public class UserDto {

    private long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private long contact;
    private String billingAddress;
    private String shippingAddress;
    private List<String> role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
  
    public long getContact() {
		return contact;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
