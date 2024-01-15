package com.example.customspinnerwithtext.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ProgressBar
import android.widget.Spinner
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.customspinnerwithtext.R


class CustomSpinnerWithTitle : ConstraintLayout {

    private var title: String? = null
    private var textSize:Float? = null
    var tvTitle: TextView? = null
    private var spinner: Spinner? = null
    private var progressBar: ProgressBar? = null
    private var rootLayout: ConstraintLayout? = null
    val selectedItem: String
        get() = if (spinner!!.selectedItem != null) {
                spinner!!.selectedItem.toString()

        } else {
            ""
        }

    fun setLoading(loading: Boolean) {
        if (loading) {
            progressBar!!.visibility = VISIBLE
        } else {
            progressBar!!.visibility = INVISIBLE
        }
    }

    constructor(context: Context) : super(context) {
        initView(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        getAttrsFromXML(context, attrs)
        initView(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        getAttrsFromXML(context, attrs)
        initView(context)
    }

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int,
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        getAttrsFromXML(context, attrs)
        initView(context)
    }




    fun setTitle(title: String?) {
        tvTitle!!.text = title
    }

    private fun getAttrsFromXML(context: Context?, attrs: AttributeSet?) {
        if (context != null) {
            val typedArray =
                context.obtainStyledAttributes(attrs, R.styleable.CustomSpinnerWithTitle)

            title = typedArray.getString(R.styleable.CustomSpinnerWithTitle_title)
            textSize = typedArray.getDimension(R.styleable.CustomSpinnerWithTitle_titleTextSize,16f)
            typedArray.recycle()
        }
    }

    private fun initView(context: Context) {
        layoutParams =
            LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        LayoutInflater.from(context).inflate(R.layout.custom_spinner_with_title, this, true)
        rootLayout = findViewById<ConstraintLayout>(R.id.root_custom_spinner_field)
        tvTitle = findViewById<TextView>(R.id.title_tv)
        spinner = findViewById<Spinner>(R.id.spinner)
        textSize?.let{
            tvTitle?.textSize = it
        }
        title?.let {
            if(it.isNotEmpty()){
                tvTitle?.text = title
            }
        }
//        if (title != null && title!!.isNotEmpty()) {
//            tvTitle!!.text = title
//        }
    }
    fun setAdapter(arrayAdapter: ArrayAdapter<*>?) {
        spinner?.adapter = arrayAdapter
    }
    fun setOnItemSelectedListener(itemSelectedListener: AdapterView.OnItemSelectedListener?) {
        spinner?.onItemSelectedListener = itemSelectedListener
    }
}
