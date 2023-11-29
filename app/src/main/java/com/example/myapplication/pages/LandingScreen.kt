import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.myapplication.R
import kotlinx.coroutines.delay

private const val SplashWaitTime: Long = 2000

@Composable
fun LandingScreen(modifier: Modifier = Modifier, onTimeout: () -> Unit) {
    LaunchedEffect(Unit) {
        delay(SplashWaitTime)
        onTimeout()
    }
    Image(
        painterResource(id = R.drawable.landing),
        contentDescription = null,
        modifier
            .fillMaxSize()
            .wrapContentSize()
    )
}
