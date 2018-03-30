package GameState

import java.awt.Graphics2D

abstract class GameState {

    protected var gameStateManager: GameStateManager? = null

    abstract fun initialize()
    abstract fun update()
    abstract fun draw(graphics2D: Graphics2D)
    abstract fun keyPressed(key: Int)
    abstract fun keyReleased(key: Int)
}