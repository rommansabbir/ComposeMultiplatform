import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Login() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        var title by remember { mutableStateOf("Enter your credential for login") }
        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var usernameErrorMessage by remember { mutableStateOf("") }
        var passwordErrorMessage by remember { mutableStateOf("") }

        Spacer(modifier = Modifier.fillMaxWidth().height(16.dp))
        Text(title, fontSize = 18.sp)
        Spacer(modifier = Modifier.fillMaxWidth().height(16.dp))
        TextField(
            username, {
                username = it
            }, keyboardOptions = KeyboardOptions(KeyboardCapitalization.None),
            isError = usernameErrorMessage.isNotEmpty(),
            placeholder = {
                Text(usernameErrorMessage, color = Color.Red)
            }
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(16.dp))
        TextField(
            password,
            {
                password = it
            },
            isError = passwordErrorMessage.isNotEmpty(),
            placeholder = {
                Text(passwordErrorMessage, color = Color.Red)
            }
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(16.dp))
        Button({
            usernameErrorMessage = if (username.toLowerCase(Locale.current) != "admin") {
                "Enter a valid username"
            } else{
                ""
            }
            passwordErrorMessage = if (password.toLowerCase(Locale.current) != "123456") {
                "Enter a valid password"
            } else{
                ""
            }
            title =
                if (usernameErrorMessage.isEmpty() && passwordErrorMessage.isEmpty()) {
                    //logged in
                    "Logged In"
                } else {
                    "Logged error"
                }
        }) {
            Text("Login")
        }
        Spacer(modifier = Modifier.fillMaxWidth().height(16.dp))
    }
}

