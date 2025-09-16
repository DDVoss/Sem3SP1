package app.dao;

import app.entities.Cast;
import app.entities.Crew;
import app.utils.IDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CrewDAO implements IDAO<Crew, Integer> {

    private final EntityManagerFactory emf;

    public CrewDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Crew create(Crew crew) {
        try (EntityManager em = emf.createEntityManager())  {
            em.getTransaction().begin();
            em.persist(crew);
            em.getTransaction().commit();
            return crew;
        } catch (Exception e)   {
            e.getMessage();
            return null;
        }
    }

    @Override
    public List<Crew> getAll() {
        try (EntityManager em = emf.createEntityManager())  {
            TypedQuery<Crew> query = em.createQuery("SELECT c FROM Crew c", Crew.class);
            return query.getResultList();
        } catch (Exception e)   {
            e.getMessage();
            return null;
        }
    }

    @Override
    public Crew getById(Integer id) {
        try (EntityManager em = emf.createEntityManager())  {
            Crew crew = em.find(Crew.class, id);
            return crew;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    @Override
    public Crew update(Crew crew) {
        try(EntityManager em = emf.createEntityManager())   {
            em.getTransaction().begin();
            Crew updateCrew = em.merge(crew);
            em.getTransaction().commit();
            em.close();
            return updateCrew;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    @Override
    public boolean delete(Integer id) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Crew removeCrew = getById(id);
            em.remove(removeCrew);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }
}
