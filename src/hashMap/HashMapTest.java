package hashMap;

import java.util.HashMap;

public class HashMapTest {
	static HashMap<String,Object> map = new HashMap<String,Object>(); 
	
	class AddHashMap implements Runnable{
		@Override
		public void run() {
			for(int i= 0; i< 100 ; i++)
				map.put(String.valueOf(i), i);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new HashMapTest().new AddHashMap());
		Thread t2 = new Thread(new HashMapTest().new AddHashMap());
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(map.size());
	}

}
