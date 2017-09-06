package spring;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_Pessoa;
	@Column(name = "NOME")
	private String nome;
	@Column(name = "IDADE")
	private int idade;
	
	public Person() {
		
	}

	public Person(String nome, int idade) {
		super();
		this.nome = nome;
		this.idade = idade;
	}

	public Long getId_Pessoa() {
		return id_Pessoa;
	}

	public void setId_Pessoa(Long id_Pessoa) {
		this.id_Pessoa = id_Pessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Person [id=" + id_Pessoa + ", nome=" + nome + ", idade=" + idade + "]";
	}

}
