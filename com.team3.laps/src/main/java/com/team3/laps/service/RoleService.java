package com.team3.laps.service;

import java.util.ArrayList;
import com.team3.laps.model.Role;

public interface RoleService {

	ArrayList<Role> findAllRoles();

	Role findRole(Integer dec);

	Role createRole(Role r);

	Role changeRole(Role r);

	void removeRole(Role r);
}
