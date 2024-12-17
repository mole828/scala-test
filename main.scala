trait Barkable {
  def bark(): Unit
}

trait User extends Barkable

object MainClass {
  def main(args: Array[String]): Unit = {
    val user = new User {
      override def bark(): Unit = println("我可以叫")
    }
    user.bark()
  }
}