package kalva.learnings.ads.graph

import java.util

import kalva.learnings.ads.Graph

object SoftwareInstallation extends App {

  val vertices: Int = 6
  val softwares = List('A', 'B', 'C', 'D', 'E', 'F')
  val graph = Graph(vertices, new Array[util.LinkedList[Char]](vertices))

  generateData()
  compileModules()

  def compileModules(): Unit = {
    val stack = new util.Stack[Char]()
    val visited = new Array[Boolean](vertices)
    for (module <- softwares) {
      val dep = graph.adjList(softwares.indexOf(module))
      if (null == dep) {
        stack.push(module)
        visited(softwares.indexOf(module)) = true
      }
    }
    for (i <- softwares) {
      _compileModules(i, visited, stack)
    }
    println(stack)
  }

  def _compileModules(m: Char, visited: Array[Boolean], stack: util.Stack[Char]): Unit = {
    if (!visited(softwares.indexOf(m))) {
      stack.push(m)
      visited(softwares.indexOf(m)) = true
    }
    val dep = graph.adjList(softwares.indexOf(m))
    if (null == dep) {
      return
    }
    import scala.collection.JavaConversions._
    for (module <- dep.length - 1 to 0 by -1) {
      if (!visited(softwares.indexOf(dep(module)))) {
        stack.push(dep(module))
        visited(softwares.indexOf(dep(module))) = true
      }
    }
  }

  def addEdge(source: Char, dest: Char): Unit = {
    graph.adjList(softwares.indexOf(source)).addFirst(dest)
  }

  def generateData(): Unit = {
    for (i <- 0 until vertices - 1) {
      graph.adjList(i) = new util.LinkedList[Char]()
    }
    addEdge('A', 'B')
    addEdge('A', 'C')
    addEdge('B', 'D')
    addEdge('B', 'E')
    addEdge('C', 'D')
    addEdge('D', 'E')
  }
}

