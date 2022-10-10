package com.theexistingcompany.aisdevtool

import android.net.eap.EapSessionConfig.EapSimConfig
import com.theexistingcompany.aisdevtool.api.EasyAppService
import com.theexistingcompany.aisdevtool.repository.EasyAppRepository
import com.theexistingcompany.aisdevtool.viewmodel.MainActivityViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module

val appModule = module {
    factory<EasyAppService> { ApiManager().prepaidIdentity() }
}

val repositoryModule = module {
        factory { EasyAppRepository(get())
    }
}

val viewModelModule = module {
    viewModel {
        MainActivityViewModel(
            get(),
        )
    }
}

val useCaseModule = module {
    factory { LogInUseCase(get()) }
}