package com.apptikar.yaskon.adapters

import android.graphics.Rect
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import kotlin.math.log


class ResultSpacesItemDecoration(private val space: Int) : ItemDecoration() {
override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {



        outRect.top = space

   }
}
