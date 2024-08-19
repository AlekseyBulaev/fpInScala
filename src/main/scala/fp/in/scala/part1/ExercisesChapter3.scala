package fp.in.scala.part1

import fp.in.scala.part1.Chapter3._
import scala.annotation.tailrec

import scala.collection.immutable.Nil.startsWith

object ExercisesChapter3 {

  /*
  3.1
  What will be the result of the following match expression?
   */
  val x: Int = List(1, 2, 3, 4, 5) match {
    case ::(x, ::(2, ::(4, _))) => x
    case Nil => 42
    case ::(x, ::(y, ::(3, ::(4, _)))) => x + y
    case ::(h, t) => h
    case _ => 101
  }

  /*
  3.2
  Implement the function tail for removing the first element of a List.
  Note that the function takes constant time.
  What are different choices you could make in your implementation if the List is Nil?
  We'll return to this question in the next chapter.
   */
  def tail[A](l: List[A]): List[A] = l match {
    case ::(_, next) => next
    case Nil => sys.error("tail of empty list")
  }

  /*
  3.3.
  Using the same idea, implement the function setHead
  for replacing the first element of a List with a different value.
   */
  def setHead[A](l: List[A], z: A): List[A] = l match {
    case ::(_, next) => ::(z, next)
    case Nil => sys.error("setHead on empty list")
  }

  /*
  3.4
  Generalize tail to the function drop, which removes the first n elements from a list.
  Note that this function takes time proportional only to the number of elements being dropped -
  we don't need to make a copy of the entire List.
   */
  @tailrec
  def drop[A](l: List[A], n: Int): List[A] = l match {
    case ::(_, next) => if (n == 0) l else drop(next, n - 1)
    case Nil => Nil
  }

