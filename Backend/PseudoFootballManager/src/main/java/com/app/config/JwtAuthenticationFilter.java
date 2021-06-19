package com.app.config;




import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.app.helper.JwtUtil;
import com.app.service.CustomUserServiceImpl;
import com.app.service.ICustomUserService;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private ICustomUserService customUtilService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)throws ServletException, IOException {
		//get jwt 
		//bearer
		//validate
		
		String requestTokenHeader =request.getHeader("Authorization");
		System.out.println("token "+requestTokenHeader);
		String userName=null;
		String jwtToken=null;
		if(requestTokenHeader !=null)// && requestTokenHeader.startsWith("Bearer ")) //space gives intentionally
		{
			jwtToken=requestTokenHeader;//.substring(7);
			System.out.println("jwt token inside "+jwtToken);
			try {
				userName = this.jwtUtil.extractUsername(jwtToken);
				UserDetails userDetails =this.customUtilService.loadUserByUsername(userName);
				if(userName !=null && SecurityContextHolder.getContext().getAuthentication()==null)
				{
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=
											new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
					usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
						
				}
				else 
				{
					System.out.println("Token Not Validated");
				}
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		filterChain.doFilter(request, response);
		
	}

	
}

