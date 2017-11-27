package DaemonThread;
/**
 * 守护线程：一般在后台完成系统性的服务，比如垃圾回收线程、JIT线程。
 * 工作线程：完成程序业务的线程。当期线程结束，那么守护线程也将停止工作。因此当程序中只存在守护线程时，java虚拟机就会退出。
 * @author wsz
 * @date 2017年11月27日
 */
class Daemon1 implements Runnable{

	@Override
	public void run() {
		while(true) {
			System.out.println("alive");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
public class DaemonThread {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Daemon1());
		//设置为守护线程，且必须在线程start之前设置，否则出现java.lang.IllegalThreadStateException异常，
		//且线程将一直打印“alive”,因为当前程序只有main主线程，当main休眠2秒后程序将退出。
		//如果t不是守护线程，在main结束后，t线程仍将一直打印不会结束。
		t.setDaemon(true);
		t.start();
//		t.setDaemon(true);  //出现异常，且不会终止，将一直打印。
		t.sleep(2000);
	}

}
