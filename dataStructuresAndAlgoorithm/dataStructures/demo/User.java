package dataStructuresAndAlgoorithm.dataStructures.demo;

import java.util.Date;
import java.util.Objects;

/**
 * @Author: ruan
 * Date: 2021/8/20 11:09
 * @Description:
 */
public class User {
    private int age;
    private String name;
    private Date time;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public int hashCode(){
        //int code = age/name.length()+time.hashCode();
        //return code;
        return Objects.hash(age,name,time);
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return age == user.age && Objects.equals(name,user.name) && Objects.equals(time,user.time);
    }
}
