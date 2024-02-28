package ch.bbw.architecturerefcard03.service;

import ch.bbw.architecturerefcard03.model.Joke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JokeRepository extends JpaRepository<Joke, Long> {
}
