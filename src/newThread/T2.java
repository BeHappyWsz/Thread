package newThread;
/**
 * 实现Runnable接口
 * @author wsz
 * @date 2017年11月26日
 */
public class T2 implements Runnable{

	public static void main(String[] args) {
		Thread t2 = new Thread(new T2());//使用Thread类的构造函数传入Runnable接口的实例
		t2.start();
	}

	@Override
	public void run() {
		int a = 0;
		while(a < 50) {
			System.out.println(a++);//打印0-49数字
		}
	}
}
