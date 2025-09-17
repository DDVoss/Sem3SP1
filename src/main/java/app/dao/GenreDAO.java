package app.dao;

import app.entities.Genre;
import app.utils.IDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class GenreDAO implements IDAO<Genre, Integer> {
    private final EntityManagerFactory emf;

    public GenreDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Genre create(Genre genre) {
        try (EntityManager em = emf.createEntityManager())  {
            em.getTransaction().begin();
            em.persist(genre);
            em.getTransaction().commit();
            return genre;
        } catch (Exception e)   {
            e.getMessage();
            return null;
        }
    }

    @Override
    public List<Genre> getAll() {
        return List.of();
    }

    @Override
    public Genre getById(Integer id) {
        return null;
    }

    @Override
    public Genre update(Genre genre) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
