// https://leetcode.com/problems/combination-sum-iii/

package tests.algorithm.leetcode;

import java.util.*;

public class LeetCode216 implements ILCSolution {
	
	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result= new ArrayList<>();
        dfs(k,n,1,new ArrayList<Integer>(),result);
        return result;
    }

    public void dfs(int k, int target, int start,List<Integer>path,List<List<Integer>>result){
        if(k==0&&target==0){
            result.add(path);
            return;
        }
        if(k<=0) return;
        for(int i=start;i<=9;i++){
            int newT=target-i;    
            if(newT>=0){
                List<Integer> nPath= new ArrayList<>(path);
                nPath.add(i);
                dfs(k-1,newT,i+1,nPath,result);
            }else{
                break;
            }
        }
    }

	@Override
	public void myPrint() {
		// TODO Auto-generated method stub
	}

}
