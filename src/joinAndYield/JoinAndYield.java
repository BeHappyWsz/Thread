package joinAndYield;

public class JoinAndYield {

	public volatile static long i = 0L;
	
	class AddThread extends Thread{
		
		@Override
		public void run() {
			for(i = 0L;i<500000L;i++);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		AddThread addThread = new JoinAndYield().new AddThread();
		addThread.start();
//		addThread.join(); //��ʹ��join,i��ֵ���ﲻ��ѭ�����ֵ��
		System.out.println(i);
	}
}
