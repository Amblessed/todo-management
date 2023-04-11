package com.bright.todomanagement.service;

/*
 * @Project Name: todo-management
 * @Author: Okechukwu Bright Onwumere
 * @Created: 10/04/2023
 */


import com.bright.todomanagement.dto.TodoDto;

import java.util.List;

public interface TodoService {

    TodoDto addTodo(TodoDto todoDto);

    TodoDto getTodo(Long id);

    List<TodoDto> getTodos();

    TodoDto updateTodo(TodoDto todoDto, Long id);

    void deleteTodo(Long id);

    TodoDto completedTodo(Long id);

    TodoDto inCompleteTodo(Long id);
}
