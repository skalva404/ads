package kalva.learnings.ads.tree.binary

import kalva.learnings.ads.tree.TreeNode

object MirroringTrees extends App {

  val root = TreeNode.createSampleTree()
  var mirrorRoot = TreeNode.createSampleTree()
  var mirrorRoot1 = new TreeNode(root.getData, null, null)
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

  def mirrorTree(root: TreeNode): Unit = {

    if (null == root) {
      return
    }
    val left = root.getLeft
    root.setLeft(root.getRight)
    root.setRight(left)
    mirrorTree(root.getLeft)
    mirrorTree(root.getRight)
  }

  def mirrorTree(root: TreeNode, mirror: TreeNode): Unit = {
    if (null == root) {
      return
    }
    if (null != root.getLeft) {
      mirror.setRight(new TreeNode(root.getLeft.getData, null, null))
    }
    if (null != root.getRight) {
      mirror.setLeft(new TreeNode(root.getRight.getData, null, null))
    }
    mirrorTree(root.getLeft, mirror.getRight)
    mirrorTree(root.getRight, mirror.getLeft)
  }

  def isMirror(thiz: TreeNode, that: TreeNode): Boolean = {
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
