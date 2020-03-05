package com.hcl.ecom.rolebasedoauth2.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.hcl.ecom.rolebasedoauth2.dto.UserDto;

import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @NotEmpty(message = "Please enter First Name")
    @Column(name = "FIRST_NAME")
    private String firstName;
    @NotEmpty(message = "Please enter Last Name")
    @Column(name = "LAST_NAME")
    private String lastName;
    @NotEmpty(message = "Please enter User Name")
    @Column(name = "USERNAME")
    private String username;
    @NotEmpty(message = "Please enter Password")
    @Column(name = "PASSWORD")
    private String password;
    @NotEmpty(message = "Please enter Email")
    @Column(name = "EMAIL")
    private String email;
    @NotNull
    @Column(name = "CONTACT")
    private long contact;
    @NotEmpty(message = "Please enter Shipping Address")
    @Column(name = "SHIPPING_ADDRESS")
    private String shippingAddress;
    @NotEmpty(message = "Please enter Billing Address")
    @Column(name = "BILLING_ADDRESS")
    private String billingAddress;
    
    

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "User_ROLES",
            joinColumns =  @JoinColumn(name ="USER_ID"),inverseJoinColumns= @JoinColumn(name="ROLE_ID"))
    private Set<Role> roles;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

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

	public String getShippingAddress() {
		return shippingAddress;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public UserDto toUserDto(){
        UserDto userDto = new UserDto();
        userDto.setId(this.id);
        userDto.setEmail(this.email);
        userDto.setFirstName(this.firstName);
        userDto.setLastName(this.lastName);
        userDto.setUsername(this.username);
        userDto.setContact(this.contact);
        userDto.setBillingAddress(this.billingAddress);
        userDto.setShippingAddress(this.shippingAddress);
        userDto.setRole(this.roles.stream().map(role -> role.getName().toString()).collect(Collectors.toList()));
        return userDto;
    }
}
