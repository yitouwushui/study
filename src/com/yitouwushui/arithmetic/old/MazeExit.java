package com.yitouwushui.arithmetic.old;

import java.util.Stack;

/**
 * Created by ding on 2017/8/11.
 */

public class MazeExit {

    private class Cell {
        int x = 0; //单元所在行
        int y = 0; //单元所在列
        boolean visited = false; //是否访问过
        char c = ' ';  //是墙('1')、可通路('0')或起点到终点的路径('*')

        public Cell(int x, int y, char c, boolean visited) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.visited = visited;
        }
    }

    public void mazeExit(char[][] maze, int sx, int sy, int ex, int ey) {
        Cell[][] cells = createMaze(maze); //创建化迷宫
        printMaze(cells);  //打印迷宫
        Stack s = new Stack();  //构造堆栈
        Cell startCell = cells[sx][sy]; //起点
        Cell endCell = cells[ex][ey]; //终点
        s.push(startCell);  //起点入栈
        startCell.visited = true; //标记起点已被访问
        while (!s.isEmpty()) {
            Cell current = (Cell) s.peek();
            if (current == endCell) { //路径找到
                while (!s.isEmpty()) {
                    Cell cell = (Cell) s.pop();//沿路返回将路径上的单元设为*
                    cell.c = '*';
                    //堆栈中与 cell 相邻的单元才是路径的组成部分，除此之外，
                    //堆栈中还有记录下来但是未继续向下探索的单元，
                    //这些单元直接出栈
                    while (!s.isEmpty() && !isAdjoinCell((Cell) s.peek(), cell)) s.pop();
                }
                System.out.println("找到从起点到终点的路径。");
                printMaze(cells);
                return;
            } else { //如果当前位置不是终点
                int x = current.x;
                int y = current.y;
                int count = 0;
                if (isValidWayCell(cells[x + 1][y])) { //向下
                    s.push(cells[x + 1][y]);
                    cells[x + 1][y].visited = true;
                    count++;
                }
                if (isValidWayCell(cells[x][y + 1])) { //向右
                    s.push(cells[x][y + 1]);
                    cells[x][y + 1].visited = true;
                    count++;
                }
                if (isValidWayCell(cells[x][y - 1])) { //向左
                    s.push(cells[x][y - 1]);
                    cells[x][y - 1].visited = true;
                    count++;
                }
                if (isValidWayCell(cells[x - 1][y])) { //向上
                    s.push(cells[x - 1][y]);
                    cells[x - 1][y].visited = true;
                    count++;
                }
                Cell cell2 = ((Cell) s.peek());
                System.out.print("当前顶部-x:" + cell2.x + "  ,y:" + cell2.y);
                if (count == 0) s.pop();//如果是死点，出栈
                Cell cell3 = ((Cell) s.peek());
                System.out.println("------------x:" + cell3.x + "  ,y:" + cell3.y);
            }//end of if
        }//end of while
        System.out.println("没有从起点到终点的路径。");
    }

    private void printMaze(Cell[][] cells) {
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++)
                System.out.print(cells[x][y].c);
            System.out.println();
        }
    }

    private boolean isAdjoinCell(Cell cell1, Cell cell2) {
        if (cell1.x == cell2.x && Math.abs(cell1.y - cell2.y) < 2) return true;
        if (cell1.y == cell2.y && Math.abs(cell1.x - cell2.x) < 2) return true;
        return false;
    }

    /**
     * 判断是否为可以前进位置，如果没墙，要加边界条件
     *
     * @param cell
     * @return
     */
    private boolean isValidWayCell(Cell cell) {
        return cell.c == '0' && !cell.visited;
    }

    private Cell[][] createMaze(char[][] maze) {
        Cell[][] cells = new Cell[maze.length][];
        for (int x = 0; x < maze.length; x++) {
            char[] row = maze[x];
            cells[x] = new Cell[row.length];
            for (int y = 0; y < row.length; y++)
                cells[x][y] = new Cell(x, y, maze[x][y], false);
        }
        return cells;
    }

    public static void main(String args[]) {
        MazeExit mazeExit = new MazeExit();
        char[][] ch = {
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '1', '1', '0', '0', '1', '1'},
                {'1', '0', '0', '1', '1', '0', '0', '1', '0', '1'},
                {'1', '0', '0', '0', '0', '0', '0', '1', '0', '1'},
                {'1', '0', '0', '0', '0', '1', '1', '0', '0', '1'},
                {'1', '0', '0', '1', '1', '1', '0', '0', '0', '1'},
                {'1', '0', '0', '0', '0', '1', '0', '1', '0', '1'},
                {'1', '0', '1', '1', '0', '0', '0', '1', '0', '1'},
                {'1', '1', '0', '0', '0', '0', '1', '0', '0', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}};
        mazeExit.mazeExit(ch, 8, 8, 1, 7);
    }
}
