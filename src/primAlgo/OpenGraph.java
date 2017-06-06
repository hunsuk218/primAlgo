package primAlgo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class OpenGraph {
	public static int[][] getNum(String fileName) throws IOException
	{
		BufferedReader in = new BufferedReader(new FileReader(fileName));

		String str;

		str = in.readLine();
		int firstNum = Integer.parseInt(str);
		int[][] num = new int[firstNum][firstNum];
		int count = 0;
		
		System.out.println("초기 파일 상태:");
		System.out.println(firstNum);
		
		while(true)
		{
			str = in.readLine();
			if(str == null)
				break;
			StringTokenizer tokens = new StringTokenizer(str);
			

			for(int i=0;i<firstNum;i++)
			{
				num[count][i] = Integer.parseInt(tokens.nextToken("\t"));
			}
			count++;
		}
		in.close();

		for(int i=0;i<firstNum;i++)
		{
			for(int j=0;j<firstNum;j++)
			{
				System.out.print(num[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println("초기 상태 끝!!\n");
		return num;
	}
}