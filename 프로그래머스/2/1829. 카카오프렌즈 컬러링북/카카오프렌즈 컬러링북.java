import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        int[] mov={0,0,1,-1};
        boolean[][] visited=new boolean[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]&&picture[i][j]!=0){
                    
                    numberOfArea++;
                    
                    int count=0;
                    
                    Queue<Coordinate> queue=new ArrayDeque<>();
                    queue.offer(new Coordinate(i,j));
                    visited[i][j]=true;
                
                    while(!queue.isEmpty()){
                        
                        Coordinate c=queue.poll();
                        count++;
                        int row=c.row;
                        int col=c.col;
                        
                        for(int k=0;k<4;k++){
                            int nextrow=row+mov[k];
                            int nextcol=col+mov[3-k];
                            
                            if(nextrow>=0&&nextrow<m&&nextcol>=0&&nextcol<n&&!visited[nextrow][nextcol]&&picture[nextrow][nextcol]==picture[row][col]){
                                queue.offer(new Coordinate(nextrow,nextcol));
                                visited[nextrow][nextcol]=true;
                            }
                        }
                    }
                    maxSizeOfOneArea=Math.max(count,maxSizeOfOneArea);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    static class Coordinate{
        int row;
        int col;
        public Coordinate(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
}