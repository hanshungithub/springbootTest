package cn.hassan.webcrud.entities;

import lombok.Data;

import java.util.Date;

@Data
public class Employee {

	private Integer id;
    private String lastName;

    private String email;
    //1 male, 0 female
    private Integer gender;
    private Department department;
    private Date birth;

    public Employee(Integer id, String lastName, String email, Integer gender, Department department, Date birth) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.birth = birth;
    }

    public Employee(int i, String s, String s1, int i1, Department department) {
    }
}
