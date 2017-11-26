package stopThread;

class User{
	private int id;
	
	private String name;
	
	public User() {
		this.id = 0;
		this.name = "0";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
}

public class StopThread extends Thread{
	public static User u = new User();
	
	class ReadThread extends Thread{//���߳�
		@Override
		public void run() {
			while(true) {
				synchronized(u) {
					if(u.getId() != Integer.parseInt(u.getName())) {
						System.out.println(u.toString());
						break;
					}
					Thread.yield();
				}
			}
		}
	}
	
	class ChangeThread extends Thread{//д�߳�
		volatile boolean stopThread = false;
		
		public void stopme() {
			stopThread = true;
		}
		
		@Override
		public void run() {
			while(true) {
				if(stopThread) {
					System.out.println("Thread is stop");
					System.out.println(u.toString());
					break;
				}
				synchronized(u) {
					long time = System.currentTimeMillis()/100000000;
					u.setId((int)time);
					try {
						Thread.sleep(200);
						System.out.println(u.toString());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					u.setName(String.valueOf(time));
					Thread.yield();//ǫ��
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new StopThread().new ReadThread().start();
		long count = 500L;
		while(count > 0L) {
			Thread t = new StopThread().new ChangeThread();
			t.start();
//			t.stop();//ǿ��ֹͣ,���������ݲ�һ��
			((ChangeThread) t).stopme();//�Զ����ʶ�������̵߳Ľ���
			count--;
		}
	}
}
