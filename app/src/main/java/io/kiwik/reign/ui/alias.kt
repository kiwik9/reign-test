package io.kiwik.reign.ui

typealias OnItemClickListener<T> = (item: T) -> Unit
typealias OnLongItemClickListener<T> = (item: T) -> Unit
typealias OnItemRemoveListener<T> = (item: T, pos: Int) -> Unit
typealias OnItemCheckListener<T> = (item: T, pos: Int, res: Boolean) -> Unit
typealias OnItemGpsListener<T> = (item: T) -> Unit
typealias OnItemCallListener<T> = (item: T) -> Unit
