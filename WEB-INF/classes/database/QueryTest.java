package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import bean.ResProfile;

public class QueryTest{

	public static List<ResProfile> getQueryList(String id){

		List<ResProfile> userList = new ArrayList<ResProfile>();


		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracleに接続する
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","cprimeuser","cprime");
			System.out.println("接続完了");

			//select文
			String sql="select res_id, res_name, res_title,res_text,res_likes from res_table WHERE res_thread_id = '"+id+"' order by res_no";

			//Statementインターフェイスを実装するクラスをインスタンス化する
			Statement st=cn.createStatement();

			//select文を実行し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			ResultSet rs=st.executeQuery(sql);

			//カーソルを一行だけスクロールし、データをフェッチする
			while(rs.next()){
				ResProfile prof = new ResProfile();

				String res_count = rs.getString(1);	//1列目のデータを取得
				String res_id = rs.getString(2);	//2列目のデータを取得
				String res_name = rs.getString(3);		//3列目のデータを取得
				String res_text = rs.getString(4);		//6列目のデータを取得
				String res_likes = rs.getString(5);		//7列目のデータを取得
				prof.setRes_count(res_count);
				prof.setRes_id(res_id);
				prof.setRes_name(res_name);
				prof.setRes_text(res_text);
				prof.setRes_likes(res_likes);


				userList.add(prof);

				//System.out.println("username"+"\t"+"password"); //確認表示
				//System.out.println(name+"\t"+pass);				//確認その２
			}


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
		return userList;

	}
}
