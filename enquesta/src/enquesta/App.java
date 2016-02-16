package enquesta;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class App
 */
@WebServlet("/enquesta")
public class App extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private HashMap<String, Integer>begudes = new HashMap<>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public App() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig conf) throws ServletException {
    	conf.getServletContext().setAttribute("begudes", begudes);
    	super.init();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("formulari.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int temp=0;
		
		String bagudaSeleccionada = request.getParameter("beguda");
		if(begudes.containsKey(bagudaSeleccionada)){
			temp=begudes.get(bagudaSeleccionada);
		}
		begudes.put(bagudaSeleccionada, temp+1);
		request.getRequestDispatcher("resultatServlet").forward(request, response);
		//doGet(request,response);
	}

}
