package kalva.learnings.ads

class SClass(val props: java.util.Map[_, _]) {
  private val p = props

  def getMap(): java.util.Map[_, _] = {
    p
  }
}
