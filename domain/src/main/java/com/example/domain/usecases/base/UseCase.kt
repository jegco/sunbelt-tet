package com.example.domain.usecases.base

import androidx.lifecycle.LiveData
import com.example.domain.utils.Result

interface UseCase<Params, Response> {
    fun execute(params: Params): LiveData<Result<Response>>
}