package org.example.polimorfismodinamico.models;

import java.util.ArrayList;

public class DataBase03 implements DatabaseManager{
    private ArrayList<Student> dataBase03= new ArrayList<>();

    public DataBase03() {

    }

    @Override
    public void addStudent(Student student) {
        dataBase03.add(student);
    }

    @Override
    public void update(Student student, int indice) {
        dataBase03.set(indice,student);
    }



    public void setDataBase03(ArrayList<Student> dataBase03) {
        this.dataBase03 = dataBase03;
    }

    public DataBase03(ArrayList<Student> dataBase03) {
        this.dataBase03 = dataBase03;
    }


}
