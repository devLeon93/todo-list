package com.todolist.todolistbackend.repository;

import com.todolist.todolistbackend.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}