package com.MicroserviceProject.productservice.dto;

public class PersonsResponse {
    private int person_id;
    private String first_name;
    private String last_name;

    @Override
    public String toString() {
        return "Persons{" +
                "id=" + person_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }

    public int getId() {
        return person_id;
    }

    public void setId(int id) {
        this.person_id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
