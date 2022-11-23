package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class StreamAPIEx {
    public static void main(String[] args) {

        Set<Person> personSet = new TreeSet<>();
        personSet.add(new Person.PersonBuilder().setFirstname("Sahak").setLastname("Sahakyan").setAge(17).build());
        personSet.add(new Person.PersonBuilder().setFirstname("Erik").setLastname("Sarukhanyan").setAge(17).build());
        personSet.add(new Person.PersonBuilder().setFirstname("Martin").setLastname("Tonoyan").setAge(16).build());
        personSet.add(new Person.PersonBuilder().setFirstname("Arsen").setLastname("Balyan").setAge(16).build());
        personSet.add(new Person.PersonBuilder().setFirstname("Levon").setLastname("Martirosyan").setAge(17).build());
        personSet.add(new Person.PersonBuilder().setFirstname("Simon").setLastname("Mkoyan").setAge(18).build());
        //System.out.println(personSet);

//      ----------------------|   Stream Map   |----------------------
        /*List<Person> list = new ArrayList<>();
        list.add(new Person.PersonBuilder().setFirstname("Sahak").setLastname("Sahakyan").setAge(17).build());
        list.add(new Person.PersonBuilder().setFirstname("Erik").setLastname("Sarukhanyan").setAge(17).build());
        list.add(new Person.PersonBuilder().setFirstname("Arsen").setLastname("Balyan").setAge(16).build());
        list.add(new Person.PersonBuilder().setFirstname("Martin").setLastname("Tonoyan").setAge(16).build());
        list.add(new Person.PersonBuilder().setFirstname("Levon").setLastname("Martirosyan").setAge(17).build());
        list.add(new Person.PersonBuilder().setFirstname("Simon").setLastname("Mkoyan").setAge(18).build());
        System.out.println(list);
        list = list.stream().map(e->
                new Person.PersonBuilder()
                    .setFirstname(String.valueOf(e.getFirstname().length()))
                    .setAge(e.getAge())
                    .setLastname(String.valueOf(e.getLastname().length()))
                    .build()
            ).collect(Collectors.toList());
        System.out.println(list);*/
//      ----------------------| End Stream Map |----------------------

//      ----------------------|   Stream Filter   |----------------------
        /*personSet = personSet.stream().filter(e->e.getAge() > 16).collect(Collectors.toSet());
        System.out.println(personSet);*/
//      ----------------------| End Stream Filter |----------------------

//      ----------------------|   Stream ForEach   |----------------------
        /*Stream<Person> stream = personSet.stream();
        stream.forEach(System.out::println);*/
//      ----------------------| End Stream ForEach |----------------------

//      ----------------------|   Stream Reduce   |----------------------
        /*List<Integer> integers = new ArrayList<>();
        integers.add(5);
        integers.add(75);
        integers.add(10);
        integers.add(69);
        integers.add(1);
        integers.add(33);
        Stream<Integer> stream = integers.stream();
        Optional<Integer> optional = stream.reduce((a,e) -> a*e);
        optional.ifPresent(System.out::println);*/
//      ----------------------| End Stream Reduce |----------------------

//      ----------------------|   Stream Sorted   |----------------------
        /*List<Integer> integers = new ArrayList<>();
        integers.add(5);
        integers.add(75);
        integers.add(24);
        integers.add(82);
        integers.add(22);
        integers.add(26);
        integers.add(10);
        integers.add(69);
        integers.add(1);
        integers.add(33);
        System.out.println(integers.stream().sorted().collect(Collectors.toList()));*/
//      ----------------------| End Stream Sorted |----------------------

//      ----------------------|   Stream Method Chaining   |----------------------
        /*Stream<Person> personStream = personSet.stream();
        personStream
                .map(e-> new Person.PersonBuilder().setFirstname(e.getFirstname().toUpperCase())
                        .setLastname(e.getLastname().toUpperCase())
                        .setAge(e.getAge())
                        .build())
                .filter(e-> e.getAge() > 16)
                .forEach(System.out::println);
                //.reduce((a,e) -> new Person.PersonBuilder().setAge(a.getAge() + e.getAge()).build())
                    //.ifPresent(System.out::println);*/
//      ----------------------| End Stream Method Chaining |----------------------

//      ----------------------|   Stream ConCat   |----------------------
        /*List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list1.add("e");
        List<String> list2 = new ArrayList<>();
        list2.add("f");
        list2.add("g");
        list2.add("h");
        list2.add("i");
        list2.add("j");

        List<String> list3 = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
        list3.forEach(System.out::println);*/
//      ----------------------| End Stream ConCat |----------------------

//      ----------------------|   Stream Distinct   |----------------------
        /*List<String> list1 = new ArrayList<>();
        list1.add("b");
        list1.add("c");
        list1.add("a");
        list1.add("e");
        list1.add("d");
        list1.add("a");
        list1.add("b");
        list1.add("z");
        list1.add("c");
        list1.add("q");
        Stream<String> stream =list1.stream();
//        System.out.println(stream.peek(System.out::println).count());
        //Throws IllegalStateException --- Stream has already been operated upon or closed
        System.out.println(stream.distinct().peek(System.out::println).count());*/
//      ----------------------| End Stream Distinct |----------------------

//      ----------------------|   Stream Collect by grouping  |----------------------
        Map<Integer, List<Person>> map = personSet.stream().collect(Collectors.groupingBy(Person::getAge));
        for (Map.Entry<Integer, List<Person>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
//      ----------------------| End Stream Collect by grouping |----------------------

    }
}

class Person implements Comparable<Person> {
    private final String firstname;
    private final String lastname;
    private final int age;
    private final String passportId;

    private Person(String firstname, String lastname, int age, String passportId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.passportId = passportId;
    }

    @Override
    public int compareTo(Person o) {
        int x = this.firstname.compareTo(o.firstname);
        if (x == 0) {
            x = this.lastname.compareTo(o.lastname);
            if (x == 0) {
                return this.age - o.getAge();
            }
            return x;
        }
        return x;
    }

    public static class PersonBuilder {
        private String firstname;
        private String lastname;
        private int age;
        private String passportId;

        public PersonBuilder setFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public PersonBuilder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public PersonBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public Person build() {
            return new Person(firstname, lastname, age, generatePassportId());
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

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", passportId='" + passportId + '\'' +
                '}';
    }



}