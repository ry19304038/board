package kaigyou;

public class kaigyou{
	public static String Kaigyou(String res_text){
		String altertext;

		while(true){
			if(res_text.indexOf("\r\n")>=0){
				altertext=res_text.replace("\r\n","<br>");
			}else{
				altertext=res_text;
			}
			break;
		}

		return altertext;
	}
}
