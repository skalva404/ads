package kalva.learnings.ads.tree.binary

import java.util

import kalva.learnings.ads.tree.{Node}

object SearchNode extends App {

  println(recusive(Node.createSampleTree(), 10))
  println(iterative(Node.createSampleTree(), 10))

  def iterative(root: Node, value: Int): Node = {
    val queue: util.Queue[Node] = new util.LinkedList()
    queue.add(root)
    while (!queue.isEmpty) {
      val node = queue.poll()
      if (value == node.getData) {
        return node
      }
      if(null != node.getLeft) {
        queue.add(node.getLeft)
      }
      if(null != node.getRight) {
        queue.add(node.getRight)
      }
    }
    null
  }

  def recusive(root: Node, value: Int): Node = {
    if (null == root) {
      return null
    }
    if (value == root.getData) {
      return root
    }
    var temp: Node = null
    if (null == {
      temp = recusive(root.getLeft, value)
      temp
    } &&
      null == {
        temp = recusive(root.getRight, value)
        temp
      }) {
      return null
    }
    temp
  }
}
