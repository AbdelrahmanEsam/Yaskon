package com.apptikar.yaskon.ui

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat.getColor
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.apptikar.yaskon.R
import com.apptikar.yaskon.adapters.*
import com.apptikar.yaskon.databinding.FragmentFirstBinding
import com.apptikar.yaskon.pojos.Apartments
import com.apptikar.yaskon.pojos.City
import com.apptikar.yaskon.pojos.PopularPlaces
import com.apptikar.yaskon.pojos.StoryHome
import de.hdodenhof.circleimageview.CircleImageView


class FirstFragment : Fragment(),StoriesAdapter.OnStoryListener,PropertyAdapter.OnPropertyListener {
    private lateinit var recyclerAdapter: CitiesAdapter
    private lateinit var propertyRecyclerAdapter: PropertyAdapter
    private lateinit var storiesRecyclerAdapter: StoriesAdapter
    private lateinit var popularPlacesAdapter: PopularPlacesAdapter
    private lateinit var recommendedRecyclerAdapter: PropertyAdapter
    private  lateinit var binding:FragmentFirstBinding
    private lateinit var nav: NavController
    private val  viewModel:SharedViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)
        binding.viewModel = viewModel
        requireActivity().window.statusBarColor = getColor(requireContext(), R.color.orange_500)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nav = Navigation.findNavController(view)
            recycler()
            apartmentRecycler()
            storiesRecycler()
            popularRecycler()
            recommendedRecycler()
        binding.searchTextView.setOnClickListener {
            deepSearch()
        }
        binding.profileImage.setOnClickListener {
            nav.navigate(R.id.action_firstFragment_to_accountListFragment)
        }

        binding.community.setOnClickListener {
            nav.navigate(R.id.action_firstFragment_to_communityFragment)
        }




    }

    private fun deepSearch()
    {
        nav.navigate(R.id.action_firstFragment_to_settingsAccountFragment)
    }





    private fun dummy() {
        viewModel.cities.value?.add(City("cairo", BitmapFactory.decodeResource(resources, R.drawable.f)))
        viewModel.cities.value?.add(City("alexandria", BitmapFactory.decodeResource(resources, R.drawable.g)))
        viewModel.cities.value?.add(City("dahab", BitmapFactory.decodeResource(resources, R.drawable.h)))
        viewModel.cities.value?.add(City("sharm el sheihk", BitmapFactory.decodeResource(resources, R.drawable.i)))
    }

    private fun recycler() {

        if (viewModel.cities.value?.isEmpty()!!) {
            dummy()
        }
            recyclerAdapter = CitiesAdapter()
            viewModel.cities.value?.let { recyclerAdapter.setDataAdapter(it) }

        val linear = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.citiesRecyclerHome.apply {
            layoutManager = linear
            adapter = recyclerAdapter
            addItemDecoration(SpacesItemDecoration(12))
        }

    }

    private fun apartmentDummy() {
        viewModel.properties.value?.add(Apartments("vensia", BitmapFactory.decodeResource(requireContext().resources, R.drawable.dummy3), bedsNum = "8", bathsNum = "6", price = "450 EGP", squareSize = "700 M²", apartmentOverView = "Apartments in Ali Al Sibai St. 250 M² super lux Rent..."))
        viewModel.properties.value?.add(Apartments("vensia", BitmapFactory.decodeResource(resources, R.drawable.dummy3), bedsNum = "10", bathsNum = "4", price = "1000 EGP", squareSize = "800 M²", apartmentOverView = "Apartments in Ali Al Sibai St. 250 M² super lux Rent..."))
        viewModel.properties.value?.add(Apartments("vensia", BitmapFactory.decodeResource(resources, R.drawable.dummy3), bedsNum = "3", bathsNum = "6", price = "1200 EGP", squareSize = "900 M²", apartmentOverView = "Apartments in Ali Al Sibai St. 250 M² super lux Rent..."))
        viewModel.properties.value?.add(Apartments("vensia", BitmapFactory.decodeResource(resources, R.drawable.dummy3), bedsNum = "2", bathsNum = "1", price = "200 EGP", squareSize = "200 M²", apartmentOverView = "Apartments in Ali Al Sibai St. 250 M² super lux Rent..."))
    }

    private fun apartmentRecycler() {
        if (viewModel.properties.value?.isEmpty() == true) {
            apartmentDummy()
        }
            propertyRecyclerAdapter = PropertyAdapter(this)
            viewModel.properties.value?.let { propertyRecyclerAdapter.setDataAdapter(it,"home") }


        val linear = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.placesRecyclerHome.apply {
            layoutManager = linear
            adapter = propertyRecyclerAdapter
            addItemDecoration(SpacesItemDecoration(30))
        }


    }

    private fun dummyStories() {

        viewModel.stories.value?.add(StoryHome("cresu", BitmapFactory.decodeResource(resources, R.drawable.cresu)))
        viewModel.stories.value?.add(StoryHome("cresu2", BitmapFactory.decodeResource(resources, R.drawable.cresu)))
        viewModel.stories.value?.add(StoryHome("cresu3", BitmapFactory.decodeResource(resources, R.drawable.cresu)))
        viewModel.stories.value?.add(StoryHome("cresu4", BitmapFactory.decodeResource(resources, R.drawable.g)))
        viewModel.stories.value?.add(StoryHome("cresu4", BitmapFactory.decodeResource(resources, R.drawable.g)))

    }


    private fun storiesRecycler() {
        if (viewModel.stories.value?.isEmpty() == true) {
            dummyStories()
        }
            storiesRecyclerAdapter = StoriesAdapter(this)
            viewModel.stories.value?.let { storiesRecyclerAdapter.setDataAdapter(it) }



        val linear = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.storiesRecyclerHome.apply {
            layoutManager = linear
            adapter = storiesRecyclerAdapter
            addItemDecoration(SpacesItemDecoration(22))

        }
    }


    private fun popularPlaces(): MutableList<PopularPlaces> {
        val popular :MutableList<PopularPlaces> = ArrayList()
        popular.add(PopularPlaces("vensia", place = "blue Hole", image = BitmapFactory.decodeResource(resources, R.drawable.dummy1)))
        popular.add(PopularPlaces("vensia", place = "blue Hole", image = BitmapFactory.decodeResource(resources, R.drawable.dummy2)))
        popular.add(PopularPlaces("vensia", place = "blue Hole", image = BitmapFactory.decodeResource(resources, R.drawable.dummy1)))
        popular.add(PopularPlaces("vensia", place = "blue Hole", image = BitmapFactory.decodeResource(resources, R.drawable.dummy2)))
        return popular
    }

    private fun popularRecycler() {
        popularPlacesAdapter = PopularPlacesAdapter()
        popularPlacesAdapter.setDataAdapter(popularPlaces())
        val linear = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.popularRecyclerHome.layoutManager = linear
        binding.popularRecyclerHome.adapter = popularPlacesAdapter
        binding.popularRecyclerHome.addItemDecoration(SpacesItemDecoration(20))
    }

    private fun recommendedDummy(): MutableList<Apartments> {
        val apartments :MutableList<Apartments> = ArrayList()
        apartments.add(Apartments("vensia", BitmapFactory.decodeResource(resources, R.drawable.dummy3), bedsNum = "8", bathsNum = "6", price = "450 EGP", squareSize = "700 M²", apartmentOverView = "Apartments in Ali Al Sibai St. 250 M² super lux Rent..."))
        apartments.add(Apartments("vensia", BitmapFactory.decodeResource(resources, R.drawable.dummy3), bedsNum = "10", bathsNum = "4", price = "1000 EGP", squareSize = "800 M²", apartmentOverView = "Apartments in Ali Al Sibai St. 250 M² super lux Rent..."))
        apartments.add(Apartments("vensia", BitmapFactory.decodeResource(resources, R.drawable.dummy3), bedsNum = "3", bathsNum = "6", price = "1200 EGP", squareSize = "900 M²", apartmentOverView = "Apartments in Ali Al Sibai St. 250 M² super lux Rent..."))
        apartments.add(Apartments("vensia", BitmapFactory.decodeResource(resources, R.drawable.dummy3), bedsNum = "2", bathsNum = "1", price = "200 EGP", squareSize = "200 M²", apartmentOverView = "Apartments in Ali Al Sibai St. 250 M² super lux Rent..."))
        return apartments
    }

    private fun recommendedRecycler() {
        recommendedRecyclerAdapter = PropertyAdapter(this)
        recommendedRecyclerAdapter .setDataAdapter(recommendedDummy(), "home")
        val linear = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.highlyRecommendedRecyclerHome.layoutManager = linear
        binding.highlyRecommendedRecyclerHome.adapter = recommendedRecyclerAdapter
        binding.highlyRecommendedRecyclerHome.addItemDecoration(SpacesItemDecoration(30))
    }


    override fun onStoryClicked(border: CircleImageView, storyImage: CircleImageView, position: Int) {
        storiesRecyclerAdapter.data[position].seen = true
        storiesRecyclerAdapter.notifyItemChanged(position)
        nav.navigate(R.id.action_firstFragment_to_story)
    }

    override fun onPropertyClicked(apartmentImage: ImageView, position: Int) {
        nav.navigate(R.id.action_firstFragment_to_propertyFragment)
    }


}