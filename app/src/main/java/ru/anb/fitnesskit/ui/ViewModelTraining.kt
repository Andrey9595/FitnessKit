package ru.anb.fitnesskit.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.anb.fitnesskit.api.ApiResult
import ru.anb.fitnesskit.api.ApiService
import ru.anb.fitnesskit.data.Training

class ViewModelTraining(private val retrofit: ApiService): ViewModel() {

    var liveData = MutableLiveData<ApiResult<List<Training>>>()

    init {
        loadListTraining()
    }

    fun loadListTraining(){
        viewModelScope.launch(Dispatchers.IO) {
            val result = retrofit.getTrainingList()
            if (result.isSuccessful){
                liveData.postValue(ApiResult.Success(result.body()))
            } else liveData.postValue(ApiResult.Error("Not Loading"))
        }
    }
}