package com.example.raktadana

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_donor.view.*

class Adapter (var data:ArrayList<donor>): RecyclerView.Adapter<Adapter.viewHolder>(){
    class viewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val Name=itemView.donot_id
        var Location=itemView.donor_location
        var Phone=itemView.phone_no
        var Bgroup=itemView.blood_group

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var itemView= LayoutInflater.from(parent.context).inflate(R.layout.list_donor,parent,false)
        return viewHolder(itemView)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val donor:donor=data[position]
        holder.Name.text=donor.Name
        holder.Phone.text=donor.Phone
        holder.Location.text=donor.Location
        holder.Bgroup.text=donor.Bgroup

    }
    override fun getItemCount(): Int {
        return data.size
    }
}