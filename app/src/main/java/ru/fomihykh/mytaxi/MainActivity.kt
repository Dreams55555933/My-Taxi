package ru.fomihykh.mytaxi

import android.app.Application
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.fomihykh.mytaxi.ui.theme.MyTaxiTheme

@Suppress("UNCHECKED_CAST")
class ShiftViewModelFactory(val application: Application): ViewModelProvider.Factory{
    override fun <T: ViewModel> create(modelClass: Class<T>):T{
        return ShiftViewModel(application) as T
    }
}

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        var pref = getSharedPreferences("openShift",MODE_PRIVATE)
        super.onCreate(savedInstanceState)
        setContent {
            val owner = LocalViewModelStoreOwner.current
            owner?.let {
                val viewModel: ShiftViewModel = viewModel(
                    it,"ShiftViewModel", ShiftViewModelFactory(LocalContext.current.applicationContext as Application)
                )
                Main(viewModel,pref)
            }
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun Main(vm: ShiftViewModel = viewModel(),pref: SharedPreferences){
        MyTaxiTheme {
            val scope = rememberCoroutineScope()
            Scaffold(
                bottomBar = {
                    Menu(vm,pref)
                },
                containerColor = Color(53,135,154)
            ) { innerPadding->
                Box(Modifier.padding(innerPadding)) {
                    Crossfade(
                        targetState = vm.selectedMenu,
                        animationSpec = tween(durationMillis = 300)
                    ) {
                        menu->
                        when(menu){
                            MenuList.STATISTIC -> Statistic(vm)
                            MenuList.ADDSHIFT ->{

                            } //AddShift()
                            MenuList.OPENSHIFT -> OpenShift(vm, pref = pref)
                            MenuList.CLOSESHIFT -> CloseShift(vm, pref = pref)
                            MenuList.LISTSHIFT -> ListShift(vm ,vm.shiftList)
                            MenuList.VIEWSHIFT -> ViewShift(vm)
                        }
                    }
                }
            }
        }
    }
}
enum class MenuList{
    STATISTIC, ADDSHIFT, CLOSESHIFT, LISTSHIFT, OPENSHIFT, VIEWSHIFT
}
