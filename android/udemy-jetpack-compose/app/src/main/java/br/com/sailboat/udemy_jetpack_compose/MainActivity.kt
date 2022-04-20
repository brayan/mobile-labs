package br.com.sailboat.udemy_jetpack_compose

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.sailboat.udemy_jetpack_compose.ui.theme.LightGreen
import br.com.sailboat.udemy_jetpack_compose.ui.theme.MainTheme
import br.com.sailboat.udemy_jetpack_compose.viewmodel.MainViewAction
import br.com.sailboat.udemy_jetpack_compose.viewmodel.MainViewModel
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainTheme {
                UsersApplication()
            }
        }
    }
}

@Composable
fun UsersApplication() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "users_list") {
        composable("users_list") {
            UserListScreen(navHostController = navController)
        }
        composable("user_details") {
            val viewModel = MainViewModel()
            val users = viewModel.viewState.users.observeAsState()

            viewModel.dispatchViewAction(MainViewAction.OnStartMainProfile)

            users.value?.firstOrNull()?.run {
                UserProfileDetailsScreen(userProfile = this)
            }
        }
    }
}

@Composable
private fun UserListScreen(viewModel: MainViewModel = MainViewModel(), navHostController: NavHostController) {
    Scaffold(topBar = { AppBar() }) {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            val users = viewModel.viewState.users.observeAsState()

            viewModel.dispatchViewAction(MainViewAction.OnStartMainProfile)

            LazyColumn {
                items(users.value.orEmpty()) {
                    ProfileCard(it) {
                        navHostController.navigate("user_details")
                    }
                }
            }
        }
    }
}

@Composable
private fun UserProfileDetailsScreen(userProfile: UserProfile) {
    Scaffold(topBar = { AppBar() }) {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
            ) {
                ProfilePicture(userProfile.imageUrl, userProfile.status, 240.dp)
                ProfileContent(userProfile.name, userProfile.status, Alignment.CenterHorizontally)
            }
        }
    }
}

@Composable
private fun AppBar() {
    TopAppBar(
        navigationIcon = {
            Icon(
                Icons.Default.Home,
                "Home icon",
                Modifier.padding(horizontal = 12.dp),
            )
        },
        title = { Text(text = "Udemy Course") },
    )
}

@Composable
private fun ProfileCard(userProfile: UserProfile, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top)
            .padding(top = 8.dp, bottom = 4.dp, start = 16.dp, end = 16.dp)
            .clickable { onClick.invoke() },
        elevation = 8.dp,
        backgroundColor = Color.White,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            ProfilePicture(userProfile.imageUrl, userProfile.status, 72.dp)
            ProfileContent(userProfile.name, userProfile.status, Alignment.Start)
        }
    }
}

@Composable
private fun ProfilePicture(imageUrl: String, isStatusOnline: Boolean, imageSize: Dp) {
    Card(
        shape = CircleShape,
        border = BorderStroke(
            width = 2.dp,
            color = if (isStatusOnline) MaterialTheme.colors.LightGreen else Color.Red
        ),
        modifier = Modifier
            .padding(16.dp)
            .size(imageSize),
        elevation = 4.dp,
    ) {
        Image(
            painter = rememberImagePainter(
                data = imageUrl,
                builder = {
                    transformations(CircleCropTransformation())
                },
            ),
            contentDescription = "Content description",
            contentScale = ContentScale.Crop,
        )
    }
}

@Composable
private fun ProfileContent(userName: String, isStatusOnline: Boolean, alignment: Alignment.Horizontal) {
    Column(
        modifier = Modifier
            .padding(8.dp)
//            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalAlignment = alignment,
    ) {
        Text(
            text = userName,
            style = MaterialTheme.typography.h5,
        )
//        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = if (isStatusOnline) "Active now" else "Offline",
                style = MaterialTheme.typography.body2,
                color = Color.Black.copy(alpha = 0.6f),
//                fontWeight = FontWeight.Bold
            )
//        }
    }
}

