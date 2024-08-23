package fp.in.scala.part1

object Chapter4 {
  sealed trait Option[+A] {
    def map[B](f: A => B): Option[B]
    def flatMap[B](f: A => Option[B]): Option[B]
    def getOrElse[B >: A](default: => B): B
    def orElse[B >: A](ob: => Option[B]): Option[B]
    def filter(f: A => Boolean): Option[A]
  }
  case class Some[A](value: A) extends Option[A] {
    override def map[B](f: A => B): Option[B] = ???

    override def flatMap[B](f: A => Option[B]): Option[B] = ???

    override def getOrElse[B >: A](default: => B): B = ???

    override def orElse[B >: A](ob: => Option[B]): Option[B] = ???

    override def filter(f: A => Boolean): Option[A] = ???
  }
  case object None extends Option[Nothing] {
    override def map[B](f: Nothing => B): Option[B] = ???

    override def flatMap[B](f: Nothing => Option[B]): Option[B] = ???

    override def getOrElse[B >: Nothing](default: => B): B = ???

    override def orElse[B >: Nothing](ob: => Option[B]): Option[B] = ???

    override def filter(f: Nothing => Boolean): Option[Nothing] = ???
  }

}
