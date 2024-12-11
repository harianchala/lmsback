package com.klef.jfsd.springboot.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.klef.jfsd.springboot.model.Admin;

public interface AdminService {
	  Admin createAdmin(Admin admin);
	    List<Admin> getAllAdmins();
	    Admin getAdminById(Long id);
	    String updateAdmin(Long id, Admin admin) throws IOException, SQLException;
	    String deleteAdmin(Long id);
}
