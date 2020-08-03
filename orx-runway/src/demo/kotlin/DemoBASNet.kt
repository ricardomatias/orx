import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.*
import org.openrndr.extra.runway.*
import org.openrndr.math.smoothstep

/**
 * This demonstrates an image reinterpretation effect.
 * This example requires a `runway/BigBiGAN` model to be active in Runway.
 */
fun main() = application {
    configure {
        width = 640
        height = 480
    }

    program {
        val image = loadImage("demo-data/images/image-001.png")

        val result: BASNETResult =
                runwayQuery("http://localhost:8000/query", BASNETRequest(image.toData()))

        val segmentImage = ColorBuffer.fromData(result.image)

        extend {
            drawer.image(segmentImage, 0.0, 0.0)
        }
    }
}