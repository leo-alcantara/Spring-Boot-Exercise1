package se.lexicon.spring_boot_exercise_1.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.spring_boot_exercise_1.model.TodoItems;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class TodoItemsDAOJPAImpl implements TodoItemsDAO {

    EntityManager entityManager;

    @Transactional
    public List<TodoItems> findByDeadlineBetween (LocalDateTime start, LocalDateTime end){
        Query query = entityManager.createQuery("SELECT t FROM TodoItems t WHERE t.deadline BETWEEN ?1 AND ?2");
        query.setParameter(1, start);
        query.setParameter(2, end);
        return query.getResultList();
    }

    @Transactional
    public List<TodoItems> findByDeadlineBefore(LocalDateTime end){
        Query query = entityManager.createQuery("SELECT t FROM TodoItems t WHERE t.deadline <= ?1");
        query.setParameter(1, end);
        return query.getResultList();
    }

    @Transactional
    public List<TodoItems> findByDeadLineAfter(LocalDateTime start){
        Query query = entityManager.createQuery("SELECT t FROM TodoItems t WHERE t.deadline >= ?1");
        query.setParameter(1, start);
        return query.getResultList();
    }

    @Transactional
    public List<TodoItems> findByTitle(String todoTitle) throws IllegalArgumentException {
        if (todoTitle == null) {
            throw new IllegalArgumentException("Can not find item: " + todoTitle);
        }
        Query query = entityManager.createQuery("SELECT t FROM TodoItems  t WHERE t.title = ?1");
        query.setParameter(1, todoTitle);
        return query.getResultList();
    }

    @Transactional
    public List<TodoItems> findAll() {
        Query query = entityManager.createQuery("SELECT t FROM TodoItems t");
        return query.getResultList();
    }

    @Transactional
    public List<TodoItems> findByDone() {
        Query query = entityManager.createQuery("SELECT t FROM TodoItems t WHERE t.done = ?1");
        query.setParameter(1, 1);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Optional<TodoItems> findById(int id) {
        TodoItems todoItems = entityManager.find(TodoItems.class, id);
        return Optional.of(todoItems);
    }

    @Override
    @Transactional
    public TodoItems update(TodoItems todoItems) {
        return entityManager.merge(todoItems);
    }

    @Override
    @Transactional
    public TodoItems save(TodoItems todoItems) throws IllegalArgumentException {
        if (todoItems == null) {
            throw new IllegalArgumentException("Can not save item: " + todoItems);
        }
        entityManager.persist(todoItems);
        return todoItems;
    }

    @Override
    @Transactional
    public boolean delete(TodoItems todoItems) {
        entityManager.remove(todoItems);
        return true;
    }
}
