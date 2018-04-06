package com.zucheDemo;

import java.util.ArrayList;//添加元素
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;//聚合操作

public class InitialDemo {

	private static Scanner input = new Scanner(System.in);
	//创建一个输入对象
	
	//读取用户输入方法
	private static String getInput(){
		try{
			return input.next();
		}
		catch(Exception e){
			return null; //确保客户输入了内容
		}
		finally{
			input.nextLine();//防止下次调用时再读取错误
		}
		//输入的异常处理
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		System.out.println("***欢迎使用租车系统***");
		List<Car> carList = initCarList();
		//为了保证随时添加修改项目，使用list
		//***暂时不懂***
		
		for(;;){//设置无条件循环
			
			System.out.println("如果你要租车，请输入1；"+"退出请输入0.");
			
			int choice;
			try{
				choice = Integer.parseInt(getInput());
				//对输入值进行转换Integer
			}
			catch(Exception e){
				System.out.println("输入有误！请正确输入。");
				continue;
			}//异常处理，确保输入的数字，而不是其他字符。
			
			if(choice == 0) break;//如果输入0的话，结束循环
			else if(choice == 1){
				rentCars(carList);
				System.out.println();
			}
			else{
				System.out.println("指令有误！请正确输入。");
				continue;
			}//如果输入其他数字，重新循环
		}
		System.out.println("***感谢使用租车系统***");
	}
	
	//生成初始化的可租车列表
	private static List<Car> initCarList(){
		List<Car> carList = new ArrayList<Car>(); //泛型数组，初始化List，确保都是car类
		carList.add(new CarBus("小型客车",500,6));			
		carList.add(new CarBus("大型客车",1000,15));
		carList.add(new CarTruck("小型货车",400,2));
		carList.add(new CarTruck("大型货车",800,10));
		carList.add(new CarPickup("小型皮卡",500,2,1));
		carList.add(new CarPickup("大型皮卡",900,4,2));
		return carList;//添加完车返回List
	}//可随时使用carList.add添加新车，不用修改其他代码
	
	//输出租车列表，用到每一类中重写的toString方法
	private static void printCarList(List<Car> carList){
		System.out.println("以下是可用车型：");
		System.out.println("序号\t车型\t租金\t载客量\t载货量");
		for(int i = 0;i < carList.size();i++){
			System.out.println((i + 1) + "\t" + (carList.get(i)).toString());
		}
	}
	
	//客户选车功能，全部使用无需预先确定长度的list功能
	private static List<Car> selectCars(List<Car> carList){
		List<Integer> rentArray = new ArrayList<Integer>(); //储存客户选过的序号
		List<Car> selectCars = new ArrayList<Car>(); //储存用户选过的车
		System.out.println("请输入租车序号，以回车分隔。输入0结束。");
		for(;;){
			System.out.println("请输入车辆序号（1-" + carList.size() + "）：");
			boolean repeated = false;
			int carNum;
			try{
				carNum = Integer.parseInt(getInput());
			}
			catch(Exception e){
				System.out.println("输入不正确！请重新输入。");
				continue;
			}//异常处理,确保输入的是数字，不是其他字符
			
			if(carNum == 0) break;
			else if(carNum > 0 && carNum <= carList.size()){ //确保输入的数字在范围之内
				for(int i = 0;i< rentArray.size();i++){
					if(carNum == rentArray.get(i)){
						System.out.println("您已输入过该车型！请重新输入。");
						repeated = true;
						break; //如果输入的序号已经选择过，则重新选择
					}
				}
				if(!repeated){
					rentArray.add(carNum);
					selectCars.add((Car) carList.get(carNum - 1));
				}//如果输入没有重复，添加到车辆列表
			}
			else{
				System.out.println("输入不正确！请重新输入正确序号。");
				continue;
			}
		}
		return selectCars;//返回选好车的list
	}
	
	//读取租车数目功能
	private static int rentCount(){
		for(;;){
			System.out.println("请输入租车数量(1 - 50)：");
			int rentCount;
			try{
				rentCount = Integer.parseInt(getInput());
			}
			catch(Exception e){
				System.out.println("输入不正确！请重新输入。");
				continue;
			}//异常处理
			if(rentCount >= 1 && rentCount <=50)
				return rentCount;
			else System.out.println("输入不正确！请重新输入。");
		}
	}
	
