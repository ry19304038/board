import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.List;

import bean.ResProfile;
import database.InsertTest;
import database.listQuery;
import database.QueryTest;
import database.CreateThread;
import database.ResListQuery;
import bean.ThreadListProfile;
import database.listQuery;
import kaigyou.kaigyou;
import error.NoidException;


public class CPrimeThread extends HttpServlet{
  public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException,NoidException{

    //文字コード固定
    req.setCharacterEncoding("Windows-31J");

    System.out.println("CPrimeThread 21");
    // 入力画面からデータを取得する
    String th_id=req.getParameter("id");
  	String res_name=TextConversion.textReplace(req.getParameter("res_name"));
    String res_text=TextConversion.textReplace(req.getParameter("res_text"));


    System.out.println(res_name);
    System.out.println(res_text);
    System.out.println(th_id);

    if(th_id==null||th_id.length()==0){
      throw new NoidException("スレッドを選択しろ",null);
    }

    // ResProfileをインスタンス化し、データをセットする
    ResProfile ResProfile = new ResProfile();
    ResProfile.setRes_name(res_name);
    ResProfile.setRes_text(res_text);
    ResProfile.setTh_id(th_id);
    // ResProfile.setRes_kaigyou(altertext);


    String altertext = kaigyou.Kaigyou(res_text);

    // CBeanごとinsertに入れる
    InsertTest.executeInsert(ResProfile);
    System.out.println(th_id);

    List<ResProfile> ResList = ResListQuery.getQueryList(th_id);
    req.setAttribute("ResList", ResList);

    List<ThreadListProfile> ThreadList = listQuery.getQueryList();
    req.setAttribute("ThreadList", ThreadList);

    System.out.println(th_id);

    System.out.println("ResList 25");
    req.setAttribute("th_id",th_id);
    RequestDispatcher dis = req.getRequestDispatcher("iti?th_id="+th_id);

    dis.forward(req, res);
  }
}
