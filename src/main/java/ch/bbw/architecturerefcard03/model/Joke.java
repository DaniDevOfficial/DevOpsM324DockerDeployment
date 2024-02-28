package ch.bbw.architecturerefcard03.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="joke")
public class Joke {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String text;
	private int rating;
	@Temporal(TemporalType.DATE)
	@Column(name="creation_date")
	private Date creationDate;

	@ManyToOne
	@JoinColumn(name="section_idfs", nullable=false)
	@JsonIgnore
	private Section section;

}
