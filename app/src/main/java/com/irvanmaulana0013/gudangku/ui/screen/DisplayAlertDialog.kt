package com.irvanmaulana0013.gudangku.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.irvanmaulana0013.gudangku.R
import com.irvanmaulana0013.gudangku.ui.theme.GudangkuTheme

@Composable
fun DisplayRecycleBinDialog(
    showDialog: Boolean,
    onDismissRequest: () -> Unit,
    onUndo: () -> Unit,
    onDelete: () -> Unit
) {
    if (showDialog) {
        AlertDialog(
            text = { Text(text = stringResource(R.string.hapus_permanen)) },
            confirmButton = {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    TextButton(onClick = onUndo) {
                        Text(text = stringResource(R.string.tombol_undo))
                    }
                    TextButton(onClick = onDelete) {
                        Text(text = stringResource(R.string.tombol_hapus))
                    }
                }
            },
            dismissButton = {
                TextButton(onClick = onDismissRequest) {
                    Text(text = stringResource(R.string.tombol_batal))
                }
            },
            onDismissRequest = onDismissRequest
        )
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun RecycleBinDialogPreview() {
    GudangkuTheme {
        DisplayRecycleBinDialog(
            showDialog = true,
            onDismissRequest = {},
            onUndo = {},
            onDelete = {}
        )
    }
}