package com.example.techhub.utils

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ClearAll
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInputField(value:String, label:Int, onValueChange:(String)->Unit, modifier: Modifier = Modifier, type: KeyboardType
){
    var showPassword by remember { mutableStateOf(false) }

    OutlinedTextField(value = value, onValueChange = onValueChange, singleLine = true,
        label = { Text(stringResource(id = label)) },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = type,
            imeAction = ImeAction.Next, autoCorrect = true,),
        visualTransformation = if (type == KeyboardType.Password && !showPassword) PasswordVisualTransformation() else VisualTransformation.None,
        modifier = modifier, shape = RoundedCornerShape(12.dp), trailingIcon = {
            if(type == KeyboardType.Password){
                if(showPassword){ IconButton(onClick = { showPassword = false }) {
                    Icon(
                        imageVector = Icons.Filled.Visibility,
                        contentDescription = "hide_password"
                    )
                }}
                else{IconButton(
                    onClick = { showPassword = true }) {
                    Icon(
                        imageVector = Icons.Filled.VisibilityOff,
                        contentDescription = "hide_password"
                    )
                }}
            }
        }
    )
}