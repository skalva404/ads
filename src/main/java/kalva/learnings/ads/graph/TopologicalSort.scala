//package kalva.learnings.ads.graph
//
//import java.util
//
//import kalva.learnings.ads.Graph
//
///**
//  * https://algorithms.tutorialhorizon.com/graph-topological-sort/
//  */
//object TopologicalSort extends App {
//
//  val vertices: Int = 8
//  val graph = new Graph(vertices, new Array[util.LinkedList[Integer]](vertices))
//
//  genearteData()
//  dependency()
//
//  def addEgde(source: Int, dest: Int) = {
////    graph.adjList(source).add(dest)
//  }
//
//  def dependency() = {
//    val visited = new Array[Boolean](vertices)
//    val stack = new util.Stack[Integer]
//    for (i <- (vertices - 1) to 0 by -1) {
//      _dependency(i, stack, visited)
//    }
//    println(stack)
//  }
//
//  private def _dependency(currentNode: Integer, stack: util.Stack[Integer], visited: Array[Boolean]): Unit = {
//    if (!visited(currentNode)) {
//      stack.push(currentNode)
//      visited(currentNode) = true
//    }
//
//    import scala.collection.JavaConversions._
//    for (i <- graph.adjList(currentNode)) {
//      if (!visited(i)) {
//        visited(i) = true
//        stack.push(i)
//      }
//    }
//  }
//
//  def genearteData() = {
//
//    for (i <- 1 to vertices) {
//      graph.adjList(i - 1) = new util.LinkedList[Integer]
//    }
//
//    addEgde(7, 6)
//    addEgde(7, 5)
//    addEgde(6, 4)
//    addEgde(6, 3)
//    addEgde(5, 4)
//    addEgde(5, 2)
//    addEgde(3, 1)
//    addEgde(2, 1)
//    addEgde(1, 0)
//  }
//}
