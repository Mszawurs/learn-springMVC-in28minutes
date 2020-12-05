package webapp.todo;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {

	@Autowired
	TodoService service;
	
	@RequestMapping(value="/list-todos", method=RequestMethod.GET)
	public String listTodos(ModelMap model) {
		model.addAttribute("todos", service.retrieveTodos("abba"));
		model.addAttribute("number", service.getTodoCount());
		return "list-todos";
	}
	
	@RequestMapping(value="/add-todo", method=RequestMethod.GET)
	public String showTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo(0, "abba", "default", LocalDate.now(), false));
		return "todo";
	}
	
	@RequestMapping(value="/add-todo", method=RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		
		service.addTodo("abba", todo.getDesc(), LocalDate.now(), false);
		model.clear();
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="/delete-todo", method=RequestMethod.GET)
	public String deleteTodo(ModelMap model, @RequestParam int id) {
		service.deleteTodo(id);
		return "redirect:list-todos";
	}
	
}
