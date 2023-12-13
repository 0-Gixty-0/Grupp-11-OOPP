package com.group11.model.utility;

import java.util.*;

/**
 * AStar search algorithm modified for use with directional values in CommandableEntity
 */
public class UAStar {

    private UAStar() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Node class representing an entity tile along with AStar attributes for cost and guess heuristic
     */
    private static class Node implements Comparable<Node> {
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

    /**
     * AStar method from start position to goal position
     * @param grid Encoded terrain matrix with only values of 1 as passable
     * @param startX Start row index
     * @param startY Start column index
     * @param goalX Goal row index
     * @param goalY Goal column index
     * @return Directional value for use in CommandableEntity
     */
    public static int aStar(List<List<Integer>> grid, int startX, int startY, int goalX, int goalY) {
        int n = grid.size();
        int m = grid.get(0).size();

        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1}; // Possible movements in x direction
        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1}; // Possible movements in y direction

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

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid.get(nx).get(ny) != 0) {
                    int newCost = current.cost + 1; // Assuming each step has a cost of 1
                    int heuristic = chebyshevDistance(nx, ny, goalX, goalY);
                    pq.add(new Node(nx, ny, newCost, heuristic));
                }
            }
        }

        // If the goal is not reachable, return a sentinel value (for example, -1)
        return -1;
    }

    /**
     * Simple chebyshev distance calculator. Distance value with all 8 grid movements allowed
     * @param x1 First node row index
     * @param y1 First node column index
     * @param x2 Second node row index
     * @param y2 Second node column index
     * @return Distance value between first and second node
     */
    private static int chebyshevDistance(int x1, int y1, int x2, int y2) {
        return Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2));
    }

    /**
     * This method gets the directional value based on directional change values in AStar
     * @param dx Difference in column index
     * @param dy Difference in row index
     * @return Directional value 0-7
     */
    public static int getDirection(int dx, int dy) {
        if (dx == 0) {
            return dy > 0 ? 2 : 6; // 2 represents right, 6 represents left
        } else if (dx > 0) {
            return dy > 0 ? 3 : (dy == 0 ? 4 : 5); // 4 represents down, 5 represents bottom left, 3 represents bottom right
        } else {
            return dy > 0 ? 1 : (dy == 0 ? 0 : 7); // 1 represents top right, 0 represents up, 7 represents top left
        }
    }
}

