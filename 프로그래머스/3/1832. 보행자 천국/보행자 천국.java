import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    int MOD = 20170805;
    
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        
        dpTable=new Integer[m][n][2];
        map=cityMap;
        M=m;
        N=n;
        
        answer=dp(0,0,0);
        
        return answer;
    }
    
    Integer[][][] dpTable;
    int[][] map;
    int M;
    int N;
    
    private int dp(int row, int col, int dir){
        
        if(row==M-1&&col==N-1){
            return 1;
        }
        
        if(row>=M||col>=N){
            return 0;
        }
        
        if(dpTable[row][col][dir]!=null){
            return dpTable[row][col][dir];
        }
        
        if(map[row][col]==0){
            dpTable[row][col][0]=dpTable[row][col][1]=(dp(row+1,col,0)+dp(row,col+1,1))%MOD;
        }
        else if(map[row][col]==1){
            dpTable[row][col][0]=0;
            dpTable[row][col][1]=0;
        }
        else if(map[row][col]==2){
            dpTable[row][col][dir]=dp(row+(1-dir),col+dir,dir);
        }
        
        return dpTable[row][col][dir];
    }
}