package fp.in.scala.part1

import fp.in.scala.part1.ExercisesChapter2._
import org.scalatest.flatspec.AnyFlatSpec

class ExercisesChapter2Tests extends AnyFlatSpec {
  "fibonacci number" should "return from function" in {
    assert(fib(10) == 55)
  }

  "sorted array" should "return true" in {
    assert(isSorted(Array(5, 4, 3, 2, 1), (a: Int, b: Int) => a > b))
  }

  "curried function" should "return from function" in {
    def f(a: Int, b: Int) = a + b
    assert(curry(f)(10)(5) == 15)
  }

  "uncurried function" should "return from function" in {
    def f(a: Int)(b: Int) =  a + b
    def uncurryFun = uncurry(f)
    assert(uncurryFun(10,5) == 15)
  }

  "compose function" should "return from function" in {
    def f: Int => Int = a => a * 2
    def g: Int => Int = b => b + 2

    assert(compose(f, g)(5) == 14)
  }
}
