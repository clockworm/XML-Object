package com.nue.xml.test;

import java.io.StringReader;
import java.util.UUID;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.junit.Test;
import com.nue.xml.entity.Book;
import com.nue.xml.entity.Student;
import lombok.Cleanup;
import lombok.SneakyThrows;

public class TestXML {
	@Test
	@SneakyThrows
	public void ObjectToXML() {
		JAXBContext jc = JAXBContext.newInstance(Student.class);
		Marshaller ms = jc.createMarshaller();
		Student student = new Student();
		Book book = new Book();
		book.setId(UUID.randomUUID().toString().replace("-", ""));
		book.setBookName("我爱中华");
		book.setPrice(23.82);
		student.setBook(book);
		student.setId(UUID.randomUUID().toString());
		student.setAge(16);
		student.setSex("男");
		student.setStuName("张晓华");
		ms.marshal(student, System.out);
		System.out.println();
		System.out.println();
	}

	@Test
	@SneakyThrows
	public void XMLToObject() {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><student><age>16</age><book><bookName>我爱中华</bookName><id>eef3b89d-71c4-48b0-8cac-ddc90387376c</id><price>23.82</price></book><id>5d95cb60-db6d-4225-ac1b-103c569f7da1</id><sex>男</sex><stuName>张晓华</stuName></student>";
		JAXBContext jc = JAXBContext.newInstance(Student.class);
		Unmarshaller us = jc.createUnmarshaller();
		@Cleanup StringReader reader = new StringReader(xml);
		Student stu = (Student) us.unmarshal(reader);
		System.out.println(stu.getBook());
		System.out.println(stu.getBook().getBookName());
		System.out.println(stu.getStuName());
	}
}
