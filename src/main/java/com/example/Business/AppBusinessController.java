package com.example.Business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/business")
@CrossOrigin(origins = "*")
public class AppBusinessController {

    @Autowired
    private AppBusinessService businessService;

    @PostMapping("/add")
    public ResponseEntity <?>addService(@RequestBody RegisterAddBusiness newBusiness) {
        businessService.addBusiness(newBusiness);
        return ResponseEntity.ok("Business added successfully");

    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteService(@PathVariable Long id) {
        businessService.deleteBusiness(id);
        return ResponseEntity.ok("Business deleted successfully");
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateService(@PathVariable Long id, @RequestBody RegisterAddBusiness updatedBusiness) {
        businessService.updateBusiness(id, updatedBusiness);
        return ResponseEntity.ok("Business updated successfully");
    }


    @GetMapping("/all")
    public List<AppBusiness> getAllServices() {
        return businessService.getAllBusinesses();
    }

    @GetMapping("/type/{serviceType}")
    public List<AppBusiness> getServicesByType(@PathVariable String serviceType) {
        return businessService.getBusinessesByType(serviceType);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<?> getServiceById(@PathVariable Long id) {
        try {
            AppBusiness business = businessService.getBusinessbyid(id);
            return ResponseEntity.ok(business);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(
                Map.of("error", e.getMessage(), "id", id)
            );
        }
    }

}
