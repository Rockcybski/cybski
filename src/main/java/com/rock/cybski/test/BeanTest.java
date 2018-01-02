package com.rock.cybski.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {
	private MainBean bean;
	public void p() {
		bean.print();
	}
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-bean-test.xml");
		BeanTest b = ac.getBean(BeanTest.class);
		b.p();
	}
	public MainBean getBean() {
		return bean;
	}
	public void setBean(MainBean bean) {
		this.bean = bean;
	}
}
