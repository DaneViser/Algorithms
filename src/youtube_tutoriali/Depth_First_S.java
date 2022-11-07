package youtube_tutoriali;

import java.util.*;
// BEZ REKURZIJE
public class Depth_First_S {
    public static void depthFirstPrint(HashMap<Character, List<Character>> graph, Character source) {
        Stack<Character> stek = new Stack<>();
        stek.push(source);

        while(stek.size() > 0){
            Character current = stek.pop();
            System.out.println(current);
            for(Character neighbor: graph.get(current)){
                stek.push(neighbor);
            }
        }

    }

    public static void main(String[] args) {
        HashMap<Character, List<Character>> graph = new HashMap<>();
        graph.put('a', Arrays.asList('b', 'c')); graph.put('b', List.of('d'));
        graph.put('c', List.of('e')); graph.put('d', List.of('f'));
        graph.put('e', List.of()); graph.put('f', List.of());
        // Function
        depthFirstPrint(graph, 'a');

    }
}
