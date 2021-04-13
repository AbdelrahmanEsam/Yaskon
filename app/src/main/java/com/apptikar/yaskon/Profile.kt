package com.apptikar.yaskon

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.apptikar.yaskon.adapters.ApartmentsAdapter
import com.apptikar.yaskon.adapters.SpacesItemDecoration
import com.apptikar.yaskon.databinding.FragmentProfileBinding
import com.apptikar.yaskon.pojos.Apartments
import kotlinx.coroutines.*


class Profile : AppCompatActivity(){

    private lateinit var binding: FragmentProfileBinding
    private lateinit var apartmentRecyclerAdapter: ApartmentsAdapter
    private var transparentPercent = 80

    private var friendlyPercent = 50
    private var helpfulPercent = 30
    private var professionalPercent = 45


    override fun onCreate(savedInstanceState: Bundle?)
    {  super.onCreate(savedInstanceState)
        binding = FragmentProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = getColor(R.color.white)
        binding.transparentProgressBar.animateProgress(1000, 0, transparentPercent)
        binding.friendlyProgressBar.animateProgress(1000, 0, friendlyPercent)
        binding.helpfulProgressBar.animateProgress(1000, 0, helpfulPercent)
        binding.professionalProgressBar.animateProgress(1000, 0, professionalPercent)
        apartmentRecycler()
        coroutines()


    }

    private fun coroutines()
    {
        transparentPercentProgress()
        friendlyPercentProgress()
        helpfulPercentProgress()
        professionalPercentProgress()
    }

    private fun transparentPercentProgress()
    {
      var transparentPercentText = 0
        CoroutineScope(Dispatchers.Default).launch{
            repeat(transparentPercent)
            {
                transparentPercentText++
                delay(1)
                updateTransparentPercentProgressUI(transparentPercentText)
            }




        }
    }

    private suspend fun updateTransparentPercentProgressUI(transparentPercentText: Int) {
      withContext(Dispatchers.Main)
      {
          binding.transparentTextView.text = transparentPercentText.toString()+"%"
      }
    }

    private fun friendlyPercentProgress()
    {
       var friendlyPercentText = 0
        CoroutineScope(Dispatchers.Default).launch{
            repeat(friendlyPercent)
            {
                friendlyPercentText++
                delay(1)
                updateFriendlyPercentProgressUI(friendlyPercentText)
            }




        }
    }

    private suspend fun updateFriendlyPercentProgressUI(transparentPercentText: Int) {
        withContext(Dispatchers.Main)
        {
            binding.friendlyTextView.text = transparentPercentText.toString()+"%"
        }
    }

    private fun helpfulPercentProgress()
    {
        var helpfulPercentText = 0
        CoroutineScope(Dispatchers.Default).launch{
            repeat(helpfulPercent)
            {
                helpfulPercentText++
                delay(1)
                updateHelpfulPercentProgressUI(helpfulPercentText)
            }




        }
    }

    private suspend fun updateHelpfulPercentProgressUI(transparentPercentText: Int) {
        withContext(Dispatchers.Main)
        {
            binding.helpfulTextView.text = transparentPercentText.toString()+"%"
        }
    }

    private fun professionalPercentProgress()
    {
        var professionalPercentText = 0
        CoroutineScope(Dispatchers.Default).launch{
            repeat(professionalPercent)
            {
                professionalPercentText++
                delay(1)
                updateProfessionalPercentProgressUI(professionalPercentText)
            } }
    }

    private suspend fun updateProfessionalPercentProgressUI(transparentPercentText: Int) {
        withContext(Dispatchers.Main)
        {
            binding.professionalTextView.text = transparentPercentText.toString()+"%"
        }
    }



    private fun apartmentDummy(): MutableList<Apartments> {
        val apartments :MutableList<Apartments> = ArrayList()
        apartments.add(Apartments("vensia", BitmapFactory.decodeResource(applicationContext.resources, R.drawable.dummy3), bedsNum = "8", bathsNum = "6", price = "450 EGP", squareSize = "700 M²",apartmentOverView = "Apartments in Ali Al Sibai St. 250 M² super lux Rent..."))
        apartments.add(Apartments("vensia", BitmapFactory.decodeResource(resources, R.drawable.dummy3), bedsNum = "10", bathsNum = "4", price = "1000 EGP", squareSize = "800 M²",apartmentOverView = "Apartments in Ali Al Sibai St. 250 M² super lux Rent..."))
        apartments.add(Apartments("vensia", BitmapFactory.decodeResource(resources, R.drawable.dummy3), bedsNum = "3", bathsNum = "6", price = "1200 EGP", squareSize = "900 M²",apartmentOverView = "Apartments in Ali Al Sibai St. 250 M² super lux Rent..."))
        apartments.add(Apartments("vensia", BitmapFactory.decodeResource(resources, R.drawable.dummy3), bedsNum = "2", bathsNum = "1", price = "200 EGP", squareSize = "200 M²",apartmentOverView = "Apartments in Ali Al Sibai St. 250 M² super lux Rent..."))
        return apartments
    }

    private fun apartmentRecycler() {
        apartmentRecyclerAdapter = ApartmentsAdapter()
        apartmentRecyclerAdapter.setDataAdapter(apartmentDummy())
        val linear = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.placesRecyclerHome.layoutManager = linear
        binding.placesRecyclerHome.adapter = apartmentRecyclerAdapter
        binding.placesRecyclerHome.addItemDecoration(SpacesItemDecoration(30))
    }

}