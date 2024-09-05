import fp.in.scala.part1.Chapter3.{Branch, Leaf, Tree}
import fp.in.scala.part1.ExercisesChapter4._
import fp.in.scala.part1.ExercisesChapter3._
import fp.in.scala.part1.ExercisesChapter2._

object Main extends App {

  val testList: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

  val testTree: Tree[Int] = Branch(Branch(Leaf(1), Leaf(2)), Branch(Branch(Leaf(3), Branch(Leaf(4), Leaf(5))), Leaf(6)))

}
