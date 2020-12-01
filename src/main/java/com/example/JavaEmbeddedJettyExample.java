/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class JavaEmbeddedJettyExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws Exception {
		int portHttp;
		try {
			portHttp = Integer.valueOf(System.getenv("PORT"));
		} catch (Exception e) {
			portHttp = 8080;
		}
		Server server = new Server(portHttp);
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		server.setHandler(context);
		context.addServlet(new ServletHolder(new JavaEmbeddedJettyExample()), "/*");
		server.start();
		server.join();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// HTML file
		resp.getWriter().print("<h1>1st Java-Jetty app running on Heroku!</h1>\n");
		resp.getWriter().print("<h2>os.name: " + System.getProperty("os.name") + "</h2>\n");
		resp.getWriter().print("<h2>os.version: " + System.getProperty("os.version") + "</h2>\n");
		resp.getWriter().print("<h2>os.arch: " + System.getProperty("os.arch") + "</h2>\n");
		resp.getWriter().print("<h2>java.version: " + System.getProperty("java.version") + "</h2>\n");
		resp.getWriter().print("<h2>java.runtime.version: " + System.getProperty("java.runtime.version") + "</h2>\n");
	}
}
