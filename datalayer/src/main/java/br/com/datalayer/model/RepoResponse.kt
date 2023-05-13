package br.com.datalayer.model

import com.google.gson.annotations.SerializedName

data class RepoResponse(
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String?,
    @SerializedName("full_name")
    val fullName: String?,
    @SerializedName("html_url")
    val url: String?
)
