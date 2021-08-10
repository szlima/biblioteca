package bibli.aplicacao;

import bibli.controle.ControladorLivro;
import bibli.controle.MenuExemplar;
import bibli.controle.MenuLivro;
import bibli.modelo.Livro;

public class Principal {

	public static void main(String[] args) {
		
		Livro livro1= new Livro("Polianna", "Eleanor Porter", 1, "Pé de Letra", 184, "978-8595201170", "Clássico");
		Livro livro2= new Livro("O Mundo de Sofia", "Jostein Gaarder", 1, "Seguinte", 568, "9788535921892", "Romance");
		Livro livro3= new Livro("A Seleção", "Kiera Cass", 1, "Seguinte", 368, "9788565765015", "Young adult");
		Livro livro4= new Livro("A Elite", "Kiera Cass", 1, "Seguinte", 360, "9788565765121", "Young adult");
		Livro livro5= new Livro("O Menino do Pijama Listrado", "John Boine", 1, "Seguinte", 192, "9788535911121", "Ficção infantil");

		//		Livro livro6= new Livro("O Menino do Pijama Listrado", "John Boine", 1, "Seguinte", 192, "9788535911121", "Ficção infantil");	
	//	Livro livroNaoCadastrado= new Livro("A Costureira", "Kate Alcott", 1, "Geração", 376, "9788581301310", "Romance");	

		//1--------------------------------------------------------------------------------------
		boolean resultadoOperacao= MenuLivro.adicionarLivro(livro1.getTitulo(), livro1.getAutor(), 
				livro1.getEdicao(), livro1.getEditora(), livro1.getNumeroPaginas(), 
				livro1.getIsbn(), livro1.getCategoria());

		if(resultadoOperacao)
			System.out.println("Livro \"" + livro1.getTitulo() + "\" adicionado.");
		else
			System.out.println("Operação não realizada.");

		//2----------------------------------------------------------------------------------------
		resultadoOperacao= MenuLivro.adicionarLivro(livro2.getTitulo(), livro2.getAutor(), 
				livro2.getEdicao(), livro2.getEditora(), livro2.getNumeroPaginas(), 
				livro2.getIsbn(), livro2.getCategoria());

		if(resultadoOperacao)
			System.out.println("Livro \"" + livro2.getTitulo() + "\" adicionado.");
		else
			System.out.println("Operação não realizada.");

		//3----------------------------------------------------------------------------------------
		resultadoOperacao= MenuLivro.adicionarLivro(livro3.getTitulo(), livro3.getAutor(), 
				livro3.getEdicao(), livro3.getEditora(), livro3.getNumeroPaginas(), 
				livro3.getIsbn(), livro3.getCategoria());

		if(resultadoOperacao)
			System.out.println("Livro \"" + livro3.getTitulo() + "\" adicionado.");
		else
			System.out.println("Operação não realizada.");

		//4----------------------------------------------------------------------------------------
		resultadoOperacao= MenuLivro.adicionarLivro(livro4.getTitulo(), livro4.getAutor(), 
				livro4.getEdicao(), livro4.getEditora(), livro4.getNumeroPaginas(), 
				livro4.getIsbn(), livro4.getCategoria());

		if(resultadoOperacao)
			System.out.println("Livro \"" + livro4.getTitulo() + "\" adicionado.");
		else
			System.out.println("Operação não realizada.");

		//5----------------------------------------------------------------------------------------
		resultadoOperacao= MenuLivro.adicionarLivro(livro5.getTitulo(), livro5.getAutor(), 
				livro5.getEdicao(), livro5.getEditora(), livro5.getNumeroPaginas(), 
				livro5.getIsbn(), livro5.getCategoria());

		if(resultadoOperacao)
			System.out.println("Livro \"" + livro5.getTitulo() + "\" adicionado.");
		else
			System.out.println("Operação não realizada.");

		MenuLivro.exibirLivrosTotal();

		for(Livro livro : ControladorLivro.getLivros().values())	{

			resultadoOperacao= MenuExemplar.adicionarExemplar(livro);

			if(resultadoOperacao)
				System.out.println("Exemplar adicionado.");
			else
				System.out.println("Operação não realizada.");



			resultadoOperacao= MenuExemplar.adicionarExemplar(livro);

			if(resultadoOperacao)
				System.out.println("Exemplar adicionado.");
			else
				System.out.println("Operação não realizada.");

		}

		MenuExemplar.exibirExemplaresTotal();

		System.out.println("\nBuscando livro pelo ISBN \"9788565765015\"");
		MenuLivro.exibirLivro("9788565765015");					

		System.out.println("\nBuscando livros pelo autor \"Kiera Cass\"");
		MenuLivro.exibirLivrosPorAutor("Kiera Cass");

		System.out.println("\nBuscando livros pelo título \"O Mundo de Sofia\"");
		MenuLivro.exibirLivrosPorTitulo("O Mundo de Sofia");


		System.out.println("\nEditando livro \"Pollyana\"");
		String novoTitulo= "Pollyana", novoAutor= livro1.getAutor(), 
				novaEditora= livro1.getEditora(), novaCategoria= livro1.getCategoria();
		int novaEdicao= 1, novoNumeroPaginas= 184;

		resultadoOperacao= MenuLivro.editarLivro(novoTitulo, novoAutor, novaEdicao, novaEditora, novoNumeroPaginas, livro1.getIsbn(), novaCategoria);

		if(resultadoOperacao)
			System.out.println("Livro \"Pollyana\" editado.");
		else
			System.out.println("Operação não realizada.");


		MenuLivro.exibirLivrosTotal();	
		MenuExemplar.exibirExemplaresTotal();


		System.out.println("\nExcluindo livro e exemplares de \"O Mundo de Sofia\"");
		MenuLivro.removerLivro(livro2.getIsbn());		


		MenuLivro.exibirLivrosTotal();	
		MenuExemplar.exibirExemplaresTotal();

		System.out.println("Removendo exemplares do livro5= \"O Menino do Pijama Listrado\"");
		MenuExemplar.removerExemplares(livro5);		
		

		System.out.println("Removendo exemplar 6 (é do livro \"Pollyana\")");
		MenuExemplar.removerExemplar("6");				
		
		System.out.println("Editando exemplar10 (colocando como o livro \"A Seleção\")");
		MenuExemplar.editarExemplar("10", livro3);
		
		System.out.println("Removendo exemplares do livro4= \"A Elite\"");
		MenuExemplar.removerExemplares("9788565765121");
		

		MenuLivro.exibirLivrosTotal();	
		MenuExemplar.exibirExemplaresTotal();

	}

}