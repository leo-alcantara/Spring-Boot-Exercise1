package se.lexicon.spring_boot_exercise_1.repository;

import se.lexicon.spring_boot_exercise_1.model.AppUser;

import java.util.Optional;

public interface AppUserDao {

    Optional<AppUser> findById(int id);

    AppUser update(AppUser appuser);

    AppUser save(AppUser appuser);

    boolean delete(AppUser appuser);
}
