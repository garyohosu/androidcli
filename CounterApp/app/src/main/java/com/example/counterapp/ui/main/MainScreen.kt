package com.example.counterapp.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavKey
import com.example.counterapp.data.DefaultDataRepository
import com.example.counterapp.theme.CounterAppTheme

@Composable
fun MainScreen(
  onItemClick: (NavKey) -> Unit,
  modifier: Modifier = Modifier,
  viewModel: MainScreenViewModel = viewModel { MainScreenViewModel(DefaultDataRepository()) },
) {
  val state by viewModel.uiState.collectAsStateWithLifecycle()
  CounterContent(
    count = (state as MainScreenUiState.Success).count,
    onIncrement = viewModel::increment,
    onDecrement = viewModel::decrement,
    onReset = viewModel::reset,
    modifier = modifier,
  )
}

@Composable
internal fun CounterContent(
  count: Int,
  onIncrement: () -> Unit,
  onDecrement: () -> Unit,
  onReset: () -> Unit,
  modifier: Modifier = Modifier,
) {
  Surface(modifier = modifier.fillMaxSize()) {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center,
      modifier = Modifier.padding(24.dp),
    ) {
      Text(
        text = "カウンター",
        style = MaterialTheme.typography.headlineMedium,
        color = MaterialTheme.colorScheme.primary,
      )
      Spacer(modifier = Modifier.height(32.dp))
      Text(
        text = count.toString(),
        fontSize = 96.sp,
        fontWeight = FontWeight.Bold,
        color = when {
          count > 0 -> MaterialTheme.colorScheme.primary
          count < 0 -> MaterialTheme.colorScheme.error
          else -> MaterialTheme.colorScheme.onSurface
        },
      )
      Spacer(modifier = Modifier.height(48.dp))
      Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        Button(
          onClick = onDecrement,
          modifier = Modifier.size(72.dp),
        ) {
          Text("-", fontSize = 28.sp)
        }
        Button(
          onClick = onIncrement,
          modifier = Modifier.size(72.dp),
        ) {
          Text("+", fontSize = 28.sp)
        }
      }
      Spacer(modifier = Modifier.height(24.dp))
      OutlinedButton(
        onClick = onReset,
        colors = ButtonDefaults.outlinedButtonColors(
          contentColor = MaterialTheme.colorScheme.error,
        ),
      ) {
        Text("リセット", fontSize = 16.sp)
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
  CounterAppTheme { CounterContent(count = 42, onIncrement = {}, onDecrement = {}, onReset = {}) }
}

@Preview(showBackground = true)
@Composable
fun MainScreenNegativePreview() {
  CounterAppTheme { CounterContent(count = -5, onIncrement = {}, onDecrement = {}, onReset = {}) }
}
