package priorityThread;
/**
 * 线程优先级：数字1-10，数字越大级别越高
 * @author wsz
 * @date 2017年11月28日
 */
public class PriorityThread {
	public final static Object object = new Object();
	
	class HighThread implements Runnable{
		int count = 0;
		@Override
		public void run() {
			while(true) {
				synchronized (object) {
					count++;
					if(count > 200000) {
						System.out.println("HighThread is ok");
						break;
					}
				}
			}
		}
		
	}
	class LowThread implements Runnable{
		int count = 0;
		@Override
		public void run() {
			while(true) {
				synchronized (object) {
					count++;
					if(count > 200000) {
						System.out.println("LowThread is ok");
						break;
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Thread high = new Thread(new PriorityThread().new HighThread());
		Thread low = new Thread(new PriorityThread().new LowThread());
		high.setPriority(Thread.MAX_PRIORITY);
		low.setPriority(Thread.MIN_PRIORITY);
		high.start();
		low.start();
	}

}
