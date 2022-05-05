package com.example.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.remote.dto.CharacterDto

//@Dao
//interface CharacterDao {
//
//    @Query("SELECT * FROM characters")
//    suspend fun getAllCharacters() : List<CharacterDto>
//
//    @Query("SELECT * FROM characters WHERE id = :id")
//    suspend fun getCharacter(id: Int): CharacterDto
//
//
//}