package threadGroup;
/**
 * �߳��飺�����ƹ��ܵ��̷߳���ͬһ���ڣ����ڹ���
 * @author wsz
 * @date 2017��11��27��
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
		ThreadGroup group = new ThreadGroup("ThreadGroup");//�߳��鼰����
//		Thread tg1 = new Thread(group,new ThreadGroupTest(),"tg1");
//		Thread tg2 = new Thread(group,new ThreadGroupTest(),"tg2");
		Thread tg1 = new Thread(group, new Print1(), "print1");
		Thread tg2 = new Thread(group, new Print2(), "print2");
		tg1.start();
		tg2.start();
		System.out.println(group.activeCount());//��ֵ��߳���Ŀ
		group.list();//�߳������߳���Ϣ
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
