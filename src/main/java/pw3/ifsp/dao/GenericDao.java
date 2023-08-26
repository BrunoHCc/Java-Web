package pw3.ifsp.dao;

import jakarta.persistence.EntityManager;

import java.util.List;

public interface GenericDao <T,K> {
    void create(T objeto);
    void delete(K key);
    void update(T objeto);
    T find(K key);
    List<T> findByName(String nome);
    List<T> findAll();
}
