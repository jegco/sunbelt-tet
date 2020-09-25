package com.example.domain.usecases.base

import androidx.lifecycle.LiveData
import com.example.domain.utils.Result

abstract class UseCaseImp<Params, Response> : UseCase<Params, Response> {

    override fun execute(params: Params): LiveData<Result<Response>> =
        buildUseCase(params)

    protected abstract fun buildUseCase(params: Params): LiveData<Result<Response>>
}