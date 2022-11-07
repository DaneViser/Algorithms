package youtube_tutoriali;

import java.util.*;

public class island_count {
    private static Set<Pair<Integer, Integer>> visited = new HashSet<>();

    private static boolean explore(List<List<Character>> grid, int row, int col, Set<Pair<Integer,Integer>> visited) {
        Pair<Integer, Integer> pos = new Pair<>(row, col);

        boolean rowInBounds = 0 <= row && row < grid.size();
        boolean colInBounds = 0 <= col && col < grid.get(0).size();
        if (!rowInBounds || !colInBounds) return false;
        if (grid.get(row).get(col) == 'W') return false;
        if (visited.contains(pos)) return false;
        visited.add(pos);

        explore(grid, row - 1, col, visited);
        explore(grid, row + 1, col, visited);
        explore(grid, row, col - 1, visited);
        explore(grid, row, col + 1, visited);

        return true;
    }

    private static int islandCount(List<List<Character>> grid) {
        int count = 0;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(0).size(); j++) {
                if(explore(grid, i, j, visited)){
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        List<List<Character>> grid = new ArrayList<>();
        grid.add(Arrays.asList('W', 'L', 'W', 'W', 'W'));
        grid.add(Arrays.asList('W', 'L', 'W', 'W', 'W'));
        grid.add(Arrays.asList('W', 'L', 'L', 'L', 'W'));
        grid.add(Arrays.asList('W', 'W', 'L', 'L', 'W'));
        grid.add(Arrays.asList('L', 'W', 'W', 'L', 'L'));
        grid.add(Arrays.asList('L', 'L', 'W', 'W', 'W'));
        System.out.println(islandCount(grid));

    }
}
