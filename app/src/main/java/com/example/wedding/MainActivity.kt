package com.example.wedding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wedding.ui.theme.WeddingTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeddingTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WeddingCard(
                        title = "Thiệp Cưới",
                        message = "Chúc mừng lễ cưới của Seol & Shin",
                        date = "Ngày 20 tháng 12 năm 2025",
                        location = "Hội trường Grand Palace, Hà Tĩnh",
                        button = "Gửi thiệp"
                    )
                }
            }
        }
    }
}

@Composable
fun WeddingCard(
    title: String,
    message: String,
    date: String,
    location: String,
    button: String,
    modifier: Modifier = Modifier
) {
    val backgroundBrush = Brush.verticalGradient(
        colors = listOf(Color(0xFFFDEEF4), Color(0xFFFFC1D9))
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(brush = backgroundBrush)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF880E4F),
            modifier = Modifier.padding(bottom = 24.dp) // Tăng khoảng cách bên dưới tiêu đề
        )

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            shape = RoundedCornerShape(16.dp),
            color = Color.White,
            shadowElevation = 8.dp
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp), // Tạo khoảng cách giữa các dòng văn bản
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = message,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF4A148C)
                )

                Text(
                    text = date,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF7B1FA2)
                )

                Text(
                    text = location,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF7B1FA2)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        PinkButton(onClick = {
            println("Button '$button' clicked!")
        })
    }
}

@Composable
fun PinkButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF69B4)), // Màu hồng
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(8.dp)
            .height(50.dp)
            .width(200.dp)
    ) {
        Text(
            text = "Gửi Thiệp",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ButtonPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PinkButton {
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeddingCardPreview() {
    WeddingTheme {
        WeddingCard(
            title = "Thiệp Cưới",
            message = "Chúc mừng lễ cưới của Seol & Shin",
            date = "Ngày 20 tháng 12 năm 2025",
            location = "Hội trường Grand Palace, Hà Tĩnh",
            button = "Gửi thiệp" ,
        )
    }
}
