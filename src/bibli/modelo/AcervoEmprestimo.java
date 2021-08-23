package bibli.modelo;

import java.time.LocalDateTime;
import java.util.HashMap;

public class AcervoEmprestimo {

	private static HashMap<String, Emprestimo> emprestimos= new HashMap<String, Emprestimo>();

	public static HashMap<String, Emprestimo> getEmprestimos() {

		return emprestimos;
	}

	public static int getNumeroEmprestimos() {

		return emprestimos.size();
	}

	public static boolean verificarExistencia(String codigo) {

		return emprestimos.containsKey(codigo);		
	}
	
	public static boolean verificarAtividade(String codigo) {

		return emprestimos.get(codigo).isAtivo();		
	}
	
	public static boolean verificarEmprestimosAtivosPorUsuario(String codigo){ 

		int quantidade= 0;

		for(Emprestimo emprestimo : emprestimos.values()) 
			if(emprestimo.isAtivo() &&
					emprestimo.getUsuario().getCodigo().equalsIgnoreCase(codigo)) 
				quantidade++;	

		return quantidade > 0;
	}
	
	public static Emprestimo buscarEmprestimo(String codigo) {

		return emprestimos.get(codigo);
	}

	public static HashMap<String, Emprestimo> buscarEmprestimosPorLivro(String codigo){

		HashMap<String, Emprestimo> emprestimosEncontrados= new HashMap<String, Emprestimo>();

		for(Emprestimo emprestimo : emprestimos.values()) 
			if(emprestimo.getExemplar().getLivro().getCodigo().toLowerCase().equals(codigo.toLowerCase())) 
				emprestimosEncontrados.put(emprestimo.getCodigo(), emprestimo);	

		return emprestimosEncontrados;
	}

	public static HashMap<String, Emprestimo> buscarEmprestimosPorUsuario(String codigo){

		HashMap<String, Emprestimo> emprestimosEncontrados= new HashMap<String, Emprestimo>();

		for(Emprestimo emprestimo : emprestimos.values()) 
			if(emprestimo.getUsuario().getCodigo().toLowerCase().equals(codigo.toLowerCase())) 
				emprestimosEncontrados.put(emprestimo.getCodigo(), emprestimo);	

		return emprestimosEncontrados;
	}

	public static void adicionarEmprestimo(Emprestimo emprestimo) {

		emprestimos.put(emprestimo.getCodigo(), emprestimo);
	}

	public static Emprestimo editarEmprestimo(Emprestimo emprestimoAtualizado) {

		return emprestimos.replace(emprestimoAtualizado.getCodigo(), emprestimoAtualizado);
	}

	public static Emprestimo removerEmprestimo(String codigo) {

		return emprestimos.remove(codigo);
	}

	public static HashMap<String, Emprestimo> buscarEmprestimosVencidos() {
		
		HashMap<String, Emprestimo> emprestimosEncontrados= new HashMap<String, Emprestimo>();
		
		for(Emprestimo emprestimo : emprestimos.values()) 
			if(emprestimo.getDataLimite().isBefore(LocalDateTime.now()))
				emprestimosEncontrados.put(emprestimo.getCodigo(), emprestimo);	
		
		return emprestimosEncontrados;
	}	
}
