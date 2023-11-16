package com.khush.aliftask.domain

class GetItemListUseCase(
    private val repository: ItemRepository
) {
    operator fun invoke() = repository.getItemList()
}