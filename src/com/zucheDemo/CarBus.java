package com.zucheDemo;
//�½��ͳ��ֻ࣬���ؿ�

public class CarBus extends Car implements IPassenger {

	
	public CarBus (String type,int price,int passCapacity){
		this.setType(type);
		this.setPrice(price);
		this.setPassCapacity(passCapacity);
	}
	//public CarBus���췽�� ��������ֵ
	
	private int passCapacity;
	
	@Override
	public int getPassCapacity() {
		return passCapacity;
	}

	@Override
	public void setPassCapacity(int passCapacity) {
		this.passCapacity = passCapacity;
	}
	//����passCapacity���ԣ�set��get��������
	
	@Override
	public String toString() {
		return super.toString() + "\t" + passCapacity + "\t---";
	}
	//���CarBusֵ
	//super�Ǽ̳и���
	
}
