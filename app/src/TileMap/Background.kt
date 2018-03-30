package TileMap

import main.GamePanel
import java.awt.Graphics2D
import java.awt.image.BufferedImage
import javax.imageio.ImageIO

class Background(resourceStream: String, private val moveScale: Int) {

    private val bufferedImage: BufferedImage =
            ImageIO.read(javaClass.getResourceAsStream(resourceStream))

    private var x: Double = 0.0
    private var y: Double = 0.0
    private var dx: Double = 0.0
    private var dy: Double = 0.0

    fun setPosition(x: Double, y: Double) {
        this.x = (x * moveScale)
        this.y = (y * moveScale)
    }

    fun setVector(dx: Double, dy: Double) {
        this.dx = dx
        this.dy = dy
    }

    fun updatePosition() {
        x += dx
        y += dy
    }

    fun draw(graphics2D: Graphics2D) {
        graphics2D.drawImage(bufferedImage, x.toInt(), y.toInt(), null)

        if (x < 0) {
            graphics2D.drawImage(
                    bufferedImage,
                    x.toInt() + GamePanel.WIDTH,
                    y.toInt(),
                    null)
        }

        if (x > 0) {
            graphics2D.drawImage(
                    bufferedImage,
                    x.toInt() - GamePanel.WIDTH,
                    y.toInt(),
                    null)
        }
    }
}