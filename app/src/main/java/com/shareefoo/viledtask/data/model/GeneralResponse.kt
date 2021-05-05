package com.shareefoo.viledtask.data.model

import com.google.gson.annotations.SerializedName


data class GeneralResponse(
    @SerializedName("categories")
    val categories: List<Category>,
    @SerializedName("services")
    val services: List<Service>
)

data class Category(
    @SerializedName("iconUrl")
    val iconUrl: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("lft")
    val lft: Int,
    @SerializedName("lvl")
    val lvl: Int,
    @SerializedName("rgt")
    val rgt: Int,
    @SerializedName("title")
    val title: String
)

data class Service(
    @SerializedName("categoryIds")
    val categoryIds: List<String>,
    @SerializedName("humanizedId")
    val humanizedId: String,
    @SerializedName("iconUrl")
    val iconUrl: String,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("title")
    val title: String
)