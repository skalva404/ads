package kalva.learnings.ads.tree.binary

import kalva.learnings.ads.tree.ThreadedNode
import kalva.learnings.ads.tree.ThreadedNode.{bottomRightNull, createSampleTree, findInorderSuccessor, printInOrder}

/**
  * https://www.geeksforgeeks.org/threaded-binary-tree/
  */
object ThreadedTreeOperations extends App {

  populateRightNull(createSampleTree())

  def populateRightNull(root: ThreadedNode): Unit = {
    val root = createSampleTree()
    val nodes = bottomRightNull(root)
    printInOrder(root)
    for (node: ThreadedNode <- nodes) {
      findInorderSuccessor(root, node.data)
    }
    println()
    printInOrder(root)
  }
}
