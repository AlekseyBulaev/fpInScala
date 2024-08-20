package fp.in.scala.part1

import fp.in.scala.part1.ExercisesChapter2._
import org.scalatest.flatspec.AnyFlatSpec

class ExercisesChapter2Test extends AnyFlatSpec {
  "fibonacci number" should "return from function" in {
    assert(fib(10) == 55)
  }

  "sorted array" should "return true" in {
    assert(isSorted(Array(1, 2, 3, 4, 5), (a: Int, b: Int) => a > b))
  }
}
