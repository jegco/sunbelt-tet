package com.example.domain.usecases.base

import rx.Observable

interface UseCase<Params, Response> {
    fun execute(params: Params): Observable<Response>
}