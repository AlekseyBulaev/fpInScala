package fp.in.scala.part1

import org.scalatest.flatspec.AnyFlatSpec

import fp.in.scala.part1.ExercisesChapter3._
import fp.in.scala.part1.Chapter3._

class ExercisesChapter3Tests extends AnyFlatSpec {

  "tail function" should "return from function" in {
    assert(tail(List(1, 2, 3)) == List(2, 3))
    assertThrows[Throwable](tail(Nil))
  }

  "setHead function" should "return from function" in {
    assert(setHead(List(1, 2, 3), 0) == List(0, 2, 3))
    assertThrows[Throwable](setHead(Nil, "head"))
  }

  "drop function" should "return from function" in {
    assert(drop(List(1, 2, 3, 4, 5), 3) == List(4, 5))
    assertThrows[Throwable](drop(List(1, 2), 3))
  }

  "dropWhile function" should "return from function" in {
    assert(dropWhile(List(1, 2, 3, 4, 5), (x: Int) => x < 4) == List(4, 5))
    assertThrows[Throwable](dropWhile(Nil, (x: Int) => x > 3))
  }

  "init function" should "return from function" in {
    assert(init(List(1, 2, 3, 4, 5)) == List(1, 2, 3, 4))
    assertThrows[Throwable](init(Nil))
  }

  "length function" should "return from function" in {
    assert(length(List(1, 2, 3)) == 3)
  }

  "foldLeft" should "return from function" in {
    assert(foldLeft(List("H", "e", "l", "l", "o"), "")(_ + _) == "Hello")
    assertThrows[Throwable](foldLeft(Nil: List[Int], 0)(_ + _))
  }
}
