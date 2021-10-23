package top.workbear.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import top.workbear.backend.domain.AppUser;

/**
 * @author workbear
 */
public interface AppUserRepo extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
