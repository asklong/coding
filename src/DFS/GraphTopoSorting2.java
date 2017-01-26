package DFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphTopoSorting2 {
    HashMap<Integer, Queue<Integer>> map;
    Stack<Integer> s;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    	int [] ans = {};
        map = new HashMap<>();
        s = new Stack<Integer>();
        for(int i=0; i<prerequisites.length; i++){
        	int preCourse = prerequisites[i][1];
        	int afterCourse = prerequisites[i][0];
        	Queue<Integer>checkQ = map.get(afterCourse);
        	if(checkQ!=null && !checkQ.isEmpty()){
        		for(Integer m:checkQ){
        			if (m==preCourse) {
						return ans;
					}
        		}
        	}
            map.putIfAbsent(prerequisites[i][1], new LinkedList<Integer>());
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        boolean[] visited = new boolean[numCourses];
        for(int i=0; i<numCourses; ++i){
        	if(visited[i]==false){
        		visitNode(i, visited);
        	}
            
        }
        ans = new int[numCourses];
        int j=0;
        while((j<numCourses)&&(!s.isEmpty())){
            ans[j++] = s.pop();
        }
        return ans;
    }
    void visitNode(Integer coursei, boolean[]visited){
        Queue<Integer> q = map.get(coursei);
        while(q!=null && !q.isEmpty()){
        	int course = q.poll();
        	if (visited[course] == false) {
        		visitNode(course,visited);
			}
            
        }
        s.push(coursei);
        visited[coursei] = true;
        
    }

}
