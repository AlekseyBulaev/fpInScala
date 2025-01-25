## What is functional programming?

- pure functions
- side effects
- referential transparency
- substitution model


```scala
//side effects (impure)

class Cafe {
  def buyCoffee(cc: CreditCard): Coffee = {
    val cup = new Coffee()
    cc.charge(cup.price) //side effect
    cup
  }
}

```

```scala
//no side effects (pure)
class Cafe {
  def buyCoffee(cc: CreditCard): (Coffee, Charge) = {
    val cup = new Coffee()
    (cup, Charge(cc, cup.price))
  }
}
```

links:
- [fpinscala wiki](https://github.com/fpinscala/fpinscala/wiki)
- [Why Functional Programming Matters](https://www.cs.kent.ac.uk/people/staff/dat/miranda/whyfp90.pdf)
- [Functional Programming](https://en.wikipedia.org/wiki/Functional_programming)
- [Is network I/O always an effect worth tracking?](https://pchiusano.github.io/2014-05-21/what-effects-are-worth-tracking.html)
