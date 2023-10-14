package org.example.person.mock;

import org.example.person.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonMock {

    private List<Person> mockedPersons = new ArrayList<>();

    public PersonMock() {
        createPersonMockList(10);
    }

    public void createPersonMockList(int amountPersons) {
        mockedPersons.clear();
        for (int i = 0; i < amountPersons; i++) {
            String name = "Person-" + i;
            String cpf = "0930384568" + i;
            String age = String.valueOf(i);

            createPersonMock(i, name, cpf, age);
        }
    }

    public Person createPersonMock(Integer id, String name, String cpf, String age) {
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        person.setCpf(cpf);
        person.setAge(age);
        this.mockedPersons.add(person);

        return person;
    }

    public List<Person> getMockedPersons() {
        return mockedPersons;
    }

    public void setMockedPersons(List<Person> mockedPersons) {
        this.mockedPersons = mockedPersons;
    }
}
