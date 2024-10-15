package com.oliveirasantos.api;

import com.google.gson.Gson;

public class JsonExample {
    public static void main(String[] args){
            Person person = new Person(23,"Carlos");
            Gson gson = new Gson();
            String json = gson.toJson(person);
            System.out.println("JSON: "+json);

            String jsonRenonse = "{\"name\":\"John\",\"age\":30}";
            Person deserializedPerson = gson.fromJson(jsonRenonse, Person.class);
            System.out.println("Name: "+deserializedPerson.getName());
    }
}

class Person{
    private String name;
    public Person(int age, String name) {
        
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private int age;
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
