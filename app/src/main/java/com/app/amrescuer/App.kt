package com.app.amrescuer

import android.app.Application
import com.app.amrescuer.activity.auth.AuthViewModalFactory
import com.app.amrescuer.network.MyApi
import com.app.amrescuer.network.NetworkInterceptor
import com.app.amrescuer.repositories.UserRepository
import com.app.amrescuer.room.AppDatabase
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class App:Application(),KodeinAware {
    override val kodein= Kodein.lazy {
        import(androidXModule(this@App))
        bind() from  singleton { NetworkInterceptor(instance()) }
        bind() from  singleton { MyApi(instance()) }
        bind() from  singleton { AppDatabase(instance()) }
        bind() from singleton { UserRepository(instance(),instance()) }
        bind() from provider { AuthViewModalFactory(instance()) }
    }

}