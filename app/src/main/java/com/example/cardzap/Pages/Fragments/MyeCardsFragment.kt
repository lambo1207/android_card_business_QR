package com.example.cardzap.Pages.Fragments

import android.content.Context
import android.content.Intent
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cardzap.Pages.NewCard
import com.example.cardzap.Pages.SettingPage
import com.example.cardzap.R
import com.example.cardzap.adapters.CardAdapter
import com.example.cardzap.models.Card
import kotlin.random.Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MyeCardsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyeCardsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var ivScan: ImageView
    private lateinit var ivNewCard: ImageView
    private lateinit var rvCards: RecyclerView
    private lateinit var ivSetting: ImageView
    private var listCard: MutableList<Card> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_mye_cards, container, false)

        ivScan = view.findViewById(R.id.iv_scan_qr)
        ivNewCard = view.findViewById(R.id.iv_new_card)
        rvCards = view.findViewById(R.id.rv_card_qr)
        ivSetting = view.findViewById(R.id.iv_setting)

        ivScan.setOnClickListener {

        }

        ivSetting.setOnClickListener {
            startActivity(Intent(context,SettingPage::class.java))
        }

        ivNewCard.setOnClickListener{
            val newCardIntent = Intent(context, NewCard::class.java)
            startActivity(newCardIntent)
        }

        val cardAdapter = context?.let { CardAdapter(it) }

        val linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rvCards.layoutManager = linearLayoutManager

        listCard = context?.let { getData(listCard, it) }!!
        cardAdapter?.setData(listCard)
        rvCards.adapter = cardAdapter
        cardAdapter?.notifyDataSetChanged()

        return view
    }

    private fun getData(itemList: MutableList<Card>, context: Context): MutableList<Card> {
        val cardListGet: MutableList<Card> = ArrayList()

        val random = Random
        val imgInt = intArrayOf(
            R.mipmap.img_ava01, R.mipmap.img_ava02, R.mipmap.img_ava03, R.mipmap.img_ava04,
            R.mipmap.img_ava05, R.mipmap.img_ava06, R.mipmap.img_ava07
        )
        val imgString = arrayOfNulls<String>(imgInt.size)
        var imgParse: String
        for (i in imgInt.indices) {
            imgParse = "android.resource://" + context.packageName + "/" + imgInt[i]
            imgString[i] = imgParse
        }
        val nameCard = arrayOf(
            "Iphone 11", "Iphone 12 Pro", "Iphone 13 ProMax", "Iphone 12 Mini",
            "Iphone 13 Mini", "Iphone 11 ProMax", "Iphone 14", "Iphone 14 Pro", "Iphone 14 ProMax", "Iphone 15"
        )
        val email = arrayOf(
            "Iphone 11", "Iphone 12 Pro", "Iphone 13 ProMax", "Iphone 12 Mini",
            "Iphone 13 Mini", "Iphone 11 ProMax", "Iphone 14", "Iphone 14 Pro", "Iphone 14 ProMax", "Iphone 15"
        )

        for (i in 1..10) {
            val card = Card(
                i, nameCard[random.nextInt(nameCard.size)],
                imgString[random.nextInt(imgString.size)]!!, email[random.nextInt(email.size)]
            )
            cardListGet.add(card)
        }
        return cardListGet
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MyeCardsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MyeCardsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}