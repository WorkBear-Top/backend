package top.workbear.backend.service;

import top.workbear.backend.domain.AppRole;
import top.workbear.backend.domain.AppUser;

import java.util.List;

/**
 * @author workbear
 */
public interface AppUserService {
    AppUser saveUser(AppUser user);
    AppRole saveRole(AppRole role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser>getUsers();
}
