package com.todo.todoapp.controller;

import org.springframework.ui.Model;
import com.todo.todoapp.mpdel.task;
import com.todo.todoapp.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskController {
    private final TaskService taskService ;
    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }
    @GetMapping
    public String getTasks(Model model){
        List<task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }
    @PostMapping
    public String createTasks(@RequestParam String tittle){
         taskService.createTask(tittle);

        return "redirect:/";
    }
    @GetMapping("/{id}/delete")
    public String deleteTasks(@PathVariable Long id){
        taskService.deleteTask(id);
        return "redirect:/";
    }
    @GetMapping("/{id}/toggle")
    public String toggleTasks(@PathVariable Long id){
        taskService.toggleTask(id);
        return "redirect:/";
    }




}
