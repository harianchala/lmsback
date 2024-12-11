package com.klef.jfsd.springboot.services;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Faculty;
import com.klef.jfsd.springboot.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public Admin createAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}

	@Override
	public Admin getAdminById(Long id) {
		return adminRepository.findById(id).orElse(null);
	}

	@Override
	public String updateAdmin(Long id, Admin admin) {
		Admin existingAdmin = adminRepository.findById(id).orElse(null);
        if (existingAdmin==null) {
            return "Admin not found";
        }
        existingAdmin.setUsername(admin.getUsername());
        existingAdmin.setFullname(admin.getFullname());
        existingAdmin.setPassword(admin.getPassword());
        existingAdmin.setEmail(admin.getEmail());
        existingAdmin.setPhonenumber(admin.getPhonenumber());
        existingAdmin.setRole(admin.getRole());
        
        existingAdmin.setGender(admin.getGender());
        existingAdmin.setAddress(admin.getAddress());
       
        adminRepository.save (existingAdmin);
        return "Admin updated successfully";
	}



	@Override
	public String deleteAdmin(Long id) {
		if (!adminRepository.existsById(id)) {
            return "Admin not found";
        }
       adminRepository.deleteById(id);
        return "Admin deleted successfully";
	}

}
