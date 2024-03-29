package bibli.modelo;

public class Livro implements Comparable<Livro>{

	private static int totalLivrosJaCadastrados= 0;

	private String codigo;
	private String titulo;
	private String autor;
	private int edicao;
	private String editora;
	private int numeroPaginas;
	private String isbn;
	private String categoria;
	private int quantidadeExemplares;

	public Livro(String titulo, String autor, 
			int edicao, String editora, int numeroPaginas,
			String isbn, String categoria) {
		
		totalLivrosJaCadastrados++;
		this.codigo= "L" + String.valueOf(totalLivrosJaCadastrados);
		this.titulo = titulo;
		this.autor = autor;
		this.edicao = edicao;
		this.editora = editora;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.categoria = categoria;
		this.quantidadeExemplares = 0;
	}	
	
	public Livro(String codigo, String titulo, String autor, 
			int edicao, String editora, int numeroPaginas,
			String isbn, String categoria, int quantidadeExemplares) {
		
		this.codigo= codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.edicao = edicao;
		this.editora = editora;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.categoria = categoria;
		this.quantidadeExemplares = quantidadeExemplares;
	}	
	
	public static int getTotalLivrosJaCadastrados() {
		return totalLivrosJaCadastrados;
	}

	public static void setTotalLivrosJaCadastrados(int totalLivrosJaCadastrados) {
		Livro.totalLivrosJaCadastrados = totalLivrosJaCadastrados;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getQuantidadeExemplares() {
		return quantidadeExemplares;
	}

	public void aumentarQuantidadeExemplares() {
		this.quantidadeExemplares++;
	}
	
	public void diminuirQuantidadeExemplares() {
		this.quantidadeExemplares--;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null)
			return false;

		if (this == obj)
			return true;		

		if (obj instanceof Livro) {
			Livro outroLivro = (Livro) obj;

			if(outroLivro.getCodigo() == null || 
					outroLivro.getTitulo() == null || 
					outroLivro.getAutor() == null || 
					outroLivro.getEditora() == null ||
					outroLivro.getIsbn() == null ||
					outroLivro.getCategoria() == null)
				return false;

			if(outroLivro.getCodigo().equalsIgnoreCase(this.codigo) &&
					outroLivro.getTitulo().equalsIgnoreCase(this.titulo) &&
					outroLivro.getAutor().equalsIgnoreCase(this.autor) &&					
					(outroLivro.getEdicao() == this.edicao) &&
					outroLivro.getEditora().equalsIgnoreCase(this.editora) &&
					(outroLivro.getNumeroPaginas() == this.numeroPaginas) &&
					outroLivro.getIsbn().equalsIgnoreCase(this.isbn) &&
					outroLivro.getCategoria().equalsIgnoreCase(this.categoria))
				return true;
		}

		return false;
	}

	@Override
	public String toString() {
		return "Código: " + codigo + " | Título: " + titulo +
				"\nNúmero de exemplares: " + quantidadeExemplares + " | Autor: " + autor + 
				"\nEditora: " + editora  + " | " + numeroPaginas + " páginas | Edição: " + edicao +
				"\nISBN: " + isbn + " | Categoria: " + categoria;
	}

	@Override
	public int compareTo(Livro arg0) { 		

		int comparacao= this.titulo.compareToIgnoreCase(arg0.getTitulo());

		if(comparacao == 0)
			comparacao= this.isbn.compareToIgnoreCase(arg0.getIsbn());

		return comparacao;
	}
}