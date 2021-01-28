package com.example.pathwayhub_sujeesh.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pathwayhub_sujeesh.MainActivity
//import com.example.pathwayhub_sujeesh.db.AppDatabase1
import com.example.pathwayhub_sujeesh.network.PathPojo
import com.example.pathwayhub_sujeesh.network.RetroInstance
import com.example.pathwayhub_sujeesh.network.RetroService
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/*import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pathwayhub_sujeesh.network.PathPojo
import com.example.pathwayhub_sujeesh.network.RetroInstance
import com.example.pathwayhub_sujeesh.network.RetroService


import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers*/

class MainViewModel : ViewModel() {
    lateinit var pathList: MutableLiveData<PathPojo>

    init {
        pathList = MutableLiveData()
    }

    fun getListObserver() : MutableLiveData<PathPojo>{
        println("List**** "+pathList)
        return pathList
    }

    fun apiCall(mainActivity: MainActivity) {
        val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
        retroInstance.getList()

            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getListObserverRx(mainActivity))
      //  println("List****111 "+retroInstance)


    }

    private fun getListObserverRx(mainActivity: MainActivity): Observer<PathPojo> {
        return object  :Observer<PathPojo>{
            override fun onComplete() {
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: PathPojo) {
                pathList.postValue(t)
                println("Val****1 "+pathList)
                /*try {
                    val db = AppDatabase1.getInstance(mainActivity).pathDao()
                    db.storePath(t.response.docs)

                } catch (e: Exception) {
                    println("chat Exception history")

                }*/
            }

            override fun onError(e: Throwable) {
                pathList.postValue(null)
                println("Val****2 "+pathList)
            }
        }
    }
}