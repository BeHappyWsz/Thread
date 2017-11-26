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
//		addThread.join(); //不使用join,i的值将达不到循环最大值。
		System.out.println(i);
	}
}
