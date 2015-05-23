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
* @author Dave Wichers <a href="https://www.aspectsecurity.com">Aspect Security</a>
* @created 2015
*/

package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12687")
public class BenchmarkTest12687 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

		String bar = new Test().doSomething(param);
		
        try {
	    	java.util.Random numGen = java.security.SecureRandom.getInstance("SHA1PRNG");
        	boolean randNumber = getNextNumber(numGen);
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println("Problem executing SecureRandom.nextBoolean() - TestCase");
            throw new ServletException(e);
        }

        response.getWriter().println("Weak Randomness Test java.security.SecureRandom.nextBoolean() executed");
	}
	
	boolean getNextNumber(java.util.Random generator) {
		return generator.nextBoolean();
	
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a49072 = param; //assign
		StringBuilder b49072 = new StringBuilder(a49072);  // stick in stringbuilder
		b49072.append(" SafeStuff"); // append some safe content
		b49072.replace(b49072.length()-"Chars".length(),b49072.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map49072 = new java.util.HashMap<String,Object>();
		map49072.put("key49072", b49072.toString()); // put in a collection
		String c49072 = (String)map49072.get("key49072"); // get it back out
		String d49072 = c49072.substring(0,c49072.length()-1); // extract most of it
		String e49072 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d49072.getBytes() ) )); // B64 encode and decode it
		String f49072 = e49072.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f49072); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
