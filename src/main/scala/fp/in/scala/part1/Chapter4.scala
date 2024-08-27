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

  def mean(xs: Seq[Double]): Option[Double] =
    if (xs.isEmpty) None
    else Some(xs.sum / xs.length)

  sealed trait Either[+E, +A] {
    def map[B](f: A => B): Either[E, B]

    def flatMap[EE >: E, B](f: A => Either[EE, B]): Either[EE, B]

    def orElse[EE >: E, B >: A](b: => Either[EE, B]): Either[EE, B]

    def map2[EE >: E, B, C](b: Either[EE, B])(f: (A, B) => C): Either[EE, C]
  }

  case class Left[+E](value: E) extends Either[E, Nothing] {
    override def map[B](f: Nothing => B): Either[E, B] = ???

    override def flatMap[EE >: E, B](f: Nothing => Either[EE, B]): Either[EE, B] = ???

    override def orElse[EE >: E, B >: Nothing](b: => Either[EE, B]): Either[EE, B] = ???

    override def map2[EE >: E, B, C](b: Either[EE, B])(f: (Nothing, B) => C): Either[EE, C] = ???
  }

  case class Right[+A](value: A) extends Either[Nothing, A] {
    override def map[B](f: A => B): Either[Nothing, B] = ???

    override def flatMap[EE >: Nothing, B](f: A => Either[EE, B]): Either[EE, B] = ???

    override def orElse[EE >: Nothing, B >: A](b: => Either[EE, B]): Either[EE, B] = ???

    override def map2[EE >: Nothing, B, C](b: Either[EE, B])(f: (A, B) => C): Either[EE, C] = ???
  }

  /*
  Summary
    In this chapter, we noted some of the problems with using exceptions and introduced
  the basic principles of purely functional error handling. Although we focused on the
  algebraic data types Option and Either, the bigger idea is that we can represent
  exceptions as ordinary values and use higher-order functions to encapsulate common
  patterns of handling and propagating errors. This general idea, of representing
  effects as values, is something we'll see again and again throughout this book in
  various guises.
    We don't expect you to be fluent with all the higher-order functions we wrote in
  this chapter, but you should now have enough familiarity to get started writing your
  own functional code complete with error handling. With these new tools in hand,
  exceptions should be reserved only for truly unrecoverable conditions.
    Lastly, in this chapter we touched briefly on the notion of non-strict function
  (recall the functions orElse, getOrElse, and Try). In the next chapter, we'll look
  more closely at why non-strictness is important and how it can buy us greater modularity
  and efficiency in our functional programs.
   */
}
