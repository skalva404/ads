package kalva.learnings.ads.tree.binary

import kalva.learnings.ads.Utils
import kalva.learnings.ads.tree.Node

object PrintByOrders extends App {

  println(printLevelOrder(Node.createSampleTree()))
  println(printZigZagOrder(Node.createSampleTree()))

  def printZigZagOrder(root: Node): Unit = {
    val height = Utils.height(root)
    for (i <- 0 until height) {
      _printZigZagOrder(root, i, 0)
    }
  }

  def _printZigZagOrder(root: Node, level: Int, currentLevel: Int): Unit = {
    if (null == root) {
      return
    }
    if (level == currentLevel) {
      print(root.getData + "\t")
      return
    }
    if (0 == level % 2) {
      _printZigZagOrder(root.getLeft, level, currentLevel + 1)
      _printZigZagOrder(root.getRight, level, currentLevel + 1)
    } else {
      _printZigZagOrder(root.getRight, level, currentLevel + 1)
      _printZigZagOrder(root.getLeft, level, currentLevel + 1)
    }
  }

  def printLevelOrder(root: Node): Unit = {
    val height = Utils.height(root)
    for (i <- 0 until height) {
      _printLevelOrder(root, i, 0)
    }
  }

  def _printLevelOrder(root: Node, level: Int, currentLevel: Int): Unit = {
    if (null == root) {
      return
    }
    if (level == currentLevel) {
      print(root.getData + "\t")
      return
    }
    _printLevelOrder(root.getLeft, level, currentLevel + 1)
    _printLevelOrder(root.getRight, level, currentLevel + 1)
  }
}
