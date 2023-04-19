/*-------------------------------------*/
/*         prog_05_23.java             */
/*   A sample code for CPU scheduler   */
/*       (Java thread based)           */
/*-------------------------------------*/

class Scheduler extends Thread {
	
	Thread[] runq;
	int slice_unit, tcnt;

	Scheduler(int tunit) {
		slice_unit = tunit;
		runq = new Thread[5]; tcnt = 0;
	}

	void add_thread(Thread th) {
		runq[tcnt++] = th;
		// th.suspend();
	}
	
	void cpu_yield(int pri) {
		try {
			Thread.sleep(pri * slice_unit);
		}
		catch (InterruptedException e) {};
	}
	
	public void run() {
		
		int pri = 1, t;
		Thread cth;

		while(tcnt == 0);
		while(pri > 0) { 
			for(t = pri = 0; t < tcnt; t++) {
				cth = runq[t];
				if(cth.isAlive()) {
					pri = cth.getPriority();
					cth.setPriority(8);
					/* cth.resume(); */ cpu_yield(pri);
					if(cth.isAlive()) {
						/* cth.suspend(); */ cth.setPriority(pri);
					}
				}
			}
		}
	}
}

public class prog_05_23 {
		
		static int matrixA[][], matrixB[][], matrixC[][];
	
		static class Main extends Thread
		{
			int id, sz;
			Main(int n, int size) { id = n; sz = size; }
			
			public void run() {
			
				int i, j, k;
			
				for(i = 0; i < sz; i++) {
					for(j = 0; j < sz; j++) {
						for(k = 0; k < sz; k++) {
							matrixC[i][j] = matrixA[i][k] * matrixB[k][j];
						}
					}
				}
				System.out.println("Finishing thread " + id + " ...");
				}
			}
		
		
		public static void main(String atgs[]) {
			
			int msize = 256;
		
			matrixA = new int[msize][msize];
			matrixB = new int[msize][msize];
			matrixC = new int[msize][msize];

			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

			Scheduler sched = new Scheduler(50);
			sched.setPriority(9);
			sched.start();

			prog_05_23.Main main1 = new prog_05_23.Main(1, msize);
			prog_05_23.Main main2 = new prog_05_23.Main(2, msize);
			prog_05_23.Main main3 = new prog_05_23.Main(3, msize);

			main1.setPriority(4); main1.start();
			sched.add_thread(main1);
			main2.setPriority(2); main2.start();
			sched.add_thread(main2);
			main3.setPriority(6); main3.start();
			sched.add_thread(main3);
			
			try {
				main1.join();
				main2.join();
				main3.join();
				sched.join();
			} catch (InterruptedException e) {}
			
			System.out.println("Finishing main thread ...");
		}
}
