package ch.bbw.architecturerefcard03.controller;

import ch.bbw.architecturerefcard03.model.Joke;
import ch.bbw.architecturerefcard03.service.JokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api")
public class JokeRestController {

    private JokeRepository jokeRepository;

    @Autowired
    public JokeRestController(JokeRepository jokeRepository) {
        this.jokeRepository = jokeRepository;
    }

    @GetMapping("jokes")
    public List<Joke> getJokes() {
        return StreamSupport.stream(
                jokeRepository
                        .findAll()
                        .spliterator(), false)
                .collect(Collectors.toList());
    }
}


