package youtube_tutoriali.graphs;

import java.util.*;

public class largest_component {
    private static Set<Character> visited = new HashSet<>();

    private static int largestComponent(HashMap<Character, List<Character>> graph) {

        int longest = 0;
        for (Character node : graph.keySet()) {
            int size = exploreSize(graph, node, visited);
            if (size > longest) longest = size;
        }
        return longest;
    }

    private static int exploreSize(HashMap<Character, List<Character>> graph, Character node, Set<Character> visited) {
        if (visited.contains(node)) return 0;
        visited.add(node);
        int size = 1;
        for (Character neighbour : graph.get(node)) {
            size += exploreSize(graph, neighbour, visited);
        }
        return size;
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
        System.out.println(largestComponent(graph));
    }
}
