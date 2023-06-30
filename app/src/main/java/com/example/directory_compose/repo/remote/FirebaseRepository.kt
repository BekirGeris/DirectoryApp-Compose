package com.example.directory_compose.repo.remote

import android.util.Log
import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.MutableLiveData
import com.example.directory_compose.model.User
import com.example.directory_compose.model.UserForFirebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.Locale

class FirebaseRepository {
    var userList = MutableLiveData<List<User>>()
    private var refUser: DatabaseReference

    init {
        userList = MutableLiveData()
        val db = FirebaseDatabase.getInstance()
        refUser = db.getReference("users")
    }

    fun getAllUsers() {
        refUser.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = ArrayList<User>()

                for (c in snapshot.children) {
                    val user = c.getValue(UserForFirebase::class.java)

                    user?.let {
                        it.key = c.key!!
                        list.add(it.toUser())
                    }
                }

                userList.value = list
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }

    fun searchUser(searchText: String) {
        refUser.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = ArrayList<User>()

                for (c in snapshot.children) {
                    val user = c.getValue(UserForFirebase::class.java)

                    user?.let {
                        if (it.userName?.lowercase()?.contains(searchText.lowercase()) == true) {
                            it.key = c.key!!
                            list.add(it.toUser())
                        }
                    }
                }

                userList.value = list
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }

    fun saveUser(user: User) {
        refUser.push().setValue(user)
    }

    fun updateUser(user: User) {
        val data = HashMap<String, Any>()
        data["userName"] = user.userName
        data["userTel"] = user.userTel
        refUser.child(user.key).updateChildren(data)
    }

    fun deleteUser(user: User) {
        refUser.child(user.key).removeValue()
    }
}