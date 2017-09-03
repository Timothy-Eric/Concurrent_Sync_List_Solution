import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CManager {
	
	final static private List<CaseExecutor> list = Collections.synchronizedList(new ArrayList<>());
	
	final private ExecutorService threadPool;
	
	public CManager(int max) {
		list.add(new CaseExecutor(1));
		list.add(new CaseExecutor(2));
		list.add(new CaseExecutor(3));
		list.add(new CaseExecutor(4));
		list.add(new CaseExecutor(5));

		
		this.threadPool = Executors.newFixedThreadPool(max);
	}
	
	public void startRun() {
		
		while(list.size() > 0) {
			Iterator<CaseExecutor> it = list.iterator();
			
			while(it.hasNext()) {
				
				Runnable work = it.next();
				threadPool.execute(work);

				it.remove();
			}
			
		}
		
		threadPool.shutdown();
		
	}
	
	
	
	static class CaseExecutor implements Runnable{
		
		final private int value;

		public CaseExecutor(int v) {
			value = v;
		}
		
		@Override
		public String toString() {
			return "[" + value + "]";
		}
		
		@Override
		public void run() {
			System.out.println("Start: " + value);
			try {
			switch (value) {
			case 1:
				Thread.sleep(3000);
				break;
			case 2:
				Thread.sleep(4000);
				break;
			case 3:
				Thread.sleep(1000);
				break;
			case 4:
				Thread.sleep(3000);
				break;
			case 5:
				Thread.sleep(7000);
				break;
			default:
				Thread.sleep(7000);
				break;
			}
			}catch (Exception e){}
			
			System.out.println("END: " + value);
			
		}
	}

	public static void main(String[] args) {
		new CManager(3).startRun();
	}
}
