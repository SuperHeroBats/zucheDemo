package com.zucheDemo;

public class CarPickup extends Car implements ICargo, IPassenger {

	private int passCapacity;
	private int cargoCapacity;
	//ע�Ϳ�CarBus��ͬ������
	
	@Override
	public int getPassCapacity() {
		// TODO �Զ����ɵķ������
		return passCapacity;
	}

	@Override
	public void setPassCapacity(int passCapacity) {
		// TODO �Զ����ɵķ������
		this.passCapacity = passCapacity;
	}

	@Override
	public int getCargoCapacity() {
		// TODO �Զ����ɵķ������
		return cargoCapacity;
	}

	@Override
	public void setCargoCapacity(int cargoCapacity) {
		// TODO �Զ����ɵķ������
		this.cargoCapacity = cargoCapacity;
	}
	
	public CarPickup(String type,int price,int passCapacity,int cargoCapacity){
		
		this.setCargoCapacity(cargoCapacity);
		this.setPassCapacity(passCapacity);
		this.setPrice(price);
		this.setType(type);
	}
	
	public String toString(){
		return super.toString() + "\t" + passCapacity + "\t" + cargoCapacity;
	}

}
