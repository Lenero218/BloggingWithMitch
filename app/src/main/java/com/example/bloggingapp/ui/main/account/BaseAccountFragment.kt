package com.example.bloggingapp.ui.main.account

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.example.bloggingapp.R
import com.example.bloggingapp.ViewModals.ViewModelProviderFactory
import com.example.bloggingapp.ui.DataStateChangedListener
import com.example.bloggingapp.ui.main.account.state.AccountViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseAccountFragment : DaggerFragment(){

    @Inject
    lateinit var providerFactory:ViewModelProviderFactory
    lateinit var viewModel: AccountViewModel

    val TAG: String = "AppDebug"

    lateinit var stateChangeListener: DataStateChangedListener



    //Initialisation of the function for the functions to get change
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            setupActionBarWithNavController(R.id.accountFragment,activity as AppCompatActivity)
             viewModel=activity?.run{
            ViewModelProvider(this,providerFactory).get(AccountViewModel::class.java)
        }?:throw Exception("Invalid Activity")
             cancelActiveJobs()

    }


     fun cancelActiveJobs(){
        viewModel.cancelActiveJobs()
    }


    //Setting up the function so that main blog fragment will not get affected by change in fragment
    fun setupActionBarWithNavController(fragmentId:Int, activity:AppCompatActivity){
        val appBarConfiguration=AppBarConfiguration(setOf(fragmentId))
        NavigationUI.setupActionBarWithNavController(
            activity,
            findNavController(),
            appBarConfiguration
        )
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try{
            stateChangeListener = context as DataStateChangedListener
        }catch(e: ClassCastException){
            Log.e(TAG, "$context must implement DataStateChangeListener" )
        }
    }
}
