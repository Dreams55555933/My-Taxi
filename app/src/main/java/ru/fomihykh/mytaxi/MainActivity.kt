package ru.fomihykh.mytaxi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.fomihykh.mytaxi.ui.theme.MyTaxiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Main()
        }
    }
    @Preview(showSystemUi = true)
    @Composable
    fun Main(vm: ShiftViewModel = viewModel()){
        MyTaxiTheme {
            val scope = rememberCoroutineScope()
            Scaffold(
                bottomBar = {
                    Menu()
                },
                containerColor = Color(53,135,154)
            ) { innerPadding->
                Box(Modifier.padding(innerPadding)) {
                    when(vm.selectedMenu){
                        MenuList.STATISTIC -> Statistic()
                        MenuList.ADDSHIFT -> AddShift()
                        MenuList.CLOSESHIFT -> CloseShift()
                        MenuList.LISTSHIFT -> ListShift(vm.shiftList)
                    }
                }
            }
        }
    }
}
enum class MenuList{
    STATISTIC, ADDSHIFT, CLOSESHIFT, LISTSHIFT
}
