package newThread;
/**
 * �̳�Thread��,Thread���ʵ����ʵ��Runnable�ӿ�
 * @author wsz
 * @date 2017��11��26��
 */
public class T1 extends Thread{
	long count = 0L;
	
	@Override
	public void run() {
		while(count < 50L) {
			System.out.println(count++);//��ӡ0-49����
		}
	}
	public static void main(String[] args) {
		T1 t1 = new T1();
		t1.start();
	}

}
