package com.bright.todomanagement.repository;

/*
 * @Project Name: todo-management
 * @Author: Okechukwu Bright Onwumere
 * @Created: 10/04/2023
 */


import com.bright.todomanagement.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
