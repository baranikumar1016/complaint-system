package com.complaint.system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.complaint.system.enums.ComplaintStatus;
import com.complaint.system.model.Complaint;
import com.complaint.system.repository.ComplaintRepository;

@Service
public class ComplaintService {
	
	final ComplaintRepository repo ;
	
	ComplaintService(ComplaintRepository repo){
		this.repo=repo;
	}
	
	public Complaint createcomplaint(Complaint complaint) {
		return repo.save(complaint);
	}
	
	public List<Complaint> getcomplaintsbyuser(Long userid) {
		return repo.findByUser_Id(userid);
	}
	
	public List<Complaint> getallcomplaints() {
		return repo.findAll();
	}
	
	public Complaint updatestatus(Long userid ,ComplaintStatus status) {
		
		Optional<Complaint> opt = repo.findById(userid);
		if(opt.isEmpty()) {
			throw new RuntimeException ("complaint not found !!");
		}
		Complaint complaint = opt.get();
		complaint.setStatus(status);
		return repo.save(complaint);
		
	}

}
