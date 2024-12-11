package com.klef.jfsd.springboot.controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import com.klef.jfsd.springboot.model.Admin;

import com.klef.jfsd.springboot.services.AdminService;



@RestController
@CrossOrigin(origins = "http://localhost:3000") // Adjust origin as per your frontend host
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	

	
	 @PostMapping("/create")
	    public Admin createAdmin(@RequestBody Admin admin) {
	        return adminService.createAdmin(admin);
	    }

	    @GetMapping("/all")
	    public List<Admin> getAllAdmins() {
	        return adminService.getAllAdmins();
	    }

	    @GetMapping("/all/{id}")	
	    public Admin getAdminById(@PathVariable Long id) {
	        return adminService.getAdminById(id);
	    }
	    
	    @PutMapping("/update/{id}")
	    public String updateAdmin(@PathVariable Long id, @RequestBody Admin admin) throws IOException, SQLException {
	        return adminService.updateAdmin(id, admin);
	    }
	  

	    @DeleteMapping("/delete/{id}")
	    public String deleteAdmin(@PathVariable Long id) {
	        return adminService.deleteAdmin(id);
	    }
	
}
