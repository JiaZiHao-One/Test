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
	   System.out.println("��ӭʹ�ô���⳵ϵͳ:");
	   System.out.println("���Ƿ�Ҫ�⳵:1�� 0��");
	   Scanner in = new Scanner(System.in);
	   int sure = in.nextInt();
	   if(sure==1) {
		   System.out.println("�����⳵�����ͼ����Ŀ��:");
		   Car c1 = new Test().new aodiA4(1,"�µ�A4",500.0,4);
		   Car c2 = new Test().new mazida6(2,"���Դ�6",400.0,4);
		   Car c3 = new Test().new pikaxue6 (3,"Ƥ��ѩ6",450.0,4,2.0);
		   Car c4 = new Test().new jinlong(4,"����",800.0,20);
		   Car c5 = new Test().new songhuajiang(5,"�ɻ���",400.0,4.0);
		   Car c6 = new Test().new yiweitong(6,"��ά��",1000.0,20.0);
		   System.out.println("ѡ�����\t��������\t���\t����/�ػ���");
		   System.out.println(c1.id+"\t"+c1.name+"\t"+c1.rent+"\t"+c1.manned+"��");
		   System.out.println(c2.id+"\t"+c2.name+"\t"+c2.rent+"\t"+c2.manned+"��");
		   System.out.println(c3.id+"\t"+c3.name+"\t"+c3.rent+"\t"+c3.manned+"��/"+c3.carry+"��");
		   System.out.println(c4.id+"\t"+c4.name+"\t"+c4.rent+"\t"+c4.manned+"��");
		   System.out.println(c5.id+"\t"+c5.name+"\t"+c5.rent+"\t"+c5.carry+"��");
		   System.out.println(c6.id+"\t"+c6.name+"\t"+c6.rent+"\t"+c6.carry+"��");
		   System.out.println("��������Ҫ�⳵������:");
		   int number = in.nextInt();
		   int mannedsum=0;
		   double carrysum=0;
		   double rentsum=0;
		   List<String> mannedcar = new ArrayList<String>();
		   List<String> carrycar = new ArrayList<String>();
		   for(int i=0;i<number;i++) {
			   System.out.println("��������賵�����");
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
		   System.out.println("�������⳵����:");
		   int day=in.nextInt();
		   System.out.println("����˵�");
		   System.out.println("***�����˵ĳ���:");
		   for(String s: mannedcar){
			   System.out.print(s+"\t");
		   }
		   System.out.println("������:"+mannedsum+"��");
		   System.out.println("***���ػ��ĳ���:");
		   for(String s: carrycar){
			   System.out.print(s+"\t");
		   }
		   System.out.println("���ػ�:"+carrysum+"��");
		   System.out.println("***�⳵�ܼ۸�:"+rentsum*day+"Ԫ");
	   }else {
		   System.out.println("���˳��˴���⳵ϵͳ!");
		   System.exit(1);
	   }
   }
   public static void main(String args[]) {
	   Test t = new Test();
	   t.run();
   }
}
