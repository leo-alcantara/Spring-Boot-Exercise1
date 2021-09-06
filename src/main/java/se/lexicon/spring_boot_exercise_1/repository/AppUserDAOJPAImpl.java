package se.lexicon.spring_boot_exercise_1.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.spring_boot_exercise_1.model.AppUser;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
public class AppUserDAOJPAImpl implements AppUserDao {

    EntityManager entityManager;

    @Override
    @Transactional
    public Optional<AppUser> findById(int id) {
         AppUser appUser = entityManager.find(AppUser.class, id);
        return Optional.of(appUser);
    }

    @Override
    @Transactional
    public AppUser update(AppUser appuser) {
        return entityManager.merge(appuser);
    }

    @Override
    @Transactional
    public AppUser save(AppUser appuser) {
        entityManager.persist(appuser);
        return appuser;
    }

    @Override
    @Transactional
    public boolean delete(AppUser appuser) {
        entityManager.remove(appuser);
        return true;
    }
}
