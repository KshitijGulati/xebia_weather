package xebia.Assignment.weatherapp.weather.view

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import xebia.Assignment.weatherapp.R
import xebia.Assignment.weatherapp.common.CommonUtils
import xebia.Assignment.weatherapp.common.network.listener.INetworkListener
import xebia.Assignment.weatherapp.common.network.receiver.NetworkReceiver
import xebia.Assignment.weatherapp.common.network.util.NetworkConstants
import xebia.Assignment.weatherapp.common.network.util.NetworkUtil
import xebia.Assignment.weatherapp.common.network.util.displayToast

open class BaseActivity : AppCompatActivity(), INetworkListener {
    private var mNetworkReceiver: NetworkReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CommonUtils.setContext(this)
        NetworkUtil.setConnectivityListener(this)
        registerNetworkReceiver()
    }



    private fun registerNetworkReceiver() {
        mNetworkReceiver = NetworkReceiver()
        val intentFilter = IntentFilter()
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
        this.registerReceiver(mNetworkReceiver, intentFilter)
    }

    override fun onConnectivityChange(connectionStatus: String) {
        when (connectionStatus) {
            NetworkConstants.POOR_NETWORK -> {
                mIsNetworkAvailable = true
                mIsConnectivityPoor = true
                this.displayToast(getString(R.string.poor_network))
            }
            NetworkConstants.TYPE_WIFI -> {
                mIsNetworkAvailable = true
                mIsConnectivityPoor = false
            }
            NetworkConstants.TYPE_NOT_CONNECTED -> {
                mIsNetworkAvailable = false
                mIsConnectivityPoor = false
                this.displayToast(getString(R.string.no_network))
            }
        }

        if (mIsNetworkAvailable) initOnlineFlow() else initOfflineFlow()
    }

    open fun initOnlineFlow() {
    }

    open fun initOfflineFlow() {
    }

    companion object {
        var mIsNetworkAvailable: Boolean = false
        var mIsConnectivityPoor: Boolean = false
    }

}