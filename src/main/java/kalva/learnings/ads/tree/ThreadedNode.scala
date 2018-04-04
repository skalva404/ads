package kalva.learnings.ads.tree

case class ThreadedNode(data: Int,
                        left: ThreadedNode = null, right: ThreadedNode = null,
                        thread: ThreadedNode = null)

/**
  * *                            1
  * *                      2         3
  * *                   4    5   6     7
  * *                  8 9           10 11
  */
object ThreadedNode {
  def createSampleTree() = ThreadedNode(1,
    ThreadedNode(2,
      ThreadedNode(4, ThreadedNode(8), ThreadedNode(9)),
      ThreadedNode(5)),
    ThreadedNode(3,
      ThreadedNode(6),
      ThreadedNode(7, ThreadedNode(10), ThreadedNode(11))))

  def printPreOrder(node: ThreadedNode) {
    if (null != node) {
      print(node.data + "\t")
      printPreOrder(node.left)
      printPreOrder(node.right)
    }
  }

  def height(node: ThreadedNode): Int = {
    if (null == node) {
      return 0
    }
    1 + Math.max(height(node.left), height(node.right))
  }

  def printDFS(node: ThreadedNode): Unit = {
    for (i <- 1 to height(node)) {
      _printDFS(node, i)
    }
  }

  private def _printDFS(node: ThreadedNode, level: Int): Unit = {
    if (null == node) {
      return
    }
    if (1 == level) {
      print(node.data + "\t")
      return
    }
    _printDFS(node.left, level - 1)
    _printDFS(node.right, level - 1)
  }
}
