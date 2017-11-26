package waitAndNotify;

public class WaitAndNotify {
	
	final static Object object = new Object();
	
	class T1 extends Thread{
		@Override
		public void run() {
			synchronized(object) {
				System.out.println("T1 start");
				try {
					System.out.println("T1 wait");
					object.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("T1 end");
			}
		}
	}
	
	class T2 extends Thread{
		@Override
		public void run() {
			synchronized(object) {
				System.out.println("T2 start,notify one thread");
				object.notify();
				System.out.println("T2 end");
			}
		}
	}
	
	public static void main(String[] args) {
		T1 t1 = new WaitAndNotify().new T1();
		T2 t2 = new WaitAndNotify().new T2();
		
		t1.start();
		t2.start();
	}
}
