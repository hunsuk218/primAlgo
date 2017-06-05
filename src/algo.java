public class algo {
	int nodeNum;
	int graph[][];
	int nearest[];
	int distance[];
		
	public algo(int[][] num)
	{
		this.graph = num;
	}

	public void run(){
		nodeNum = graph.length;
		nearest = new int[nodeNum];
		distance = new int[nodeNum];
		
		int now = 0;
		
		for(int i = 1;i<nodeNum;i++){
			nearest[i] = 0;
			distance[i] = graph[0][i];
		}
		
		for(int i=0;i<nodeNum -1;i++)
		{
			int temp = 100;
			for(int j=0;j<nodeNum;j++)
			{
				if(distance[j]> 0 && distance[j] < temp)
				{
					temp = distance[j];
					now = j;
				}
			}
			System.out.println(nearest[now] + 1 + "," + (now + 1) + "¼±ÅÃ");
			distance[now] = 0;
			
			for(int k = 1; k<nodeNum;k++)
			{
				if(graph[k][now] < distance[k])
				{
					distance[k] = graph[k][now];
					nearest[k] = now;
				}
			}
		}
	}
	
	public void setGraph(int[][] num)
	{
		graph = num;
	}

}