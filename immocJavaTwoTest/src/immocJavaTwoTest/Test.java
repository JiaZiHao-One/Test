package immocJavaTwoTest;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
   class Car{
	   private int id;
	   private String name;
	   private double rent;
	   private int manned;
	   private double carry;
	   public Car(int id,String name,double rent,int manned) {
		   this.id=id;
		   this.name=name;
		   this.rent=rent;
		   this.manned=manned;
	   }
	   public Car(int id,String name,double rent,double carry) {
		   this.id=id;
		   this.name=name;
		   this.rent=rent;
		   this.carry=carry;
	   }
	   public Car(int id,String name,double rent,int manned,double carry) {
		   this(id, name, rent, manned);
		   this.carry=carry;
	   }
	   public int getManned() {
		return manned;
	}
	   public double getCarry() {
		return carry;
	}
	   public int getId() {
		   return id;
	   }
	   public String getName() {
		   return name;
	   }
	   public double getRent() {
		   return rent;
	   }
   }
   class aodiA4 extends Car{
	public aodiA4(int id, String name, double rent,int manned) {
		super(id, name, rent,manned);
	}
   }
   class mazida6 extends Car{
		public mazida6(int id, String name, double rent,int manned) {
			super(id, name, rent,manned);
		}
   }
   class pikaxue6 extends Car{
	   public pikaxue6(int id, String name, double rent,int manned,double carry) {
			super(id, name, rent,manned,carry);
		}
   }
   class jinlong extends Car{
		public jinlong(int id, String name, double rent,int manned) {
			super(id, name, rent,manned);
		}
   }
   class songhuajiang extends Car{
	public songhuajiang(int id, String name, double rent,double carry) {
		super(id, name, rent,carry);
	}
   }
   class yiweitong extends Car{
	   public yiweitong(int id, String name, double rent,double carry) {
			super(id, name, rent,carry);
		}
   }
   public void run() {
	   System.out.println("欢迎使用答答租车系统:");
	   System.out.println("您是否要租车:1是 0否");
	   Scanner in = new Scanner(System.in);
	   int sure = in.nextInt();
	   if(sure==1) {
		   System.out.println("您可租车的类型及其价目表:");
		   Car c1 = new Test().new aodiA4(1,"奥迪A4",500.0,4);
		   Car c2 = new Test().new mazida6(2,"马自达6",400.0,4);
		   Car c3 = new Test().new pikaxue6 (3,"皮卡雪6",450.0,4,2.0);
		   Car c4 = new Test().new jinlong(4,"金龙",800.0,20);
		   Car c5 = new Test().new songhuajiang(5,"松花江",400.0,4.0);
		   Car c6 = new Test().new yiweitong(6,"依维柯",1000.0,20.0);
		   System.out.println("选择序号\t车辆类型\t租金\t载人/载货量");
		   System.out.println(c1.id+"\t"+c1.name+"\t"+c1.rent+"\t"+c1.manned+"人");
		   System.out.println(c2.id+"\t"+c2.name+"\t"+c2.rent+"\t"+c2.manned+"人");
		   System.out.println(c3.id+"\t"+c3.name+"\t"+c3.rent+"\t"+c3.manned+"人/"+c3.carry+"吨");
		   System.out.println(c4.id+"\t"+c4.name+"\t"+c4.rent+"\t"+c4.manned+"人");
		   System.out.println(c5.id+"\t"+c5.name+"\t"+c5.rent+"\t"+c5.carry+"吨");
		   System.out.println(c6.id+"\t"+c6.name+"\t"+c6.rent+"\t"+c6.carry+"吨");
		   System.out.println("请输入您要租车的数量:");
		   int number = in.nextInt();
		   int mannedsum=0;
		   double carrysum=0;
		   double rentsum=0;
		   List<String> mannedcar = new ArrayList<String>();
		   List<String> carrycar = new ArrayList<String>();
		   for(int i=0;i<number;i++) {
			   System.out.println("请输入租借车辆序号");
			   int id=in.nextInt();
			   switch(id) {
			   case 1:
				   mannedsum+=c1.manned;
				   rentsum+=c1.rent;
				   mannedcar.add(c1.name);
				   break;
			   case 2:
				   mannedsum+=c2.manned;
				   rentsum+=c2.rent;
				   mannedcar.add(c2.name);
				   break;
			   case 3:
				   mannedsum+=c3.manned;
				   carrysum+=c3.carry;
				   rentsum+=c3.rent;
				   mannedcar.add(c3.name);
				   carrycar.add(c3.name);
				   break;
			   case 4:
				   mannedsum+=c4.manned;
				   rentsum+=c4.rent;
				   mannedcar.add(c4.name);
				   break;
			   case 5:
				   carrysum+=c5.carry;
				   rentsum+=c5.rent;
				   carrycar.add(c5.name);
				   break;
			   case 6:
				   carrysum+=c6.carry;
				   rentsum+=c6.rent;
				   carrycar.add(c6.name);
				   break;
			   }
		   }
		   System.out.println("请输入租车天数:");
		   int day=in.nextInt();
		   System.out.println("你的账单");
		   System.out.println("***可载人的车有:");
		   for(String s: mannedcar){
			   System.out.print(s+"\t");
		   }
		   System.out.println("共载人:"+mannedsum+"人");
		   System.out.println("***可载货的车有:");
		   for(String s: carrycar){
			   System.out.print(s+"\t");
		   }
		   System.out.println("共载货:"+carrysum+"吨");
		   System.out.println("***租车总价格:"+rentsum*day+"元");
	   }else {
		   System.out.println("你退出了答答租车系统!");
		   System.exit(1);
	   }
   }
   public static void main(String args[]) {
	   Test t = new Test();
	   t.run();
   }
}
