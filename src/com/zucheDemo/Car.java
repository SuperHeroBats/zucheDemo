package com.zucheDemo;
//新建Car类

public abstract class Car {
	
	private String type;
	private int price;
	//设置两个私有属性，只允许本类使用
	//与public不同的是，public对外开放
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	//设置set和get方法调用内部变量
	//private和set get方法是一套的，需要设置内部属性再进行调用
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString() {
		return type + "\t" + price;
	}
	//设置toString，返回两个属性值
	//toString用于输出字符串
}


