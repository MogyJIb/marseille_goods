package by.gomel.marseille.goods.domain.extentions

import android.widget.SeekBar
import androidx.appcompat.widget.AppCompatSeekBar

fun AppCompatSeekBar.setOnSeekBarChangeListener(onProgressChanged: (seekBar: SeekBar, progress: Int, fromUser: Boolean) -> Unit)
        = setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                onProgressChanged(seekBar, progress, fromUser)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) { }
            override fun onStopTrackingTouch(seekBar: SeekBar) { }

        })