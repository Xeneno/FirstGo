package com.example.Business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppBusinessService {

    @Autowired
    private AppBusinessRepository repo;

    public void addBusiness(RegisterAddBusiness dto) {

        AppBusiness business = new AppBusiness();
        // entity business (fields)
        
        business.setEmail(dto.businessEmail);
        business.setType(dto.serviceType);
        business.setName(dto.serviceName);
        business.setNumber(dto.contactNumber);
        business.setDescription(dto.trialDescription);
        business.setPrice(dto.trialPrice);
        business.setAddress(dto.address);

        //buiness object (email,type,name,number,description,price,address)

        repo.save(business);
    }

    public List<AppBusiness> getAllBusinesses() {
        return repo.findAll();
    }

    public void deleteBusiness(Long id) {
        repo.deleteById(id);
    }

    public AppBusiness getBusinessbyid(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Business not found"));
    }

    public List<AppBusiness> getBusinessesByType(String serviceType) {
        return repo.findByServiceType(serviceType);
    }
    
    public void updateBusiness(Long id, RegisterAddBusiness dto) {
        AppBusiness business = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Business not found"));

        business.setEmail(dto.businessEmail);
        business.setType(dto.serviceType);
        business.setName(dto.serviceName);
        business.setNumber(dto.contactNumber);
        business.setDescription(dto.trialDescription);
        business.setPrice(dto.trialPrice);
        business.setAddress(dto.address);

        repo.save(business);
    }

}
