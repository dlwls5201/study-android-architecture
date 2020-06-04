package com.tistory.mashuparchitecture.mapper

/**
 * Interface for model mappers. It provides helper methods that facilitate
 * retrieving of models from outer layers
 *
 * @param <V> the view model input type
 * @param <D> the domain model output type
 */
interface Mapper<V, D> {

    fun mapToView(entity: D): V

    fun mapFromView(item: V): D
}