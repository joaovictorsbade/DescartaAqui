package br.com.fiap.descartaaqui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.fiap.descartaaqui.ui.navigation.AppNavigation
import br.com.fiap.descartaaqui.ui.theme.DescartaAquiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DescartaAquiTheme {
                AppNavigation()  // Chama apenas a navegação unificada
            }
        }
    }
}
