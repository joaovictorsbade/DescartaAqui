package br.com.fiap.descartaaqui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import br.com.fiap.descartaaqui.ui.navigation.AppNavigation
import br.com.fiap.descartaaqui.ui.theme.DescartaAquiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DescartaAquiTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    AppNavigation()
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    DescartaAquiTheme {
        AppNavigation()
    }
}
