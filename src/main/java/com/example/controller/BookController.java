import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.entity.BookEntity;
import com.example.service.BookService;

@Controller
public class BookController {
	@Autowired
	BookService bookservice;
	
	@RequestMapping("/add")
	public String index() {
		return "index";
	}
	
	@RequestMapping(Value="/add",method=RequestMethod.POST)
	public String orderView(@ModelAttribute BookEntity book) {
		bookservice.saveBook(book);
	}
	
	@RequestMapping("/edit/{id}")
	public String Edit(@PathVariable Long id,Model model) {
		BookEntity bookentity=bookservice.editBook(id);
	}
	
	@RequestMapping("/delete/{id}")
	public String Delete(@PathVariable Long id, Model model) {
		bookservice.deleteBook(id);
		return "Redirect:manage";
	}
	
}