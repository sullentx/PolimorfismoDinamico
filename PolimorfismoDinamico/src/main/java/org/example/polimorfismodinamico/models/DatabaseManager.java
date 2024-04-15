package org.example.polimorfismodinamico.models;

import java.util.ArrayList;

public interface DatabaseManager {
    void addStudent(Student student);
    void update(Student student, int indice);

}
