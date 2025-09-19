package app.dao;

import app.entities.MovieCast;
import app.utils.IDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CastDAO implements IDAO<MovieCast, Integer> {

    private final EntityManagerFactory emf;

    public CastDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public MovieCast create(MovieCast movieCast) {
        try (EntityManager em = emf.createEntityManager())  {
            em.getTransaction().begin();
            em.persist(movieCast);
            em.getTransaction().commit();
            return movieCast;
        } catch (Exception e)   {
            e.getMessage();
            return null;
        }
    }

    @Override
    public List<MovieCast> getAll() {
        try (EntityManager em = emf.createEntityManager())  {
            TypedQuery<MovieCast> query = em.createQuery("SELECT c FROM MovieCast c", MovieCast.class);
            return query.getResultList();
        } catch (Exception e)   {
            e.getMessage();
            return null;
        }
    }

    @Override
    public MovieCast getById(Integer id) {
        try (EntityManager em = emf.createEntityManager())  {
            MovieCast movieCast = em.find(MovieCast.class, id);
            return movieCast;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    @Override
    public MovieCast update(MovieCast movieCast) {
        try(EntityManager em = emf.createEntityManager())   {
            em.getTransaction().begin();
            MovieCast updateMovieCast = em.merge(movieCast);
            em.getTransaction().commit();
            em.close();
            return updateMovieCast;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    @Override
    public boolean delete(Integer id) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            MovieCast removeMovieCast = getById(id);
            em.remove(removeMovieCast);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }
}
