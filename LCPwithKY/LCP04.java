package LCPwithKY;

public class LCP04 {
    public int keyboard(int k, int n) {
        long[][] dp=new long[n+1][27];
        for(int i=0;i<27;i++){
            dp[0][i]=1;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<27;j++){
                for(int p=0;p<k+1;p++){
                    //第i次按键盘，对j号字母键按了p次
                    if(i<p)
                        continue;
                    dp[i][j]+=dp[i-p][j-1]*C(i,p); 
                    dp[i][j]=dp[i][j]%1000000007;
                }                      
            }         
        }     
        return (int)dp[n][26];
    }
    
    public int C(int m, int n){
        //求组合数
        int k=1;
        int ans=1;
        while(k<=n){
            ans=((m-k+1)*ans)/k;
            k++;
        }
        return ans;
    }
}
