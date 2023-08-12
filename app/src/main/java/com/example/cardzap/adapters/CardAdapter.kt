package com.example.cardzap.adapters

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.cardzap.R
import com.example.cardzap.models.Card

class CardAdapter(private val context: Context) : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {
    private var cardList: List<Card> = ArrayList()
    private var itemClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(card: Card)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        itemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = cardList[position] ?: return
        holder.onBindData(card)
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    fun setData(list: List<Card>) {
        cardList = list
        notifyDataSetChanged()
    }

    inner class CardViewHolder(itemCard: View) : RecyclerView.ViewHolder(itemCard) {
        private val tvNameCard: TextView = itemView.findViewById(R.id.tv_name_card)
        private val tvDepartment: TextView = itemView.findViewById(R.id.tv_department)
        private val tvCompany: TextView = itemView.findViewById(R.id.tv_company)
        private val tvEmail: TextView = itemView.findViewById(R.id.tv_email)
        private val tvPhoneNumber: TextView = itemView.findViewById(R.id.tv_phone)
        private val tvAddress: TextView = itemView.findViewById(R.id.tv_address)
        private val tvWebSite: TextView = itemView.findViewById(R.id.tv_website)
        private val tvFaceBook: TextView = itemView.findViewById(R.id.tv_fb)
        private val ivAvatar: ImageView = itemView.findViewById(R.id.iv_avatar)
        private val tvLinkIn: TextView = itemView.findViewById(R.id.tv_linkin)

        fun onBindData(card: Card) {
            ivAvatar.setImageURI(Uri.parse(card.imgAvatar))
            tvNameCard.text = card.nameCard
            tvDepartment.text = card.department
            tvCompany.text = card.company
            tvEmail.text = card.email
            tvPhoneNumber.text = card.phoneNumber
            tvAddress.text = card.address
            tvWebSite.text = card.webSite
            tvFaceBook.text = card.facebook
            tvLinkIn.text = card.linkin

            setBgr()

            itemView.setOnClickListener {
                val dia = AlertDialog.Builder(it.context)
                dia.setTitle("Dialog Fragment")
                dia.setIcon(R.mipmap.ic_scan_qr)
                dia.setMessage("ID ${card.nameCard}: ${card.email}, ${card.phoneNumber}")

                dia.setNegativeButton("No") { _, _ ->
                }

                dia.setPositiveButton("Yes") { _, _ ->
                    Toast.makeText(dia.context, "ok", Toast.LENGTH_SHORT).show()
                }

                dia.show()

                itemClickListener?.onItemClick(card)
            }
        }

        private fun setBgr() {
            itemView.setBackgroundResource(R.drawable.bg_white_corner10)
        }
    }
}