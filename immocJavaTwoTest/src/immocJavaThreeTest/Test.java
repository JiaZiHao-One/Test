package immocJavaThreeTest;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Test {
	boolean flag = true;
	String[] book = new String[] {"仙剑奇侠传一","仙剑奇侠传二","仙剑奇侠传三","仙剑奇侠传四","仙剑奇侠传五","仙剑奇侠传六","仙剑奇侠传七"};
	public void one(){
		Boolean flag=true;
		int cmd=0;
		while(flag) {
			System.out.println("输入命令:1-按照图书序号查找;2-按照图书名称查找");
			try {
				Scanner in = new Scanner(System.in);
				cmd =in.nextInt();
				if(cmd==1) {
					System.out.println("请输入图书序号:");
					int one = in.nextInt();
					String s = book[one];
					System.out.println("book:"+s);
					flag=false;
				}else if(cmd==2){
					System.out.println("请输入图书名称");
					String two = in.next();
					for(int i=0;i<book.length;i++) {
						if(two.equals(book[i])) {
						System.out.println("book:"+two);
					    return;
						}
					}
					System.out.println("图书不存在");
					flag = true;
				}else {
					System.out.println("命令输入错误!请根据提示输入数字命令!");
					flag=true;
				}
			}catch(InputMismatchException i) {
				flag=true;
				System.out.println("命令输入错误!请根据提示输入数字命令!");
			}catch(ArrayIndexOutOfBoundsException a) {
				System.out.println("图书不存在");
				flag = true;
			}
		}
	}
	public static void main(String[] args) {
		Test  t = new Test();
		t.one();
	}
}
/*Throwable(异常类的祖父类)有Error(jvm异常)和Exception(程序异常)
 * Error类发生在JVM虚拟机中,被认为是不能恢复的严重错误条件,无法处理
 * Exception类分为RuntimeException(运行时异常)和CheckedException(非运行时异常)
 * RuntimeException java允许不做处理,交给运行环境处理;CheckedException,必须处理(try-catch-finally)
 * 1、NullPointerException(空指针异常)
 * 2、ClassCastException(类型转换异常)
 * 3、ArrayIndexOutOfBoundsException(数组下标越界错误)
 * 4、NumberFormatException(数字转换异常)
 * 5、ArithmeticException(算数异常)
 * 6、NegativeArrayException(数组下标异常)
 * 7、SQLException(数据库操作异常)
 * 8、IOException(输入输出异常)
 * 9、SystemException(系统异常)
 * 10、FileNotFoundException(文件未找到异常)
 */
