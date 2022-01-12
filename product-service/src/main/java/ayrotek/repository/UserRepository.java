package ayrotek.repository;

import javax.transaction.Transactional;

import ayrotek.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<AppUser, Integer> {

  boolean existsByUsername(String username);

  AppUser findByUsername(String username);

  @Transactional
  void deleteByUsername(String username);

}
