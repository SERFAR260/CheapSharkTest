package com.sifh.cheapsharktest.framework.data

import com.google.gson.annotations.SerializedName
import java.sql.Timestamp

data class Results(
    @SerializedName("internalName") var internalName: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("metacriticLink") var metaCriticLink: String? = null,
    @SerializedName("dealID") var dealID: String? = null,
    @SerializedName("storeID") var storeID: String? = null,
    @SerializedName("gameID") var gameID: String? = null,
    @SerializedName("salePrice") var salePrice: String? = null,
    @SerializedName("normalPrice") var normalPrice: String? = null,
    @SerializedName("isOnSale") var isOnSale: String? = null,
    @SerializedName("savings") var savings: String? = null,
    @SerializedName("metacriticScore") var metaCriticScore: String? = null,
    @SerializedName("steamRatingText") var steamRatingText: String? = null,
    @SerializedName("steamRatingPercent") var steamRatingPercent: String? = null,
    @SerializedName("steamRatingCount") var steamRatingCount: String? = null,
    @SerializedName("steamAppID") var steamAppID: String? = null,
    @SerializedName("releaseDate") var releaseDate: Long? = 0L,
    @SerializedName("lastChange") var lastChange: Long? = 0L,
    @SerializedName("dealRating") var dealRating: String? = null,
    @SerializedName("thumb") var thumb: String? = null,
)
