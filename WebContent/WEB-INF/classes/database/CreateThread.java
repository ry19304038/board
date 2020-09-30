
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

	public static void CreateThread(ThreadListProfile cbean){
		try{

			String th_title=cbean.getTh_title();
			String th_name=cbean.getTh_name();
			String th_category=cbean.getTh_category();
			String th_description=cbean.getTh_description();
			String th_date=cbean.getTh_date();
			System.out.println(th_title);
			System.out.println(th_name);

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String className = new Object(){}.getClass().getName();
			System.out.println(className);
			System.out.println("CreateThread");
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"cprimeuser","cprime");



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

			int i=st.executeUpdate(sql);
			System.out.print(i);
			System.out.println(sql);



			cn.close();

		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
