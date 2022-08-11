package com.product;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductDetail
 */
@WebServlet("/ProductDetail")
public class ProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
			int Product_ID = Integer.parseInt(req.getParameter("id"));
			PrintWriter out = res.getWriter();
			res.setContentType("text/html");
			out.println("<html><body>");
			
			Connection con = DBconnection.getMyConnection();
			String query="select*from product where id = ?";

			if (Product_ID <=2) {
				//if (con != null) {

					try {

						PreparedStatement ps = con.prepareStatement(query);
						ps.setInt(1, Product_ID);
						ResultSet pd = ps.executeQuery();
						out.println("<table border=1 cellpadding=10 cellspacing=0> <thead><tr>");
						out.println("<th>id</th><th>product</th><th>cost</th>");
						out.println("<tr></thead>");
						out.println("<tbody>");
						
						// ResultSetMetaData rsmd = pd.getMetaData();
						while (pd.next()) {
							out.println("<tr>");
							out.print(pd.getInt(1)+" "+pd.getString(2)+" "+pd.getInt(3)+"<br>");
							out.print("'<td>'"+pd.getInt(1)+"'</td><td>'"+pd.getString(2)+"'</td><td>'"+pd.getInt(3)+"'</td>'");
							out.print("</tr>");
							
					}
						out.print("</tbody></table>");}
						catch (SQLException e) {
						e.printStackTrace();} 
			//}
			
//				else {
//					out.print("Error");
//				}
			
			}
			 else {
				out.println("Invalid ID");
			 }
			
		}



		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}
}
		

