package com.todo.todoapp.repository;

import com.todo.todoapp.mpdel.task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<task,Long> {
}
