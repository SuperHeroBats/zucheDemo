package com.zucheDemo;
//新建客车类，只能载客

public class CarBus extends Car implements IPassenger {

	
	public CarBus (String type,int price,int passCapacity){
		this.setType(type);
		this.setPrice(price);
		this.setPassCapacity(passCapacity);
	}
	//public CarBus构造方法 传递属性值
	
	private int passCapacity;
	
	@Override
	public int getPassCapacity() {
		return passCapacity;
	}

	@Override
	public void setPassCapacity(int passCapacity) {
		this.passCapacity = passCapacity;
	}
	//设置passCapacity属性，set和get方法调用
	
	@Override
	public String toString() {
		return super.toString() + "\t" + passCapacity + "\t---";
	}
	//输出CarBus值
	//super是继承父类
	
}

//自动转换文件编码UTF-8
