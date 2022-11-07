package youtube_tutoriali.graphs;

import java.util.*;

public class undirected_path {

    private static HashMap<Character, List<Character>> buildGraph(List<List<Character>> edges) {
        HashMap<Character, List<Character>> graph = new HashMap<>();
        for (List<Character> edge : edges) {
            Character a = edge.get(0);
            Character b = edge.get(1);
            if (!(graph.containsKey(a))) graph.put(a, new ArrayList<>());
            if (!(graph.containsKey(b))) graph.put(b, new ArrayList<>());
            graph.get(a).add(b);
            graph.get(b).add(a);

        }

        return graph;
    }

    private static Set<Character> visi = new HashSet<>();

    private static boolean has_path(HashMap<Character, List<Character>> graph, Character src, Character dst, Set<Character> visited) {
        // DFS
        if (src == dst) return true;
        if (visited.contains(src)) return false; // koristimo visited da ne udjemo u infinite loop
        visited.add(src);                       // proveri svesku ili net za vise info
        for (Character neighbour : graph.get(src)) {
            if (has_path(graph, neighbour, dst, visited)) return true;
        }
        return false;
    }


    private static boolean undirected_path(List<List<Character>> edges, Character nodeA, Character nodeB) {
        HashMap<Character, List<Character>> graph = buildGraph(edges);
        return has_path(graph, nodeA, nodeB, visi);
    }

    public static void main(String[] args) {
        List<List<Character>> edges = new ArrayList<>();
        edges.add(Arrays.asList('i', 'j'));
        edges.add(Arrays.asList('k', 'i'));
        edges.add(Arrays.asList('m', 'k'));
        edges.add(Arrays.asList('k', 'l'));
        edges.add(Arrays.asList('o', 'n'));

        System.out.println(undirected_path(edges, 'i', 'l'));
    }
}
