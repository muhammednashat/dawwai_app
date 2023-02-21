package com.example.dawaai.repository

import com.example.dawaai.data.models.ItemFoFirebase
import com.example.dawaai.data.localy.ItemDatabase
import com.example.dawaai.data.models.asdomainModel
import com.google.firebase.database.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ItemRepository(private val database: ItemDatabase) {

    val applicationScope = CoroutineScope(Dispatchers.Default)
    private var databaseReference: DatabaseReference =
        FirebaseDatabase.getInstance().getReference("Items")
    var listOfItem = arrayListOf<ItemFoFirebase>()

    val items = database.itemDao.getAllItems()

    suspend fun refreshData() {
        withContext(Dispatchers.IO) {
            getDataFromFirebase()
        }
    }

    private fun getDataFromFirebase() {
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                listOfItem.clear()
                if (snapshot.exists()) {
                    for (snapItem in snapshot.children) {
                        val itemFoFirebase = snapItem.getValue(ItemFoFirebase::class.java)
                        listOfItem.add(itemFoFirebase!!)
                    }
                    applicationScope.launch {
                        database.itemDao.upSert(*listOfItem.asdomainModel().toTypedArray())
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }


}