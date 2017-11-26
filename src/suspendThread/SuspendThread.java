package suspendThread;

public class SuspendThread {

	public static Object object = new Object();
	
	class ChangeThread extends Thread{
		
		volatile boolean suspendThread = false;
		
		public void suspendme() {
			suspendThread = true;
		}
		
		public void resumeme() {
			suspendThread = false;
			synchronized (this) {
				notify();
			}
		}
		
		@Override
		public void run() {
			while(true) {
				synchronized(this) {
					while(suspendThread) {
						try {
							wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				
				synchronized (object) {
					System.out.println("in ChangeThread");
				}
				Thread.yield();
			}
		}
	}
	
	class ReadThread extends Thread{
		
		@Override
		public void run() {
			while(true) {
				synchronized (object) {
					System.out.println("in ReadThread");
				}
				Thread.yield();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ChangeThread changeThread = new SuspendThread().new ChangeThread();
		ReadThread readThread = new SuspendThread().new ReadThread();
		
		changeThread.start();
		readThread.start();
		
		Thread.sleep(100);
		changeThread.suspendme();//¹ÒÆð
		System.out.println("suspend changeThread 1s");
		Thread.sleep(100);
		System.out.println("resume changeThread");
		changeThread.resumeme();//¼ÌÐøÖ´ÐÐ
	}
}
