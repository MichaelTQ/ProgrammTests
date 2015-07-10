package tests.algorithm.leetcode;

public class LeetCode214 implements ILCSolution {
	
	public int[] KMPpreprocess(String S){
	    int[] pi=new int[S.length()];
	    //init start of pi
	    pi[0]=-1;
	    //get each index in pi, i is the index being processed
	    for (int i=1;i<pi.length;i++){
	        int j=pi[i-1];
	        while (j!=-1 && S.charAt(j+1)!=S.charAt(i)) {j=pi[j];}
	        if (j==-1){
	            if (S.charAt(0)==S.charAt(i)) pi[i]=0;
	            else pi[i]=-1;
	        }
	        else if (S.charAt(j+1)==S.charAt(i)){
	            pi[i]=j+1;
	        }

	    }

	    return pi;
	}

	public String shortestPalindrome(String s) {
		if("".equals(s) || null == s) return s;
	    String sPlus=s+"#" + new StringBuilder(s).reverse().toString();
	    
	    int[] PI=KMPpreprocess(sPlus);
	    int palinIndex=Math.min(PI[PI.length-1],s.length()-1);

	    String nonPalin=s.substring(palinIndex+1);
	    String Palin=s.substring(0,palinIndex+1);
	    
	    return new StringBuilder(nonPalin).reverse().toString() + Palin+nonPalin;
	}
	
	public String shortestPalindromeEasy(String s) {
		if(null == s) return s;
		String subString = s;
		StringBuffer sb = new StringBuffer();
		while(!this.isPalindrome(subString)) {
			sb.append(subString.charAt(subString.length() - 1));
			subString = subString.substring(0, subString.length() - 1);
		}
		sb.append(s);
		return sb.toString();
	}
	
	private boolean isPalindrome(String s) {
		if(s == null) {
			return false;
		}
		int start = 0;
		int end = s.length() - 1;
		while(start < end) {
			if(s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	@Override
	public void myPrint() {
		// TODO Auto-generated method stub
	}

}
