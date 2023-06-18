package com.example.chatapp

import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.VideoCall
import androidx.compose.material.icons.filled.VoiceChat
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatapp.ui.theme.ChatAppTheme




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatAppTheme {
                // A surface container using the 'background' color from the theme
                @Composable
                fun ChatsScreen() {
                    Scaffold(
                        topBar = { TopBar() },
                        bottomBar = { BottomBar() }
                    ) {
                        ChatList(
                            chats = listOf(
                                Chat(
                                    "Alice",
                                    "Hello, how are you?",
                                    "https://randomuser.me/api/portraits/women/32.jpg",
                                    true
                                ),
                                Chat(
                                    "Bob",
                                    "I'm good, thanks!",
                                    "https://randomuser.me/api/portraits/men/32.jpg",
                                    false
                                ),
                                Chat(
                                    "Charlie",
                                    "Hey, what's up?",
                                    "https://randomuser.me/api/portraits/men/42.jpg",
                                    false
                                )
                            )
                        )
                    }
                }

                @Composable
                fun TopBar() {
                    TopAppBar(
                        title = { Text("Alice") },
                        navigationIcon = {
                            Image(
                                painter = painterResource(id = R.drawable.ic_back_arrow),
                                contentDescription = "Back Arrow",
                                modifier = Modifier.clickable { /* Handle back arrow click */ }
                            )
                        },
                        actions = {
                            IconButton(onClick = { /* Handle video call icon click */ }) {
                                Icon(Icons.Filled.VideoCall, contentDescription = "Video Call")
                            }
                            IconButton(onClick = { /* Handle voice call icon click */ }) {
                                Icon(Icons.Filled.VoiceChat, contentDescription = "Voice Call")
                            }
                        }
                    )
                }

                @Composable
                fun BottomBar() {
                    Surface(color = MaterialTheme.colors.primary, elevation = 8.dp) {
                        Row(
                            modifier = Modifier.fillMaxWidth().height(56.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            TextField(
                                value = TextFieldValue(),
                                onValueChange = { /* Handle text field value change */ },
                                modifier = Modifier.weight(1f).padding(horizontal = 8.dp),
                                placeholder = { Text(text = "Write a message") }
                            )
                            IconButton(onClick = { /* Handle send icon click */ }) {
                                Icon(Icons.Filled.Send, contentDescription = "Send")
                            }
                        }
                    }
                }

                @Composable
                fun ChatList(chats: List<Chat>) {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colors.surface)
                    ) {
                        items(chats) { chat ->
                            ChatItem(chat = chat)
                            Divider()
                        }
                    }
                }

                @Composable
                fun ChatItem(chat: Chat) {
                    Row(
                        modifier = Modifier.padding(16.dp).fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = chat.imageId),
                            contentDescription = "Profile Picture",
                            modifier = Modifier
                                .size(
            }
        }
    }
}

