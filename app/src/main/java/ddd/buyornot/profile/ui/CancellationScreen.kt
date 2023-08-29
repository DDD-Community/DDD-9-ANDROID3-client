package ddd.buyornot.profile.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ddd.component.BDSAppBar
import com.ddd.component.BDSButtonInnerPadding
import com.ddd.component.BDSCheckbox
import com.ddd.component.BDSFilledButton
import com.ddd.component.BDSIconButton
import com.ddd.component.BDSImage
import com.ddd.component.BDSText
import com.ddd.component.R
import com.ddd.component.theme.BDSColor
import com.ddd.component.theme.BDSColor.Black
import com.ddd.component.theme.BDSColor.SlateGray900
import ddd.buyornot.findActivity

@Composable
fun CancellationScreen() {
    val context = LocalContext.current

    var allChecked by remember { mutableStateOf(false) }
    var checked1 by remember { mutableStateOf(false) }
    var checked2 by remember { mutableStateOf(false) }
    var checked3 by remember { mutableStateOf(false) }

    allChecked = checked1 && checked2 && checked3

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BDSAppBar(
                modifier = Modifier
                    .height(54.dp)
                    .fillMaxWidth(),
                left = {
                    BDSIconButton(
                        modifier = Modifier.padding(16.dp),
                        resId = R.drawable.ic_back,
                        onClick = { context.findActivity().finish() },
                        tint = BDSColor.White
                    )
                },
                center = null
            )
            Spacer(modifier = Modifier.height(94.dp))
            BDSImage(
                resId = ddd.buyornot.R.drawable.ic_text_logo,
                modifier = Modifier
                    .width(248.dp)
                    .height(47.dp),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(42.dp))
            BDSImage(
                resId = ddd.buyornot.R.drawable.graphic_cancellation,
                modifier = Modifier
                    .width(332.dp)
                    .height(172.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart)
        ) {
            Row {
                BDSCheckbox(
                    checkedImage = R.drawable.ic_check,
                    uncheckedImage = R.drawable.ic_uncheck,
                    checked = allChecked,
                    onClick = {
                        allChecked = !allChecked
                        checked1 = allChecked
                        checked2 = allChecked
                        checked3 = allChecked
                    }
                )
                BDSText(
                    text = "계정을 삭제하기 전 확인해주세요!",
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = SemiBold,
                    color = Black
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            CheckCard(
                text = "닉네임과 프로필이 삭제됩니다.",
                checked = checked1,
                onClick = { checked1 = !checked1 }
            )
            Spacer(modifier = Modifier.height(12.dp))
            CheckCard(
                text = "개인 정보와 아카이브함 기록이 삭제됩니다",
                checked = checked2,
                onClick = { checked2 = !checked2 }
            )
            Spacer(modifier = Modifier.height(12.dp))
            CheckCard(
                text = "연결된 소셜 계정 정보가 삭제됩니다.",
                checked = checked3,
                onClick = { checked3 = !checked3 }
            )
            Spacer(modifier = Modifier.height(24.dp))
            Spacer(modifier = Modifier.height(12.dp))
            BDSFilledButton(
                text = "계정 삭제하기",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(start = 16.dp, end = 16.dp),
                contentPadding = BDSButtonInnerPadding.MEDIUM,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = SemiBold,
                enabled = allChecked,
                onClick = { /* 계정 삭제 */ }
            )
            Spacer(modifier = Modifier.height(54.dp))
        }
    }
}

@Composable
private fun CheckCard(
    text: String,
    checked: Boolean,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .padding(start = 24.dp)
    ) {
        BDSCheckbox(
            checkedImage = R.drawable.ic_check,
            uncheckedImage = R.drawable.ic_uncheck,
            checked = checked,
            onClick = onClick
        )
        Spacer(modifier = Modifier.width(16.dp))
        BDSText(
            text = text,
            fontSize = 12.sp,
            lineHeight = 18.sp,
            fontWeight = Normal,
            color = SlateGray900
        )
    }
}