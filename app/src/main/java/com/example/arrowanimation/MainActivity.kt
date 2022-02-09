package com.example.arrowanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.animatedVectorResource
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
    var showCloseIcon by remember {
        mutableStateOf(true)
    }

    ArrowAnimationTheme {
        // A surface container using the 'background' color from the theme
        Scaffold(topBar = {
            TopAppBar(
                title = { Text("Animation Demo") },
                navigationIcon = { AnimatedBackArrow(showCloseIcon) },
            )
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
private fun AnimatedBackArrow(showCloseIcon: Boolean) {
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


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArrowAnimationTheme {
        BackArrowAnimationDemo()
    }
}