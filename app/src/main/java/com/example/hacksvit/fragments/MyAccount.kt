package com.example.hacksvit.fragments

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.hacksvit.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MyAccount.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyAccount : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name_edit = view.findViewById<TextView>(R.id.name_vol_edit)
        val email_edit = view.findViewById<TextView>(R.id.email_vol_edit)
        val address_edit = view.findViewById<TextView>(R.id.address_vol_edit)
        val phone_no_edit = view.findViewById<TextView>(R.id.phone_vol_edit)
        //val logout_vol =view.findViewById<Button>(R.id.logout_vol)

        val database = Firebase.database.getReference("Volunteers/${Firebase.auth.uid}")
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                name_edit.setText(snapshot.child("Name").value.toString())
                address_edit.setText(snapshot.child("Address").value.toString())
                email_edit.setText(snapshot.child("Email").value.toString())
                phone_no_edit.setText(snapshot.child("Phone_no").value.toString())

            }

            override fun onCancelled(error: DatabaseError) {
                Log.e(ContentValues.TAG, error.toString())
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_account, container, false)
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MyAccount().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}