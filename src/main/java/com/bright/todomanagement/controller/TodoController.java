package com.bright.todomanagement.controller;

/*
 * @Project Name: todo-management
 * @Author: Okechukwu Bright Onwumere
 * @Created: 10/04/2023
 */


import com.bright.todomanagement.dto.TodoDto;
import com.bright.todomanagement.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class TodoController {

    private TodoService todoService;

    //Build add Todo REST API
    @PostMapping("/create")
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto){
        TodoDto savedTodo = todoService.addTodo(todoDto);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    //Build get Todo REST API
    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable("id") Long id){
        TodoDto savedTodoDto = todoService.getTodo(id);
        return ResponseEntity.ok(savedTodoDto);
    }

    //Build get All Todos REST API
    @GetMapping("/all")
    public ResponseEntity<List<TodoDto>> getAllTodos(){
        List<TodoDto> savedTodoDtos = todoService.getTodos();
        return ResponseEntity.ok(savedTodoDtos);
    }

    //Build update Todo REST API
    @PutMapping("/{id}/update")
    public ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto todoDto, @PathVariable("id") Long id){
        TodoDto updatedTodoDto = todoService.updateTodo(todoDto, id);
        return ResponseEntity.ok(updatedTodoDto);
    }

    //Build update Todo REST API
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long id){
        todoService.deleteTodo(id);
        return ResponseEntity.ok("Todo successfully deleted!!!");
    }

    //Build complete Todo REST API
    @PatchMapping("/{id}/complete")  //Partial Update
    public ResponseEntity<TodoDto> completeTodo(@PathVariable("id") Long id){
        TodoDto updatedTodoDto = todoService.completedTodo(id);
        return ResponseEntity.ok(updatedTodoDto);
    }

    //Build inComplete Todo REST API
    @PatchMapping("/{id}/incomplete")  //Partial Update
    public ResponseEntity<TodoDto> inCompleteTodo(@PathVariable("id") Long id){
        TodoDto updatedTodoDto = todoService.inCompleteTodo(id);
        return ResponseEntity.ok(updatedTodoDto);
    }
}
