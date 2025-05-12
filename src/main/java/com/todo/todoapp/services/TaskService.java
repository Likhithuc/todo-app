package com.todo.todoapp.services;

import com.todo.todoapp.mpdel.task;
import com.todo.todoapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository){
        this.taskRepository=taskRepository;
    }
    public List<task> getAllTasks(){
        return taskRepository.findAll();
    }
    public void createTask(String tittle){
        task tk=new task();
        tk.setTittle(tittle);
        tk.setCompleted(false);
        taskRepository.save(tk);
    }
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
    public void toggleTask(Long id){
        task tk=taskRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Ivalid task id"));
        tk.setCompleted(!tk.isCompleted());
        taskRepository.save(tk);
    }
}
