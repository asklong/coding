package DP;

public class UnbdKnap {
	//we want to put the items to the package with W as it's volume
	//suppose the voulme is n, we want to get the max value when put the package full
	//dp[n] = max{ dp[n], dp[n- wt[i]] + val[i] }
	//we consider it's sub problem, if the package include item i,
	//the rest volume is n-wt[i], it's max value is dp[n-wt[i]], and value of item i is val[i]
	//for each i, we check the value, and find the max value for volume n
	static int unboundedKnapsack(int W, int val[], int wt[]){
		int [] dp = new int[W+1];
		//dp[0] is 0, means if volume of the package is 0, the max value is 0
		dp[0] = 0;
		//the first for loop means the sub problem of left side of i is already solved
		for(int i=1; i<=W; ++i){
			//for package with volume i, try each item
			for(int j=0; j<wt.length; j++){
				//if package could include the item i
				if(i>=wt[j]){
					dp[i] = Math.max(dp[i], dp[i-wt[j]] + val[j]);
				}
			}//for
		}//for
		return dp[W];
	}
	public static void main(String[]args){
		int W = 100;
		int val[] = {10,30,20};
		int wt[] = {5, 10, 15};
		int r = unboundedKnapsack(W, val, wt);
		System.out.println(r);
	}
}
