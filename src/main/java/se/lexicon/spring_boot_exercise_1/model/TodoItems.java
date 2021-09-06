package se.lexicon.spring_boot_exercise_1.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class TodoItems {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String todoId;
    private String title;
    private String description;
    private LocalDateTime deadline;
    boolean done = false;

    public TodoItems() {
    }

    public TodoItems(String title, String description, LocalDateTime deadline) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
    }

    public String getTodoId() {
        return todoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public boolean isDone() {
        return done;
    }

    public void toggleDone(boolean done) {
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItems todoItems = (TodoItems) o;
        return isDone() == todoItems.isDone() && getTodoId().equals(todoItems.getTodoId()) && getTitle().equals(todoItems.getTitle()) && getDescription().equals(todoItems.getDescription()) && getDeadline().equals(todoItems.getDeadline());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTodoId(), getTitle(), getDescription(), getDeadline(), isDone());
    }

    @Override
    public String toString() {
        return "TodoItems{" +
                "todoId='" + todoId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", done=" + done +
                '}';
    }
}
