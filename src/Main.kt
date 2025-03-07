/**
 * ===============================================================
 * Kotlin GUI Basic Starter
 * ===============================================================
 *
 * This is a starter project for a simple Kotlin GUI application.
 * The Java Swing library is used, plus the FlatLAF look-and-feel
 * for a reasonably modern look.
 */

import com.formdev.flatlaf.FlatDarkLaf
import java.awt.*
import java.awt.event.*
import javax.swing.*


/**
 * Launch the application
 */
fun main() {
    FlatDarkLaf.setup()     // Flat, dark look-and-feel
    MainWindow()            // Create and show the UI
}


/**
 * Main UI window (view)
 * Defines the UI and responds to events
 * The app model should be passwd as an argument
 */
class MainWindow : JFrame(), ActionListener, KeyListener {

    // Fields to hold the UI elements
    private lateinit var greetingLabel: JLabel
    private lateinit var helloButton: JButton
    private lateinit var goodbyeButton: JButton
    private lateinit var helloJTextField: JTextField



    /**
     * Configure the UI and display it
     */
    init {
        configureWindow()               // Configure the window
        addControls()                   // Build the UI

        setLocationRelativeTo(null)     // Centre the window
        isVisible = true                // Make it visible
    }

    /**
     * Configure the main window
     */
    private fun configureWindow() {
        title = "Kotlin Swing GUI Demo"
        contentPane.preferredSize = Dimension(600, 350)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isResizable = false
        layout = null

        pack()
    }

    /**
     * Populate the UI with UI controls
     */
    private fun addControls() {
        val defaultFont = Font(Font.SANS_SERIF, Font.PLAIN, 36)

        greetingLabel = JLabel("Hello, $name")
        greetingLabel.horizontalAlignment = SwingConstants.CENTER
        greetingLabel.bounds = Rectangle(200, 0, 300, 100)
        greetingLabel.font = defaultFont
        add(greetingLabel)

        pack()

        helloButton = JButton("Hello!")
        helloButton.bounds = Rectangle(50,200,150,150)
        helloButton.foreground = Color.YELLOW
        helloButton.background = Color(0,33,66)
        helloButton.font = defaultFont
        helloButton.addActionListener(this)     // Handle any clicks
        add(helloButton)

        pack()

        goodbyeButton = JButton("goodbye!")
        goodbyeButton.bounds = Rectangle(380,200,150,150)
        goodbyeButton.foreground = Color.YELLOW
        goodbyeButton.background = Color(0,36,68)
        goodbyeButton.font = defaultFont
        goodbyeButton.addActionListener(this)     // Handle any clicks
        add(goodbyeButton)

        pack()

        helloJTextField= JTextField(" ")
        helloJTextField.bounds = Rectangle(200,100,200,100)
        helloJTextField.foreground = Color.YELLOW
        helloJTextField.background = Color(0,21,54)
        helloJTextField.font = defaultFont
        helloJTextField.addActionListener(this)
        helloJTextField.addKeyListener(this)
        add(helloJTextField)

        pack()



    }


    /**
     * Handle any UI events (e.g. button clicks)
     */
    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {
            helloJTextField -> {
                println("name text changed!")
            }
            helloButton -> {
                println("Hello button pressed")
                var name = "stranger"
                if (helloJTextField.text.isNotBlank())  name = helloJTextField.text
                    name = helloJTextField.text
                    greetingLabel.text = "Hello there, $name!"
                    greetingLabel.foreground = Color.GREEN
                }
                goodbyeButton -> {
                    var name = "stranger"
                    if (helloJTextField.text.isNotBlank()) name = helloJTextField.text
                        name = helloJTextField.text
                        greetingLabel.text = "goodbye, $name!"
                        greetingLabel.foreground = Color.RED
                    }


                }
                greetingLabel.text = "hello there!, ${helloJTextField.text}!"

            }

    override fun keyTyped(e: KeyEvent?) {
        println("key TYPED: ${e?.keyChar}")


    }
    override fun keyPressed(e: KeyEvent?) {
        println("key PRESSED: ${e?.keyCode}")
        if (e?.keyCode in KeyEvent.VK_A .. KeyEvent.VK_Z ) {
            println("letter key:")
        } else {
            e?.consume()
        }
    }

    override fun keyReleased(e: KeyEvent?) {
        println("key RELEASED: ${e?.keyCode}")    }
}





