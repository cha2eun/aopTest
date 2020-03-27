package com.bit.exam01;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bit.dao.GoodsDao;
import com.bit.dao.MemberDao;

public class MainTest {

	public static void main(String[] args) {
		//
		ApplicationContext context = new ClassPathXmlApplicationContext("com/bit/exam01/beans.xml");
		MemberDao mdao = (MemberDao)context.getBean("mDao");
		GoodsDao gdao = (GoodsDao)context.getBean("gDao");
		
		mdao.insertMember("유관순", 20);
		mdao.updateMember();
		ArrayList<String> list = mdao.listMember();
		for( String m : list) {
			System.out.println(m);
		}
		
		gdao.insertGoods("옥수수", 3000);
		ArrayList<String> goods = gdao.list();
		for(String g : goods) {
			System.out.println(g);
		}
	}

}
