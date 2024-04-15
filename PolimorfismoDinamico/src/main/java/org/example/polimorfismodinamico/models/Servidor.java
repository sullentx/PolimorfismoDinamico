package org.example.polimorfismodinamico.models;

public class Servidor {
    private DataBase01 dataBase01;
    private DataBase02 dataBase02;
    private DataBase03 dataBase03;
    public Servidor() {
        this.dataBase01 = new DataBase01();
        this.dataBase02 = new DataBase02();
        this.dataBase03 = new DataBase03();
    }
    public DataBase01 getDataBase01() {
        return dataBase01;
    }

    public DataBase02 getDataBase02() {
        return dataBase02;
    }

    public DataBase03 getDataBase03() {
        return dataBase03;
    }

}
