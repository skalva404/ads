package kalva.learnings.ads.graph;

import java.util.LinkedList;
import java.util.Stack;

public class TopoSort {

    static class Graph {

        int vertices;
        LinkedList<Integer>[] neighbors;

        public Graph(int vertices) {
            this.vertices = vertices;
            neighbors = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                neighbors[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int dest) {
            neighbors[source].addFirst(dest);
        }

        public void topologicalSorting() {

            boolean[] visited = new boolean[vertices];
            Stack<Integer> stack = new Stack<>();
            //visit from each node if not already visited
            for (int i = 0; i < vertices; i++) {
                if (!visited[i]) {
                    topologicalSortUtil(i, visited, stack);
                }
            }
            System.out.println("Topological Sort: ");
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                System.out.print(stack.pop() + " ");
            }
        }

        public void topologicalSortUtil(int start, boolean[] visited, Stack<Integer> stack) {
            visited[start] = true;
            for (int i = 0; i < neighbors[start].size(); i++) {
                int vertex = neighbors[start].get(i);
                if (!visited[vertex])
                    topologicalSortUtil(vertex, visited, stack);
            }
            stack.push(start);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(7, 6);
        graph.addEdge(7, 5);
        graph.addEdge(6, 4);
        graph.addEdge(6, 3);
        graph.addEdge(5, 4);
        graph.addEdge(5, 2);
        graph.addEdge(3, 1);
        graph.addEdge(2, 1);
        graph.addEdge(1, 0);
        graph.topologicalSorting();
    }
}
