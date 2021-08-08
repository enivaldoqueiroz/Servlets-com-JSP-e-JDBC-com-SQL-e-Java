package filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/principal/*"})//Intercepta todas as requisi��es que vieram do projeto ou mapeamento
public class FilterAutenticacao implements Filter {
    
    public FilterAutenticacao() {
        
    }
	
    //Encerra os processos quando o servidor � padado
    //Enterronpe os processos de conex�o com banco
	public void destroy() {
		
	}
	
	//Intercepta as requisi��es e as repostas no sistema
	//Tudo que fizer no sistema vai fazer por aqui
	//Validar autenica��o
	//Dar commit e rolback de transa��es do banco
	//Validar e fazer redirecionamento de paginas
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		String usuarioLogado = (String) session.getAttribute("usuario");
		
		String urlParaAutenticar = req.getServletPath(); //URL que est� sendo acessada
		
		//Validar se est� logado se n�o redireciona para a tela de login
		if(usuarioLogado == null || (usuarioLogado != null && usuarioLogado.isEmpty()) && 
				!urlParaAutenticar.contains("ServletLogi")) {
			RequestDispatcher redireciona = request.getRequestDispatcher("index.jsp?url=" + urlParaAutenticar);
			request.setAttribute("msg", "Por realize o login!!");
		}
		
		chain.doFilter(request, response);
	}

	//Inicia os processos ou recursos  quando o servidor sobe o projeto
	//Inicia a conex�o com o banco
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
