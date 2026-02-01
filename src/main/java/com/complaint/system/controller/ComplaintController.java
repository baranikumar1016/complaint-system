package com.complaint.system.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.complaint.system.enums.ComplaintStatus;
import com.complaint.system.model.Complaint;
import com.complaint.system.model.User;
import com.complaint.system.repository.UserRepository;
import com.complaint.system.service.ComplaintService;

@RestController
@RequestMapping("/api/complaints")
@CrossOrigin
public class ComplaintController {

    private final ComplaintService service;
    private final UserRepository repo;
    public ComplaintController(ComplaintService service,UserRepository repo) {
        this.service = service;
        this.repo=repo;
    }

    @PostMapping
    public Complaint create(@RequestBody Complaint complaint) {
        return service.createcomplaint(complaint);
    }

    @GetMapping("/user/{userId}")
    public List<Complaint> byUser(@PathVariable Long userId) {
        return service.getcomplaintsbyuser(userId);
    }

    @GetMapping
    public List<Complaint> all() {
        return service.getallcomplaints();
    }
    
    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateStatus(@PathVariable Long id,@RequestParam ComplaintStatus status,@RequestParam Long userId ){
    	Optional<User> optuser = repo.findById(userId);
    	if(optuser.isEmpty()) {
    		return ResponseEntity.badRequest().body("User not found !!");
    	}
    	User user = optuser.get();
    	if(user.getRole() == null || !user.getRole().equalsIgnoreCase("ADMIN")) {
    		return ResponseEntity.badRequest().body("Acess Denaid :Admins only !!");

    	}
    	Complaint updated = service.updatestatus(id, status);
    	return ResponseEntity.ok(updated);

    	
    }
}
