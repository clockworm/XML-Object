package com.nue.xml.entity;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String bookName;
	private double price;
}
