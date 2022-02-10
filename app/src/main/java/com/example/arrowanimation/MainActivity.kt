package com.example.arrowanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.arrowanimation.ui.theme.ArrowAnimationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BackArrowAnimationDemo()
        }
    }
}

@Composable
private fun BackArrowAnimationDemo() {
    ArrowAnimationTheme {
        var showCloseIcon by remember {
            mutableStateOf(true)
        }
        Scaffold(topBar = {
            Column {
                TopAppBar(
                    title = { Text("Morphing Animation") },
                    navigationIcon = { AnimatedBackArrowMorphing(showCloseIcon) },
                )

                Spacer(modifier = Modifier.height(16.dp))

                TopAppBar(
                    title = { Text("Rotation Animation") },
                    navigationIcon = { AnimatedBackArrowRotation(showCloseIcon) },
                )
            }

        }) {
            Button(
                modifier = Modifier.padding(all = 16.dp),
                onClick = { showCloseIcon = showCloseIcon.not() }) {
                Text("Toggle")
            }
        }
    }
}

@OptIn(ExperimentalAnimationGraphicsApi::class)
@Composable
private fun AnimatedBackArrowMorphing(showCloseIcon: Boolean) {
    IconButton(onClick = { }) {
        val drawableId =
            if (showCloseIcon)
                R.drawable.close_to_back_arrow
            else R.drawable.back_arrow_to_close

        val contentDescription = if (showCloseIcon) "Close" else "Back"

        Icon(
            painter = animatedVectorResource(id = drawableId).painterFor(atEnd = false),
            contentDescription = contentDescription
        )
    }
}

@OptIn(ExperimentalAnimationGraphicsApi::class)
@Composable
private fun AnimatedBackArrowRotation(showCloseIcon: Boolean) {
    IconButton(onClick = { }) {
        val drawableId =
            if (showCloseIcon)
                R.drawable.close_to_arrow_back_v2
            else R.drawable.arrow_back_to_close_v2

        val contentDescription = if (showCloseIcon) "Close" else "Back"

        Icon(
            painter = animatedVectorResource(id = drawableId).painterFor(atEnd = false),
            contentDescription = contentDescription
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BackArrowAnimationDemo()
}