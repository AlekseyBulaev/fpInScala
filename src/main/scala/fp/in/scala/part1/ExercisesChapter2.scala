package fp.in.scala.part1

import scala.annotation.tailrec

object ExercisesChapter2 {

  /*
  2.1
  Write a recursive function to get nth Fibonacci number (http://mng.bz/C29s).
  The first two Fibonacci numbers are 0 and 1. The nth number is always the sum of the previous two -
  the sequence begins 0,1,1,2,3,5,8,13. You definition should ve use a local tail-recursive function.
   */
  def fib(n: Int): Int = {
    @tailrec
    def go(current: Int, previous: Int, left: Int): Int = {
      if (left == n) current
      else go(current + previous, current, left + 1)
    }
    if (n > 1 ) go(1, 0, 1)
    else if( n >= 0) n
    else sys.error("fib on the negative input")
  }

  /*
  2.2
  Implement isSorted, which checks whether an Array[A] is sorted according to a given comparison function.
   */
  def isSorted[A](as: Array[A], f: (A, A) => Boolean): Boolean = {
    @tailrec
    def go(n: Int): Boolean = {
      if(n >= as.length - 1) true
      else if(f(as(n), as(n+1))) false
      else go(n+1)
    }
    go(0)
  }

  /*
  2.3
  Let's look at another example, currying, which converts a function of two arguments into a function of one argument
  that partially applies f. Here again there's only one implementation that compiles.
   */
  def curry[A, B, C](f: (A, B) => C): A => B => C = a => b => f(a, b)

  /*
  2.4
  Implement uncurry, which reverses the transformation of curry. Note that since => associates to the right,
  A => (B => C) can be written as A => B => C
   */
  def uncurry[A, B, C](f: A => B => C): (A, B) => C = (a,b) => f(a)(b)

  /*
  2.5
  Implement the higher-order function that compose two functions.
   */
  def compose[A, B, C](f: B => C, g: A => B): A => C = a => f(g(a))
}
