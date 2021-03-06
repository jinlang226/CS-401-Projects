import java.util.*;

public class TowerOfHanoiTester
{
	public static void main(String[] args)
	{
		Scanner inScan = new Scanner(System.in);
		Random rand = new Random();

		System.out.println("Test Constructor TowerOfHanoi()");
		System.out.println("===============================");
		TowerOfHanoi toh = new TowerOfHanoi();
		System.out.println("Constructing a Tower of Hanoi using the following statement:");
		System.out.println("  TowerOfHanoi toh = new TowerOfHanoi()");
		Tester.checkInt(toh.peekTopDisk(1).getSize(), 1, "toh", "peekTopDisk(1)");
		Tester.checkNull(toh.peekTopDisk(2), "toh", "peekTopDisk(2)");
		Tester.checkNull(toh.peekTopDisk(3), "toh", "peekTopDisk(3)");
		Tester.checkInt(toh.getNumberOfDisks(1), 7, "toh", "getNumberOfDisks(1)");
		Tester.checkInt(toh.getNumberOfDisks(2), 0, "toh", "getNumberOfDisks(2)");
		Tester.checkInt(toh.getNumberOfDisks(3), 0, "toh", "getNumberOfDisks(3)");
		Tester.checkToString(toh.toString(), "toh", inScan);
		System.out.println("Move top disk from pole 1 to pole 2");
		Tester.checkTrue(toh.move(1, 2), "toh", "move(1, 2)");
		Tester.checkInt(toh.peekTopDisk(1).getSize(), 2, "toh", "peekTopDisk(1)");
		Tester.checkInt(toh.peekTopDisk(2).getSize(), 1, "toh", "peekTopDisk(2)");
		Tester.checkNull(toh.peekTopDisk(3), "toh", "peekTopDisk(3)");
		Tester.checkInt(toh.getNumberOfDisks(1), 6, "toh", "getNumberOfDisks(1)");
		Tester.checkInt(toh.getNumberOfDisks(2), 1, "toh", "getNumberOfDisks(2)");
		Tester.checkInt(toh.getNumberOfDisks(3), 0, "toh", "getNumberOfDisks(3)");
		Tester.checkToString(toh.toString(), "toh", inScan);
		System.out.println("Move top disk from pole 1 to pole 3");
		Tester.checkTrue(toh.move(1, 3), "toh", "move(1, 3)");
		
		Tester.checkInt(toh.peekTopDisk(1).getSize(), 3, "toh", "peekTopDisk(1)");
		Tester.checkInt(toh.peekTopDisk(2).getSize(), 1, "toh", "peekTopDisk(2)");
		Tester.checkInt(toh.peekTopDisk(3).getSize(), 2, "toh", "peekTopDisk(3)");
		Tester.checkInt(toh.getNumberOfDisks(1), 5, "toh", "getNumberOfDisks(1)");
		Tester.checkInt(toh.getNumberOfDisks(2), 1, "toh", "getNumberOfDisks(2)");
		Tester.checkInt(toh.getNumberOfDisks(3), 1, "toh", "getNumberOfDisks(3)");
		
		Tester.checkToString(toh.toString(), "toh", inScan);
		System.out.println("Move top disk from pole 2 to pole 3");
		Tester.checkTrue(toh.move(2, 3), "toh", "move(2, 3)");

		
		Tester.checkInt(toh.peekTopDisk(1).getSize(), 3, "toh", "peekTopDisk(1)");
		Tester.checkNull(toh.peekTopDisk(2), "toh", "peekTopDisk(2)");
		Tester.checkInt(toh.peekTopDisk(3).getSize(), 1, "toh", "peekTopDisk(3)");
		Tester.checkInt(toh.getNumberOfDisks(1), 5, "toh", "getNumberOfDisks(1)");
		Tester.checkInt(toh.getNumberOfDisks(2), 0, "toh", "getNumberOfDisks(2)");
		Tester.checkInt(toh.getNumberOfDisks(3), 2, "toh", "getNumberOfDisks(3)");
		
		Tester.checkToString(toh.toString(), "toh", inScan);
		System.out.println("Reset the Tower of Hanoi");
		toh.reset();
		

		///does not work
		Tester.checkInt(toh.peekTopDisk(1).getSize(), 1, "toh", "peekTopDisk(1)");
		Tester.checkNull(toh.peekTopDisk(2), "toh", "peekTopDisk(2)");
		Tester.checkNull(toh.peekTopDisk(3), "toh", "peekTopDisk(3)");
		Tester.checkInt(toh.getNumberOfDisks(1), 7, "toh", "getNumberOfDisks(1)");
		Tester.checkInt(toh.getNumberOfDisks(2), 0, "toh", "getNumberOfDisks(2)");
		Tester.checkInt(toh.getNumberOfDisks(3), 0, "toh", "getNumberOfDisks(3)");
		
		Tester.checkToString(toh.toString(), "toh", inScan);

		System.out.println("Test Constructor TowerOfHanoi(int)");
		System.out.println("==================================");
		int numDisks = rand.nextInt(6) + 3;
		toh = new TowerOfHanoi(numDisks);
		System.out.println("Constructing a Tower of Hanoi using the following statement:");
		System.out.println("  TowerOfHanoi toh = new TowerOfHanoi(" + numDisks + ")");
		
		Tester.checkInt(toh.peekTopDisk(1).getSize(), 1, "toh", "peekTopDisk(1)");
		Tester.checkNull(toh.peekTopDisk(2), "toh", "peekTopDisk(2)");
		Tester.checkNull(toh.peekTopDisk(3), "toh", "peekTopDisk(3)");
		Tester.checkInt(toh.getNumberOfDisks(1), numDisks, "toh", "getNumberOfDisks(1)");
		Tester.checkInt(toh.getNumberOfDisks(2), 0, "toh", "getNumberOfDisks(2)");
		Tester.checkInt(toh.getNumberOfDisks(3), 0, "toh", "getNumberOfDisks(3)");
		
		Tester.checkToString(toh.toString(), "toh", inScan);
		System.out.println("Move top disk from pole 1 to pole 2");
		Tester.checkTrue(toh.move(1, 2), "toh", "move(1, 2)");
		
		Tester.checkInt(toh.peekTopDisk(1).getSize(), 2, "toh", "peekTopDisk(1)");
		Tester.checkInt(toh.peekTopDisk(2).getSize(), 1, "toh", "peekTopDisk(2)");
		Tester.checkNull(toh.peekTopDisk(3), "toh", "peekTopDisk(3)");
		Tester.checkInt(toh.getNumberOfDisks(1), numDisks - 1, "toh", "getNumberOfDisks(1)");
		Tester.checkInt(toh.getNumberOfDisks(2), 1, "toh", "getNumberOfDisks(2)");
		Tester.checkInt(toh.getNumberOfDisks(3), 0, "toh", "getNumberOfDisks(3)");
		
		Tester.checkToString(toh.toString(), "toh", inScan);
		System.out.println("Move top disk from pole 1 to pole 3");
		Tester.checkTrue(toh.move(1, 3), "toh", "move(1, 3)");

		
		Tester.checkInt(toh.peekTopDisk(1).getSize(), 3, "toh", "peekTopDisk(1)");
		Tester.checkInt(toh.peekTopDisk(2).getSize(), 1, "toh", "peekTopDisk(2)");
		Tester.checkInt(toh.peekTopDisk(3).getSize(), 2, "toh", "peekTopDisk(3)");
		Tester.checkInt(toh.getNumberOfDisks(1), numDisks - 2, "toh", "getNumberOfDisks(1)");
		Tester.checkInt(toh.getNumberOfDisks(2), 1, "toh", "getNumberOfDisks(2)");
		Tester.checkInt(toh.getNumberOfDisks(3), 1, "toh", "getNumberOfDisks(3)");
		
		Tester.checkToString(toh.toString(), "toh", inScan);
		System.out.println("Move top disk from pole 2 to pole 3");
		Tester.checkTrue(toh.move(2, 3), "toh", "move(2, 3)");

		
		Tester.checkInt(toh.peekTopDisk(1).getSize(), 3, "toh", "peekTopDisk(1)");
		Tester.checkNull(toh.peekTopDisk(2), "toh", "peekTopDisk(2)");
		Tester.checkInt(toh.peekTopDisk(3).getSize(), 1, "toh", "peekTopDisk(3)");
		Tester.checkInt(toh.getNumberOfDisks(1), numDisks - 2, "toh", "getNumberOfDisks(1)");
		Tester.checkInt(toh.getNumberOfDisks(2), 0, "toh", "getNumberOfDisks(2)");
		Tester.checkInt(toh.getNumberOfDisks(3), 2, "toh", "getNumberOfDisks(3)");
		
		Tester.checkToString(toh.toString(), "toh", inScan);
		System.out.println("Reset the Tower of Hanoi");
		toh.reset();

		
		Tester.checkInt(toh.peekTopDisk(1).getSize(), 1, "toh", "peekTopDisk(1)");
		Tester.checkNull(toh.peekTopDisk(2), "toh", "peekTopDisk(2)");
		Tester.checkNull(toh.peekTopDisk(3), "toh", "peekTopDisk(3)");
		Tester.checkInt(toh.getNumberOfDisks(1), numDisks, "toh", "getNumberOfDisks(1)");
		Tester.checkInt(toh.getNumberOfDisks(2), 0, "toh", "getNumberOfDisks(2)");
		Tester.checkInt(toh.getNumberOfDisks(3), 0, "toh", "getNumberOfDisks(3)");
		
		Tester.checkToString(toh.toString(), "toh", inScan);

	}
}
