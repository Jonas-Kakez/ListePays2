import androidx.compose.runtime.Composable
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.woof.ui.CountryApp

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home"){
        composable("home"){ Accueil(navController)}
        composable("flagScreen"){ ListeDrapeau(navController)}
        composable("CountryScreen"){ CountryApp(navController) }
    }
}