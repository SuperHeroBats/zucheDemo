package com.zucheDemo;

public class CarPickup extends Car implements ICargo, IPassenger {

	private int passCapacity;
	private int cargoCapacity;
	//注释看CarBus，同样道理
	
	@Override
	public int getPassCapacity() {
		// TODO 自动生成的方法存根
		return passCapacity;
	}

	@Override
	public void setPassCapacity(int passCapacity) {
		// TODO 自动生成的方法存根
		this.passCapacity = passCapacity;
	}

	@Override
	public int getCargoCapacity() {
		// TODO 自动生成的方法存根
		return cargoCapacity;
	}

	@Override
	public void setCargoCapacity(int cargoCapacity) {
		// TODO 自动生成的方法存根
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
