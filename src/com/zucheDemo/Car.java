package com.zucheDemo;
//�½�Car��

public abstract class Car {
	
	private String type;
	private int price;
	//��������˽�����ԣ�ֻ������ʹ��
	//��public��ͬ���ǣ�public���⿪��
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	//����set��get���������ڲ�����
	//private��set get������һ�׵ģ���Ҫ�����ڲ������ٽ��е���
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString() {
		return type + "\t" + price;
	}
	//����toString��������������ֵ
	//toString��������ַ���
}


