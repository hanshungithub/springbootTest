package cn.hassan.webcrud.entities;

import lombok.Data;

@Data
public class Department {

	private Integer id;
	private String departmentName;

	public Department(Integer id, String departmentName) {
		this.id = id;
		this.departmentName = departmentName;
	}
}
