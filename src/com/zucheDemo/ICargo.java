package com.zucheDemo;
//新建可载货车接口

public interface ICargo {
	public int getCargoCapacity();
	public void setCargoCapacity(int cargoCapacity);
	//接口只允许public 所以生成get和set两个成员
}
