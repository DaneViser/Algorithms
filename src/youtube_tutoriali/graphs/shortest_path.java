package youtube_tutoriali.graphs;

import java.util.*;

public class shortest_path {
    private static Set<Character> visited = new HashSet<>();
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

    private static int shortestPath(List<List<Character>> edges, Character nodeA, Character nodeB) {
        HashMap<Character, List<Character>> graph = buildGraph(edges);
        Queue<Pair<Character, Integer>> queue = new PriorityQueue<>();
        Pair<Character, Integer> pom = new Pair<>(nodeA, 0);
        queue.add(pom);
        visited.add(nodeA);

        while (queue.size() > 0) {
            Pair<Character, Integer> pair = queue.remove();
            if(pair.getL() == nodeB) return pair.getR();
            for(Character neighbour: graph.get(pair.getL())){
                if(!visited.contains(neighbour)){
                    visited.add(neighbour);
                    queue.add(new Pair<>(neighbour, pair.getR() + 1));
                }

            }

        }

        return -1; // vraca -1 ako nema puta
    }

    public static void main(String[] args) {
        List<List<Character>> edges = new ArrayList<>();
        edges.add(Arrays.asList('w', 'x'));
        edges.add(Arrays.asList('x', 'y'));
        edges.add(Arrays.asList('z', 'y'));
        edges.add(Arrays.asList('z', 'v'));
        edges.add(Arrays.asList('w', 'v'));
        System.out.println(buildGraph(edges));
        System.out.println(shortestPath(edges,'w', 'x'));
    }
}
