package com.servi.study.leetcode;

public class LeetCode_Offer_12 {
    public static void main(String[] args) {
//        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        System.out.println(new LeetCode_Offer_22().exist(board, "ABCCED"));

        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        System.out.println(new LeetCode_Offer_12().exist(board, "CESEEEFS"));



//        char[][] board = new char[][]{{'a', 'b'}};
//        System.out.println(new LeetCode_Offer_22().exist(board, "ba"));
    }

    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int[] visited = new int[board.length * board[0].length];
                if (dfs(board, w, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, char[] w, int i, int j, int index, int[] visited) {

        int len = board[0].length * i + j;
        if (visited[len] == 1) {
            return false;
        }

        char a = board[i][j];
        char b = w[index];
        if (a != b) {
            return false;
        }

        visited[len] = 1;

        if (index < w.length - 1) {
            index++;
        } else {
            return true;
        }

        if (i - 1 >= 0 && dfs(board, w, i - 1, j, index, visited)) {
            return true;
        }

        if (i + 1 < board.length && dfs(board, w, i + 1, j, index, visited)) {
            return true;
        }

        if (j - 1 >= 0 && dfs(board, w, i, j - 1, index, visited)) {
            return true;
        }

        if (j + 1 < board[0].length && dfs(board, w, i, j + 1, index, visited)) {
            return true;
        }
        visited[len] = 0;
        return false;
    }
}
