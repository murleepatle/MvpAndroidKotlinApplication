package com.example.mvpapplication.local_db

import androidx.room.*
import com.example.mvpapplication.model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM User")
    fun getAll(): List<User>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User):Long


    @Query("SELECT COUNT() FROM User WHERE username =:user AND password=:password")
    fun checkUser(user: String, password: String):Int
}
