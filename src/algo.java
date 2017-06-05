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
		nodeNum = graph.length;			//��� ����
		nearest = new int[nodeNum];		//���� ����� ���
		distance = new int[nodeNum];	//���� ����� ����� ����
		
		int now = 0;
		
		//�ʱ� ����
		for(int i = 1;i<nodeNum;i++){
			nearest[i] = 0;					//�ʱ⿡ 0�� ��尡 ���� �����ٰ� ����
			distance[i] = graph[0][i];		//distance�� ���� ����
		}
		
		for(int i=0;i<nodeNum -1;i++)	//������ ���� ��ŭ �ݺ�
		{
			int temp = 100;					//���� ū ��(���Ѵ�)
			for(int j=0;j<nodeNum;j++)
			{
				if(distance[j]> 0 && distance[j] < temp)	//temp�� ���� ������ ���Ѵ�. --> distance�� ���� ���� �� ���Ѵ�. 
				{
					temp = distance[j];
					now = j;
				}
			}
			
			System.out.println(nearest[now] + 1 + "," + (now + 1) + "����");
			
			distance[now] = 0;		//������ ������ ���� 0���� ���� �������� ���õ��� �ʵ��� �Ѵ�.
			
			for(int k = 1; k<nodeNum;k++)	//0���� �������ϱ� 1������ ����, distance�� ���� ª������ ������ �ִµ� �̰��� �ʱ�ȭ ����
			{								//�̰��� ������ now�� ���� �����ؼ� �� ª�� ���� ã�´�? ���� ���̳��� �˰��򿡼� A -> B B -> C --> A -> C �̷�������
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