package cdshop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	
	@Autowired
	private DataAccess dao;
	
	@RequestMapping("/")
	public String viewTablePage(Model model) {
		List<CD> listCD = dao.list();
		model.addAttribute("listCD", listCD);
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewForm(Model model) {
		CD cd= new CD();
		model.addAttribute("cd", cd);
		return "new_form";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute("cd") CD cd) {
		dao.save(cd);
		return "redirect:/";
	}
	
	@RequestMapping(value="/edit/{id}")
	public ModelAndView showEditForm(@PathVariable(name ="id")int id) {
		ModelAndView mav = new ModelAndView("edit_form");
		CD cd = dao.get(id);
		mav.addObject("cd", cd);
		return mav;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@ModelAttribute("cd") CD cd) {
		dao.update(cd);
		return "redirect:/";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable(name = "id") int id) {
	    dao.delete(id);
	    return "redirect:/";      
	}

}
