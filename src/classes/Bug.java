package classes;

//CLASSE BUG
public class Bug {

	// ATRIBUTOS
	private int id;

	private String titulo;

	private int idade;

	private Prioridade prioridade;

	// CONSTRUTORES
	public Bug() {
	}

	public Bug(int id, String titulo, int idade, Prioridade prioridade) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.idade = idade;
		this.prioridade = prioridade;
	}

	//GETTERS E SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

	//SOBREESCRITA DO METODO toString PARA MOSTRAS OS ATRIBUTOS DA CLASSE
	@Override
	public String toString() {
		return "Bug:[id=" + id + ", titulo=" + titulo + ", idade=" + idade + ", prioridade=" + prioridade + "]\n";
	}
	
}