@Composable
private fun MainDynamicContentCompose(viewModel: MainViewModel = MainViewModel()) {
    val newNameState = viewModel.viewState.name.observeAsState("")

    Column(
        modifier = Modifier.padding(all = 16.dp)
    ) {
        DynamicContentCompose(
            newName = newNameState.value,
            onNewNameChanged = { name ->
                viewModel.dispatchViewAction(MainViewAction.OnInsertName(name))
            }
        )
    }
}

@Composable
private fun DynamicContentCompose(
    newName: String,
    onNewNameChanged: (newName: String) -> Unit
) {
    Column(
        modifier = Modifier.padding(all = 16.dp)
    ) {
        TextField(
            value = newName,
            onValueChange = onNewNameChanged,
        )

        Button(
            modifier = Modifier.padding(vertical = 16.dp),
            onClick = { }
        ) {
            Text(text = newName)
        }
    }
}

@Composable
private fun CoreUiCompose() {
    Surface(
        color = Color.DarkGray,
        modifier = Modifier.fillMaxSize(), // match height and width
    ) {
//        PlayingWithColumnsRowsAndTexts()
        PlayingWithColumnsRowsAndSquares()
    }
}

@Composable
private fun PlayingWithColumnsRowsAndSquares() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ColoredSquare(color = Color.Red)
            ColoredSquare(color = Color.Magenta)
        }
        ColoredSquare(color = Color.Cyan)
        ColoredSquare(color = Color.Yellow)
        ColoredSquare(color = Color.Blue)
    }
}

@Composable
private fun PlayingWithColumnsRowsAndTexts() {
    Surface(
        color = Color.Blue,
//            modifier = Modifier.wrapContentSize(align = Alignment.TopStart),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
    ) {
        Column(
            modifier = Modifier.padding(all = 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "One",
                    color = Color.White,
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(end = 16.dp),
                    style = MaterialTheme.typography.body1
                )
                Text(
                    text = "Two",
                    color = Color.White,
                    modifier = Modifier.wrapContentSize(),
                    style = MaterialTheme.typography.body1
                )
            }
            Text(
                text = "Wrapped content, height and width",
                color = Color.White,
                modifier = Modifier.wrapContentSize(),
                style = MaterialTheme.typography.body1
            )
            Text(
                text = "Wrapped content, height and width",
                color = Color.White,
                modifier = Modifier.wrapContentSize(),
                style = MaterialTheme.typography.body1
            )
        }
    }
}

@Composable
private fun ColoredSquare(color: Color) {
    Surface(
        color = color,
        modifier = Modifier
            .height(100.dp)
            .width(100.dp)
    ) {

    }
}

@Composable
private fun BasicMainActivityCompose(context: Context) {
    MainTheme {
        Surface(color = MaterialTheme.colors.background) {
            GreetingText("Android")
            GreetingButton("Android", onClick = {
                Toast.makeText(context, "Hey!", Toast.LENGTH_SHORT).show()
            })
        }
    }
}

@Composable
private fun GreetingText(name: String) {
    Text(
        text = "Hello, $name!",
        modifier = Modifier
//            .fillMaxHeight()
            .fillMaxWidth()
//            .wrapContentWidth()
            .wrapContentHeight()
//            .width(80.dp)
//            .height(240.dp)
            .clickable { }
//            .padding(all = 12.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp),
//            style = TextStyle(
//                color = Color.White,
//                fontWeight = FontWeight.SemiBold,
//                fontSize = 18.sp
//            )
        style = MaterialTheme.typography.h5,
        fontWeight = FontWeight.SemiBold
    )
}

@Composable
private fun GreetingButton(name: String, onClick: () -> Unit) {
    Button(onClick = onClick) {
        GreetingText(name = "Click-me, $name!!")
        GreetingText(name = "Hello!")
    }
}

@Preview(showBackground = true)
@Composable
private fun UserProfileDetailsPreview() {
    MainTheme {
        val viewModel = MainViewModel()
        val users = viewModel.viewState.users.observeAsState()

        viewModel.dispatchViewAction(MainViewAction.OnStartMainProfile)

        users.value?.firstOrNull()?.run {
            UserProfileDetailsScreen(this)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun UserListPreview() {
    MainTheme {
//        UserListScreen()
    }
}