package com.zucheDemo;

import java.util.ArrayList;//���Ԫ��
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;//�ۺϲ���

public class InitialDemo {

	private static Scanner input = new Scanner(System.in);
	//����һ���������
	
	//��ȡ�û����뷽��
	private static String getInput(){
		try{
			return input.next();
		}
		catch(Exception e){
			return null; //ȷ���ͻ�����������
		}
		finally{
			input.nextLine();//��ֹ�´ε���ʱ�ٶ�ȡ����
		}
		//������쳣����
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		
		System.out.println("***��ӭʹ���⳵ϵͳ***");
		List<Car> carList = initCarList();
		//Ϊ�˱�֤��ʱ����޸���Ŀ��ʹ��list
		//***��ʱ����***
		
		for(;;){//����������ѭ��
			
			System.out.println("�����Ҫ�⳵��������1��"+"�˳�������0.");
			
			int choice;
			try{
				choice = Integer.parseInt(getInput());
				//������ֵ����ת��Integer
			}
			catch(Exception e){
				System.out.println("������������ȷ���롣");
				continue;
			}//�쳣����ȷ����������֣������������ַ���
			
			if(choice == 0) break;//�������0�Ļ�������ѭ��
			else if(choice == 1){
				rentCars(carList);
				System.out.println();
			}
			else{
				System.out.println("ָ����������ȷ���롣");
				continue;
			}//��������������֣�����ѭ��
		}
		System.out.println("***��лʹ���⳵ϵͳ***");
	}
	
	//���ɳ�ʼ���Ŀ��⳵�б�
	private static List<Car> initCarList(){
		List<Car> carList = new ArrayList<Car>(); //�������飬��ʼ��List��ȷ������car��
		carList.add(new CarBus("С�Ϳͳ�",500,6));			
		carList.add(new CarBus("���Ϳͳ�",1000,15));
		carList.add(new CarTruck("С�ͻ���",400,2));
		carList.add(new CarTruck("���ͻ���",800,10));
		carList.add(new CarPickup("С��Ƥ��",500,2,1));
		carList.add(new CarPickup("����Ƥ��",900,4,2));
		return carList;//����공����List
	}//����ʱʹ��carList.add����³��������޸���������
	
	//����⳵�б��õ�ÿһ������д��toString����
	private static void printCarList(List<Car> carList){
		System.out.println("�����ǿ��ó��ͣ�");
		System.out.println("���\t����\t���\t�ؿ���\t�ػ���");
		for(int i = 0;i < carList.size();i++){
			System.out.println((i + 1) + "\t" + (carList.get(i)).toString());
		}
	}
	
	//�ͻ�ѡ�����ܣ�ȫ��ʹ������Ԥ��ȷ�����ȵ�list����
	private static List<Car> selectCars(List<Car> carList){
		List<Integer> rentArray = new ArrayList<Integer>(); //����ͻ�ѡ�������
		List<Car> selectCars = new ArrayList<Car>(); //�����û�ѡ���ĳ�
		System.out.println("�������⳵��ţ��Իس��ָ�������0������");
		for(;;){
			System.out.println("�����복����ţ�1-" + carList.size() + "����");
			boolean repeated = false;
			int carNum;
			try{
				carNum = Integer.parseInt(getInput());
			}
			catch(Exception e){
				System.out.println("���벻��ȷ�����������롣");
				continue;
			}//�쳣����,ȷ������������֣����������ַ�
			
			if(carNum == 0) break;
			else if(carNum > 0 && carNum <= carList.size()){ //ȷ������������ڷ�Χ֮��
				for(int i = 0;i< rentArray.size();i++){
					if(carNum == rentArray.get(i)){
						System.out.println("����������ó��ͣ����������롣");
						repeated = true;
						break; //������������Ѿ�ѡ�����������ѡ��
					}
				}
				if(!repeated){
					rentArray.add(carNum);
					selectCars.add((Car) carList.get(carNum - 1));
				}//�������û���ظ�����ӵ������б�
			}
			else{
				System.out.println("���벻��ȷ��������������ȷ��š�");
				continue;
			}
		}
		return selectCars;//����ѡ�ó���list
	}
	
