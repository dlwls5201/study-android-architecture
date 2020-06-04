package com.tistory.blackjin.data.source.local.mapper

interface DBMapper<M, E> {

    fun mapFromLocal(model: M): E

    fun mapToLocal(entity: E): M

}