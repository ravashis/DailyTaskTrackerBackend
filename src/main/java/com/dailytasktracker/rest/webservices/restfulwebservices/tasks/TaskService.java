package com.dailytasktracker.rest.webservices.restfulwebservices.tasks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TaskService {
	
	private static List<Task> tasks=new ArrayList<Task>();
	private static long idCounter;
	
	static {
		
		tasks.add(new Task(++idCounter,"admin","Task 1",new Date(),false));
		tasks.add(new Task(++idCounter,"admin","Task 2",new Date(),false));
		tasks.add(new Task(++idCounter,"admin","Task 3",new Date(),false));
		tasks.add(new Task(++idCounter,"admin","Task 4",new Date(),false));
		tasks.add(new Task(++idCounter,"admin","Task 5",new Date(),false));
	}
	
	List<Task> getAllTasks(){
		return tasks;
	}
	
	Task deleteById(long id) {
		Task task=findById(id);
		if(task==null)
			return null;
		tasks.remove(task);
		return task;
	}
	
	Task findById(long id) {
		for(Task task:tasks)
		{
			if(task.getId() == id)
			{
				return task;
			}
		}
		return null;
	}
	
	Task save(Task task) {
		if((task.getId()==0) || (task.getId()==-1))
		{
			task.setId(++idCounter);
			tasks.add(task);
		}
		else
		{
			deleteById(task.getId());
			tasks.add(task);
		}
		return task;
	}
	

}
