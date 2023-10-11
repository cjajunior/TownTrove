package br.com.towntrove.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.towntrove.R
import br.com.towntrove.ui.theme.TownTroveTheme


@Composable
fun TroveListItem(
    modifier: Modifier = Modifier
){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .padding(bottom = 7.dp),
            contentAlignment = Alignment.Center
    ){
            Row(
                modifier = Modifier
                    .width(92.dp)
                    .height(25.dp)
                    .padding(4.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = TextStyle(
                        fontSize = 19.42.sp,
                        lineHeight = 24.63.sp,
                        fontWeight = FontWeight.Normal,
                        // color = Color.White,
                    )
                )
            }
        }
}


@Preview(showBackground = true)
@Composable
fun TownTrovePreviw() {
    TownTroveTheme {
        TroveListItem()
    }
}
