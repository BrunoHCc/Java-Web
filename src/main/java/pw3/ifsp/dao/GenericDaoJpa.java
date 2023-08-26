package pw3.ifsp.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class GenericDaoJpa <T,K>implements GenericDao<T,K>{


    public GenericDaoJpa(Class<T> entityClass) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ead1");
        this.entityManager = entityManagerFactory.createEntityManager();
        this.entityClass = entityClass;
    }

    private final EntityManager entityManager;
    private final Class<T> entityClass;
    @Override
    public void create(T aluno) {
        entityManager.getTransaction().begin();
        entityManager.persist(aluno);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(K key) {
        T entity = find(key);
        if(entity!=null){
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        }
    }

    @Override
    public void update(T objeto) {
        entityManager.getTransaction().begin();
        entityManager.merge(objeto);
        entityManager.getTransaction().commit();
    }

    @Override
    public T find(K key) {
        return entityManager.find(entityClass,key);
    }

    @Override
    public List<T> findByName(String nome){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<T> root = criteriaQuery.from(entityClass);

        Predicate predicate = criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
        criteriaQuery.where(predicate);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
    @Override
    public List<T> findAll() {
        CriteriaQuery<T> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(entityClass);
        criteriaQuery.select(criteriaQuery.from(entityClass));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
