package com.example.dawaai.ui.add

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dawaai.data.models.ItemFoFirebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddingViewModel(private val  application: Application,
): AndroidViewModel(application) {

    private var databaseReference : DatabaseReference = FirebaseDatabase.getInstance().getReference("Items")


    private val _onButtonClicked = MutableLiveData<Boolean>()
    val onButtonClicked: LiveData<Boolean>
        get() = _onButtonClicked

    fun onButtonClicked() {
        _onButtonClicked.value = true
    }

    fun addDataToFirebase(item: ItemFoFirebase){

        val iteemId = databaseReference.push().key!!
        databaseReference.child(iteemId).setValue(item)
            .addOnCompleteListener{
                Toast.makeText(application ,"Don",Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener{
                Toast.makeText(application ,"Don not",Toast.LENGTH_SHORT).show()
            }

    }

    fun buttonHandled() {
        _onButtonClicked.value = false

    }

}