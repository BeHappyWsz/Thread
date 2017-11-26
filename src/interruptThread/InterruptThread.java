package interruptThread;

public class InterruptThread {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread() {
			
			@Override
			public void run() {
				while(true) {
					if(Thread.currentThread().isInterrupted()) {
						System.out.println("Interrupted");
						break;
					}
					try {
						System.out.println("interrupteThread");
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.out.println("Interrupted when sleep");
						//抛出异常将会清除中断标志位,需要重新设置中断标志位,
						Thread.currentThread().interrupt();
					}
				}
			}
		};
		t1.start();
		Thread.sleep(500);
		t1.interrupt();
	}
}
