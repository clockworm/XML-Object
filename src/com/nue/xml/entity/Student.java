package com.nue.xml.entity;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String stuName;
	private int age;
	private String sex;
	private Book book;
}
