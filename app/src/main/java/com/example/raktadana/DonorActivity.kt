package com.example.raktadana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_donor.*

class DonorActivity : AppCompatActivity() {
    private lateinit var db: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donor)

        db= FirebaseFirestore.getInstance()
        Continue.setOnClickListener {
            if(checking()){
                val name=name.text.toString()
                val phone=phone.text.toString()
                val location=location.text.toString()
                val bgroup=bgroup.text.toString()
                val donor= hashMapOf(
                    "Name" to name,
                    "Phone" to phone,
                    "Location" to location,
                    "Bgroup" to bgroup
                )
                val Donors=db.collection("DONORS")
                Donors.document(name).set(donor)
                Toast.makeText(this,"Donor Successfully added to Database",
                    Toast.LENGTH_SHORT).show()

            }
            else{
                Toast.makeText(this?.applicationContext,"Fill the Fiels Correctly", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checking(): Boolean {
        if(name.text.toString().trim { it<=' '}.isNotEmpty()
            && phone.text.toString().trim { it<=' '}.isNotEmpty()
            && location.text.toString().trim { it<=' '}.isNotEmpty()
            && bgroup.text.toString().trim { it<=' '}.isNotEmpty()) {
            return true
        }
        return false
    }
}