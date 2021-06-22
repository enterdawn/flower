package ent;

public class customerent {
    private int id;
    private String Usernam;
    private int gender;
    private String password;
    private String name;
    private String phone;
    public customerent(){
        id=0;
        Usernam="";
        gender=0;
        password="";
        name="";
        phone="";
    }

    public customerent(int id,String Usernam,int gender,String password,String name,String phone) {
        this.id=id;
        this.Usernam=Usernam;
        this.gender=gender;
        this.password=password;
        this.name=name;
        this.phone=phone;
    }
    public int getid(){
        return id;
    }
    public String getusername(){
        return this.Usernam;
    }
    public int getgender(){
        return gender;
    }
    public String getpassword(){
        return password;
    }
    public String getname(){
        return name;
    }
    public String getphone(){
        return phone;
    }
    public void setid(int id){
        this.id=id;
    }
    public void setusername(String username){
        this.Usernam=username;
    }
    public void setgender(int gender){
        this.gender=gender;
    }
    public void setpassword(String password){
        this.password=password;
    }
    public void setname(String name){
        this.name=name;
    }
    public void setphone(String phone){
        this.phone=phone;
    }

}
