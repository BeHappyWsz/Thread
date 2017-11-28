package synchronize;

public class AddThread implements Runnable{
	static AddThread instance = new AddThread();
	static volatile int count = 0; 
	public static void main(String[] args) throws InterruptedException {
		//此时指向同一个实例对象，保证线程关注到同一个对象锁资源上。
//		Thread t1 = new Thread(instance);
//		Thread t2 = new Thread(instance);
		//此时作用于静态方法，可以实例化不同对象
		Thread t1 = new Thread(new AddThread());
		Thread t2 = new Thread(new AddThread());
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(count);//count值一般总是小于2个线程累加之和的。即使使用了volatile
	}

	@Override
	public void run() {
//		synchronized (instance) {
//			for(int i = 0; i < 10000 ;i ++) {
//				count++;
//			}
//		}
		for(int i = 0 ;i < 10000 ; i++) {
			increase();
		}
	}
	
	public static synchronized void increase() {//作用于实例方法，
		count++;
	}
}
