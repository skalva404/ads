//class Cell{
//  int row;
//  int col;
//  int dist;
//}
//
//  int findDistance(int[][] matrix, int m, int n){
//    int rows = matrix.length;
//    int cols = matrix[0].length;
//    boolean[][] visited = new boolean[rows][cols];
//    Queue<Cell> queue = new LinkedList<>();
//    int answer = -1;
//    queue.offer(new Cell(0, 0, 0));
//    visisted[0][0] = true;
//    while(!queue.isEmpty()) {
//      Cell c = queue.poll();
//      if(c.row == m && c.col ==n){
//        answer = c.dist;
//        break;
//      }
//      if(c.row>0 && !visited[c.row-1][c.col] && matrix[c.row-1][c.col] == 1){
//        visited[c.row-1][c.col] = true;
//        queue.offer(new Cell(c.row-1, c.col, c.dist+1));
//      }
//      if(c.col>0 && !visited[c.row][c.col-1] && matrix[c.row][c.col-1] == 1){
//        visited[c.row][c.col-1] = true;
//        queue.offer(new Cell(c.row, c.col-1, c.dist+1));
//      }
//      if(c.row<m-1 && !visited[c.row+1][c.col] && matrix[c.row+1][c.col] == 1){
//        visited[c.row+1][c.col] = true;
//        queue.offer(new Cell(c.row+1, c.col, c.dist+1));
//      }
//      if(c.col<n-1 && !visited[c.row][c.col+1] && matrix[c.row][c.col+1] == 1){
//        visited[c.row][c.col+1] = true;
//        queue.offer(new Cell(c.row, c.col+1, c.dist+1));
//      }
//
//    }
//    return answer;
//  }