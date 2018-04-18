package kalva.learnings.ads.tree.binary

import kalva.learnings.ads.tree.Node

object DeepestLeftNode extends App {

  var dlLevel: Int = 0
  var dlNode: Node = _

  deepestLeftNode(createSample(), 0, left = false)
  println(dlNode)

  def createSample(): Node = {
    new Node(1,
      new Node(2,
        new Node(4, null, null),
        new Node(5, new Node(8), null)),
      new Node(3, new Node(6), new Node(7, null, null)))
  }

  def deepestLeftNode(root: Node, level: Int, left: Boolean): Unit = {
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
