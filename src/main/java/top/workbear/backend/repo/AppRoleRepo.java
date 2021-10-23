package top.workbear.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import top.workbear.backend.domain.AppRole;

/**
 * @author workbear
 */
public interface AppRoleRepo extends JpaRepository<AppRole, Long> {
    AppRole findByName(String name);
}
