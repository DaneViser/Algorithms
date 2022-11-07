package youtube_tutoriali;

import java.util.*;

// BREADTH FIRST MOZE SAMO ITERATIVNO ! NE MOZE REKURZIVNO !
public class Breadth_First_S {
    private static void breadthFirstPrint(HashMap<Character, List<Character>> graph, Character source){
        Queue<Character> queue = new PriorityQueue<>();
        queue.add(source);
        while(queue.size() > 0){
            Character current = queue.remove();
            System.out.println(current);
            for(Character neighbour: graph.get(current)){
                queue.add(neighbour); // moze da se zameni sa -> queue.addAll(graph.get(current));
            }
        }
    }
    public static void main(String[] args) {
        HashMap<Character, List<Character>> graph = new HashMap<>();
        graph.put('a', Arrays.asList('b', 'c')); graph.put('b', List.of('d'));
        graph.put('c', List.of('e')); graph.put('d', List.of('f'));
        graph.put('e', List.of()); graph.put('f', List.of());
        //Functions
        System.out.println("BREATH FIRST SEARCH");
        breadthFirstPrint(graph, 'a');
    }
}
