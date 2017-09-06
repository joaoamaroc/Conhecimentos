package spring;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "Knowledges", uniqueConstraints = @UniqueConstraint(columnNames="KNOWLEDGE"))
public class Knowledges {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	//private Knowledge knowledge;
	@Column(name = "KNOWLEDGE")
	private String knowledge;
	@Column(name = "LEVEL")
	//private String level;
	private Level level;
	@OneToOne
	private Person person;

	public Knowledges() {
		// Empty body.
	}
	
	public Knowledges(String knowledge, Level level, Person person) {
		super();
		this.knowledge = knowledge;
		this.level = level;
		this.person = person;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKnowledge() {
		return knowledge;
	}

	public void setKnowledge(String knowledge) {
		this.knowledge = knowledge;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Knowledges [id=" + id + ", knowledge=" + knowledge + ", level=" + level + ", person=" + person + "]";
	}

	
}
