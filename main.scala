import scala.annotation.switch
import scala.reflect.Selectable.reflectiveSelectable

trait Barkable {
  def bark(): Unit
}

trait User extends Barkable

enum Dog extends Barkable {
  case Husky extends Dog
  case Poodle extends Dog

  override def bark(): Unit = println("汪汪汪")
}

enum ProductType {
    case Shipping
    case Virtual
}

sealed trait Product {
  val price: Double
  val ptype: ProductType
}

class PhysicalProduct(override val price: Double) extends Product {
    override val ptype: ProductType = ProductType.Shipping
    val shippingCost: Double = 10.0
}

class VirtualProduct(override val price: Double ) extends Product {
    override val ptype: ProductType = ProductType.Virtual
}

def vp(p: {val shippingCost: Double}): Double = p.shippingCost


@main def main(): Unit = {
    val product  = new PhysicalProduct(100.0)
    println(vp(product))
}
