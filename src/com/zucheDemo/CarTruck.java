package com.zucheDemo;
//新建货车类，只能载货

public class CarTruck extends Car implements ICargo {
	
	public CarTruck(String type,int price,int cargoCapacity){
		this.setType(type);
		this.setPrice(price);
		this.setCargoCapacity(cargoCapacity);
	}
	//注释看CarBus，同样道理
	
	private int cargoCapacity;
	
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
	
	public String toString(){
		return super.toString() + "\t---\t" + cargoCapacity;
	}

}

//自动转换文件编码UTF-8
