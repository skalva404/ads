package kalva.learnings.ads.tree.bst

import kalva.learnings.ads.tree.Node

object BSTOperations extends App {

  testDelete()

  def insert(root: Option[Node], value: Integer): Node = {
    val node = root.get
    if (null == node) {
      return new Node(value, null, null)
    }
    if (value < root.get.getData) {
      root.get.setLeft(insert(Some(root.get.getLeft), value))
    }
    if (value > root.get.getData) {
      root.get.setRight(insert(Some(root.get.getRight), value))
    }
    root.get
  }

  def delete(root: Some[Node], key: Int): Node = {
    if (null == root || null == root.get) {
      return null
    }
    if (key > root.get.getData) {
      root.get.setRight(delete(Some(root.get.getRight), key))
    } else if (key < root.get.getData) {
      root.get.setLeft(delete(Some(root.get.getLeft), key))
    } else {
      if (null == root.get.getLeft) {
        return root.get.getRight
      } else if (null == root.get.getRight) {
        return root.get.getLeft
      }
      root.get.setData(Node.leftMostNode(root.get.getRight).getData)
      root.get.setRight(delete(Some(root.get.getRight), root.get.getData))
    }
    root.get
  }

  /**
    * *         50
    * *     /       \
    * *   30       70
    * *   /  \      /  \
    * * 20   40  60  80
    */
  def testDelete(): Unit = {
    val root = sampleDate()
    root.printInOrder()
    println()

    delete(Some(root), 40)
    root.printInOrder()
    println()

    delete(Some(root), 80)
    root.printInOrder()
    println()

    delete(Some(root), 70)
    root.printInOrder()
    println()

    delete(Some(root), 50)
    root.printInOrder()
    println()

    delete(Some(root), 20)
    root.printInOrder()
    println()
  }

  def sampleDate(): Node = {
    val root: Node = new Node(50, null, null)
    insert(Some(root), 30)
    insert(Some(root), 70)
    insert(Some(root), 20)
    insert(Some(root), 40)
    insert(Some(root), 60)
    insert(Some(root), 80)
    root
  }
}
