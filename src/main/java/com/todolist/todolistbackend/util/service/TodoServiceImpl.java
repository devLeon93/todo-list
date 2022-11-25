package com.todolist.todolistbackend.util.service;

import com.todolist.todolistbackend.entity.Todo;
import com.todolist.todolistbackend.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;


/**
 * @author leonid.barsucovschi
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    public static final Logger LOG = LoggerFactory.getLogger(TodoServiceImpl.class);

    public final TodoRepository todoRepository;

    @Override
    public List<Todo> getAllTodo() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getTodoById(Long id) {
        return todoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Task with id " + id + "not found"));
    }

    @Override
    public void createTodo(Todo todo) {
        Todo createTodo = new Todo();
        createTodo.setTitle(todo.getTitle());
        createTodo.setCompleted(todo.getCompleted());
        todoRepository.save(createTodo);

    }

    @Override
    public void updateTodo(Long id, Todo todo) {
        Todo updateTodo = todoRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("This id " + id + " does not exist"));
        updateTodo.setTitle(todo.getTitle());
        updateTodo.setCompleted(todo.getCompleted());
        todoRepository.save(updateTodo);
    }

    @Override
    public void delete(Long id) {
        Todo deleteTodo = todoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Todo not allowed to delete with id " + id));
        todoRepository.delete(deleteTodo);
    }
}
