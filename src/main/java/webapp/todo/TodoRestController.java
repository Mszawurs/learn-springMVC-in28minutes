package webapp.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoRestController {

	@Autowired
	TodoService service;
	
	@RequestMapping(path="/todos")
	public List<Todo> retrieveAllTodos(){
		return service.retrieveTodos("abba");
	}
	
	@RequestMapping(path="/todos/{id}")
	public Todo retrieveAllTodos(@PathVariable int id){
		return service.retrieveTodo(id);
	}
}
