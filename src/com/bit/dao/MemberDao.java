package com.bit.dao;

import java.util.ArrayList;

import com.bit.exam01.ProfilingAdvice;

public class MemberDao {
	private ProfilingAdvice advice = new ProfilingAdvice();
	public int insertMember(String name,int age) {
		System.out.println("ȸ�����");
		 return 1;
	}
	public void updateMember() {
		System.out.println("ȸ�� ����");
	}
	public ArrayList<String > listMember(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("�̼���");
		list.add("������");
		list.add("������");
		return list;
	}

}
