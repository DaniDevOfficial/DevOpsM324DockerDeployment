package ch.bbw.architecturerefcard03.service;

import java.util.ArrayList;
import java.util.List;

import ch.bbw.architecturerefcard03.model.Joke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

	private JokeRepository jokeRepository;

	@Autowired
	public DatabaseService(JokeRepository jokeRepository) {
		this.jokeRepository = jokeRepository;
	}

	public List<Joke> getJokes() {
		return (ArrayList) jokeRepository.findAll();
	}
	
}
