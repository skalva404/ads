package kalva.learnings.ads.tree.binary

import java.util

import kalva.learnings.ads.tree.TreeNode

object SearchNode extends App {

  println(recusive(TreeNode.createSampleTree(), 10))
  println(iterative(TreeNode.createSampleTree(), 10))

  def iterative(root: TreeNode, value: Int): TreeNode = {
    val queue: util.Queue[TreeNode] = new util.LinkedList()
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

  def recusive(root: TreeNode, value: Int): TreeNode = {
    if (null == root) {
      return null
    }
    if (value == root.getData) {
      return root
    }
    var temp: TreeNode = null
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
