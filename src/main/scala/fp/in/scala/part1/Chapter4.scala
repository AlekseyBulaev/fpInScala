package fp.in.scala.part1

object Chapter4 {
  sealed trait Option[+A] {
    def map[B](f: A => B): Option[B] = this match {
      case Some(value) => Some(f(value))
      case None => None
    }
    def getOrElse[B >: A](default: => B): B = this match {
      case Some(value) => value
      case None => default
    }

    def flatMap[B](f: A => Option[B]): Option[B] = this match {
      case Some(value) => f(value)
      case None => None
    }

    def flatMapViaMap[B](f: A => Option[B]): Option[B] = map(f) getOrElse None

    def orElse[B >: A](ob: => Option[B]): Option[B] = this match {
      case Some(value) => this
      case None => ob
    }

    def orElseViaGetOrElse[B >: A](ob: => Option[B]): Option[B] = this map(Some(_)) getOrElse ob
    def filter(f: A => Boolean): Option[A] = this match {
      case Some(value) if (f(value)) => Some(value)
      case _ => None
    }

    def filterViaFlatMap(f: A => Boolean): Option[A] = flatMap(a => if(f(a)) Some(a) else None)
  }
  case class Some[A](value: A) extends Option[A]

  case object None extends Option[Nothing]

  def mean(xs: Seq[Double]): Double =
    if (xs.isEmpty) throw new ArithmeticException("mean of empty list!")
    else xs.sum / xs.length

  sealed trait Either[+E, +A] {
    def map[B](f: A => B): Either[E, B] = this match {
      case Left(value) => Left(value)
      case Right(value) => Right(f(value))
    }

    def flatMap[EE >: E, B](f: A => Either[EE, B]): Either[EE, B] = this match {
      case Left(value) => Left(value)
      case Right(value) => f(value)
    }

    def orElse[EE >: E, B >: A](b: => Either[EE, B]): Either[EE, B] = this match {
      case Left(value) => b
      case _ => this
    }

    def map2[EE >: E, B, C](b: Either[EE, B])(f: (A, B) => C): Either[EE, C] = this match {
      case Left(value) => ???
      case Right(value) => ???
    }
  }

  case class Left[+E](value: E) extends Either[E, Nothing]

  case class Right[+A](value: A) extends Either[Nothing, A]

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
