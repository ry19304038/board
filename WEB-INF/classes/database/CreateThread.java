
package database;

import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

import bean.ThreadListProfile;

public class CreateThread{

	public static void executeInsert(ThreadListProfile cbean){
		try{

			String th_title=cbean.getTh_title();
			String th_name=cbean.getTh_name();
			String th_category=cbean.getTh_category();
			String th_description=cbean.getTh_description();
			String th_date=cbean.getTh_date();
			System.out.println(th_title);
			System.out.println(th_name);

			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("CreateThread");

			//Oracleに接続する
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"cprimeuser","cprime");
			System.out.println("接続完了");

			//select文
			// 他のをやりたかったらここを変える
			// String sql=" SELECT empno,ename FROM emp";

			// スレッドIDの最後を取得
			// String thred_id="SELECT MAX(th_id)+1 FROM board_thread";
			// →NULLが戻ってくる

			// th_idの最大を求め、isEmptyでNULLかの判定を行っている


			String sql="SELECT MAX(th_id) FROM board_thread";
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(sql);

			rs.next();
			String thread_id=rs.getString(1);
			if(thread_id==null){
				thread_id="0";
			}
			int thread_id1=Integer.parseInt(thread_id);
			thread_id1 +=1;



			sql="INSERT INTO board_thread(th_id, th_title, th_name, th_category, th_description)VALUES("+thread_id1+",'"+th_title+"','"+th_name+"', '"+th_category+"','"+th_description+"')";

			// select文を実行しResultSetインターフェイスを実装したクラスのインスタンスが返る
			int i=st.executeUpdate(sql);
			System.out.print(i);
			System.out.println(sql);



			//Oracleから切断する
			cn.close();

			System.out.println("切断完了");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("クラスがないみたい。");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQL関連の例外みたい。");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
