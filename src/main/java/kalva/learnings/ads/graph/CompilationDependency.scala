package kalva.learnings.ads.graph

import java.util

import kalva.learnings.ads.Graph

object CompilationDependency extends App {

  val vertices: Int = 8
  val graph = Graph(vertices, new Array[util.LinkedList[Integer]](vertices))

  for (i <- 1 to vertices) {
    graph.adjList(i) = new util.LinkedList[Integer]
  }

  def addEgde(source: Int, dest: Int) = {
    graph.adjList(source).add(dest)
  }

  def dependency() = {
    val stack = new util.Stack[Integer]
    for (i <- (vertices - 1) to 0 by -1) {
      
    }
  }

  def genearteData() = {
    addEgde(7, 6)
    addEgde(7, 5)
    addEgde(6, 4)
    addEgde(6, 3)
    addEgde(5, 4)
    addEgde(5, 2)
    addEgde(3, 1)
    addEgde(2, 1)
    addEgde(1, 0)
  }
}
