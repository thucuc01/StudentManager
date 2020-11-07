package love;

import java.io.Serializable;

public class Person implements Serializable {
    int id;
    String name;
    byte age;
    String address;


    public Person() {
    }

    public Person(int id, String name, byte age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
