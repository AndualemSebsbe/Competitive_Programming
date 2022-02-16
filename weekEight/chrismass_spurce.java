import java.util.*;
 
public class chrismass_spurce {
	
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	
    public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
        int n = scan.nextInt();
		
		int[] dp = new int[n];
		
		for(int j=0;j<n;++j)
			adj.add(new ArrayList<Integer>());
		
		
		for(int i=1;i<n;++i)
		{
			int node = scan.nextInt();
			addEdge(adj,node-1,i);
		}
		
		
		DFS(0,0,dp);
		boolean spruce = true;
		for(int z: dp)
			if(z==1)
				spruce = false;
		
		if(spruce)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
	
	public static void addEdge(ArrayList<ArrayList<Integer>> adj,int u,int v)
	{
		adj.get(u).add(v);
	}
    
    public static void DFS(int curr,int par,int[] dp)
	{
		int leafNode=0;
		if(adj.get(curr).size()>0)
		{
			for(int child: adj.get(curr))
			{
				if(adj.get(child).size()==0)
				{
					leafNode++;
				}
				else
					DFS(child,curr,dp);
			}
			
			if(leafNode<3)
				dp[curr] = 1;
		}
	}
}