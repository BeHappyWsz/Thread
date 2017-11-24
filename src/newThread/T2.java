package newThread;

public class T2 implements Runnable{

	public static void main(String[] args) {
		Thread t2 = new Thread(new T2());
		t2.start();
	}

	@Override
	public void run() {
		int a = 0;
		while(a < 50) {
			System.out.println(a++);
		}
	}
}
