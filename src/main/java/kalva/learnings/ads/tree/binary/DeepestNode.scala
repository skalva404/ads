package kalva.learnings.ads.tree.binary

import kalva.learnings.ads.Node

object DeepestNode extends App {

  var dl = 0
  var dn = 0

  deepestNode(Node.createSampleTree(), 1)
  println(dl + " => " + dn)

  def deepestNode(root: Node, level: Int): Unit = {
    if (null == root) {
      return
    }
    if (level > dl) {
      dl = level
      dn = root.getData
    }
    deepestNode(root.getRight, level + 1)
    deepestNode(root.getLeft, level + 1)
  }
}
