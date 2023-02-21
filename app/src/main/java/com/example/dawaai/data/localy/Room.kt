package com.example.dawaai.data.localy;

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.dawaai.data.models.Item

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upSert(vararg items: Item)

    @Query("SELECT * FROM Items_table")
    fun getAllItems(): LiveData<List<Item>>

    @Query("SELECT * FROM Items_table WHERE name LIKE  :search ")
    fun getSomeItems(search : String): LiveData<List<Item>>


}

private lateinit var INSTANCE: ItemDatabase

@Database(entities = [Item::class], version = 2, exportSchema = false)
abstract class ItemDatabase() : RoomDatabase() {

    abstract val itemDao: ItemDao
}

fun getDatabase(context: Context): ItemDatabase {
    synchronized(ItemDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                ItemDatabase::class.java,
                "item_.db"
            ).fallbackToDestructiveMigration()
                .build()
        }
    }
    return INSTANCE
}