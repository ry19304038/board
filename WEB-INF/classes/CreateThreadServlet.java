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
    req.setCharacterEncoding("Windows-31J");

    System.out.println("ThreadServlet17");
    // 入力画面からデータを取得する
  	String th_title=TextConversion.textReplace(req.getParameter("th_title"));
  	String th_name=TextConversion.textReplace(req.getParameter("th_name"));
    String th_category=req.getParameter("c1");
    String th_description=req.getParameter("th_description");

    // CBeanをインスタンス化し、データをセットする
    ThreadListProfile ThreadListProfile = new ThreadListProfile();
    ThreadListProfile.setTh_title(th_title);
    ThreadListProfile.setTh_name(th_name);
    ThreadListProfile.setTh_category(th_category);
    ThreadListProfile.setTh_description(th_description);

    // CBeanごとinsertに入れる
    CreateThread.executeInsert(ThreadListProfile);

    // CreateThreadに引数を渡す
    // CreateThread.ThreadInsert(th_title,th_name);

    System.out.println("ThreadServlet31");
    RequestDispatcher dispatcher=
    req.getRequestDispatcher("ThreadList");
    System.out.println("ThreadServlet37");
    dispatcher.forward(req,res);


    }
}
