package ent;
import java.util.*;
public class orders {
    private int id;
    private int storeid;
    private int customerid;
    private int flowerid;
    private int count;
    private float price;
    private Date time;
    private boolean status;
    public orders() {
        id=0;
        storeid=0;
        customerid=0;
        flowerid=0;
        count=0;
        price=0;
        time=new Date(0);
        status=false;
    }

    public orders(int id, int storeid, int customerid, int flowerid, int count, float price, Date time,boolean status) {
        this.id = id;
        this.storeid = storeid;
        this.customerid = customerid;
        this.flowerid = flowerid;
        this.count = count;
        this.price = price;
        this.time = time;
        this.status=status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public boolean getStatus(){
        return status;
    }
    public int getId() {
        return id;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public float getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public int getCustomerid() {
        return customerid;
    }

    public int getFlowerid() {
        return flowerid;
    }

    public int getStoreid() {
        return storeid;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public void setFlowerid(int flowerid) {
        this.flowerid = flowerid;
    }

    public void setStoreid(int storeid) {
        this.storeid = storeid;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
