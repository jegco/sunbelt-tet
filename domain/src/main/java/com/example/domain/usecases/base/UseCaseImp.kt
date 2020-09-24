package com.example.domain.usecases.base

import rx.Observable

abstract class UseCaseImp<Params, Response> : UseCase<Params, Response> {

    override fun execute(params: Params): Observable<Response> = buildUseCase(params)

    protected abstract fun buildUseCase(params: Params): Observable<Response>
}