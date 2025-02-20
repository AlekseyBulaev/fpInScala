package fp.in.scala.part1

import org.scalatest.flatspec.AnyFlatSpec
import fp.in.scala.part1.ExercisesChapter3.{productViaFoldLeft, _}
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

  "sum, product and length" should "return from function" in {
    assert(sumViaFoldLeft(List(1, 2, 3, 4)) == 10)
    assertThrows[Throwable](sumViaFoldLeft(Nil) == 10)
    assert(productViaFoldLeft(List(1, 2, 3, 4)) == 24)
    assertThrows[Throwable](productViaFoldLeft(Nil) == 10)
    assert(lengthViaFoldLeft(List(1, 2, 3, 4, 5)) == 5)
    assertThrows[Throwable](lengthViaFoldLeft(Nil) == 10)
  }

  "reverse function" should "return from function" in {
    assert(reverse(List(1, 2, 3)) == List(3, 2, 1))
    assertThrows[Throwable](reverse(Nil))
  }

  "append function" should "return from function" in {
    assert(appendViaFoldRight(List(1, 2, 3), List(4, 5, 6)) == List(1, 2, 3, 4, 5, 6))
    assert(appendViaFoldLeft(List(1, 2, 3), List(4, 5, 6)) == List(1, 2, 3, 4, 5, 6))
  }

  "listConcat function" should "return from function" in {
    assert(addOne(List(1, 2, 3)) == List(2, 3, 4))
  }

  "doublesToString function" should "return from function" in {
    assert(doublesToString(List(1.0, 2.0, 3.0)) == "1.02.03.0")
  }

  "map function" should "return from function" in {
    assert(map(List(1, 2, 3))(_ + 1) == List(2, 3, 4))
  }

  "filter function" should "return from function" in {
    assert(filter(List(1, 2, 3, 4))(_ >= 3) == List(3, 4))
  }

  "foldRightViaFoldLeft function" should "return from function" in {
    assert(foldRightViaFoldLeft(List(1, 2, 3), Nil: List[Int])((a, b) => ::(a, b)) == List(1, 2, 3))
    assert(foldRightViaFoldLeft((1 to 100000).toList, 0)((a: Int, b: Int) => a + b) == 705082704)
  }

  "foldLeftViaFoldRight function" should "return from function" in {
    assert(foldLeftViaFoldRight(List(1, 2, 3), Nil: List[Int])((a, b) => ::(b, a)) == List(1, 2, 3))
    assertThrows[StackOverflowError](foldLeftViaFoldRight((1 to 100000).toList, 0)((a: Int, b: Int) => a + b))
  }

  "listConcat funciton" should "return from funciton" in {
    assert(listConcat(List(List(1, 2), List(3, 4), List(5, 6))) == List(1, 2, 3, 4, 5, 6))
  }
}
