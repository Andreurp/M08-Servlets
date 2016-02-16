package enquesta;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class resultatServlet
 */
@WebServlet("/resultatServlet")
public class resultatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Integer>begudes;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public resultatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig conf) throws ServletException {
    	begudes=(HashMap<String, Integer>) conf.getServletContext().getAttribute("begudes");
    	super.init();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//PrintWriter resultat = response.getWriter();
		/*for(Entry<String, Integer> b: begudes.entrySet()){
			//resultat.println(b.getKey()+": "+b.getValue()+"<br>");
			//System.out.println("\t"+j.getKey()+": "+j.getValue());
			resultat.append(b.getKey()+": "+b.getValue()+"<br>");
		}*/
		/*
		for(Entry<String, Integer> b: begudes.entrySet()){
			request.setAttribute(b.getKey(),b.getValue());
		}*/
		request.setAttribute("begudes", begudes);
		request.getRequestDispatcher("resultat.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
