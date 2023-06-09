package com.capstone.aksaintar.ui.views.detection

import android.graphics.Bitmap
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.capstone.aksaintar.ml.Model
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer
import java.nio.ByteOrder

object TensorFLowHelper {

    val imageSize = 224
    val numChannels = 3
    val confidenceThreshold = 0.8f

    @Composable
    fun classifyImage(image: Bitmap, callback: (@Composable (fruit: String) -> Unit)) {
        val model: Model = Model.newInstance(LocalContext.current)

        val resizedImage = Bitmap.createScaledBitmap(image, imageSize, imageSize, true)

        val inputFeature0 =
            TensorBuffer.createFixedSize(
                intArrayOf(1, imageSize, imageSize, numChannels),
                DataType.FLOAT32
            )
        val byteBuffer: ByteBuffer =
            ByteBuffer.allocateDirect(4 * imageSize * imageSize * numChannels)
        byteBuffer.order(ByteOrder.nativeOrder())
        val intValues = IntArray(imageSize * imageSize)
        resizedImage.getPixels(
            intValues,
            0,
            resizedImage.width,
            0,
            0,
            resizedImage.width,
            resizedImage.height
        )
        var pixel = 0
        for (i in 0 until imageSize) {
            for (j in 0 until imageSize) {
                val value = intValues[pixel++] // RGB
                byteBuffer.putFloat((value shr 16 and 0xFF) * (1f / 255))
                byteBuffer.putFloat((value shr 8 and 0xFF) * (1f / 255))
                byteBuffer.putFloat((value and 0xFF) * (1f / 255))
            }
        }


        inputFeature0.loadBuffer(byteBuffer)

        val outputs: Model.Outputs = model.process(inputFeature0)
        val outputFeature0: TensorBuffer = outputs.outputFeature0AsTensorBuffer
        val confidences = outputFeature0.floatArray
        var maxPos = 0
        var maxConfidence = 0f
        for (i in confidences.indices) {
            if (confidences[i] > maxConfidence) {
                maxConfidence = confidences[i]
                maxPos = i
            }
        }
        val classes = arrayOf(
            "pesawat",
            "pisang",
            "beruang",
            "tempat tidur",
            "bangku",
            "burung",
            "perahu",
            "brokoli",
            "bus",
            "kue",
            "mobil",
            "kucing",
            "telepon selular",
            "jam",
            "sapi",
            "anjing",
            "donat",
            "gajah",
            "hydrant pemadam kebakaran",
            "jerapah",
            "kuda",
            "hot dog",
            "layang-layang",
            "sepeda motor",
            "jeruk",
            "oven",
            "orang",
            "pizza",
            "kulkas",
            "sandwich",
            "gunting",
            "domba",
            "wastafel",
            "tanda berhenti",
            "koper",
            "boneka beruang",
            "toilet",
            "lampu lalu lintas",
            "kereta",
            "truk",
            "payung",
            "vas bunga",
            "zebra"
        )

        val maxConfidenceClass =
            if (maxConfidence > confidenceThreshold) classes[maxPos] else "Tidak Diketahui"
        callback.invoke(maxConfidenceClass)

        model.close()
    }
}

