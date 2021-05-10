package com.apptikar.yaskon.ui
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.apptikar.yaskon.pojos.*
import java.util.*
import kotlin.collections.ArrayList

class SharedViewModel :ViewModel() {

    private  val _cities  = MutableLiveData<MutableList<City>>()
    val cities: LiveData<MutableList<City>>get() = _cities

    private val _stories = MutableLiveData<MutableList<StoryHome>>()
    val stories: LiveData<MutableList<StoryHome>>get() = _stories

    private val _properties = MutableLiveData<MutableList<Apartments>>()
    val properties: LiveData<MutableList<Apartments>>get() = _properties

    private val _tags  = MutableLiveData<MutableList<Tag>>()
    val tags: LiveData<MutableList<Tag>>get() = _tags

    private val _chosenTags  = MutableLiveData<MutableList<String>>()

    private val _amenities  = MutableLiveData<MutableList<Amenities>>()
    val amenities: LiveData<MutableList<Amenities>>get() = _amenities

    private val _chosenAmenities  = MutableLiveData<MutableList<String>>()


    private val _rentOrBuy = MutableLiveData<String>()
    val rentOrBuy: LiveData<String> get() = _rentOrBuy

    private val _minPriceRange = MutableLiveData<String>()
    val minPriceRange: LiveData<String> get() = _minPriceRange

    private val _maxPriceRange = MutableLiveData<String>()
    val maxPriceRange: LiveData<String> get() = _maxPriceRange

    private val _beds = MutableLiveData<Int>()
    val beds: LiveData<Int> get() = _beds

    private val _previousBeds = MutableLiveData<Int>()
    val previousBeds: LiveData<Int> get() = _previousBeds


    private val _bedrooms = MutableLiveData<Int>()
    val bedrooms: LiveData<Int> get() = _bedrooms

    private val _previousBedsRooms = MutableLiveData<Int>()
    val previousBedsRooms: LiveData<Int> get() = _previousBedsRooms

    private val _bathrooms = MutableLiveData<Int>()
    val bathrooms: LiveData<Int> get() = _bathrooms

    private val _previousBathRooms = MutableLiveData<Int>()
    val previousBathRooms: LiveData<Int> get() = _previousBathRooms

    private val _greenHouse = MutableLiveData<Boolean>()
    val greenHouse: LiveData<Boolean> get() = _greenHouse

    private val _topTen = MutableLiveData<Boolean>()
    val topTen: LiveData<Boolean> get() = _topTen

    private val _verified = MutableLiveData<Boolean>()
    val verified: LiveData<Boolean> get() = _verified


    fun setCities(cities:MutableList<City>)
    {
        _cities.value = cities
    }

    fun setStories(stories:MutableList<StoryHome>)
    {
        _stories.value = stories
    }

    fun setProperties( properties:MutableList<Apartments>)
    {
        _properties.value = properties
    }

    fun setTags( tags:MutableList<Tag>)
    {
        _tags.value = tags
    }



    fun setRentOrBuy(rentOrBuyValue:String)
    {
        _rentOrBuy.value = rentOrBuyValue
    }
    fun minPriceRange(minPrice:String)
    {
        _minPriceRange.value = minPrice
    }

    fun maxPriceRange(maxPrice:String)
    {
        _maxPriceRange.value = maxPrice
    }

    fun beds(beds:Int)
    {
        _beds.value = beds
    }

    fun previousBeds(previousBeds:Int)
    {
        _previousBeds.value = previousBeds
    }

    fun bedsRooms(bedrooms:Int)
    {
        _bedrooms.value = bedrooms
    }

    fun previousBedsRooms(previousBedRooms:Int)
    {
        _previousBedsRooms.value = previousBedRooms
    }


    fun bathRooms(baths:Int)
    {
        _bathrooms.value = baths
    }

    fun previousBathRooms(previousBaths:Int)
    {
        _previousBathRooms.value = previousBaths
    }

    fun greenHouse()
    {
        _greenHouse.value = !_greenHouse.value!!
    }

    fun topTen()
    {
        _topTen.value = !_topTen.value!!
    }

    fun verified()
    {
        _verified.value = !_verified.value!!
    }


    fun chosenTags(position:Int)
    {
        _tags.value?.get(position)?.let { _chosenTags.value?.add(it.tag) }
    }

    fun chosenAmenities(position:Int)
    {
        _amenities.value?.get(position)?.let { _chosenAmenities.value?.add(it.amenityName) }
    }


    fun setAmenities()
    {
        _amenities.value = ArrayList()
        _amenities.value?.add(Amenities("WIFI"))
        _amenities.value?.add(Amenities("Self check-in"))
        _amenities.value?.add(Amenities("Laptop-friendly"))



    }

    fun viewAllAmenities()
    {
        _amenities.value?.add(Amenities("workspaces"))
        _amenities.value?.add(Amenities("Free parking"))
        _amenities.value?.add(Amenities("Pet-friendly spaces"))
        _amenities.value?.add(Amenities("Instant Book"))
        _amenities.value?.add(Amenities("Laptop-friendly "))
        _amenities.value?.add(Amenities("Good lighting"))
        _amenities.value?.add(Amenities("Fully equipped kitchens"))
        _amenities.value?.add(Amenities("Office supplies"))
        _amenities.value?.add(Amenities("TV"))
        _amenities.value?.add(Amenities("air conditioning"))
        _amenities.value?.add(Amenities("Breakfast"))
    }

  fun dummyTags()
    {
        _tags.value?.add(Tag("Studio"))
        _tags.value?.add(Tag("Apartment"))
        _tags.value?.add(Tag("Furnished apartment"))
    }

    fun initDeepSearch()
    {
        setAmenities()
        _tags.value?.forEach { it.selected = false }
        _amenities.value?.forEach { it.checked = false }
        _rentOrBuy.value = "Rent"
        beds.value?.let {previousBeds(it) }
        bedrooms.value?.let {previousBedsRooms(it) }
        bathrooms.value?.let {previousBathRooms(it)}
        _beds.value = 1
        _bedrooms.value = 1
        _bathrooms.value = 1
        _greenHouse.value = false
        _topTen.value = false
        _verified.value = false
        _minPriceRange.value = "400 EGP"
        _maxPriceRange.value = "700 EGP"
        _chosenTags.value = ArrayList()
        _chosenAmenities.value = ArrayList()

    }










    init {

        _cities.value  = ArrayList()
        _stories.value = ArrayList()
        _properties.value = ArrayList()
        _tags.value = ArrayList()
        _chosenTags.value = ArrayList()
        _chosenAmenities.value = ArrayList()
        setAmenities()
        _rentOrBuy.value = "Rent"
        _beds.value = 1
        _bedrooms.value = 1
        _bathrooms.value = 1
        _greenHouse.value = false
        _topTen.value = false
        _verified.value = false
        _minPriceRange.value = "400 EGP"
        _maxPriceRange.value = "700 EGP"
    }

}