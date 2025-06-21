package org.example.education

interface Base {
    fun someFun()
}

interface Player{
    fun damageInfo(damage: Int)
    fun rankInfo(rank: String)
}

class BaseImpl() : Base {
    override fun someFun() {
        println("BaseImpl: doing someFun()")
    }
}

class Derived(someBase: Base) : Base by someBase

class DamageManager(val gunName: String): Player {
    override fun damageInfo(damage: Int) {
        println("The gun $gunName has $damage damage")
    }

    override fun rankInfo(rank: String) {
        println("Your rank: $rank")
    }
}

class FakeGun : Player {
    override fun damageInfo(damage: Int) {
        println("Pew pew... Oh no , this is a toy gun!")
    }

    override fun rankInfo(rank: String) {
        println("I'm a GLOBALL!!!")
    }
}

class User(val name: String, p: Player): Player by p // делегирует все вызовы p


fun main() {
    val fake = FakeGun()
    val kid = User("Little Timmy", fake)
    val m16 = DamageManager("m16")
    val ak47 = DamageManager("ak-47")
    val silver = User("silver 3", m16)
    val global = User("Global", ak47)
    silver.damageInfo(45)
    silver.damageInfo(82)
    silver.rankInfo("silver 3")
    global.damageInfo(100)
    global.rankInfo("global")
    kid.damageInfo(999)
}