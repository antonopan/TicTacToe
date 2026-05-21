package com.nile.pantelis.tic_tac_toe.view

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.InfiniteTransition
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nile.pantelis.tic_tac_toe.R

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun Symbols(infiniteTransition: InfiniteTransition, turn: Boolean) {

//    val pulsate by infiniteTransition.animateFloat(
//        initialValue = 0.8f,
//        targetValue = 1.2f,
//        animationSpec = infiniteRepeatable(
//            animation = tween(1200),
//            repeatMode = RepeatMode.Reverse
//        ),
//        label = "PulseScale"
//    )
    val pulsate = remember { Animatable(0.8f) }

    LaunchedEffect(Unit) {
        // 1. Μετάβαση στο target value (1.2f)
        pulsate.animateTo(
            targetValue = 2.7f,
            animationSpec = tween(durationMillis = 200) // Μισός χρόνος για το "ανέβασμα"
        )
        // 2. Επιστροφή στην αρχική τιμή (0.8f)
        pulsate.animateTo(
            targetValue = 1.7f,
            animationSpec = tween(durationMillis = 100) // Μισός χρόνος για το "κατέβασμα"
        )
    }


    if (turn) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Icon(
                painter = painterResource(R.drawable.cross),
                contentDescription = "Cross",
                modifier = Modifier
                    .size(64.dp)
                    .graphicsLayer(
                        scaleX = pulsate.value,
                        scaleY = pulsate.value
                    ),
                tint = Color(0xfffaac02) // This remains solid
            )
            Icon(
                painter = painterResource(R.drawable.cross),
                contentDescription = "Cross",
                modifier = Modifier
                    .size(71.dp)
                    .graphicsLayer {
                        scaleX = pulsate.value
                        scaleY = pulsate.value
                        renderEffect = android.graphics.RenderEffect.createBlurEffect(
                            25f, 25f, android.graphics.Shader.TileMode.DECAL
                        ).asComposeRenderEffect()
                        // Ανάμειξη χρωμάτων για να φαίνεται το εσωτερικό
                        blendMode = androidx.compose.ui.graphics.BlendMode.Screen
                    },
                tint = Color(0xffffd270)
            )
        }
    } else {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.circle),
                contentDescription = "Cross",
                modifier = Modifier
                    .size(65.dp)
                    .graphicsLayer {
                        scaleX = pulsate.value
                        scaleY = pulsate.value
                        // Create and apply a blur effect
                        renderEffect = android.graphics.RenderEffect.createBlurEffect(
                            25f, 25f, android.graphics.Shader.TileMode.DECAL
                        ).asComposeRenderEffect()
                    },
                tint = Color(0xff70ffcf)
            )
            Icon(
                painter = painterResource(R.drawable.circle),
                contentDescription = "Circle",
                modifier = Modifier
                    .size(65.dp)
                    .graphicsLayer(
                        scaleX = pulsate.value,
                        scaleY = pulsate.value
                    ),
                tint = Color(0xff02faa7) // This remains solid
            )
        }
    }
}