  /*
  3.5
  Implement dropWhile, which removes elements from the List prefix as long as they match a predicate
   */
  @tailrec
  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
    case ::(head, next) if f(head) => dropWhile(next, f)
    case _ => l
  }

  /*
  3.6
  Not everything works out so nicely, Implement a function, init,
  that returns a List consisting of all but the last element of a List.
  So, given List(1,2,3,4), init will return List(1,2,3).
  Why can't this function be implemented in constant time like tail?
   */
  def init[A](l: List[A]): List[A] = l match {
    case ::(head, Nil) => Nil
    case ::(head, tail) => ::(head, init(tail))
    case Nil => sys.error("init on an empty list")
  }

  /*
  3.7
  Can product, implemented using foldRight, immediately halt the recursion and return 0.0 if it encounters a 0.0?
  Why or why not? Consider how any short-circuiting might work if you call foldRight with a large list.
  This is a deeper question that we'll return to in chapter 5.
   */

  /*
  3.8
  See what happens when you pass Nil and :: themselves to foldRight, like this:
  foldRight(List(1,2,3), Nil:List[Int])(::(_,_)).
  What do you think this says about the relationship between foldRight and the data constructors of List?
   */
  val testValue: List[Int] = foldRight(List(1, 2, 3), Nil: List[Int])(::(_, _))

  /*
  3.9
  Compute the length of a list using foldRight.
   */
  def length[A](l: List[A]): Int = foldRight(l, 0)((_, b) => b + 1)

  /*
  3.10
  Our implementation of foldRight is not tail-recursive and will result in a StackOverflowError for large lists
  (we say it's not stack-safe). Convince yourself that this is the case, and then write another general
  list-recursion function, foldLeft , that is tail-recursive, using the techniques
  we discussed in the previous chapter.
   */
  @tailrec
  def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B = as match {
    case Nil => z
    case ::(head, next) => foldLeft(next, f(z, head))(f)
  }

  /*
  3.11
  Write sum, product, and a function to compute the length of a list using foldLeft.
   */
  def sumFoldLeft(ints: List[Int]): Int = foldLeft(ints, 0)(_ + _)

  def productFoldLeft(ints: List[Int]): Int = foldLeft(ints, 1)(_ * _)

  def lengthFoldLeft(ints: List[Int]): Int = foldLeft(ints, 0)((_, acc) => acc + 1)

  /*
  3.12
  Write a function that returns the reverse of a list (given List(1,2,3) it returns List(3,2,1).
  See if you can write it using fold.
   */
  def reverse[A, B](l: List[A]): List[A] = foldLeft(l, List[A]())((b, a) => ::(a, b))

  /*
  3.13
  Hard: Can you write foldLeft in terms of foldRight?
  How about the other way around? Implementing foldRight via foldLeft is useful
  because it lets us implement foldRight tail-recursively,
  which means it works even for large lists without overflowing the stack.
   */

  /*
  3.14
  Implement append in terms of either foldLeft or foldRight
   */
  def append[A, B](as: List[A], z: List[A]): List[A] = foldRight(as, z)((a, b) => ::(a, b))

  /*
  3.15
  Hard: Write a function that concatenates a list into a single list.
  Its runtime should be linear in the total length of all lists.
  Try to use functions we have already defined.
   */
  def flatten[A](in: List[List[A]]): List[A] = foldRight(in, Nil: List[A])(append)

  /*
  3.16
  write a function that transforms a list of integers by adding 1 to each element.
  (Reminder: this should be a pure function that returns a new list!)
  */
  def transform(in: List[Int]): List[Int] = foldRight(in, Nil: List[Int])((a, b) => ::(a + 1, b))

  /*
  3.17
  Write a function that turns each value in a List[Double] into a String.
  You can use the expression d.toString to convert some d: Double to a String.
   */
  def turn(in: List[Double]): List[String] = foldRight(in, Nil: List[String])((a, b) => ::(a.toString, b))

  /*
  3.18
  Write a function map that generalizes modifying each element in a list
  while maintaining the structure of the list.
   */
  def map[A, B](as: List[A])(f: A => B): List[B] = foldRight(as, Nil: List[B])((a, b) => ::(f(a), b))

  /*
  3.19
  Write a function filter that removes elements from a list unless they satisfy a given predicate.
  Use it to remove all odd numbers from a List[Int].
   */
  def filter[A](as: List[A])(f: A => Boolean): List[A] = foldRight(as, Nil: List[A])((a, b) => {
    if (f(a)) ::(a, b) else b
  })

  /*
  3.20
  Write a function flatMap that works like map except that the function given
  will return a list instead of a single result,
  and that list should be inserted into the final resulting list.
   */
  def flatMap[A, B](as: List[A])(f: A => List[B]): List[B] = flatten(map(as)(f))

  /*
  3.21
  Use flatMap to implement filter.
   */

  def filterFromFlatMap[A](as: List[A])(f: A => Boolean): List[A] = flatMap(as)(a => if (f(a)) List(a) else Nil)

  /*
  3.22
  Write a function that accepts two lists and constructs a new list by adding corresponding elements.
  For example, List(1,2,3) and List(4,5,6) become List(5,7,9).
   */
  def addPairWise(as: List[Int], bs: List[Int]): List[Int] = (as, bs) match {
    case (_, Nil) => Nil
    case (Nil, _) => Nil
    case (::(head1, next1), ::(head2, next2)) => ::(head1 + head2, addPairWise(next1, next2))
  }

  /*
  3.23
  Generalize the function you just wrote so that it's not specific to integers or addition.
  Name your generalized function zipWith.
   */
  def zipWith[A, B, C](as: List[A], bs: List[B])(f: (A, B) => C): List[C] = (as, bs) match {
    case (_, Nil) => Nil
    case (Nil, _) => Nil
    case (::(head1, next1), ::(head2, next2)) => ::(f(head1, head2), zipWith(next1, next2)(f))
  }

  /*
  3.24
  Hard: As an example, implement hasSubsequence for checking whether a List contains another List as a subsequence.
  For instance, List(1,2,3,4) would have List(1,2), List(2,3), List(4) as subsequence, among others.
  You may have some difficulty finding a concise purely function implementation that is also efficient.
  That's ok. Implement the function however comes most naturally. We'll return to this implementation
  in chapter 5 and hopefully improve on it.
  Note: Any two values x and y can be compared for equality in Scala using the expression x == y.
   */
  @tailrec
  def hasSubsequence[A](sup: List[A], sub: List[A]): Boolean = sup match {
    case Nil => false
    case ::(_, next) => if (sup startsWith sub) true else hasSubsequence(next, sub)
  }

  /*
  3.25
  Write a function size that counts the numbers of nodes (leaves and branches) in a tree.
   */
  def size[A](t: Tree[A]): Int = t match {
    case Leaf(_) => 1
    case Branch(left, right) => 1 + size(left) + size(right)
  }

  /*
  3.26
  Write a function maximum that returns the maximum element in a Tree[Int].
  (Note: in Scala, you can use x.max(y) or x max y to compute the maximum of two integers a and y.)
   */
  def maximum(t: Tree[Int]): Int = t match {
    case Leaf(value) => value
    case Branch(left, right) => maximum(left) max maximum(right)
  }

  /*
  3.27
  Write a function depth that returns the maximum path length from the root of a tree to any leaf.
   */
  def depth[A](t: Tree[A]): Int = t match {
    case Leaf(_) => 0
    case Branch(left, right) => (1 + depth(left)) max (1 + depth(right))
  }

  /*
  3.28
  Write a function map, analogous to the method of the same name on List,
  that modifies each element in a tree with a given function.
   */
  def map[A, B](t: Tree[A])(f: A => B): Tree[B] = t match {
    case Leaf(value) => Leaf(f(value))
    case Branch(left, right) => Branch(map(left)(f), map(right)(f))
  }

  /*
  3.29
  Generalize size, maximum, depth, and map, writing a new function fold that abstracts over their similarities.
  Reimplement them in terms of this more general function. Can you draw an analogy between
  this fold function and the left and right folds for List?
   */
  def fold[A, B](t: Tree[A])(f: A => B)(g: (B, B) => B): B = t match {
    case Leaf(value) => f(value)
    case Branch(left, right) => g(fold(left)(f)(g), fold(right)(f)(g))
  }

  def sizeViaFold[A](t: Tree[A]): Int = fold(t)(_ => 1)(_ + _ + 1)

  def maximumViaFold(t: Tree[Int]): Int = fold(t)(a => a)(_ max _)

  def depthViaFold[A](t: Tree[A]): Int = fold(t)(_ => 0)(_ + 1 max _ + 1)

  def mapViaFold[A, B](t: Tree[A])(f: A => B): Tree[B] = fold(t)(a => Leaf(f(a)): Tree[B])(Branch(_, _))
  /*
  Summary
  In this chapter, we covered a number of important concepts. We introduced algebraic sata types and
  pattern matching, and showed how to implement purely functional data structures, including the singly linked list.
  We hope that, through the exercises in this chapter, you got more comfortable writing pure
  functions and generalizing them. We'll continue to develop these skills in the chapters ahead
   */
}
