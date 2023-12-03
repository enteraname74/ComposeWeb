package view.utils

import androidx.compose.foundation.lazy.LazyListState

object LazyListUtils {
    /**
     * Tries to go to an element at a given index
     */
    suspend fun goToElement(
        listState: LazyListState,
        index: Int
    ) {
        if (index < listState.layoutInfo.totalItemsCount) {
            listState.animateScrollToItem(index)
        }
    }
}