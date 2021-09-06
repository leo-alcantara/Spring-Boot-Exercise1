package se.lexicon.spring_boot_exercise_1.repository;

import se.lexicon.spring_boot_exercise_1.model.TodoItems;

import java.util.Optional;

public interface TodoItemsDAO {

    Optional<TodoItems> findById(int id);

    TodoItems update(TodoItems todoItems);

    TodoItems save(TodoItems todoItems);

    boolean delete(TodoItems todoItems);
}
