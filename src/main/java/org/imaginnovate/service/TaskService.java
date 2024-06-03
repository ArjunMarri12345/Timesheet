package org.imaginnovate.service;

import java.util.List;

import org.imaginnovate.model.Task;
import org.imaginnovate.repository.TaskRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class TaskService {

    @Inject
    TaskRepository taskRepository;

    @Transactional
    public List<Task> getAllTasks() {
        return taskRepository.listAll();
    }

    @Transactional
    public Task getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Transactional
    public void addTask(Task task) {
        taskRepository.persist(task);
    }

    @Transactional
    public Task updateTask(Long id, Task updatedTask) {
        Task existingTask = taskRepository.findById(id);
        if (existingTask != null) {
            existingTask.setName(updatedTask.getName());
            existingTask.setDescription(updatedTask.getDescription());
            taskRepository.persist(existingTask);
        }
        return existingTask;
    }

    @Transactional
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id);
        if (task != null) {
            taskRepository.delete(task);
        }
    }
}
