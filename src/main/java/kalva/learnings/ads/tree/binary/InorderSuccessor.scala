package kalva.learnings.ads.tree.binary

import kalva.learnings.ads.tree.TreeNode

object InorderSuccessor extends App {

  var found: Boolean = false

  def findInorderSuccessor(root: TreeNode, value: Int): TreeNode = {
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

  def findInorderLeafNodesSuccessors(root: TreeNode): TreeNode = {
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
  findInorderSuccessor(TreeNode.createSampleTree(), 8)
  found = false
  findInorderSuccessor(TreeNode.createSampleTree(), 9)
  found = false
  findInorderSuccessor(TreeNode.createSampleTree(), 5)
  found = false
  findInorderSuccessor(TreeNode.createSampleTree(), 6)
  found = false
  findInorderSuccessor(TreeNode.createSampleTree(), 10)
  println()
  found = false
  findInorderLeafNodesSuccessors(TreeNode.createSampleTree())
}
