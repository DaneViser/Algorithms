package youtube_tutoriali.graphs;

import java.util.*;

// HAS PATH ZADATAK KORISTECI DFS/BFS
public class has_path_search {
    // DFS

    private static boolean has_path_dfs(HashMap<Character, List<Character>> graph, Character source, Character destination) {
        if(source == destination) return true;
        for(Character neighbor: graph.get(source)){
            if(has_path_dfs(graph, neighbor, destination))
                return true;
        }
        return false;
    }
    // BFS

    private static boolean has_path_bfs(HashMap<Character, List<Character>> graph, Character source, Character destination) {
        Queue<Character> queue = new PriorityQueue<>();
        queue.add(source);
        while(queue.size() > 0){
            Character current = queue.remove();
            if(current == destination) return true;
            for(Character neighbour: graph.get(current)){
                queue.add(neighbour);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HashMap<Character, List<Character>> graph = new HashMap<>();
        graph.put('f', Arrays.asList('g', 'i'));
        graph.put('g', List.of('h'));
        graph.put('h', List.of());
        graph.put('i', List.of('g', 'k'));
        graph.put('j', List.of('i'));
        graph.put('k', List.of());
        // Function


        // hasPath_dfs(graph, 'f', 'k'); true

        System.out.println(has_path_dfs(graph, 'f', 'k'));
        // hasPath_bfs(graph,'f','k'); true

        System.out.println(has_path_bfs(graph, 'f', 'k'));

    }
}
