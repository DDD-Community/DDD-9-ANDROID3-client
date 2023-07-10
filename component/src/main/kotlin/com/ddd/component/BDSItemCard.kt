package com.ddd.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ddd.component.theme.BDSColor.Primary400
import java.text.DecimalFormat

// TODO: data class 위치 변경
data class ArchiveItem(
    val imageUrl: String? = null,
    val brand: String? = null,
    val name: String? = null,
    val discount: Float? = null,
    val price: Long? = null,
)

@Composable
fun BDSArchiveItemCard(
    archiveItem: ArchiveItem,
    modifier: Modifier = Modifier
) {
    var isSelectMode by remember { mutableStateOf(false) }
    var isSelect by remember { mutableStateOf(false) }

    Box(
        modifier
            .size(164.dp, 260.dp)
            .clickable {
                isSelectMode = true
            }
    ) {
        // TODO: BDSButton 추가되면 수정
        if (isSelectMode) {
            BDSButton(
                onClick = {
                    isSelect = !isSelect
                }
            )
        }

        Column {
            BDSImage(
                url = archiveItem.imageUrl, /*?: defaultImage*/
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(color = Primary400)
                    .size(164.dp, 164.dp)
                    .then(modifier),
                contentScale = ContentScale.FillBounds,
                contentDescription = "image description"
            )
            if (archiveItem.brand != null) {
                Spacer(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(12.dp)
                )
                BDSText(
                    text = archiveItem.brand,
                    style = MaterialTheme.typography.labelMedium,
                    lineHeight = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            if (archiveItem.name != null) {
                Spacer(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(4.dp)
                )
                BDSText(
                    text = archiveItem.name,
                    maxLines = 2,
                    style = MaterialTheme.typography.bodySmall,
                    lineHeight = 20.sp
                )
            }
            Spacer(
                modifier = modifier
                    .fillMaxWidth()
                    .height(2.dp)
            )
            Row {
                if (archiveItem.discount != null) {
                    BDSText(
                        text = "${archiveItem.discount}% ",
                        modifier = modifier.offset(0.dp, 2.dp),
                        color = Primary400,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 20.sp
                    )
                }
                if (archiveItem.price != null) {
                    BDSText(
                        text = archiveItem.price.toPriceFormat(),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

fun Long?.toPriceFormat() =
    if (this == null) {
        ""
    } else {
        val formatter = DecimalFormat("#,###원")
        formatter.format(this)
    }