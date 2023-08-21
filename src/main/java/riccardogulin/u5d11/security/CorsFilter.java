package riccardogulin.u5d11.security;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// ************************* CORS (CROSS-ORIGIN RESOURCE SHARING)
// **************************

// I browser di default adottano la Same Origin Policy, una politica stringente
// che non permette
// richieste http su origin differenti da quella del frontend

// ************ Esempi di origin differenti ***************
// http://localhost:3000 e http://localhost:3001 sono 2 diverse origin perché
// hanno porta diversa
// https://fe.com e https://be.com sono 2 diverse origin perché sono 2 domini
// diversi
// https://domain.com e http://domain.com sono 2 diverse origin perché hanno
// protocolli diversi

// Quello che possiamo fare è configurare il backend in maniera che istruisca il
// frontend affinchè sia più permissivo. Ciò significa configurare CORS per
// "rilassare" questa stringente politica

@Component
public class CorsFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
		response.setHeader("Access-Control-Allow-Methods", "*");
		response.setHeader("Access-Control-Allow-Headers", "*");
		response.setHeader("Access-Control-Allow-Max-Age", "3600");

		if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
			response.setStatus(HttpServletResponse.SC_OK); // <-- 200 OK
		} else { // "GET", "POST", "PUT", "DELETE", ecc ecc...
			filterChain.doFilter(request, response);
		}
	}
}
