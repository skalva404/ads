package kalva.learnings.ads.tree.binary

import kalva.learnings.ads.tree.{Node}

object MirroringTrees extends App {

  val root = Node.createSampleTree()
  var mirrorRoot = Node.createSampleTree()
  var mirrorRoot1 = new Node(root.getData, null, null)
  root.printBFS()

  println()
  mirrorTree(mirrorRoot)
  mirrorRoot.printBFS()

  println()
  print(isMirror(root, mirrorRoot))

  println()
  mirrorTree(root, mirrorRoot1)
  mirrorRoot1.printBFS()

  println()
  println(isMirror(root, mirrorRoot1))

  def mirrorTree(root: Node): Unit = {

    if (null == root) {
      return
    }
    val left = root.getLeft
    root.setLeft(root.getRight)
    root.setRight(left)
    mirrorTree(root.getLeft)
    mirrorTree(root.getRight)
  }

  def mirrorTree(root: Node, mirror: Node): Unit = {
    if (null == root) {
      return
    }
    if (null != root.getLeft) {
      mirror.setRight(new Node(root.getLeft.getData, null, null))
    }
    if (null != root.getRight) {
      mirror.setLeft(new Node(root.getRight.getData, null, null))
    }
    mirrorTree(root.getLeft, mirror.getRight)
    mirrorTree(root.getRight, mirror.getLeft)
  }

  def isMirror(thiz: Node, that: Node): Boolean = {
    if (null == thiz && null == that) {
      return true
    }
    if (that.getData != thiz.getData) {
      return false
    }

    if ((null != thiz && null == that) || (null == thiz && null != that)) {
      return false
    }
    isMirror(thiz.getLeft, that.getRight) && isMirror(thiz.getRight, that.getLeft)
  }
}
