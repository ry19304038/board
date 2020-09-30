import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;

import bean.ThreadListProfile;
import database.CreateThread;

public class CreateThreadServlet extends HttpServlet{
  public void doPost(HttpServletRequest req,HttpServletResponse res)
  throws IOException,ServletException{
    req.setCharacterEncoding("UTF-8");

    System.out.println("CreateThreadServlet");

  	String th_title=TextConversion.textReplace(req.getParameter("th_title"));
  	String th_name=TextConversion.textReplace(req.getParameter("th_name"));
    String th_category=req.getParameter("c1");
    String th_description=req.getParameter("th_description");

    ThreadListProfile ThreadListProfile = new ThreadListProfile();
    ThreadListProfile.setTh_title(th_title);
    ThreadListProfile.setTh_name(th_name);
    ThreadListProfile.setTh_category(th_category);
    ThreadListProfile.setTh_description(th_description);

    CreateThread.executeInsert(ThreadListProfile);

    // CreateThread�Ɉ�����n��
    // CreateThread.ThreadInsert(th_title,th_name);

    RequestDispatcher dispatcher=
    req.getRequestDispatcher("ThreadListServlet");
    dispatcher.forward(req,res);


    }
}
