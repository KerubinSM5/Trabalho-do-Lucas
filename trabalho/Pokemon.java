package trabalho2;


public class Pokemon {
	static Integer count = 1;
	Integer id;
	String nome;
	String descricao;
	String tipagem;
	String fraquezas;
	String linhaEvolutiva;
	
	public Pokemon(String nome, String descricao, String tipagem, String fraquezas, String linhaEvolutiva) {
		this.id = count;
		this.nome = nome;
		this.descricao = descricao;
		this.tipagem = tipagem;
		this.fraquezas = fraquezas;
		this.linhaEvolutiva = linhaEvolutiva;
		count++;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipagem() {
		return tipagem;
	}

	public void setTipagem(String tipagem) {
		this.tipagem = tipagem;
	}

	public String getFraquezas() {
		return fraquezas;
	}

	public void setFraquezas(String fraquezas) {
		this.fraquezas = fraquezas;
	}

	public String getLinhaEvolutiva() {
		return linhaEvolutiva;
	}

	public void setLinhaEvolutiva(String linhaEvolutiva) {
		this.linhaEvolutiva = linhaEvolutiva;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", tipagem=" + tipagem
				+ ", fraquezas=" + fraquezas + ", linhaEvolutiva=" + linhaEvolutiva + "]";
	}
	
}