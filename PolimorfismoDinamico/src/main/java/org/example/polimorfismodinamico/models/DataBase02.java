package org.example.polimorfismodinamico.models;

import java.util.ArrayList;

public class DataBase02 implements DatabaseManager{
    private  ArrayList<Student> dataBase02= new ArrayList<>();

    public DataBase02() {

    }

    @Override
    public void addStudent(Student student) {
        dataBase02.add(student);
    }

    @Override
    public void update(Student student, int indice) {
        dataBase02.set(indice,student);
    }


    public DataBase02(ArrayList<Student> dataBase02) {
        this.dataBase02 = dataBase02;
    }

    public void setDataBase02(ArrayList<Student> dataBase02) {
        this.dataBase02 = dataBase02;
    }


}
