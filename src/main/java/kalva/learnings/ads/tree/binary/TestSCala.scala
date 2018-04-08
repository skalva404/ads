package kalva.learnings.ads.tree.binary

class TestSCala {

  def ->(str: String): Unit = {
    print("-> " + str)
  }
}

object TestSCala extends App {
  new TestSCala -> "sunil"
}
