package com.todolist.todolistbackend.controller;

import com.todolist.todolistbackend.entity.Todo;
import com.todolist.todolistbackend.util.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author leonid.barsucovschi
 */

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public ResponseEntity<List<Todo>> all () {
        List<Todo> todos = todoService.getAllTodo();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> todoById (@PathVariable("id") Long id) {
        Todo todo = todoService.getTodoById(id);
        return new ResponseEntity<>(todo,HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> create (@RequestBody Todo todo) {
        todoService.createTodo(todo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update (@RequestBody Todo todo,
                                     @PathVariable("id") Long id) {
        todoService.updateTodo(id,todo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") Long id) {
        todoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
