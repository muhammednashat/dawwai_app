package com.example.dawaai.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Entity(tableName = "items_table")
@Parcelize
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id:Long?,
    val name: String? = null,
    val information: String? = null
): Parcelable


fun List<ItemFoFirebase>.asdomainModel():List<Item>{
    return map{
        Item(
            id = it.id,
            name =it.name ,
            information = it.information
        )
    }
}
