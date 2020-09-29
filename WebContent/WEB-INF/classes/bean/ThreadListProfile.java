package bean;
import java.io.Serializable;

public class ThreadListProfile implements Serializable{
  private String th_id;
  private String th_title;
  private String th_name;
  private String th_description;
  private String th_date;
  private String th_category;

  public void setTh_title(String th_title){
    this.th_title = th_title;
  }

  public String getTh_title(){
    return th_title;
  }
  public void setTh_name(String th_name){
    this.th_name = th_name;
  }

  public String getTh_name(){
    return th_name;
  }
  public void setTh_description(String th_description){
    this.th_description = th_description;
  }

  public String getTh_description(){
    return th_description;
  }
  public void setTh_date(String th_date){
    this.th_date = th_date;
  }

  public String getTh_date(){
    return th_date;
  }

  public void setTh_category(String th_category){
    this.th_category = th_category;
  }

  public String getTh_category(){
    return th_category;
  }
  public void setTh_id(String th_id){
    this.th_id = th_id;
  }

  public String getTh_id(){
    return th_id;
  }

}
