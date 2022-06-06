package com.example.raktadana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.*
import kotlinx.android.synthetic.main.activity_reciever.*

class RecieverActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var donorarraylist:ArrayList<donor>
    private lateinit var myadapter:Adapter
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reciever)

        recycler_view.apply {
            layoutManager=LinearLayoutManager(this.context)
            setHasFixedSize(true)
        }

        donorarraylist= arrayListOf()

        myadapter=Adapter(donorarraylist)
        recycler_view.adapter=myadapter


        EventChangeListener()
    }

    private fun EventChangeListener(){
        db= FirebaseFirestore.getInstance()
        db.collection("DONORS")
            .addSnapshotListener(object : EventListener<QuerySnapshot> {
                override fun onEvent(
                    value: QuerySnapshot?,
                    error: FirebaseFirestoreException?
                ) {
                    if(error!=null){
                        Log.e("Firestore",error.message.toString())
                        return
                    }
                    for(dc: DocumentChange in value?.documentChanges!!){
                        if(dc.type== DocumentChange.Type.ADDED){
                            donorarraylist.add(dc.document.toObject(donor::class.java))
                        }
                    }
                    myadapter.notifyDataSetChanged()
                }
            })
    }
}