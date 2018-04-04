package kalva.learnings.ads

import kalva.learnings.ads.tree.ThreadedNode

object TestScala extends App {
  println(ThreadedNode.height(ThreadedNode.createSampleTree()))
  ThreadedNode.printPreOrder(ThreadedNode.createSampleTree())
  println()
  ThreadedNode.printDFS(ThreadedNode.createSampleTree())
}
