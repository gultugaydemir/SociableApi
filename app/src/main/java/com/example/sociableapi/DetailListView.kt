package com.example.sociableapi

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class DetailListView(ctx: Context, attrs: AttributeSet?): ConstraintLayout(ctx, attrs) {

    init {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.DetailListView)

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
                as LayoutInflater
        inflater.inflate(R.layout.detail_list_view, this, true)

        var value: TextView = findViewById(R.id.DetailListNumber)
        value.text = ta.getString(R.styleable.DetailListView_number_field)

        var name: TextView = findViewById(R.id.DetailListText)
        name.text = ta.getString(R.styleable.DetailListView_text_field)
    }
}