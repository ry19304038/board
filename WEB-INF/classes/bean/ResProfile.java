package bean;
import java.io.Serializable;

public class ResProfile implements Serializable{
    private String res_name;
    private String res_text;
    private String res_likes;
    private String res_count;
    private String res_id;
    private String th_id;
    private String res_date;
    private String kaigyou;


    public void setRes_name(String res_name){
        this.res_name=res_name;
    }
    public String getRes_name(){
        return res_name;
    }
    public void setRes_text(String res_text){
        this.res_text=res_text;
    }
    public String getRes_text(){
        return res_text;
    }

    public void setRes_likes(String res_likes){
        this.res_likes=res_likes;
    }
    public String getRes_likes(){
        return res_likes;
    }
    public void setRes_count(String res_count){
        this.res_count=res_count;
    }
    public String getRes_count(){
        return res_count;
    }
    public void setRes_id(String res_id){
        this.res_id=res_id;
    }
    public String getRes_id(){
        return res_id;
    }

    public void setTh_id(String th_id){
        this.th_id=th_id;
    }
    public String getTh_id(){
        return th_id;
    }

    public void setRes_date(String res_date){
        this.res_date=res_date;
    }
    public String getRes_date(){
        return res_date;
    }
    // public void setRes_kaigyou(String kaigyou){
    //     this.kaigyou=kaigyou;
    // }
    // public String getRes_kaigyou(){
    //     return kaigyou;
    // }

}
