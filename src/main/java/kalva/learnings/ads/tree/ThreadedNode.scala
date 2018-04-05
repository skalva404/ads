package kalva.learnings.ads.tree

import scala.collection.mutable.ListBuffer

case class ThreadedNode(var data: Int,
                        left: ThreadedNode = null, right: ThreadedNode = null,
                        var thread: ThreadedNode = null,
                        var tempNode: ThreadedNode = null)

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

  def printInOrder(node: ThreadedNode) {
    if (null != node) {
      printInOrder(node.left)
      if (null != node.thread) {
        print(node.data + "(" + node.thread.data + ")" + "\t")
      } else {
        print(node.data + "\t")
      }
      printInOrder(node.right)
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

  def leftMostNode(node: ThreadedNode): ThreadedNode = {
    if (null == node) {
      return null
    }
    val root = leftMostNode(node.left)
    if (null == root) {
      return node
    }
    root
  }

  def rightMostNode(node: ThreadedNode): ThreadedNode = {
    if (null == node) {
      return null
    }
    val root = rightMostNode(node.right)
    if (null == root) {
      return node
    }
    root
  }

  def printRightThread(node: ThreadedNode): Unit = {
    if (null == node) {
      return
    }
    var leftNode = leftMostNode(node)
    while (null != leftNode) {
      print(leftNode.data + "\t")
      leftNode = leftNode.thread
    }
    printRightThread(node.right)
  }

  def bottomRightNull(root: ThreadedNode): ListBuffer[ThreadedNode] = {
    val buffer: ListBuffer[ThreadedNode] = ListBuffer()
    _bottomRightNull(root, buffer)
    buffer
  }

  def findInorderSuccessor(root: ThreadedNode, value: Int): ThreadedNode = {
    var temp: ThreadedNode = null
    val searched = find(root, value)
    if (null != searched.right) {
      temp = leftMostNode(searched.right)
    } else {
      if (value == rightMostNode(root).data) {
        temp = null
      } else {
        inorderSuccessorWhenRightIsNull(root, value)
        val node = find(root, value)
        if (null != node) {
          temp = node.thread
        }
      }
    }
    temp
  }

  private def inorderSuccessorWhenRightIsNull(root: ThreadedNode, value: Int): ThreadedNode = {
    if (null == root) {
      return null
    }
    if (null != root.tempNode) {
      return null
    }
    if (root.data == value) {
      return root
    }

    var temp: ThreadedNode = null
    if (null == {
      temp = inorderSuccessorWhenRightIsNull(root.right, value)
      temp
    } && null == {
      temp = inorderSuccessorWhenRightIsNull(root.left, value)
      temp
    }) {
      return null
    }
    if (null != root.left && temp.data == root.left.data) {
      val node = find(root, value)
      if (null == node.thread) {
        node.thread = root
      }
    }
    root
  }

  def find(root: ThreadedNode, value: Int): ThreadedNode = {
    if (null == root) {
      return null
    }
    if (value == root.data) {
      return root
    }
    var temp: ThreadedNode = find(root.right, value)
    if (null != temp) {
      return temp
    }
    temp = find(root.left, value)
    if (null != temp) {
      return temp
    }
    null
  }

  private def _bottomRightNull(root: ThreadedNode, list: ListBuffer[ThreadedNode] = null): Unit = {
    if (null == root) {
      return
    }
    if (null == root.right) {
      list += root
    }
    _bottomRightNull(root.left, list)
    _bottomRightNull(root.right, list)
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
