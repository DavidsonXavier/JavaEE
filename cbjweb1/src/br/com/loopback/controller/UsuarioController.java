package br.com.loopback.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.loopback.entidade.Usuario;
import br.com.loopback.jdbc.UsuarioDAO;


@WebServlet("/usucontroller.do")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UsuarioController() {
        super();
  
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		System.out.println("Chamando m�todo GET");
//		String nome = request.getParameter("nome");
//		System.out.println("Nome:"+ nome);
//		
//		PrintWriter saida =response.getWriter();
//		saida.println("Nome:"+ nome);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//doGet(request, response);
		System.out.println("Chamando m�todo Post");
		
		String nome=request.getParameter("txtnome");
		String login=request.getParameter("txtlogin");
		String senha=request.getParameter("txtsenha");
		
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setNome(nome);
		usuario.setSenha(senha);
		
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.cadastrar(usuario);
		
		PrintWriter saida =response.getWriter();
		saida.println("Cadastrado");
	}

}
