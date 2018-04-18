package kalva.learnings.ads.tree.binary

import kalva.learnings.ads.tree.Node

object Siblings extends App {

  def createSublings(root: Node): Unit = {
    if (null == root) {
      return
    }
    if (null != root.getLeft) {
      root.getLeft.setSibling(root.getRight)
    }
    if (null != root.getSibling && null != root.getRight) {
      root.getRight.setSibling(root.getSibling.getLeft)
    }
    createSublings(root.getLeft)
    createSublings(root.getRight)
  }

  val tree = Node.createSampleTree()
  tree printBFS()
  createSublings(tree)
  println()
  tree printBFS()
}
