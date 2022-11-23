package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class StudentsAndStreamEx {
    public static void main(String[] args) {
        Student sahak = new Student.StudentBuilder()
                .setFirstname("Sahak")
                .setLastname("Sahakyan")
                .setAge(17)
                .setCourse(3)
                .setAvgGrade(9.9)
                .build();
        Student erik = new Student.StudentBuilder()
                .setFirstname("Erik").
                setLastname("Sarukhanyan")
                .setAge(17)
                .setCourse(3)
                .setAvgGrade(7)
                .build();
        Student martin = new Student.StudentBuilder()
                .setFirstname("Martin")
                .setLastname("Tonoyan")
                .setAge(16)
                .setCourse(1)
                .setAvgGrade(6)
                .build();
        Student arsen = new Student.StudentBuilder()
                .setFirstname("Arsen")
                .setLastname("Balyan")
                .setAge(16)
                .setCourse(2)
                .setAvgGrade(8.5)
                .build();
        Student levon = new Student.StudentBuilder()
                .setFirstname("Levon")
                .setLastname("Martirosyan")
                .setAge(17)
                .setCourse(2)
                .setAvgGrade(7.9)
                .build();
        Student simon = new Student.StudentBuilder()
                .setFirstname("Simon")
                .setLastname("Mkoyan")
                .setAge(18)
                .setCourse(2)
                .setAvgGrade(7.4)
                .build();

        List<Student> students = new ArrayList<>();
            students.add(sahak);
            students.add(erik);
            students.add(martin);
            students.add(arsen);
            students.add(levon);
            students.add(simon);

//      ----------------------|   Stream Collectors.groupingBy(...)   |----------------------
        /*Map<Integer, List<Student>> map1 = students
                .stream()
                .sorted((e1, e2) -> {
                    int x = e1.getCourse() - e2.getCourse();
                    if (x == 0) {
                        double y = e1.getAvgGrade() - e2.getAvgGrade();
                        if (y == 0) return e1.getAge() - e2.getAge();
                        return (int) y;
                    }
                    return x;
                })
                .collect(Collectors.groupingBy(Student::getCourse));

        for (Map.Entry<Integer, List<Student>> map : map1.entrySet()) {
            System.out.println(map.getKey() + ": " + map.getValue());
        }*/
//      ----------------------| End Stream Collectors.groupingBy(...) |----------------------

//      ----------------------|   Stream Collectors.partitioningBy(...)   |----------------------
        /*Map<Boolean, List<Student>> map2 = students
                .stream()
                .sorted((e1, e2) -> {
                    int x = e1.getCourse() - e2.getCourse();
                    if (x == 0) {
                        double y = e1.getAvgGrade() - e2.getAvgGrade();
                        if (y == 0) return e1.getAge() - e2.getAge();
                        return (int) y;
                    }
                    return x;
                })
                .collect(Collectors.partitioningBy(e -> e.getAvgGrade() > 8.0));

        for (Map.Entry<Boolean, List<Student>> map : map2.entrySet()) {
            System.out.println(map.getKey() + ": " + map.getValue());
        }*/
//      ----------------------| End Stream Collectors.partitioningBy(...) |----------------------

//      ----------------------|   Stream FindFirst   |----------------------
        /*Optional<Student> optional = students.stream().findFirst();
        optional.ifPresent(System.out::println);*/
//      ----------------------| End Stream FindFirst |----------------------

//      ----------------------|   Stream Min and Max   |----------------------
        /*students.stream().min(Student::compareTo).ifPresent(System.out::println);
        students.stream().max(Student::compareTo).ifPresent(System.out::println);*/
//      ----------------------| End Stream Min and Max |----------------------

//      ----------------------|   Stream Limit   |----------------------
        //System.out.println(students.stream().sorted(Student::compareTo).filter(e -> e.getAvgGrade() > 7.8).limit(2).collect(Collectors.toList()));
//      ----------------------| End Stream Limit |----------------------

//      ----------------------|   Stream Skip   |----------------------
        /*System.out.println(students.stream().sorted(Student::compareTo).filter(e -> e.getAvgGrade() > 7.8).collect(Collectors.toList()));
        System.out.println(students.stream().sorted(Student::compareTo).filter(e -> e.getAvgGrade() > 7.8).skip(2).collect(Collectors.toList()));*/
//      ----------------------| End Stream Skip |----------------------

//      ----------------------|   Stream MapToInt   |----------------------
        /*List<Integer> integers = students.stream().mapToInt(Student::getCourse).boxed().collect(Collectors.toList());
        int sum = students.stream().mapToInt(Student::getCourse).sum();
        int max = students.stream().mapToInt(Student::getCourse).max().getAsInt();
        int min = students.stream().mapToInt(Student::getCourse).min().getAsInt();
        double average = students.stream().mapToDouble(Student::getAvgGrade).average().getAsDouble();
        System.out.println(integers);*/
//      ----------------------| End Stream MapToInt |----------------------
    }
}
class Student implements Comparable<Student> {
    private final String firstname;
    private final String lastname;
    private final int age;
    private final int course;
    private final double avgGrade;
    private final String passportId;

    private Student(String firstname, String lastname, int age, int course, double avgGrade, String passportId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.course = course;
        this.avgGrade = avgGrade;
        this.passportId = passportId;
    }

    public static class StudentBuilder {
        private String firstname;
        private String lastname;
        private int age;
        private int course;
        private double avgGrade;
        private String passportId;

        public StudentBuilder setFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public StudentBuilder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public StudentBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder setCourse(int course) {
            this.course = course;
            return this;
        }

        public StudentBuilder setAvgGrade(double avgGrade) {
            this.avgGrade = avgGrade;
            return this;
        }


        public Student build() {
            return new Student(firstname, lastname, age, course, avgGrade, generatePassportId());
        }

        private String generatePassportId() {
            StringBuilder s = new StringBuilder("");
            for (int i = 0; i < 16; i++) {
                int j = randomInteger();
                switch (j) {
                    case 0:
                        int min = 48;
                        int max = 57;
                        s.append((char) Math.floor(Math.random() * (max - min + 1) + min));
                        break;
                    case 1:
                        min = 65;
                        max = 90;
                        s.append((char) Math.floor(Math.random() * (max - min + 1) + min));
                        break;
                    case 2:
                        min = 97;
                        max = 122;
                        s.append((char) Math.floor(Math.random() * (max - min + 1) + min));
                        break;
                }
            }
            return String.valueOf(s);
        }

        private Integer randomInteger() {
            return new Random().nextInt(3);
        }
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getCourse() {
        return course;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", course=" + course +
                ", avgGrade=" + avgGrade +
                ", passportId='" + passportId + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student e2) {
        int x = this.getCourse() - e2.getCourse();
        if (x == 0) {
            double y = this.getAvgGrade() - e2.getAvgGrade();
            if (y == 0) return this.getAge() - e2.getAge();
            return (int) y;
        }
        return x;
    }

}