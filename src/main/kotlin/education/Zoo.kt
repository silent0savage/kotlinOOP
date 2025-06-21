package org.example.education

abstract class Being(
    val kingdom: String,
    val type: String,
    val group: String,
    val family: String,
    val genus: String,
    val species: String,
    val name: String
) {
    var age: Int = 0
    var isAlive: Boolean = true

    open fun describe() = "Name: $name"
}


abstract class Animal(
    type: String,
    group: String,
    family: String,
    genus: String,
    species: String,
    name: String
) : Being(
    kingdom = "Animalia",
    type = type,
    group = group,
    family = family,
    genus = genus,
    species = species,
    name = name
), LifeCycle {
    abstract fun move()
    abstract fun eat()
}


abstract class Plant (
    type: String,
    group: String,
    family: String,
    genus: String,
    species: String,
    name: String
) : Being(
    kingdom = "Plantae",
    type = type,
    group = group,
    family = family,
    genus = genus,
    species = species,
    name = name
), LifeCycle

class Tiger(
    type: String,
    group: String,
    family: String,
    genus: String,
    species: String,
    name: String,
) : Animal(
    type, group, family, genus, species, name
), LifeCycle {
    var energy : Int = 100
    var weight: Double = 1.0
    companion object {
        var tigerCount = 2
    }

    override fun move() {
        if (energy > 0) {
            println("$name prowls stealthily")
            energy -= 10
        } else {
            println("$name too tired to move")
        }
    }
    override fun eat() {
        println("$name hunts and eats prey")
        energy += 20
    }
    override fun growUp() {
        weight += 10
        println("$name is growing and gaining strength, current weight = $weight")
    }
    override fun reproduce() {
        if (tigerCount > 1) {
            tigerCount += 1
            println("Current count of tigers = $tigerCount")
        }

    }
    override fun die() {
        tigerCount--
        println("$name has died =(") }

    override fun toString(): String {
        return "Tiger(name=$name, weight=$weight, energy=$energy, count of tigers=$tigerCount)"
    }
}


class Oak(
    type: String,
    group: String,
    family: String,
    genus: String,
    species: String,
    name: String) : Plant(
    type, group, family, genus, species, name
), LifeCycle {
    var height: Double = 1.0
    companion object {
        var oakCount = 1
    }
    override fun growUp() {
        height += 10
        println("I grow up")
    }
    override fun reproduce() {
        oakCount++
        println("Seed planted new bud")
    }
    override fun die() {
        oakCount--
        println("I has withered")
    }
    override fun toString(): String {
        return "Oak(name=$name, height=$height, count of oaks = $oakCount)"
    }
}