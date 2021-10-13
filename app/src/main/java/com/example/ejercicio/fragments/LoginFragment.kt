package com.example.ejercicio.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ejercicio.database.appDatabase
import com.example.ejercicio.database.userDao
import com.example.ejercicio.databinding.LoginFragmentBinding
import com.example.ejercicio.entities.User
import com.google.android.material.snackbar.Snackbar

class LoginFragment : Fragment() {

    private lateinit var userList :MutableList<User>
    private lateinit var binding: LoginFragmentBinding
    private var db: appDatabase? = null
    private var userDao: userDao? = null
    private var i : Int = 0
    private var lastUserId : Int = 0

    companion object {
        fun newInstance() = LoginFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LoginFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        db = context?.let { appDatabase.getAppDataBase(it) }
        userDao = db?.userDao()

        binding.btnAdd.setOnClickListener {
            val searchedUser = findUser()
            if(searchedUser == null) {
                userDao?.insertPerson(User(i, binding.name.text.toString(), binding.password.text.toString()))
                i += 1
                Snackbar.make(binding.root, "Usuario agregado", Snackbar.LENGTH_LONG).show()
            } else {
                Snackbar.make(binding.root, "El usuario ya existe", Snackbar.LENGTH_LONG).show()
            }
        }

        binding.btnDelete.setOnClickListener {
            val searchedUser = findUser()
            if (searchedUser != null) {
                Log.d("usuario", searchedUser.name)
            }
            if(searchedUser != null){
                userDao?.delete(searchedUser)
                Snackbar.make(binding.root, "Usuario eliminado", Snackbar.LENGTH_LONG).show()
            } else {
                Snackbar.make(binding.root, "No se encontró al usuario", Snackbar.LENGTH_LONG).show()
            }
        }

        binding.btnEnter.setOnClickListener {

            if (binding.name.length() > 0 && binding.password.length() > 0) {

                val searchedUser = findUser()

                if(searchedUser != null){
                    lastUserId = searchedUser.id
                    Log.d("n°", lastUserId.toString())
                    val action = LoginFragmentDirections.actionLoginFragment2ToMainActivityEquipo(searchedUser)
                    findNavController().navigate(action)
                } else {
                    Snackbar.make(binding.root, "Usuario y/o contraseña inválidos", Snackbar.LENGTH_LONG).show()
                }
            } else{
                Snackbar.make(binding.root, "Los campos no deben estar vacíos", Snackbar.LENGTH_LONG).show()
            }
        }

    }

    private fun findUser(): User? {

        var idx = 0
        var searchedUser : User? = null
        var user : User?
        userList = userDao?.loadAllPersons() as MutableList<User>

        while ( idx < userList.size && searchedUser == null ) {
            user = userList[idx]

            if (user.name == binding.name.text.toString() && user.password == binding.password.text.toString()) {
                searchedUser = user
                Log.d("sU","Usuario encontrado. ID: " + searchedUser.id)
            }
            idx++
        }
        return searchedUser
    }

    fun getUser(): User? {
        return userDao?.loadPersonById(lastUserId)
    }
}