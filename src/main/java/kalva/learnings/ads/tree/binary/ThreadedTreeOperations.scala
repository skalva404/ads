package kalva.learnings.ads.tree.binary

import kalva.learnings.ads.tree.ThreadedNode
import kalva.learnings.ads.tree.ThreadedNode.createSampleTree

object ThreadedTreeOperations extends App {

  populateRightNull(createSampleTree())

  def populateRightNull(root: ThreadedNode): Unit = {
    val root = ThreadedNode.createSampleTree()
    val nodes = ThreadedNode.bottomRightNull(root)
    ThreadedNode.printInOrder(root)
    for (node: ThreadedNode <- nodes) {
      ThreadedNode.findInorderSuccessor(root, node.data)
    }
    println()
    ThreadedNode.printInOrder(root)
  }
}
