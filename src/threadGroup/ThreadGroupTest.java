package threadGroup;
/**
 * 线程组：将类似功能的线程放入同一组内，便于管理
 * @author wsz
 * @date 2017年11月27日
 */
class Print1 implements Runnable{

	@Override
	public void run() {
		String name = Thread.currentThread().getThreadGroup().getName()+"_"+Thread.currentThread().getName();
		while(true) {
			System.out.println(name);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class Print2 implements Runnable{

	@Override
	public void run() {
		String name = Thread.currentThread().getThreadGroup().getName()+"_"+Thread.currentThread().getName();
		while(true) {
			System.out.println(name);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
public class ThreadGroupTest implements Runnable{

	public static void main(String[] args) {
		ThreadGroup group = new ThreadGroup("ThreadGroup");//线程组及命名
//		Thread tg1 = new Thread(group,new ThreadGroupTest(),"tg1");
//		Thread tg2 = new Thread(group,new ThreadGroupTest(),"tg2");
		Thread tg1 = new Thread(group, new Print1(), "print1");
		Thread tg2 = new Thread(group, new Print2(), "print2");
		tg1.start();
		tg2.start();
		System.out.println(group.activeCount());//估值活动线程数目
		group.list();//线程组中线程信息
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getThreadGroup().getName()+"_"+Thread.currentThread().getName();
		while(true) {
			System.out.println(name);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
