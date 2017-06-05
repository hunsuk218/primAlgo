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
		nodeNum = graph.length;			//노드 개수
		nearest = new int[nodeNum];		//가장 가까운 노드
		distance = new int[nodeNum];	//가장 가까운 노드의 길이
		
		int now = 0;
		
		//초기 설정
		for(int i = 1;i<nodeNum;i++){
			nearest[i] = 0;					//초기에 0번 노드가 가장 가깝다고 가정
			distance[i] = graph[0][i];		//distance에 길이 저장
		}
		
		for(int i=0;i<nodeNum -1;i++)	//간선의 개수 만큼 반복
		{
			int temp = 100;					//가장 큰 값(무한대)
			for(int j=0;j<nodeNum;j++)
			{
				if(distance[j]> 0 && distance[j] < temp)	//temp가 가장 적은거 구한다. --> distance가 가장 작은 값 구한다. 
				{
					temp = distance[j];
					now = j;
				}
			}
			
			System.out.println(nearest[now] + 1 + "," + (now + 1) + "선택");
			
			distance[now] = 0;		//간선을 선택한 것은 0으로 만들어서 다음번에 선택되지 않도록 한다.
			
			for(int k = 1; k<nodeNum;k++)	//0번은 구했으니깐 1번부터 실행, distance가 가장 짧은값을 가지고 있는데 이것을 초기화 해줌
			{								//이것을 구해진 now를 통해 연결해서 더 짧은 값을 찾는다? 대충 다이나믹 알고리즘에서 A -> B B -> C --> A -> C 이런느낌임
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