package kalva.learnings.ads.tree.binary

import kalva.learnings.ads.tree.TreeNode

object DeepestLeftNode extends App {

  var dlLevel: Int = 0
  var dlNode: TreeNode = _

  deepestLeftNode(createSample(), 0, left = false)
  println(dlNode)

  def createSample(): TreeNode = {
    new TreeNode(1,
      new TreeNode(2,
        new TreeNode(4, null, null),
        new TreeNode(5, new TreeNode(8), null)),
      new TreeNode(3, new TreeNode(6), new TreeNode(7, null, null)))
  }

  def deepestLeftNode(root: TreeNode, level: Int, left: Boolean): Unit = {
    if (null == root) {
      return
    }
    if (dlLevel < level) {
      dlLevel = level
      dlNode = root
    }
    deepestLeftNode(root.getLeft, level + 1, left = true)
    deepestLeftNode(root.getRight, level + 1, left = false)
  }
}