	//对选好的车辆进行读取租车数量
	private static int[] rentNumArray(List<Car> carList){
			int[] rentNumArray = new int[carList.size()];//使用数组存储每种车的数量
			for(int i = 0;i< carList.size();i++){
				System.out.println("请输入选定列表里，第" + (i+1) + "辆车的租车数量：");
				rentNumArray[i] = rentCount();//调用读取租车数目的方法
			}
			return rentNumArray;//返回租车数目的数组
	}
	
	//读取租车天数功能
	private static int rentDays(){
		for(;;){
			System.out.println("请输入租车天数(1 - 365)：");
			int rentDays;
			
			try{
				rentDays = Integer.parseInt(getInput());
			}
			catch(Exception e){
				System.out.println("输入不正确！请重新输入。");
				continue;
			}//异常处理
			if(rentDays >= 1 && rentDays <= 365)
				return rentDays;
			else System.out.println("输入不正确！请重新输入。");
		}
	}
	
	//对选好的车辆进行读取租车天数
	private static int[] rentDayArray(List<Car> carList){
			int[] rentDayArray = new int[carList.size()];//使用数组存储每种车的天数
			for(int i = 0;i < carList.size();i++){
				System.out.println("请输入选定列表里，第" + (i+1) + "辆车的租车天数：");
				rentDayArray[i] = rentDays();//调用读取租车天数的方法
			}
			return rentDayArray;//返回租车天数的数组
	}
	
	//打印订单
	private static void printOrder(List<Car> carList,int[] rentNumArray,int[] rentDayArray){
		int[] rentSinglePriceTotal = new int[carList.size()];
		int[] rentSinglePassTotal = new int[carList.size()];
		int[] rentSingleCargoTotal = new int[carList.size()];
		//三个数组分别存储总价，总载客量，总载货量
		
		System.out.println("以下是您的订单：");
		System.out.println("序号\t车型\t租金\t载客量\t载货量" + "\t租用数量\t租用天数\t消费数额");
		for(int i = 0;i < carList.size();i++){
			rentSinglePriceTotal[i] = ((Car) carList.get(i)).getPrice() * rentNumArray[i] * rentDayArray[i];
			//计算每种车的总价
			System.out.println((i + 1) + "\t" + (carList.get(i)).toString() + "\t" + rentNumArray[i] + "\t" + rentDayArray[i] + "\t" + rentSinglePriceTotal[i]);
			
			try{
				rentSinglePassTotal[i] = ((CarBus) carList.get(i)).getPassCapacity() * rentNumArray[i];
			}
			catch(Exception eCarBus){
				try{
					rentSinglePassTotal[i] = ((CarPickup) carList.get(i)).getPassCapacity() * rentNumArray[i];
				}
				catch(Exception eCarPickup){
					rentSinglePassTotal[i] = 0;
				}
			}//双重try嵌套 如果车辆有载客功能，则存储一天的总载客量，否则为零

			try{
				rentSingleCargoTotal[i] = ((CarTruck) carList.get(i)).getCargoCapacity() * rentNumArray[i];
			}
			catch(Exception eCarTruck){
				try{
					rentSingleCargoTotal[i] = ((CarPickup) carList.get(i)).getCargoCapacity() * rentNumArray[i];
				}
				catch(Exception eCarPickup){
					rentSingleCargoTotal[i] = 0;
				}
			}//双重try嵌套 如果车辆有载货功能，则存储一天的总载货量，否则为零
		}
		int renTotal = IntStream.of(rentSinglePriceTotal).sum();
		int passCapacityTotal = IntStream.of(rentSinglePassTotal).sum();
		int cargoCapacityTotal = IntStream.of(rentSingleCargoTotal).sum();
		//将三个数组的值分别相加求和
		
		
		
		System.out.println("总载客量(人/天):" + passCapacityTotal);
		System.out.println("总载货量(吨/天):" + cargoCapacityTotal);
		System.out.println("订单总价(元):" + renTotal); //所有车订单总结
	}
	
	//开始租车
	private static void rentCars(List<Car> carList){
		printCarList(carList); //打印现有的车辆
		List<Car> selectCars = selectCars(carList); //用户开始选车
		System.out.println("这是您选定的租车列表:");
		printCarList(selectCars); //打印选定的车辆列表
		int[] rentNumArray = rentNumArray(selectCars); //用户对每种车输入的租车数量
		int[] rentDayArray = rentDayArray(selectCars); //用户对每种车输入的租车天数
		printOrder(selectCars,rentNumArray,rentDayArray); //打印最终订单
	}
}

//自动转换文件编码UTF-8
