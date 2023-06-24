package com.example.homework2

import android.os.Bundle
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import coil.load
import coil.request.CachePolicy
import com.example.homework2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val baraban = binding.baraban
        val resButton = binding.reset
        val animContr = AnimationController(baraban)
        baraban.setOnClickListener {
            binding.textCustom.setText("")
            animContr.startAnim { setResult(360 - (animContr.degree % 360) + 51.42f) }
        }
        resButton.setOnClickListener {
            binding.textCustom.setText("")
            binding.imageView.setImageDrawable(null)
        }
        binding.seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                val layoutParams = baraban.layoutParams
                layoutParams.width =
                    resources.getDimensionPixelSize(R.dimen.BarabanDefWidth) * p1 / 100
                baraban.layoutParams = layoutParams
                baraban.invalidate()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                // TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                //TODO("Not yet implemented")
            }

        })

    }

    companion object {
        const val FACTOR = 25.7142857f
    }

    fun setResult(degree: Float) {
        var factor_x = 1
        var factor_y = 3
        val resultImage = lazy {
            binding.imageView.load("https://picsum.photos/400") {
                memoryCachePolicy(CachePolicy.DISABLED)
            }
        }
        val result = arrayOf("Blue", "Indigo", "Violet", "Red", "Orange", "Yellow", "Green")
        for (i in 0..6) {
            if ((degree >= FACTOR * factor_x) && (degree < FACTOR * factor_y)) {
                when (result[i]) {
                    "Blue" -> resultImage.value
                    "Indigo" -> binding.textCustom.setText(result[i])
                    "Violet" -> binding.textCustom.setText(result[i])
                    "Red" -> binding.textCustom.setText(result[i])
                    "Orange" -> resultImage.value
                    "Yellow" -> binding.textCustom.setText(result[i])
                    "Green" -> resultImage.value
                    else -> resultImage.value
                }
                return
            }

            factor_x += 2
            factor_y += 2
        }
        resultImage.value
    }

}

