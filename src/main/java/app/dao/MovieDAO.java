package app.dao;

import app.entities.Movie;
import app.utils.IDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class MovieDAO implements IDAO<Movie, Integer> {

    private final EntityManagerFactory emf;

    public MovieDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Movie create(Movie movie) {
        try (EntityManager em = emf.createEntityManager())  {
            em.getTransaction().begin();
            em.persist(movie);
            em.getTransaction().commit();
            return movie;
        } catch (Exception e)   {
            e.getMessage();
            return null;
        }
    }

    @Override
    public List<Movie> getAll() {
        try (EntityManager em = emf.createEntityManager())  {
            TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m", Movie.class);
            return query.getResultList();
        } catch (Exception e)   {
            e.getMessage();
            return null;
        }
    }

    @Override
    public Movie getById(Integer id) {
        try (EntityManager em = emf.createEntityManager())  {
            Movie movie = em.find(Movie.class, id);
            return movie;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    @Override
    public Movie update(Movie movie) {
        try(EntityManager em = emf.createEntityManager())   {
            em.getTransaction().begin();
            Movie updateMovie = em.merge(movie);
            em.getTransaction().commit();
            em.close();
            return updateMovie;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    @Override
    public boolean delete(Integer id) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Movie removeMovie = getById(id);
            em.remove(removeMovie);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }
}
