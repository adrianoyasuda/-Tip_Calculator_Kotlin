package com.yasuda.calculadoradegorjetas

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        controlaSeek()
    }


    @SuppressLint("SetTextI18n")
    private fun controlaSeek() {
        tf_porcent.text = "${sb_porcent.progress}%"

        sb_porcent.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {

                var vl_progress: Int = 0

                override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                    vl_progress = progress
                    tf_porcent.text = "$progress%"


                    val a = tf_price.text.toString().toFloat()
                    val b = a * progress.toString().toFloat()
                    val c = b / 100
                    val d = c + tf_price.text.toString().toFloat()

                    tv_gorgeta.text = "Gorgeta:    R$ $c"
                    tv_total.text = "Gorgeta:    R$ $d"
                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {}

                override fun onStopTrackingTouch(seekBar: SeekBar) {
                    tf_porcent.text = "$vl_progress%"
                }
            }
        )
    }
}
