package Retrofit


import ModelClass.DataClass
import android.telecom.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


//https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=2069ba1ca20a4b5a84473dc0c97df1ca
//https://newsapi.org/v2/top-headlines?country=in&apiKey=2069ba1ca20a4b5a84473dc0c97df1ca

const val API_KEY = "2069ba1ca20a4b5a84473dc0c97df1ca"
interface NewsInterface {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadline(@Query("country")country:String,@Query("page")page:Int):retrofit2.Call<DataClass>

}

