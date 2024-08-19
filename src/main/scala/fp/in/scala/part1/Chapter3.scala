package fp.in.scala.part1

object Chapter3 {

  def foldRight[A,B](as: List[A], z: B)(f: (A,B) => B): B = as match {
    case ::(head, next) => f(head, foldRight(next, z)(f))
    case Nil => z
  }
}
