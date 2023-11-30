package com.group11.model;

import java.util.*;

public class AStar {

    public static class Node implements Comparable<Node> {
        int x, y, cost, heuristic;

        public Node(int x, int y, int cost, int heuristic) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.heuristic = heuristic;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(cost + heuristic, other.cost + other.heuristic);
        }
    }

    public static int aStar(int[][] grid, int startX, int startY, int goalX, int goalY) {
        int n = grid.length;
        int m = grid[0].length;

        int[] dx = {-1, 0, 1, 0, -1, 1, 1, -1}; // Possible movements in x direction
        int[] dy = {0, -1, 0, 1, -1, -1, 1, 1}; // Possible movements in y direction

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startX, startY, 0, chebyshevDistance(startX, startY, goalX, goalY)));

        boolean[][] visited = new boolean[n][m];

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.x == goalX && current.y == goalY) {
                // Found the goal, return the direction
                int dxToGoal = goalX - startX;
                int dyToGoal = goalY - startY;
                return getDirection(dxToGoal, dyToGoal);
            }

            if (visited[current.x][current.y]) {
                continue;
            }

            visited[current.x][current.y] = true;

            for (int i = 0; i < 8; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] != 0) {
                    int newCost = current.cost + 1; // Assuming each step has a cost of 1
                    int heuristic = chebyshevDistance(nx, ny, goalX, goalY);
                    pq.add(new Node(nx, ny, newCost, heuristic));
                }
            }
        }

        // If the goal is not reachable, return a sentinel value (for example, -1)
        return -1;
    }

    public static int chebyshevDistance(int x1, int y1, int x2, int y2) {
        return Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2));
    }

    public static int getDirection(int dx, int dy) {
        if (dx == 0) {
            return dy > 0 ? 0 : 2; // 0 represents up, 2 represents down
        } else if (dy == 0) {
            return dx > 0 ? 1 : 3; // 1 represents right, 3 represents left
        } else if (dx > 0 && dy > 0) {
            return 5; // 5 represents bottom-right
        } else if (dx > 0 && dy < 0) {
            return 6; // 6 represents top-right
        } else if (dx < 0 && dy > 0) {
            return 4; // 4 represents bottom-left
        } else {
            return 7; // 7 represents top-left
        }
    }

//    public static void main(String[] args) {
//        int[][] grid = {
//                {0, 0, 0, 0, 0},
//                {0, 1, 1, 0, 0},
//                {0, 0, 0, 0, 0},
//                {0, 1, 1, 1, 0},
//                {0, 0, 0, 0, 0}
//        };
//
//        int startX = 0;
//        int startY = 0;
//        int goalX = 4;
//        int goalY = 4;
//
//        int direction = aStar(grid, startX, startY, goalX, goalY);
//
//        if (direction != -1) {
//            System.out.println("Direction to the goal: " + direction);
//        } else {
//            System.out.println("Goal is not reachable.");
//        }
//    }
}

