package com.apptikar.yaskon.ui
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.transition.TransitionInflater
import android.util.Log
import android.view.*
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.apptikar.yaskon.R
import com.apptikar.yaskon.databinding.FragmentStoryBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.coroutines.*


class Story : Fragment(){

    private lateinit var launch: Job
    private  lateinit var binding: FragmentStoryBinding
   private lateinit var nav: NavController
    private  val list = mutableListOf(
        R.drawable.dummy_story,
        R.drawable.dummy1,
        R.drawable.dummy_story
    )
   private var counter = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {



        binding = FragmentStoryBinding.inflate(layoutInflater)


        binding.storyProgressBar.segmentCount = list.size
        binding.storyProgressBar.start()

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nav = Navigation.findNavController(view)
        story()
        binding.leftView.setOnClickListener {
            launch.cancel()
            if (counter == list.size)
            {
                counter = list.size-2
            }else if (counter > 0) {

                counter--
            }

            binding.storyProgressBar.reset()
            binding.storyProgressBar.setPosition(counter)
            binding.storyProgressBar.start()
            story()
        }

        binding.rightView.setOnClickListener {
            launch.cancel()
            if (counter < list.size-1) {

                counter++
            }else
            {
                nav.popBackStack()

            }

            binding.storyProgressBar.next()

            story()
        }

        binding.closeImageView.setOnClickListener {
            nav.popBackStack()
        }
    }


    private fun story()
    {

        launch = viewLifecycleOwner.lifecycleScope.launch(newSingleThreadContext("timer")) {

                while (isActive && counter < list.size) {

                    withContext(Dispatchers.Main)
                    {
                        Glide.with(requireActivity()).load(list[counter])
                            .apply(RequestOptions.bitmapTransform(BlurTransformation(80, 3)))
                            .into(binding.blurBack)
                        Glide.with(requireActivity()).load(list[counter])
                            .into(binding.storyImageView)
                            delay(5000)
                        binding.storyProgressBar.next()
                        counter++
                    }
                }
            withContext(Dispatchers.Main)
            {
                (requireActivity() as HomeActivity).onBackPressed()
            }


        }

    }




    override fun onResume() {
        super.onResume()
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    override fun onDestroy() {
        super.onDestroy()
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
    }







}