	//��ȡ�⳵��Ŀ����
	private static int rentCount(){
		for(;;){
			System.out.println("�������⳵����(1 - 50)��");
			int rentCount;
			try{
				rentCount = Integer.parseInt(getInput());
			}
			catch(Exception e){
				System.out.println("���벻��ȷ�����������롣");
				continue;
			}//�쳣����
			if(rentCount >= 1 && rentCount <=50)
				return rentCount;
			else System.out.println("���벻��ȷ�����������롣");
		}
	}
	
	//��ѡ�õĳ������ж�ȡ�⳵����
	private static int[] rentNumArray(List<Car> carList){
			int[] rentNumArray = new int[carList.size()];//ʹ������洢ÿ�ֳ�������
			for(int i = 0;i< carList.size();i++){
				System.out.println("������ѡ���б����" + (i+1) + "�������⳵������");
				rentNumArray[i] = rentCount();//���ö�ȡ�⳵��Ŀ�ķ���
			}
			return rentNumArray;//�����⳵��Ŀ������
	}
	
	//��ȡ�⳵��������
	private static int rentDays(){
		for(;;){
			System.out.println("�������⳵����(1 - 365)��");
			int rentDays;
			
			try{
				rentDays = Integer.parseInt(getInput());
			}
			catch(Exception e){
				System.out.println("���벻��ȷ�����������롣");
				continue;
			}//�쳣����
			if(rentDays >= 1 && rentDays <= 365)
				return rentDays;
			else System.out.println("���벻��ȷ�����������롣");
		}
	}
	
	//��ѡ�õĳ������ж�ȡ�⳵����
	private static int[] rentDayArray(List<Car> carList){
			int[] rentDayArray = new int[carList.size()];//ʹ������洢ÿ�ֳ�������
			for(int i = 0;i < carList.size();i++){
				System.out.println("������ѡ���б����" + (i+1) + "�������⳵������");
				rentDayArray[i] = rentDays();//���ö�ȡ�⳵�����ķ���
			}
			return rentDayArray;//�����⳵����������
	}
	
	//��ӡ����
	private static void printOrder(List<Car> carList,int[] rentNumArray,int[] rentDayArray){
		int[] rentSinglePriceTotal = new int[carList.size()];
		int[] rentSinglePassTotal = new int[carList.size()];
		int[] rentSingleCargoTotal = new int[carList.size()];
		//��������ֱ�洢�ܼۣ����ؿ��������ػ���
		
		System.out.println("���������Ķ�����");
		System.out.println("���\t����\t���\t�ؿ���\t�ػ���" + "\t��������\t��������\t��������");
		for(int i = 0;i < carList.size();i++){
			rentSinglePriceTotal[i] = ((Car) carList.get(i)).getPrice() * rentNumArray[i] * rentDayArray[i];
			//����ÿ�ֳ����ܼ�
			System.out.println((i + 1) + "\t" + (carList.get(i)).toString() + "\t" + rentNumArray[i] + "\t" + rentDayArray + "\t" + rentSinglePriceTotal[i]);
			
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
			}//˫��tryǶ�� ����������ؿ͹��ܣ���洢һ������ؿ���������Ϊ��

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
			}//˫��tryǶ�� ����������ػ����ܣ���洢һ������ػ���������Ϊ��
		}
		int renTotal = IntStream.of(rentSinglePriceTotal).sum();
		int passCapacityTotal = IntStream.of(rentSinglePassTotal).sum();
		int cargoCapacityTotal = IntStream.of(rentSingleCargoTotal).sum();
		//�����������ֵ�ֱ�������
		
		
		
		System.out.println("���ؿ���(��/��):" + passCapacityTotal);
		System.out.println("���ػ���(��/��):" + cargoCapacityTotal);
		System.out.println("�����ܼ�(Ԫ):" + renTotal); //���г������ܽ�
	}
	
	//��ʼ�⳵
	private static void rentCars(List<Car> carList){
		printCarList(carList); //��ӡ���еĳ���
		List<Car> selectCars = selectCars(carList); //�û���ʼѡ��
		System.out.println("������ѡ�����⳵�б�:");
		printCarList(selectCars); //��ӡѡ���ĳ����б�
		int[] rentNumArray = rentNumArray(selectCars); //�û���ÿ�ֳ�������⳵����
		int[] rentDayArray = rentDayArray(selectCars); //�û���ÿ�ֳ�������⳵����
		printOrder(selectCars,rentNumArray,rentDayArray); //��ӡ���ն���
	}
}