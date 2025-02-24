## Notes

>The generated `toString()` will be naively recursive and will cause stack overflow when printing long lists

> ### More about variance
> ub the declaration `trait List[+A]`, the `+` in front of the type parameter `A` is a variance annotation that signals that `A` is covariant pr "positive" parameter of `List`.
> This means that, for instance, `List[Dog]` is considered a subtype of `List[Animal]`, assuming `Dog` is a subtype of `Animal`. (More generally, for all types `X` and `Y`, if `X` is a subtype of `Y`, then `List[X]` is a subtype of `List[Y]`).
> We could leave out the `+` in front of the `A`, which would make `List` invariant in that type parameter.

- *curried function* 
- 
## links

- [wiki: lambda calculus](https://en.wikipedia.org/wiki/Lambda_calculus)

## FAQ Chapter 3

`a || go(x)` considered a tail call? What about `a && go(x)`?
