package DaemonThread;
/**
 * �ػ��̣߳�һ���ں�̨���ϵͳ�Եķ��񣬱������������̡߳�JIT�̡߳�
 * �����̣߳���ɳ���ҵ����̡߳������߳̽�������ô�ػ��߳�Ҳ��ֹͣ��������˵�������ֻ�����ػ��߳�ʱ��java������ͻ��˳���
 * @author wsz
 * @date 2017��11��27��
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
		//����Ϊ�ػ��̣߳��ұ������߳�start֮ǰ���ã��������java.lang.IllegalThreadStateException�쳣��
		//���߳̽�һֱ��ӡ��alive��,��Ϊ��ǰ����ֻ��main���̣߳���main����2�������˳���
		//���t�����ػ��̣߳���main������t�߳��Խ�һֱ��ӡ���������
		t.setDaemon(true);
		t.start();
//		t.setDaemon(true);  //�����쳣���Ҳ�����ֹ����һֱ��ӡ��
		t.sleep(2000);
	}

}
