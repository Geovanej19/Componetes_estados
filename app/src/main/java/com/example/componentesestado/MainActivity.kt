package com.example.componentesestado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentesestado.ui.theme.ComponentesEstadoTheme
import com.example.componentesestado.ui.theme.Righteous

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComponentesEstadoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BasicComponentScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BasicComponentScreen(modifier: Modifier = Modifier) {

    // Cria e "lembra" um estado mutável do tipo String, inicializado vazio
    // "remember" garante que esse valor sobreviva a recomposições (não reseta a cada redraw)
    val textFieldValue = remember {
        mutableStateOf("")
    }

    var quantidade by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var neymar by remember {
        mutableStateOf(false)
    }

    var messi by remember {
        mutableStateOf(false)
    }

    var cristiano by remember {
        mutableStateOf(false)
    }

    var sistemaSelecionado by remember {
        mutableStateOf(0)
    }

    var corFundo by remember {
        mutableStateOf(Color(239, 247, 207))
    }

    // Column organiza os elementos filhos verticalmente, um abaixo do outro
    Column(
        modifier
            .fillMaxWidth() // ocupa toda a largura disponível da tela
            .background(corFundo) // fundo em um tom claro (verde/amarelo pastel), usando RGB

    ) {
        // Primeiro texto: título principal "Aulas android"
        Text(text = "Aulas android",
            fontSize = 32.sp,                               // tamanho grande de fonte (32sp)
            fontWeight = FontWeight.Bold,                   // texto em negrito
            color = Color(0xFF3DDC84),                      // cor verde (tom característico do Android), em hexadecimal
            fontFamily = FontFamily.Serif,                  // usa fonte serifada (com serifas, tipo Times New Roman)
            modifier = Modifier
                .background(Color.Gray)                      // fundo cinza atrás do texto
                .fillMaxWidth(),                             // texto ocupa toda a largura da Column
            textAlign = TextAlign.End,                       // alinha o texto à direita dentro do espaço disponível
            letterSpacing = 4.sp                             // espaçamento extra entre as letras (4sp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "com Jetpack Compose",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(66, 133, 244),
            fontFamily = Righteous,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            // "value" define o texto atual exibido no campo
            value = textFieldValue.value,
            // "onValueChange" é chamado toda vez que o usuário digita algo no campo
            onValueChange = {novoValor ->
                // Atualiza o estado com o novo valor digitado,
                // o que dispara a recomposição do TextField com o texto atualizado
                textFieldValue.value = novoValor
            },

            // Faz o TextField ocupar toda a largura disponível do container pai
            modifier = Modifier.fillMaxWidth(),

            // Configura o tipo de teclado que vai aparecer ao focar no campo
            keyboardOptions = KeyboardOptions(
                // Define que o teclado exibido será o numérico
                // (facilita a digitação, mas NÃO impede o usuário de colar letras, por exemplo)
                capitalization = KeyboardCapitalization.Words),
            label = {
                Text(text = "Nome e sobrenome")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Ícone pessoa",
                    tint = Color(66, 133, 244)
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Ícone pessoa",
                    tint = Color(66, 133, 244)
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = quantidade,
            onValueChange = { novoValor ->
                quantidade = novoValor
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            placeholder = {
                Text(text = "Qual a quantidade")
            },
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Blue,
                unfocusedTextColor = Color.Red,
                unfocusedPlaceholderColor = Color.Magenta
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text( text = "E-mail")
            },
            placeholder = {
                Text(text = "Digite seu e-mail")
            },
            shape = RoundedCornerShape(
                topStart = 32.dp,
                topEnd = 32.dp,
                bottomEnd = 32.dp,
                bottomStart = 32.dp
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.Black
            )
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = neymar,
                onCheckedChange = {neymar = it},
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Green,
                    uncheckedColor = Color.Gray
                )
            )

            Text(text = "1. Neymar")
        }



        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = messi,
                onCheckedChange = {messi = it},
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Green,
                    uncheckedColor = Color.Gray
                )
            )

            Text(text = "2. Messi")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = cristiano,
                onCheckedChange = {cristiano = it},
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Green,
                    uncheckedColor = Color.Gray
                )
            )

            Text(text = "3. Cristiano")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = sistemaSelecionado == 0,
                onClick = {sistemaSelecionado = 0}
            )

            Text(text = "Carro")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = sistemaSelecionado == 1,
                onClick = {sistemaSelecionado = 1}
            )

            Text(text = "Moto")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = sistemaSelecionado == 2,
                onClick = {sistemaSelecionado = 2}
            )

            Text(text = "Caminhão")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = {
                    corFundo = Color.Blue
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                ),
                border = BorderStroke(4.dp, Color.Blue),
                shape = RoundedCornerShape(topEnd = 12.dp,
                    topStart = 12.dp,
                    bottomStart = 12.dp,
                    bottomEnd = 12.dp
                )
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Default.Refresh,
                        contentDescription = "Refresh"
                        )

                    Text("Clique aqui!")
                }
            }

            OutlinedButton(
                onClick = {
                    corFundo = Color.Yellow
                }
            ) {
                Text(text = "Ney")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
}