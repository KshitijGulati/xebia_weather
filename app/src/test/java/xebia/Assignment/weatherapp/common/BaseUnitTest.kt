package xebia.Assignment.weatherapp.common

import android.content.Context
import org.mockito.Mock
import org.mockito.Mockito
import xebia.Assignment.weatherapp.weather.model.listener.IFetchCurrentWeatherListener
import xebia.Assignment.weatherapp.weather.model.listener.IFetchForecastWeatherListener
import xebia.Assignment.weatherapp.weather.view.ForecastAdapter
import xebia.Assignment.weatherapp.weather.viewmodel.WeatherViewModel

open class BaseUnitTest {
    @Mock
    var mContext: Context = Mockito.mock(Context::class.java)
    val mWeatherViewModel: WeatherViewModel? = null
    var mCurrentWeatherListener: IFetchCurrentWeatherListener? = null
    var mForecastWeatherListener: IFetchForecastWeatherListener? = null
    var mForecastAdapter: ForecastAdapter?= null
}