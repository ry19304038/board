import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.List;
import java.util.Iterator;

import bean.ThreadListProfile;
import database.listQuery;

public class ThreadListServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		doPost(req,res);
	}
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{

    req.setCharacterEncoding("Windows-31J");
    List<ThreadListProfile> ThreadList = listQuery.getQueryList();
    req.setAttribute("ThreadList", ThreadList);


    System.out.println("ThradListServlet");
    RequestDispatcher dis = req.getRequestDispatcher("iti");

    dis.forward(req, res);
  }
}
