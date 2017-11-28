package arrayList;

import java.util.ArrayList;

public class ArrayListTest {

	static ArrayList<Integer> arry = new ArrayList<Integer>();
	
	class AddList implements Runnable{

		@Override
		public void run() {
			for(int i= 0; i< 10000 ; i++)
				arry.add(i);
		}
	}
	public static void main(String[] args) throws InterruptedException {
		Thread a1 = new Thread(new ArrayListTest().new AddList());
		Thread a2 = new Thread(new ArrayListTest().new AddList());
		a1.start();
		a2.start();
		a1.join();
		a2.join();
		System.out.println(arry.size());
	}

}
