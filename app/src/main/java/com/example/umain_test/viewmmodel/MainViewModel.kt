package com.example.umain_test.viewmmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.umain_test.model.AllRestaurants
import com.example.umain_test.model.Restaurant
import com.example.umain_test.network.RestarauntsRepository
import com.example.umain_test.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel

class MainViewModel @Inject constructor(

    private val repository: RestarauntsRepository
) : ViewModel() {
    private val _restarants = MutableStateFlow<Resource<List<Restaurant>>?>(null)

    val restaurants : StateFlow<Resource<List<Restaurant>>?> = _restarants
    init{
        viewModelScope.launch {
            _restarants.value = Resource.Loading
            _restarants.value = repository.getAllRestaurants()
        }
    }

}