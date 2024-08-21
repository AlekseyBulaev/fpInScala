package fp.in.scala.part1

object Chapter3 {

  def foldRight[A,B](as: List[A], z: B)(f: (A,B) => B): B = as match {
    case ::(head, next) => f(head, foldRight(next, z)(f))
    case Nil => z
  }

  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case ::(head, next) => head + sum(next)
  }

  def product(ints: List[Int]): Int = ints match {
    case Nil => 1
    case ::(0, _) => 0
    case ::(head, next) => head * product(next)
  }
}
