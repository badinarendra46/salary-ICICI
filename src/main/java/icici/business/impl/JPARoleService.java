package icici.business.impl;

import org.springframework.stereotype.Service;

import icici.business.RoleService;
import icici.business.model.Role;

@Service
public class JPARoleService extends JPACRUDService<Long, Role> implements RoleService {

}
