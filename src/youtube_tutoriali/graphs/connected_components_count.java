package youtube_tutoriali.graphs;

import java.util.*;

public class connected_components_count {
    private static Set<Character> visit = new HashSet<>();

    private static boolean explore(HashMap<Character, List<Character>> graph, Character current, Set<Character> visited) {
        if (visited.contains(current)) return false;
        visited.add(current);
        for (Character neighbour : graph.get(current)) {
            explore(graph, neighbour, visit);
        }

        return true;
    }

    private static int connectedComponents(HashMap<Character, List<Character>> graph) {
        int count = 0;
        for (Character node : graph.keySet()) {
            if (explore(graph, node, visit)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        HashMap<Character, List<Character>> graph = new HashMap<>();
        graph.put('0', Arrays.asList('8', '1', '5'));
        graph.put('1', Arrays.asList('0'));
        graph.put('5', Arrays.asList('0', '8'));
        graph.put('8', Arrays.asList('0', '5'));
        graph.put('2', Arrays.asList('3', '4'));
        graph.put('3', Arrays.asList('2', '4'));
        graph.put('4', Arrays.asList('3', '2'));
        System.out.println(Arrays.asList(graph));
        System.out.println(connectedComponents(graph));

    }
}
