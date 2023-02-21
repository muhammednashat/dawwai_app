package com.example.dawaai

import android.app.Application
import android.os.Build
import com.example.dawaai.di.myModule
//import androidx.work.*
//import com.udacity.asteroidradar.main.MainViewModel
//import com.udacity.asteroidradar.work.RefreshDataWorker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import java.util.concurrent.TimeUnit


class MyApplication():Application() {

//    val applicationScope = CoroutineScope(Dispatchers.Default)
//
//    private fun delayedInit(){
//        applicationScope.launch {
//            setupRecurringWork()
//
//        }
//    }


//   private fun setupRecurringWork(){
//
//        val repeatingRequest =
//            PeriodicWorkRequestBuilder<RefreshDataWorker>(1,TimeUnit.DAYS)
//                .setConstraints(setConstraints())
//                .build()
//
//       WorkManager.getInstance().enqueueUniquePeriodicWork(
//           RefreshDataWorker.WORK_NAME,
//           ExistingPeriodicWorkPolicy.KEEP,
//           repeatingRequest
//       )
//
//   }


//    private fun setConstraints(): Constraints {
//        return Constraints.Builder()
//            .setRequiredNetworkType(NetworkType.UNMETERED)
//            .setRequiresBatteryNotLow(true)
//            .setRequiresCharging(true)
//            .apply {
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                    setRequiresDeviceIdle(true)
//                }
//            }
//            .build()
//    }

    override fun onCreate() {
        super.onCreate()
//     delayedInit()

        startKoin {
            androidContext(this@MyApplication)
            modules(listOf(myModule))
            androidLogger()
        }
    }

}