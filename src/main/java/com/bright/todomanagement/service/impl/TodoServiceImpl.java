package com.bright.todomanagement.service.impl;

/*
 * @Project Name: todo-management
 * @Author: Okechukwu Bright Onwumere
 * @Created: 10/04/2023
 */


import com.bright.todomanagement.dto.TodoDto;
import com.bright.todomanagement.entity.Todo;
import com.bright.todomanagement.exception.ResourceNotFoundException;
import com.bright.todomanagement.repository.TodoRepository;
import com.bright.todomanagement.service.TodoService;
import com.bright.todomanagement.utils.Constants;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final ModelMapper modelMapper;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {

        //Convert TodoDto into Todo JPA Entity
        Todo todo = modelMapper.map(todoDto, Todo.class);

        Todo savedTodo = todoRepository.save(todo);

        //Convert Todo JPA entity to TodoDto
        return modelMapper.map(savedTodo, TodoDto.class);
    }

    @Override
    public TodoDto getTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(String.format(Constants.NOT_FOUND, id)));

        //Convert Todo JPA entity to TodoDto
        return modelMapper.map(todo, TodoDto.class);
    }

    @Override
    public List<TodoDto> getTodos() {

        List<Todo> todos = todoRepository.findAll();
        return todos.stream().map(todo -> modelMapper.map(todo, TodoDto.class)).toList();
    }

    @Override
    public TodoDto updateTodo(TodoDto todoDto, Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(String.format(Constants.NOT_FOUND, id)));

        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());

        Todo updatedTodo = todoRepository.save(todo);

        //Convert Todo JPA entity to TodoDto
        return modelMapper.map(updatedTodo, TodoDto.class);
    }

    @Override
    public void deleteTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(String.format(Constants.NOT_FOUND, id)));
        todoRepository.delete(todo);
    }

    @Override
    public TodoDto completedTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(String.format(Constants.NOT_FOUND, id)));
        todo.setCompleted(Boolean.TRUE);

        Todo updatedTodo = todoRepository.save(todo);

        //Convert Todo JPA entity to TodoDto
        return modelMapper.map(updatedTodo, TodoDto.class);
    }

    @Override
    public TodoDto inCompleteTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(String.format(Constants.NOT_FOUND, id)));
        todo.setCompleted(Boolean.FALSE);

        Todo updatedTodo = todoRepository.save(todo);

        //Convert Todo JPA entity to TodoDto
        return modelMapper.map(updatedTodo, TodoDto.class);
    }
}
