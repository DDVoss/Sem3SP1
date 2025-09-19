package app.dao;

import app.entities.Cast;
import app.utils.IDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class CastDAO implements IDAO<Cast, Integer> {

    private final EntityManagerFactory emf;

    public CastDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Cast create(Cast cast) {
        try (EntityManager em = emf.createEntityManager())  {
            em.getTransaction().begin();
            em.persist(cast);
            em.getTransaction().commit();
            return cast;
        } catch (Exception e)   {
            e.getMessage();
            return null;
        }
    }

    @Override
    public List<Cast> getAll() {
        return List.of();
    }

    @Override
    public Cast getById(Integer id) {
        try (EntityManager em = emf.createEntityManager())  {
            Cast cast = em.find(Cast.class, id);
            return cast;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    @Override
    public Cast update(Cast cast) {
        try(EntityManager em = emf.createEntityManager())   {
            em.getTransaction().begin();
            Cast updateCast = em.merge(cast);
            em.getTransaction().commit();
            em.close();
            return updateCast;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    @Override
    public boolean delete(Integer id) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Cast removeCast = getById(id);
            em.remove(removeCast);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }
}
