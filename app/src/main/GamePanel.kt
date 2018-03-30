package main

import GameState.GameStateManager
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import java.awt.image.BufferedImage
import javax.swing.JPanel

class GamePanel : JPanel(), Runnable, KeyListener {

    companion object {
        //dimesions
        const val WIDTH = 320
        const val HEIGHT = 240
        const val SCALE = 2
        //fps
        const val FPS = 60
    }

    //game thread
    private lateinit var thread: Thread
    private var running = true
    private val targetTime = (1000 / FPS)

    //image
    private val bufferedImage = BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB)
    private val graphics2D = bufferedImage.graphics as Graphics2D

    //game state manager
    private val gameStateManager: GameStateManager = GameStateManager()

    init {
        preferredSize = Dimension(WIDTH * SCALE, HEIGHT * SCALE)
        isFocusable = true
        requestFocus()
    }

    override fun addNotify() {
        super.addNotify()
        System.out.println("ADDNOTIFY")
        thread = Thread(this)
        addKeyListener(this)
        thread.start()
    }

    override fun run() {
        System.out.println("RUN")

        var start: Long
        var elapsed: Long
        var wait: Long

        //game loop
        while (running) {
            start = System.nanoTime()

            update()
            draw()
            drawToScreen()

            elapsed = System.nanoTime() - start

            wait = targetTime - elapsed / 1000000

            if (wait < 0) {
                wait = 5
            }
            try {
                Thread.sleep(wait)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun update() {
        gameStateManager.update()
    }

    private fun draw() {
        gameStateManager.draw(graphics2D)
    }

    private fun drawToScreen() {
        graphics.drawImage(bufferedImage,
                0,
                0,
                WIDTH * SCALE,
                HEIGHT * SCALE,
                null)
        graphics.dispose()
    }

    override fun keyTyped(e: KeyEvent?) {
    }

    override fun keyPressed(e: KeyEvent) {
        System.out.print("NOSEEEEE")
        gameStateManager.keyPressed(e.keyCode)
    }

    override fun keyReleased(e: KeyEvent) {
        gameStateManager.keyReleased(e.keyCode)
    }
}