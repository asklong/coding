package DFS;

public class Test {
	public static void main(String[]args){
		GraphTopoSorting2 g2 = new GraphTopoSorting2();
		int numCourses = 3;
		int[][] prerequisites = {{2,0},{2,1}};
		
		int [] ans = g2.findOrder(numCourses, prerequisites);
		for(int i=0; i<ans.length; i++){
			System.out.print(ans[i]+" ");
		}
	}
}
