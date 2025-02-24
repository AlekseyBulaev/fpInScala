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
    assert(doublesToString(List(1.0, 2.0, 3.0)) == List("1.0", "2.0", "3.0"))
  }

  "3.18 map function" should "return from function" in {
    assert(map(List(1, 2, 3))(_ + 1) == List(2, 3, 4))
  }

  "3.19 filter function" should "return from function" in {
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

  "concat function" should "return from funciton" in {
    assert(concat(List(List(1, 2), List(3, 4), List(5, 6))) == List(1, 2, 3, 4, 5, 6))
  }

  "3.20 flatMap function" should "return from function" in {
    assert(flatMap(List(1, 2, 3))(a => List(a, a)) == List(1, 1, 2, 2, 3, 3))
  }

  "3.21 filterViaFlatMap function" should "return from function" in {
    assert(filterViaFlatMap(List(1, 2, 3, 4, 5))((a) => a >= 3) == List(3, 4, 5))
  }

  "3.22 addPairwise function" should "return from function" in {
    assert(addPairwise(List(1, 2, 3), List(4, 5, 6)) == List(5, 7, 9))
  }

  "3.23 zipWith function" should "return from function" in {
    assert(zipWith(List(1, 2, 3), List(4, 5, 6))((a: Int, b: Int) => a + b) == List(5, 7, 9))
  }

  "3.24 hasSubsequence function" should "return from function" in {
    assert(hasSubsequence(List(1, 2, 3, 4, 5, 6), List(5, 6)))
  }

  val tree: Tree[Int] = Branch(Branch(Branch(Leaf(1), Branch(Leaf(2), Leaf(3))), Leaf(4)), Leaf(0))

  "3.25 size function" should "return from function" in {
    assert(size(tree) == 9)
  }

  "3.26 maximum function" should "return from function" in {
    assert(maximum(tree) == 4)
  }

  "3.27 depth function" should "return from function" in {
    assert(depth(tree) == 5)
  }

  "3.28 map function" should "return from function" in {
    assert(map(tree)(a => a + 1) == Branch(Branch(Branch(Leaf(2), Branch(Leaf(3), Leaf(4))), Leaf(5)), Leaf(1)))
  }

  "3.29 fold function" should "return from function" in {
    assert(fold(tree)(a => a)(_ + _) == 10)
  }

  "3.29 mapViaFold function" should "return from function" in {
    assert(mapViaFold(tree)(a => a + 1) == Branch(Branch(Branch(Leaf(2), Branch(Leaf(3), Leaf(4))), Leaf(5)), Leaf(1)))
  }

  "3.29 sizeViaFold function" should "return from function" in {
    assert(sizeViaFold(tree) == 9)
  }

  "3.29 maximumViaFold function" should "return from function" in {
    assert(maximumViaFold(tree) == 4)
  }

  "3.29 depthViaFold function" should "return from function" in {
    assert(depthViaFold(tree) == 5)
  }
}
