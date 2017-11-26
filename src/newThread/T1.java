package newThread;
/**
 * 继承Thread类,Thread类的实现是实现Runnable接口
 * @author wsz
 * @date 2017年11月26日
 */
public class T1 extends Thread{
	long count = 0L;
	
	@Override
	public void run() {
		while(count < 50L) {
			System.out.println(count++);//打印0-49数字
		}
	}
	public static void main(String[] args) {
		T1 t1 = new T1();
		t1.start();
	}

}
