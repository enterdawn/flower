package ent;

public class flowerstore {
    private int id;
    private String name;
    private String phone;
    private String address;
    private String username;
    private String password;
    public flowerstore(){
        id=0;
        name="";
        phone="";
        address="";
        username="";
        password="";
    }
    public flowerstore(int id,String name,String address,String phone,String username,String password){
        this.id=id;
        this.name=name;
        this.address=address;
        this.phone=phone;
        this.username=username;
        this.password=password;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getPhone(){
        return phone;
    }
    public String getAddress(){
        return address;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
