package com.theexistingcompany.aisdevtool

import com.theexistingcompany.aisdevtool.api.EasyAppService
import com.theexistingcompany.aisdevtool.model.CheckDeathStatusUseCase
import com.theexistingcompany.aisdevtool.model.GetCurrentDateUseCase
import com.theexistingcompany.aisdevtool.model.LogInUseCase
import com.theexistingcompany.aisdevtool.model.QueryEDocumentUseCase
import com.theexistingcompany.aisdevtool.repository.EasyAppRepository
import com.theexistingcompany.aisdevtool.viewmodel.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
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
            get(),
            get(),
            get(),
        )
    }
}

val useCaseModule = module {
    factory { LogInUseCase(get()) }
    factory { CheckDeathStatusUseCase(get()) }
    factory { GetCurrentDateUseCase(get()) }
    factory { QueryEDocumentUseCase(get()) }
}