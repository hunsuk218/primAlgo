package primAlgo;

import java.io.IOException;
import java.util.Scanner;

public class main {
	
	public static void main(String[] args) throws IOException
	{
		int[][] num;
		Scanner scan = new Scanner(System.in);
		System.out.println("���� �̸��� �Է��ϼ���");
		String fileName = scan.nextLine();
		num = OpenGraph.getNum(fileName);
		algo algo1 = new algo(num);
		algo1.run();
	}
}
