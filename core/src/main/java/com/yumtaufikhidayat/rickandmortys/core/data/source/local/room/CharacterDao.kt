package com.yumtaufikhidayat.rickandmortys.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.yumtaufikhidayat.rickandmortys.core.data.source.local.entity.CharacterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    @Query("SELECT * FROM tbl_character")
    fun getAllCharacters(): Flow<List<CharacterEntity>>

    @Query("SELECT * FROM tbl_character WHERE isFavorite = 1")
    fun getFavoriteCharacter(): Flow<List<CharacterEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(character: List<CharacterEntity>)

    @Update
    fun updateFavoriteCharacter(characterEntity: CharacterEntity)
}