package com.levelup;

/**
 * Created by Daitin on 27.11.2016.
 */
class Person {
    @Rand(from = 20, to = 100)
    private int id;
    private String name;
    private String sername;

    public Person() {
    }

    public Person(String name, String sername) {
        this.name = name;
        this.sername = sername;
    }

    public Person(int id, String name, String sername) {
        this.id = id;
        this.name = name;
        this.sername = sername;
    }
    public static Person personFactoryMethod(String name, String sername) throws IllegalAccessException{
        Person p = new Person(name, sername);
        IntitRand.init(p);
        return p;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sername='" + sername + '\'' +
                '}';
    }
}
