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

@WebServlet("/BenchmarkTest12939")
public class BenchmarkTest12939 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		java.io.File file = new java.io.File(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a83395 = param; //assign
		StringBuilder b83395 = new StringBuilder(a83395);  // stick in stringbuilder
		b83395.append(" SafeStuff"); // append some safe content
		b83395.replace(b83395.length()-"Chars".length(),b83395.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map83395 = new java.util.HashMap<String,Object>();
		map83395.put("key83395", b83395.toString()); // put in a collection
		String c83395 = (String)map83395.get("key83395"); // get it back out
		String d83395 = c83395.substring(0,c83395.length()-1); // extract most of it
		String e83395 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d83395.getBytes() ) )); // B64 encode and decode it
		String f83395 = e83395.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f83395); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
