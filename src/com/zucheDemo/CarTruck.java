package com.zucheDemo;
//�½������ֻ࣬���ػ�

public class CarTruck extends Car implements ICargo {
	
	public CarTruck(String type,int price,int cargoCapacity){
		this.setType(type);
		this.setPrice(price);
		this.setCargoCapacity(cargoCapacity);
	}
	//ע�Ϳ�CarBus��ͬ������
	
	private int cargoCapacity;
	
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
	
	public String toString(){
		return super.toString() + "\t---\t" + cargoCapacity;
	}

}
