# Scala TypeSystem Playground

## What is this? 
A project to illustrate the differences between a Inheritance-Based Polymorphism and Instance-Based Polymorphism.

## Examples

![PokemonImage](/asset/PokemonImage.png)

In the [example package](/src/test/scala/sandbox/pokemon), a selection of Pokémon are modeled with the goal of providing a handful of behaviors, `Moves`, `PrimaryType`, an optional `SecondaryType`, and a way to indicate evolutionary trees.

An implementation is given using [inheritance-based polymorphism](/src/test/scala/sandbox/pokemon/inheritance), as well as one using [instance-based polymorphism](/src/test/scala/sandbox/pokemon/instances). 

While the approaches are slightly different, both implementations are [able to provide the same API](/src/test/scala/sandbox/pokemon/Test.scala).

In the [inheritance-based polymorphism example](/src/test/scala/sandbox/pokemon/inheritance), code tends to be organized by domain objects. 
While in the [instance-based polymorphism example](/src/test/scala/sandbox/pokemon/instances), code is organized by behavior that it provides. 



## Getting Started
- Install `sbt`
- Clone this repository 
- Launch `sbt`
- Run the tests with `sbt test`
