package main

import javax.swing.JFrame

fun main(args: Array<String>) {
    val jFrame = JFrame("Dragon Tale")
    jFrame.contentPane = GamePanel()
    jFrame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    jFrame.isResizable = false
    jFrame.pack()
    jFrame.isVisible = true
}


