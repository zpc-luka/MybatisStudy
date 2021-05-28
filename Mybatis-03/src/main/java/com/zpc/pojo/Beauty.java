package com.zpc.pojo;

// 实体类
public class Beauty {
    private int id;
    private String name;
    private String sex;
    private int boyfriend;

    public Beauty() {

    }

    public Beauty(int id, String name, String sex, int boyfriend) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.boyfriend = boyfriend;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getBoyfriend() {
        return boyfriend;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBoyfriend(int boyfriend) {
        this.boyfriend = boyfriend;
    }

    @Override
    public String toString() {
        return "Beauty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", boyfriend=" + boyfriend +
                '}';
    }
}
