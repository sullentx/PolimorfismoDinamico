package org.example.polimorfismodinamico.models;

import java.util.ArrayList;

public class DataBase01 implements DatabaseManager{
    private ArrayList<Student>dataBase01 = new ArrayList<>();

    public DataBase01() {

    }


    @Override
    public void addStudent(Student student) {
        dataBase01.add(student);
    }

    @Override
    public void update(Student student,int indice) {
        dataBase01.set(indice,student);
    }


    public ArrayList<Student> getDataBase01() {
        return dataBase01;
    }

    public DataBase01(ArrayList<Student> dataBase01) {
        this.dataBase01 = dataBase01;
    }

    public void setDataBase01(ArrayList<Student> dataBase01) {
        this.dataBase01 = dataBase01;
    }

    public boolean idRepetido(int id) {
        for (Student student : dataBase01) {
            if (student.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
