package youtube_tutoriali.graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// SA REKURZIJOM !
public class Depth_First_Sa_Rekurzijom {

    private static void depthFirstPrint(HashMap<Character, List<Character>> graph, Character source) {
        System.out.println(source);
        for(Character neighbor: graph.get(source)){
            depthFirstPrint(graph, neighbor);
        }
    }
    public static void main(String[] args) {
        HashMap<Character, List<Character>> graph = new HashMap<>();
        graph.put('a', Arrays.asList('b', 'c')); graph.put('b', List.of('d'));
        graph.put('c', List.of('e')); graph.put('d', List.of('f'));
        graph.put('e', List.of()); graph.put('f', List.of());
        // Function
        System.out.println("SA REKURZIJOM " );
        depthFirstPrint(graph, 'a');

    }

}
