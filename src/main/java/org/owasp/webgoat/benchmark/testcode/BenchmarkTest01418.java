/**
* OWASP WebGoat Benchmark Edition (WBE) v1.1
*
* This file is part of the Open Web Application Security Project (OWASP)
* WebGoat Benchmark Edition (WBE) project. For details, please see
* <a href="https://www.owasp.org/index.php/WBE">https://www.owasp.org/index.php/WBE</a>.
*
* The WBE is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The WBE is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details
*
* @author Nick Sanidas <a href="https://www.aspectsecurity.com">Aspect Security</a>
* @created 2015
*/

package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01418")
public class BenchmarkTest01418 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a17050 = param; //assign
		StringBuilder b17050 = new StringBuilder(a17050);  // stick in stringbuilder
		b17050.append(" SafeStuff"); // append some safe content
		b17050.replace(b17050.length()-"Chars".length(),b17050.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map17050 = new java.util.HashMap<String,Object>();
		map17050.put("key17050", b17050.toString()); // put in a collection
		String c17050 = (String)map17050.get("key17050"); // get it back out
		String d17050 = c17050.substring(0,c17050.length()-1); // extract most of it
		String e17050 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d17050.getBytes() ) )); // B64 encode and decode it
		String f17050 = e17050.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g17050 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g17050); // reflection
		
		
		try {
			double rand = java.security.SecureRandom.getInstance("SHA1PRNG").nextDouble();
	    } catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing SecureRandom.nextDouble() - TestCase");
			throw new ServletException(e);
	    }
		
		response.getWriter().println("Weak Randomness Test java.security.SecureRandom.nextDouble() executed");
	}
}
