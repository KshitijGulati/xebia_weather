package xebia.Assignment.weatherapp.weather.viewmodel

import org.junit.Test
import org.mockito.Mockito
import xebia.Assignment.weatherapp.common.BaseUnitTest
import xebia.Assignment.weatherapp.weather.model.listener.IFetchCurrentWeatherListener
import xebia.Assignment.weatherapp.weather.model.listener.IFetchForecastWeatherListener
import xebia.Assignment.weatherapp.weather.view.ForecastAdapter

class WeatherViewModelTest: BaseUnitTest() {

    @Test
    fun getCurrentTempAndLocation() {
        mCurrentWeatherListener = Mockito.mock(IFetchCurrentWeatherListener::class.java)
        mWeatherViewModel?.getCurrentTempAndLocation(mCurrentWeatherListener!!)
    }

    @Test
    fun getWeatherForecast() {
        mForecastWeatherListener = Mockito.mock(IFetchForecastWeatherListener::class.java)
        mForecastAdapter = Mockito.mock(ForecastAdapter::class.java)
        mWeatherViewModel?.getWeatherForecast(mForecastAdapter!!, mForecastWeatherListener!!)
    }
}