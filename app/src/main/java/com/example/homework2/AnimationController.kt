package com.example.homework2

import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.RotateAnimation
import kotlin.random.Random

class AnimationController(private val view: View) : AnimationListener {
    private var lambda : (() -> Unit)? = null
    var oldDegree = 0f
    var degree = 0f
    var rotate = RotateAnimation(
        oldDegree,
        degree,
        RotateAnimation.RELATIVE_TO_SELF,
        0.5f,
        RotateAnimation.RELATIVE_TO_SELF,
        0.5f
    )


    fun startAnim(lambda: ()->Unit) {
        this.lambda=lambda
        oldDegree = degree % 360
        degree = Random.nextInt(3600) + 720f
         rotate = RotateAnimation(
            oldDegree,
            degree,
            RotateAnimation.RELATIVE_TO_SELF,
            0.5f,
            RotateAnimation.RELATIVE_TO_SELF,
            0.5f
        )
        rotate.fillAfter = true
        rotate.interpolator = AccelerateDecelerateInterpolator()
        rotate.setAnimationListener(this)
        rotate.duration = Random.nextInt(9000) + 1000L

        view.startAnimation(rotate)
    }


    override fun onAnimationStart(p0: Animation?) {
//        TODO("Not yet implemented")
    }

    override fun onAnimationEnd(p0: Animation?) {
        lambda?.let { it() }

    }


    override fun onAnimationRepeat(p0: Animation?) {
        //   TODO("Not yet implemented")
    }
}