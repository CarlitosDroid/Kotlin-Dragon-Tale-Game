package GameState

import TileMap.Background
import java.awt.Color
import java.awt.Font
import java.awt.Graphics2D
import java.awt.event.KeyEvent

class MenuState(gameStateManager: GameStateManager) : GameState() {

    private val background: Background =
            Background("/Backgrounds/menubg.gif", 1).apply {
                setVector(-0.1, 0.0)
            }
    private var currentChoice: Int = 0
    private val options: Array<String> = arrayOf("Start", "Help", "Quit")
    private val titleColor: Color? = null
    private val titleFont: Font = Font("Century Gothic", Font.PLAIN, 28)
    private val font: Font = Font("Arial", Font.PLAIN, 12)

    init {
        this.gameStateManager = gameStateManager
    }

    override fun initialize() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update() {
        background.updatePosition()
    }

    override fun draw(graphics2D: Graphics2D) {
        //draw the background
        background.draw(graphics2D)

        //draw title
        graphics2D.color = titleColor
        graphics2D.font = titleFont
        graphics2D.drawString("Dragon Tale", 80, 70)

        //draw menu options
        graphics2D.font = font
        for (position in options.indices) {
            if (position == currentChoice) {
                graphics2D.color = Color.BLACK
            } else {
                graphics2D.color = Color.RED
            }
            graphics2D.drawString(options[position], 145, 140 + position * 15)
        }
    }

    private fun selectChoice() {
        when (currentChoice) {
            START_CHOICE_POSITION -> {
                //TODO start
            }

            HELP_CHOICE_POSITION -> {
                //TODO help
            }

            QUIT_CHOICE_POSITION -> {
                System.exit(0)
            }
        }
    }

    override fun keyPressed(key: Int) {
        when (key) {
            KeyEvent.VK_ENTER -> {
                selectChoice()
            }

            KeyEvent.VK_UP -> {

                currentChoice--
                if (currentChoice == -1) {
                    currentChoice = options.size - 1
                }
            }

            KeyEvent.VK_DOWN -> {
                currentChoice++
                if (currentChoice == options.size) {
                    currentChoice = 0
                }
            }
        }
    }

    override fun keyReleased(key: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        const val START_CHOICE_POSITION = 0
        const val HELP_CHOICE_POSITION = 1
        const val QUIT_CHOICE_POSITION = 2
    }
}