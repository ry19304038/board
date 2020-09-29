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

			//Oracle�ɐڑ�����
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","cprimeuser","cprime");
			System.out.println("�ڑ�����");

			//select��
			String sql="select res_id, res_name, res_title,res_text,res_likes from res_table WHERE res_thread_id = '"+id+"' order by res_no";

			//Statement�C���^�[�t�F�C�X����������N���X���C���X�^���X������
			Statement st=cn.createStatement();

			//select�������s��
			//ResultSet�C���^�[�t�F�C�X�����������N���X��
			//�C���X�^���X���Ԃ�
			ResultSet rs=st.executeQuery(sql);

			//�J�[�\������s�����X�N���[�����A�f�[�^���t�F�b�`����
			while(rs.next()){
				ResProfile prof = new ResProfile();

				String res_count = rs.getString(1);	//1��ڂ̃f�[�^���擾
				String res_id = rs.getString(2);	//2��ڂ̃f�[�^���擾
				String res_name = rs.getString(3);		//3��ڂ̃f�[�^���擾
				String res_text = rs.getString(4);		//6��ڂ̃f�[�^���擾
				String res_likes = rs.getString(5);		//7��ڂ̃f�[�^���擾
				prof.setRes_count(res_count);
				prof.setRes_id(res_id);
				prof.setRes_name(res_name);
				prof.setRes_text(res_text);
				prof.setRes_likes(res_likes);


				userList.add(prof);

				//System.out.println("username"+"\t"+"password"); //�m�F�\��
				//System.out.println(name+"\t"+pass);				//�m�F���̂Q
			}


			//Oracle����ؒf����
			cn.close();

			System.out.println("�ؒf����");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("�N���X���Ȃ��݂����B");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQL�֘A�̗�O�݂����B");
		}catch(Exception e){
			e.printStackTrace();
		}
		return userList;

	}
}
