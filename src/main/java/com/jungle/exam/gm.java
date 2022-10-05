package com.jungle.exam;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description 古茗 面试手撕，确定一个有向图里有环
 * @Author Jungle
 * @DATE 2022/9/21
 **/

public class gm {
    public static void main(String[] args) {
        int[][] edges = {
                {0, 1}, {1, 2}, {2, 1}, {2, 3}
        };
        Graph graph = new Graph(5, edges);
        boolean b = graph.haveCircle();
        System.out.println(b);
    }
}

class Graph {
    //图的每条边,节点数量
    int[][] edges;
    int nodes;
    //临界表：用链表数组存储
    LinkedList<Integer>[] graph;
    //辅助：访问数组，访问路径数组，是否有环
    boolean[] visited;
    boolean[] onPath;
    boolean hasCircle;

    public Graph(int nodes, int[][] edges) {
        this.nodes = nodes;
        this.edges = edges;
        this.visited = new boolean[nodes];
        this.onPath = new boolean[nodes];
        graph = new LinkedList[nodes];
        for (int i = 0; i < nodes; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph[from].add(to);
        }
    }

    public boolean haveCircle() {
        for (int i = 0; i < nodes; i++) {
            traverse(graph, i);
        }
        return hasCircle;
    }

    private void traverse(List<Integer>[] graph, int start) {
        if (onPath[start]) {
            hasCircle = true;
            return;
        }
        if (visited[start]) return;
        //前序位置：做选择，当前节点加入路径中
        onPath[start] = true;
        //继续探索后续节点
        for (int s : graph[start]) {
            traverse(graph, s);
        }
        //后序位置：撤销选择，退出路径（回溯）
        onPath[start] = false;
    }
}
