package com.jungle.exam;

import java.util.Scanner;

/**
 * @Description 科大讯飞，岛屿改版
 * @Author Jungle
 * @DATE 2022/9/18
 **/
public class kdxf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = 0, n = 0;
        int[][] origin = null;
        int[][] change = null;
        if (scanner.hasNextInt()) {
            m = scanner.nextInt();
            n = scanner.nextInt();
            origin = new int[m][n];
            change = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    origin[i][j] = scanner.nextInt();
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    change[i][j] = scanner.nextInt();
                }
            }
        }
        int[][] grid = constructGrid(origin, change);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        //从每个点往四周探索
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //非0地区不探索，减少计算
                if(grid[i][j] == 1){
                    res = Math.max(res,dfs(grid,i,j));
                }
            }
        }
        System.out.println(res);
    }

    public static int[][] constructGrid(int[][] origin, int[][] change) {
        int m = origin.length;
        int n = origin[0].length;
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (origin[i][j] == change[i][j]) {
                    grid[i][j] = 1;
                }
            }
        }
        return grid;
    }

    public static int dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        //出界
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        }
        //已經訪問過
        if(grid[i][j] == 0){
            return 0;
        }
        //访问修改
        grid[i][j] = 0;
        return dfs(grid, i - 1, j) + dfs(grid, i, j + 1) + dfs(grid, i + 1, j) + dfs(grid, i, j - 1) + 1;
    }
}
