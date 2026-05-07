package com.nile.pantelis.tic_tac_toe.view

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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nile.pantelis.tic_tac_toe.R

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
            animationSpec = tween(durationMillis = 500) // Μισός χρόνος για το "ανέβασμα"
        )
        // 2. Επιστροφή στην αρχική τιμή (0.8f)
        pulsate.animateTo(
            targetValue = 1.7f,
            animationSpec = tween(durationMillis = 200) // Μισός χρόνος για το "κατέβασμα"
        )
    }

    val alpha = remember { Animatable(0.3f) }

    // Το LaunchedEffect εκτελείται αυτόματα μόλις εμφανιστεί το Component
    LaunchedEffect(Unit) {
        // 1. Πηγαίνει αργά στο opaque (1.5 δευτερόλεπτο)
        alpha.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 150)
        )
        // 2. Επιστρέφει αμέσως γρήγορα στο διαφανές (0.2 δευτερόλεπτα)
        alpha.animateTo(
            targetValue = 0.0f,
            animationSpec = tween(durationMillis = 200)
        )
    }


    if (turn) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer { this.alpha = alpha.value } // Αποδοτική σχεδίαση
                .background(Color.Black)
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
                tint = Color.Blue
            )
        }

    } else {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
//                .graphicsLayer { this.alpha = alpha.value } // Αποδοτική σχεδίαση
                .background(Color.Black)
        ) {
            Icon(
                painter = painterResource(R.drawable.circle),
                contentDescription = "Circle",
                modifier = Modifier
                    .size(64.dp)
                    .graphicsLayer(
                        scaleX = pulsate.value,
                        scaleY = pulsate.value
                    ),
                tint = Color.Red
            )
        }
    }
}