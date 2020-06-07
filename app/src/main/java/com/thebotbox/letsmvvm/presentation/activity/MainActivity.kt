package com.thebotbox.letsmvvm.presentation.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.thebotbox.letsmvvm.data.network.model.RandomQuoteResponse
import com.thebotbox.letsmvvm.databinding.ActivityMainBinding
import com.thebotbox.letsmvvm.presentation.viewmodel.MainViewModel
import com.thebotbox.letsmvvm.util.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val mBinding by viewBinding(ActivityMainBinding::inflate)
    private val mViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        mBinding.viewModel = mViewModel

        mViewModel.fetchRandomQuoteLiveData.observe(this, Observer {
            mBinding.quote.text = "${it.quote} \n\n-${it.author} \n\nid:${it.quote_id}"
        })

        mViewModel.errorLiveData.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }
}