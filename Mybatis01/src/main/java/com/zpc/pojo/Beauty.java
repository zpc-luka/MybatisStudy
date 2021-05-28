package com.zpc.pojo;

// 实体类
public class Beauty {
    private int id;
    private String name;
    private String sex;
    private int boyfriend_id;

    public Beauty() {

    }

    public Beauty(int id, String name, String sex, int boyfriend_id) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.boyfriend_id = boyfriend_id;
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

    public int getBoyfriend_id() {
        return boyfriend_id;
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

    public void setBoyfriend_id(int boyfriend_id) {
        this.boyfriend_id = boyfriend_id;
    }

    @Override
    public String toString() {
        return "Beauty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", boyfriend_id=" + boyfriend_id +
                '}';
    }
}
