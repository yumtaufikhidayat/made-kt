package com.yumtaufikhidayat.rickandmortys.core.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = CharacterEntity.TABLE_CHARACTER)
data class CharacterEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val created: String,
    val gender: String,
    val image: String,
    val name: String,
    val species: String,
    val status: String,
    val type: String,
    val url: String,
    var isFavorite: Boolean
) {
    companion object {
        const val TABLE_CHARACTER = "tbl_character"
    }
}