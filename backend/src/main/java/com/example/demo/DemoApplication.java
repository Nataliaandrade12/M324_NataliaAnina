package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This is a demo application that provides a RESTful API for a simple ToDo list
 * without persistence.
 * The endpoint "/" returns a list of tasks.
 * The endpoint "/tasks" adds a new unique task.
 * The endpoint "/delete" suppresses a task from the list.
 * The task description transferred from the (React) client is provided as a
 * request body in a JSON structure.
 * The data is converted to a task object using Jackson and added to the list of
 * tasks.
 * All endpoints are annotated with @CrossOrigin to enable cross-origin
 * requests.
 *
 * @author luh
 */
@RestController
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	private static final String REDIRECT_HOME = "redirect:/";
	private final ObjectMapper mapper = new ObjectMapper();
	private final List<Task> tasks = new ArrayList<>();

	@CrossOrigin
	@GetMapping("/")
	public List<Task> getTasks() {
		// REST endpoint that returns the current task list as JSON.
		System.out.println("API EP '/' returns task-list of size " + tasks.size() + ".");
		return tasks;
	}

	@CrossOrigin
	@PostMapping("/tasks")
	public String addTask(@RequestBody String body) {
		System.out.println("API EP '/tasks': '" + body + "'");
		Task task = parseTask(body);
		if (task == null) {
			return REDIRECT_HOME;
		}

		if (tasks.contains(task)) {
			System.out.println(">>>task: '" + task.getTaskdescription() + "' already exists!");
			return REDIRECT_HOME;
		}

		tasks.add(task);
		System.out.println("...adding task: '" + task.getTaskdescription() + "'");
		return REDIRECT_HOME;
	}

	@CrossOrigin
	@PostMapping("/delete")
	public String delTask(@RequestBody String body) {
		System.out.println("API EP '/delete': '" + body + "'");
		Task task = parseTask(body);
		if (task == null) {
			return REDIRECT_HOME;
		}

		if (tasks.remove(task)) {
			System.out.println("...deleting task: '" + task.getTaskdescription() + "'");
		} else {
			System.out.println(">>>task: '" + task.getTaskdescription() + "' not found!");
		}
		return REDIRECT_HOME;
	}

	private Task parseTask(String body) {
		try {
			return mapper.readValue(body, Task.class);
		} catch (JsonProcessingException e) {
			System.err.println("Failed to parse task JSON: " + e.getMessage());
			return null;
		}
	}

}
