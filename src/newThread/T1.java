package newThread;

public class T1 extends Thread{
	long count = 0L;
	
	@Override
	public void run() {
		while(count < 50L) {
			System.out.println(count++);
		}
	}
	public static void main(String[] args) throws InterruptedException {
		T1 t1 = new T1();
		t1.start();
		
		Thread t = new Thread() {
			@Override
			public void run() {
				System.out.println(System.currentTimeMillis());
			}
		};
//		t.join();
		t.start();
	}

}
