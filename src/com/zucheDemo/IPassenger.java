package com.zucheDemo;
//新建可载客车接口

public interface IPassenger {
	public int getPassCapacity();
	public void setPassCapacity(int passCapacity);
	//接口只允许public 所以生成get和set两个成员
}
