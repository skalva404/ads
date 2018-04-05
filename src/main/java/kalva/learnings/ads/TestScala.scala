package kalva.learnings.ads

import kalva.learnings.ads.tree.ThreadedNode

object TestScala extends App {
  //  println(ThreadedNode.height(ThreadedNode.createSampleTree()))
  //  ThreadedNode.printInOrder(ThreadedNode.createSampleTree())
  //  println()
  //  ThreadedNode.printDFS(ThreadedNode.createSampleTree())
  //  println()
  //  println(ThreadedNode.leftMostNode(ThreadedNode.createSampleTree()))
  //  println(ThreadedNode.rightMostNode(ThreadedNode.createSampleTree()))
  //  println(ThreadedNode.bottomRightNull(ThreadedNode.createSampleTree()))
  //  var tn = ThreadedNode(-10)
  //  println(ThreadedNode.find(ThreadedNode.createSampleTree(), 6, tn))
  //  println(tn)
  ThreadedNode.printInOrder(ThreadedNode.createSampleTree())
  println()
  println(ThreadedNode.findInorderSuccessor(ThreadedNode.createSampleTree(), 3).data)
  println(ThreadedNode.findInorderSuccessor(ThreadedNode.createSampleTree(), 5).data)
  println(ThreadedNode.findInorderSuccessor(ThreadedNode.createSampleTree(), 8).data)


  //  var r1: String = _
  //  if (null == {
  //    r1 = m1(); r1
  //  } &&
  //    null == {
  //      r1 = m2(); r1
  //    }) {
  //    println("Its null")
  //  } else {
  //    println("Its else")
  //  }
  //
  //  def m1(): String = {
  //    null
  //  }
  //
  //  def m2(): String = {
  //    null
  //  }
}
