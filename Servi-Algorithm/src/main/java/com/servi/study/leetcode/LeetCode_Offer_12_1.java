package com.servi.study.leetcode;

public class LeetCode_Offer_12_1 {
    public static void main(String[] args) {
//        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        System.out.println(new LeetCode_Offer_22().exist(board, "ABCCED"));

        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(new LeetCode_Offer_12_1().exist(board, "CESEEEFS"));


//        char[][] board = new char[][]{{'a', 'b'}};
//        System.out.println(new LeetCode_Offer_22().exist(board, "ba"));
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null) {
            return false;
        }
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        char[] chs = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == chs[0]) {
                    if (bfs(board, i, j, isVisited, chs, 0)) return true;
                }
            }
        }
        return false;
    }

    boolean bfs(char[][] board, int i, int j, boolean[][] isVisited, char[] chs, int index) {
        if (index == chs.length) {
            return true;
        }
        if (i < 0 || i == board.length || j < 0 || j == board[0].length || isVisited[i][j] || board[i][j] != chs[index]) {
            return false;
        }
        isVisited[i][j] = true;
        if (bfs(board, i + 1, j, isVisited, chs, index + 1) ||
                bfs(board, i, j + 1, isVisited, chs, index + 1) ||
                bfs(board, i - 1, j, isVisited, chs, index + 1) ||
                bfs(board, i, j - 1, isVisited, chs, index + 1)) {
            return true;
        }
        isVisited[i][j] = false;
        return false;
    }
}
