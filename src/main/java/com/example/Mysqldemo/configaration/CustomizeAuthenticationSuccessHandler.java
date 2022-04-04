package com.example.Mysqldemo.configaration;

/**
 * Importing all the packages whatever needed in class
 * 
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import org.springframework.stereotype.Component;

/**
 * @Component is an annotation that allows Spring to automatically detect our
 *            custom beans.
 * 
 *            And implements Spring Security `AuthenticationSuccessHandler` by
 *            adding this annotation to the class.
 */
@Component
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	/**
	 * @override method for custom landing page after successful login.
	 * 
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// set our response to OK status
		response.setStatus(HttpServletResponse.SC_OK);

		for (GrantedAuthority auth : authentication.getAuthorities()) {
			if ("ADMIN".equals(auth.getAuthority())) {
				response.sendRedirect("/dashboard");
			} 
			
			else if ("ADMIN".equals(auth.getAuthority())) {
				response.sendRedirect("/productadd");
			}

			else if ("ADMIN".equals(auth.getAuthority())) {
				response.sendRedirect("/productlist");
			}

			else if ("USER".equals(auth.getAuthority())) {
				response.sendRedirect("/userproductlist");
			}

			else if ("ADMIN".equals(auth.getAuthority())) {
				response.sendRedirect("/productupdate/{id}");
			}

			else if ("ADMIN".equals(auth.getAuthority())) {
				response.sendRedirect("/productdelete/{id}");
			}

			else if ("ADMIN".equals(auth.getAuthority())) {
				response.sendRedirect("/productdetails");
			}

			else if ("USER".equals(auth.getAuthority())) {
				response.sendRedirect("/userProductdetails/{id}");
			}

			else if ("ADMIN".equals(auth.getAuthority())) {
				response.sendRedirect("/categoryadd");
			}

			else if ("ADMIN".equals(auth.getAuthority())) {
				response.sendRedirect("/categorylist");
			}

			else if ("USER".equals(auth.getAuthority())) {
				response.sendRedirect("/categorylist");
			}

			else if ("ADMIN".equals(auth.getAuthority())) {
				response.sendRedirect("/categoryupdate/{id}");
			}

			else if ("ADMIN".equals(auth.getAuthority())) {
				response.sendRedirect("/categorydelete/{id}");
			}

			else if ("ADMIN".equals(auth.getAuthority())) {
				response.sendRedirect("/indexCategory");
			}

			else if ("ADMIN".equals(auth.getAuthority())) {
				response.sendRedirect("/supplieradd");
			}

			else if ("ADMIN".equals(auth.getAuthority())) {
				response.sendRedirect("/supplierlist");
			}

			else if ("ADMIN".equals(auth.getAuthority())) {
				response.sendRedirect("/supplierupdate/{id}");
			}

			else if ("ADMIN".equals(auth.getAuthority())) {
				response.sendRedirect("/supplierdelete/{id}");
			}

			else if ("ADMIN".equals(auth.getAuthority())) {
				response.sendRedirect("/indexSupplier");
			}

			else if ("USER".equals(auth.getAuthority())) {
				response.sendRedirect("/welcomeOrderPage");
			}

			else if ("ADMIN".equals(auth.getAuthority())) {
				response.sendRedirect("/search");
			} 
			
			else if ("USER".equals(auth.getAuthority())) {
				response.sendRedirect("/userSearch");
			}
		}
	}
}
