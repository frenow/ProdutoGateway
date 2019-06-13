package loja;

public class Produto {
	private long id;
	private String nome;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Produto(long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	

}
