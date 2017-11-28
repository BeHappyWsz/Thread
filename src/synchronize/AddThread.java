package synchronize;

public class AddThread implements Runnable{
	static AddThread instance = new AddThread();
	static volatile int count = 0; 
	public static void main(String[] args) throws InterruptedException {
		//��ʱָ��ͬһ��ʵ�����󣬱�֤�̹߳�ע��ͬһ����������Դ�ϡ�
//		Thread t1 = new Thread(instance);
//		Thread t2 = new Thread(instance);
		//��ʱ�����ھ�̬����������ʵ������ͬ����
		Thread t1 = new Thread(new AddThread());
		Thread t2 = new Thread(new AddThread());
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(count);//countֵһ������С��2���߳��ۼ�֮�͵ġ���ʹʹ����volatile
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
	
	public static synchronized void increase() {//������ʵ��������
		count++;
	}
}
