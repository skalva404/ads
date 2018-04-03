package kalva.learnings.ads.graph;

import java.util.LinkedList;
import java.util.Stack;

import kalva.learnings.ads.Graph;

/**
 * https://algorithms.tutorialhorizon.com/graph-topological-sort/
 */
public class TopologicalSort {

  private static int vertices = 8;
  private static Graph graph = new Graph(vertices, new LinkedList[vertices]);

  static {
    for (int i = 0; i < vertices; i++) {
      graph.adjList()[i] = new LinkedList<>();
    }
  }

  private static void addEgde(int source, int destination) {
    graph.adjList()[source].addFirst(destination);
  }

  private static void topologicalSorting() {
    boolean[] visited = new boolean[vertices];
    Stack<Integer> stack = new Stack<>();
    for (int i = vertices - 1; i >= 0; i--) {
      topologicalSortingUtil(i, graph.adjList()[i], visited, stack);
    }
    System.out.println(stack);
  }

  private static void topologicalSortingUtil(int currentNode, LinkedList<Integer> nodes, boolean[] visited, Stack<Integer> stack) {
    if (!visited[currentNode]) {
      stack.push(currentNode);
      visited[currentNode] = true;
    }
    for (int i = nodes.size() - 1; i >= 0; i--) {
      Integer next = nodes.get(i);
      if (!visited[next]) {
        stack.push(next);
        visited[next] = true;
      }
    }
  }

  public static void main(String[] args) {
    addEgde(7, 6);
    addEgde(7, 5);
    addEgde(6, 4);
    addEgde(6, 3);
    addEgde(5, 4);
    addEgde(5, 2);
    addEgde(3, 1);
    addEgde(2, 1);
    addEgde(1, 0);
    topologicalSorting();
  }

}
