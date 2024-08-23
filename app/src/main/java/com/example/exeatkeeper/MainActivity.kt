package com.example.exeatkeeper

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.splashscreen.SplashScreenViewProvider


fun objectAnimatorSetup(objectAnimator: ObjectAnimator, screen: SplashScreenViewProvider) {
    objectAnimator.interpolator = OvershootInterpolator()
    objectAnimator.duration = 300
    objectAnimator.doOnEnd { screen.remove() }
}

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "StateFlowValueCalledInComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().apply {
            setKeepOnScreenCondition {
                !viewModel.isReady.value
            }

            setOnExitAnimationListener { screen ->

                val zoomX = ObjectAnimator.ofFloat(
                    screen.iconView,
                    View.SCALE_X,
                    0.4f,
                    0.0f
                )

                val zoomY = ObjectAnimator.ofFloat(
                    screen.iconView,
                    View.SCALE_Y,
                    0.4f,
                    0.0f
                )

                objectAnimatorSetup(zoomX, screen)
                objectAnimatorSetup(zoomY, screen)

                zoomX.start()
                zoomY.start()
            }
        }

        setContent {

            val appContext = LocalContext.current.applicationContext
            ExeatKeeperApp()
        }
    }
}