package com.bodyweight.fitness.adapter

import com.bodyweight.fitness.model.DateTimeRepositorySet
import com.robinhood.spark.SparkAdapter

import java.util.*

class RepsAdapter : SparkAdapter() {
    private var data: ArrayList<DateTimeRepositorySet>? = null

    fun changeData(data: ArrayList<DateTimeRepositorySet>) {
        this.data = data

        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        data?.let {
            return it.size
        }

        return 0
    }

    override fun getItem(index: Int): Any {
        val item = data?.getOrNull(index)

        item?.let {
            return it
        }

        return ""
    }

    override fun getY(index: Int): Float {
        data?.getOrNull(index)?.repositorySet?.let {
            return it.reps.toFloat()
        }

        return 0f
    }

    override fun getX(index: Int): Float {
        return index.toFloat()
    }

    override fun hasBaseLine(): Boolean {
        return true
    }

    override fun getBaseLine(): Float {
        return 15f
    }
}

class TimeAdapter : SparkAdapter() {
    private var data: ArrayList<DateTimeRepositorySet>? = ArrayList()

    fun changeData(data: ArrayList<DateTimeRepositorySet>) {
        this.data = data

        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        data?.let {
            return it.size
        }

        return 0
    }

    override fun getItem(index: Int): Any {
        val item = data?.getOrNull(index)

        item?.let {
            return it
        }

        return ""
    }

    override fun getY(index: Int): Float {
        data?.getOrNull(index)?.repositorySet?.let {
            return it.seconds.toFloat()
        }

        return 0f
    }

    override fun getX(index: Int): Float {
        return index.toFloat()
    }

    override fun hasBaseLine(): Boolean {
        return true
    }

    override fun getBaseLine(): Float {
        return 120f
    }
}