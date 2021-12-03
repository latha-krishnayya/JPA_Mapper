package se.lexicon.sneha.jpa.data;

import se.lexicon.sneha.jpa.model.AppUser;

import java.util.Collection;

public interface AppUserDAO{
    AppUser create(AppUser appUser);
    AppUser findByID(int id);
    Collection<AppUser> findAll();
    AppUser update(AppUser appUser);
    void delete(int id);
}
