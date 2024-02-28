package ch.bbw.architecturerefcard03.controller;

import ch.bbw.architecturerefcard03.service.DatabaseService;
import ch.bbw.architecturerefcard03.service.JokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

	private DatabaseService databaseService;

	@Autowired
	public MainController(DatabaseService databaseService) {
		this.databaseService = databaseService;
	}

	@GetMapping("/")
	public String homepage(Model model, HttpServletRequest request) {
		model.addAttribute("jokelist", databaseService.getJokes());
		return "index";
	}
	
	@PostMapping("/")
	public void deleteJoke(@RequestParam(required = true) String id) {
		System.out.println("delete Joke: " + id);
	}
}
