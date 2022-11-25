package com.todolist.todolistbackend.util.service;

import com.todolist.todolistbackend.entity.Todo;

import java.util.List;
import java.util.Optional;

/**
 * @author leonid.barsucovschi
 */

public interface TodoService {


    List<Todo> getAllTodo();

    Todo getTodoById(Long id);

    void createTodo(Todo todo);

    void updateTodo(Long id, Todo todo);

    void delete(Long id);

}
