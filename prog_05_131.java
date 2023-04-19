/*-------------------------------------*/
/*         prog_05_131.java            */
/*   A sample code for CPU scheduling  */
/*       (Java thread based)           */
/*-------------------------------------*/

public class prog_05_131 {

	static int matrixA[][], matrixB[][], matrixC[][];

	static class Main1 extends Thread
	{
		int sz;
	
		Main1(int size) { sz = size; }
	
		public void run() {
		
			int i, j, k;
		
			for(i = 0; i < sz; i++) {
				for(j = 0; j < sz; j++) {
					for(k = 0; k < sz; k++) {
						matrixC[i][j] = matrixA[i][k] * matrixB[k][j];
					}
				}
			}
			System.out.println("Finishing thread 1 ...");
		}
	}

	static class Main2 extends Thread
	{
		int sz;
	
		Main2(int size) { sz = size; }
	
		public void run() {
		
			int i, j, k;
		
			for(i = 0; i < sz; i++) {
				for(j = 0; j < sz; j++) {
					for(k = 0; k < sz; k++) {
						matrixC[i][j] = matrixA[i][k] * matrixB[k][j];
					}
				}
			}
			System.out.println("Finishing thread 2 ...");
		}
	}

	static class Main3 extends Thread
	{
		int sz;
	
		Main3(int size) { sz = size; }
	
		public void run() {
		
			int i, j, k;
		
			for(i = 0; i < sz; i++) {
				for(j = 0; j < sz; j++) {
					for(k = 0; k < sz; k++) {
						matrixC[i][j] = matrixA[i][k] * matrixB[k][j];
					}
				}
			}
			System.out.println("Finishing thread 3 ...");
		}
	}

	public static void main(String atgs[]) {
		
		int msize = 512, i, j;

		matrixA = new int[msize][msize];
		matrixB = new int[msize][msize];
		matrixC = new int[msize][msize];

		prog_05_131.Main1 main1 = new prog_05_131.Main1(msize);
		prog_05_131.Main2 main2 = new prog_05_131.Main2(msize);
		prog_05_131.Main3 main3 = new prog_05_131.Main3(msize);

		main1.setPriority(7); main1.start();
		main2.setPriority(7); main2.start();
		main3.setPriority(7); main3.start();

		try {
			main1.join();
			main2.join();
			main3.join();	
		} catch (InterruptedException e) {}

		System.out.println("Finishing main thread ...");
	}
}

	