package newThread;
/**
 * ʵ��Runnable�ӿ�
 * @author wsz
 * @date 2017��11��26��
 */
public class T2 implements Runnable{

	public static void main(String[] args) {
		Thread t2 = new Thread(new T2());//ʹ��Thread��Ĺ��캯������Runnable�ӿڵ�ʵ��
		t2.start();
	}

	@Override
	public void run() {
		int a = 0;
		while(a < 50) {
			System.out.println(a++);//��ӡ0-49����
		}
	}
}
