package kalva.learnings.ads.tree.bst

import kalva.learnings.ads.tree.{Node}
import kalva.learnings.ads.tree.bst.BSTOperations.insert

/**
  * https://algorithms.tutorialhorizon.com/convert-bst-to-greater-sum-tree/
  */
object GreaterSum extends App {

  def greaterSum(root: Node, accumulator: Array[Int]): Unit = {
    if (null == root) {
      return
    }

    greaterSum(root.getRight, accumulator)
    val i = accumulator(0) + root.getData
    root.setData(i - root.getData)
    greaterSum(root.getLeft, {
      accumulator(0) = i
      accumulator
    })
  }

  def sampleDate(): Some[Node] = {
    val root = new Node(10, null, null)
    insert(Some(root), 5)
    insert(Some(root), 15)
    insert(Some(root), 2)
    insert(Some(root), 7)
    insert(Some(root), 12)
    insert(Some(root), 20)
    Some(root)
  }

  val sample = sampleDate()
  sample.get.printBFS()
  greaterSum(sample.get, new Array[Int](1))
  println()
  sample.get.printBFS()
}
