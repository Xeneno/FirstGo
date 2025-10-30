package com.example.Business;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "business")
public class AppBusiness {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String businessEmail;

    @Column(nullable = false)
    private String serviceType;

    @Column(nullable = false)
    private String serviceName;

    @Column(nullable = false)
    private String contactNumber;

    @Column(nullable = false)
    private String trialDescription;

    @Column(nullable = false)
    private String trialPrice;

    @Column(nullable = false)
    private String address;

    //  Getters
    public Long getId() { return id; }
    public String getEmail() { return businessEmail; }
    public String getType() { return serviceType; }
    public String getName() { return serviceName; }
    public String getNumber() { return contactNumber; }
    public String getDescription() { return trialDescription; }
    public String getPrice() { return trialPrice; }
    public String getAddress() { return address; }

    // Setters (fixed)
    public void setId(Long id) { this.id = id; }
    public void setEmail(String email) { this.businessEmail = email; }
    public void setType(String serviceType) { this.serviceType = serviceType; }
    public void setName(String serviceName) { this.serviceName = serviceName; }
    public void setNumber(String contactNumber) { this.contactNumber = contactNumber; }
    public void setDescription(String trialDescription) { this.trialDescription = trialDescription; }
    public void setPrice(String trialPrice) { this.trialPrice = trialPrice; }
    public void setAddress(String address) { this.address = address; }
}
