package lecture9;
import java.util.*;
public class flood_fill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0;i < n;i++) {
        	for(int j=0; j < m;j++) {
        		arr[i][j] = scn.nextInt();
        	}
        }
        
        boolean[][] visited = new boolean[n][m];
        floodfill(arr,0,0,"",visited);
	}
	
	public static void floodfill(int[][] maze,int sr,int sc,String asf,boolean[][] visited) {
		if(sr < 0 || sr >= maze.length || sc < 0 || sc >= maze[0].length || maze[sr][sc] == 1 || 
				visited[sr][sc] == true	) {
			return;
		}
		if(sr == maze.length-1 && sc == maze[0].length-1) {
			System.out.println(asf);
			return;
		}
		
		visited[sr][sc] = true;
		floodfill(maze,sr - 1,sc,asf + "t",visited);
		floodfill(maze,sr,sc - 1,asf + "l",visited);
		floodfill(maze,sr + 1,sc,asf + "d",visited);
		floodfill(maze,sr,sc + 1,asf + "r",visited);
		visited[sr][sc] = false;
	}

}
