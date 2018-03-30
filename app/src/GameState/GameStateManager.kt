package GameState

import java.awt.Graphics2D

class GameStateManager {

    private val gameStateList: MutableList<GameState> = mutableListOf()
    private var currentState: Int

    companion object {
        const val MENU_STATE: Int = 0
        const val LEVEL1_STATE: Int = 1
    }

    init {
        currentState = MENU_STATE
        gameStateList.add(MenuState(this))
    }

    fun setState(state: Int) {
        currentState = state
        gameStateList[currentState].initialize()
    }

    fun update() {
        gameStateList[currentState].update()
    }

    fun draw(graphics2D: Graphics2D) {
        gameStateList[currentState].draw(graphics2D)
    }

    fun keyPressed(key: Int) {
        System.out.print("current ")
        gameStateList[currentState].keyPressed(key)
    }

    fun keyReleased(key: Int) {
        gameStateList[currentState].keyReleased(key)
    }
}