package org.example.polimorfismodinamico.models;

import java.util.Objects;

public class Student {
    public String name;
    public String lastName;
    public String secondLastName;
    public int id;
    public String age;

    public Student(String name, String lastName, String secondLastName, int id, String age) {
        this.name = name;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.id = id;
        this.age = age;
    }

    public Student() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public int getId() {
        return id;
    }

    public String getAge() {
        return age;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Estudiante");
        stringBuilder.append("  Nombre: ").append(name).append("\n");
        stringBuilder.append("  Apellido Paterno: ").append(lastName).append("\n");
        stringBuilder.append("  Apellido Materno: ").append(secondLastName).append("\n");
        stringBuilder.append("  Matricula: ").append(id).append("\n");
        stringBuilder.append("  Edad: ").append(age).append("\n");
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(secondLastName, student.secondLastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(secondLastName);
    }
}
