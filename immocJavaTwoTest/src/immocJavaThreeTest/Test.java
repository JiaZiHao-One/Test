package immocJavaThreeTest;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Test {
	boolean flag = true;
	String[] book = new String[] {"�ɽ�������һ","�ɽ���������","�ɽ���������","�ɽ���������","�ɽ���������","�ɽ���������","�ɽ���������"};
	public void one(){
		Boolean flag=true;
		int cmd=0;
		while(flag) {
			System.out.println("��������:1-����ͼ����Ų���;2-����ͼ�����Ʋ���");
			try {
				Scanner in = new Scanner(System.in);
				cmd =in.nextInt();
				if(cmd==1) {
					System.out.println("������ͼ�����:");
					int one = in.nextInt();
					String s = book[one];
					System.out.println("book:"+s);
					flag=false;
				}else if(cmd==2){
					System.out.println("������ͼ������");
					String two = in.next();
					for(int i=0;i<book.length;i++) {
						if(two.equals(book[i])) {
						System.out.println("book:"+two);
					    return;
						}
					}
					System.out.println("ͼ�鲻����");
					flag = true;
				}else {
					System.out.println("�����������!�������ʾ������������!");
					flag=true;
				}
			}catch(InputMismatchException i) {
				flag=true;
				System.out.println("�����������!�������ʾ������������!");
			}catch(ArrayIndexOutOfBoundsException a) {
				System.out.println("ͼ�鲻����");
				flag = true;
			}
		}
	}
	public static void main(String[] args) {
		Test  t = new Test();
		t.one();
	}
}
/*Throwable(�쳣����游��)��Error(jvm�쳣)��Exception(�����쳣)
 * Error�෢����JVM�������,����Ϊ�ǲ��ָܻ������ش�������,�޷�����
 * Exception���ΪRuntimeException(����ʱ�쳣)��CheckedException(������ʱ�쳣)
 * RuntimeException java����������,�������л�������;CheckedException,���봦��(try-catch-finally)
 * 1��NullPointerException(��ָ���쳣)
 * 2��ClassCastException(����ת���쳣)
 * 3��ArrayIndexOutOfBoundsException(�����±�Խ�����)
 * 4��NumberFormatException(����ת���쳣)
 * 5��ArithmeticException(�����쳣)
 * 6��NegativeArrayException(�����±��쳣)
 * 7��SQLException(���ݿ�����쳣)
 * 8��IOException(��������쳣)
 * 9��SystemException(ϵͳ�쳣)
 * 10��FileNotFoundException(�ļ�δ�ҵ��쳣)
 */
