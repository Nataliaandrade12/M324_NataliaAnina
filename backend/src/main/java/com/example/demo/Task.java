package com.example.demo;
/** the simplest task 
 * 
 * @author luh
 */
import java.util.Objects;

// a simple task with only one field, the description of the task
public class Task {

	private String taskdescription;

	public Task() {
	}
	// Constructor with task description
	public String getTaskdescription() {
		return taskdescription;
	}

	public void setTaskdescription(String taskdescription) { 
		this.taskdescription = taskdescription;
	}

	// equals and hashcode based on the taskdescription field
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Task))
			return false;
		Task other = (Task) o;
		return Objects.equals(taskdescription, other.taskdescription);
	}

	@Override
	public int hashCode() {
		return Objects.hash(taskdescription);
	}
}