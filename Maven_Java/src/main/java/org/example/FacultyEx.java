package org.example;

import java.util.ArrayList;
import java.util.List;

public class FacultyEx {
    public static void main(String[] args) {
        Person sahak = new Person.PersonBuilder().setFirstname("Sahak").setLastname("Sahakyan").setAge(17).build();
        Person erik = new Person.PersonBuilder().setFirstname("Erik").setLastname("Sarukhanyan").setAge(17).build();
        Person arsen = new Person.PersonBuilder().setFirstname("Arsen").setLastname("Balyan").setAge(16).build();
        Person martin = new Person.PersonBuilder().setFirstname("Martin").setLastname("Tonoyan").setAge(16).build();
        Person levon = new Person.PersonBuilder().setFirstname("Levon").setLastname("Martirosyan").setAge(17).build();
        Person simon = new Person.PersonBuilder().setFirstname("Simon").setLastname("Mkoyan").setAge(18).build();

        Faculty faculty = new Faculty("Inform");
        Faculty faculty2 = new Faculty("Menegment");

        faculty.setAddFaculty(sahak);
        faculty.setAddFaculty(arsen);
        faculty.setAddFaculty(erik);

        faculty2.setAddFaculty(levon);
        faculty2.setAddFaculty(simon);
        faculty2.setAddFaculty(martin);

        List<Faculty> facultyList = new ArrayList<>(); // [[faculty.getFacultyList()->facultyList.stream()], [faculty2]]
        facultyList.add(faculty);
        facultyList.add(faculty2);

        facultyList.stream().flatMap(e -> e.getFacultyList().stream()).forEach(System.out::println);
    }
}
class Faculty {
    private final String name;
    private final List<Person> facultyList;

    public Faculty(String name) {
        this.name = name;
        this.facultyList = new ArrayList<>();
    }

    public void setAddFaculty(Person list) {
        facultyList.add(list);
        System.out.println("Element was add !");
    }

    public String getName() {
        return name;
    }

    public List<Person> getFacultyList() {
        return facultyList;
    }
}