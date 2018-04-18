package kalva.learnings.ads.tree.binary

import kalva.learnings.ads.tree.{Node}

object InorderSuccessor extends App {

  var found: Boolean = false

  def findInorderSuccessor(root: Node, value: Int): Node = {
    if (null == root) {
      return null
    }
    if (value == root.getData) {
      found = true
      return root
    }
    findInorderSuccessor(root.getLeft, value)
    if (found) {
      println(root.getData)
      found = !found
      return null
    }
    findInorderSuccessor(root.getRight, value)
  }

  def findInorderLeafNodesSuccessors(root: Node): Node = {
    if (null == root) {
      return null
    }
    findInorderLeafNodesSuccessors(root.getLeft)

    if (null == root.getLeft && null == root.getRight) {
      found = true
    } else if (found) {
      print(root.getData + "\t")
      found = !found
    }
    findInorderLeafNodesSuccessors(root.getRight)
  }

  found = false
  findInorderSuccessor(Node.createSampleTree(), 8)
  found = false
  findInorderSuccessor(Node.createSampleTree(), 9)
  found = false
  findInorderSuccessor(Node.createSampleTree(), 5)
  found = false
  findInorderSuccessor(Node.createSampleTree(), 6)
  found = false
  findInorderSuccessor(Node.createSampleTree(), 10)
  println()
  found = false
  findInorderLeafNodesSuccessors(Node.createSampleTree())
}
