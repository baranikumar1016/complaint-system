package com.complaint.system.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.complaint.system.model.Complaint;

public interface ComplaintRepository extends JpaRepository<Complaint, Long>{
         
	List<Complaint>findByUser_Id(Long userId);
}