package com.dailytasktracker.rest.webservices.restfulwebservices.tasks;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin(origins="*")
public class TaskResource {

	@Autowired
	private TaskService service;
	
	@GetMapping("/users/{username}/tasks")
	List<Task> getAllTasks(@PathVariable String username){
	
		return service.getAllTasks();
	}
	
	@GetMapping("/users/{username}/tasks/{id}")
	Task getTask(@PathVariable String username, @PathVariable long id){
	
		return service.findById(id);
	}
	
	@PutMapping("/users/{username}/tasks/{id}")
	ResponseEntity<Task> updateTask(@PathVariable String username, 
			@PathVariable long id,
			@RequestBody Task task){
	
		Task updatedTask=service.save(task);
		return new ResponseEntity<Task>(updatedTask, HttpStatus.OK );
	}
	
	@PostMapping("/users/{username}/tasks")
	ResponseEntity<Void> updateTask(@PathVariable String username,
			@RequestBody Task task){
	
		Task createdTask=service.save(task);
		URI uri= ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(createdTask.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/users/{username}/tasks/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable String username, @PathVariable long id)
	{
		Task task=service.deleteById(id);
		if(task!=null)
		{
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
}
