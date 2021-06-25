package com.faridrama123.transgeo.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.faridrama123.transgeo.R
import com.faridrama123.transgeo.databinding.FragmentMenu2Binding
import com.faridrama123.transgeo.ui.adapter.TransformAdapter
import com.faridrama123.transgeo.ui.model.Transform


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentMenu2.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentMenu2 : Fragment() {

    var bindingfragment : FragmentMenu2Binding? = null
    val binding get() = bindingfragment
   // private lateinit var binding: FragmentMenu2Binding


    private lateinit var transformAdapter: TransformAdapter


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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
   //     return inflater.inflate(R.layout.fragment_menu2, container, false)
        bindingfragment = FragmentMenu2Binding.inflate(inflater, container, false)
        return binding?.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentMenu2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
                FragmentMenu2().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                    }
                }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        transformAdapter = TransformAdapter()

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)

            when (param1){
                "TRANSLASI" ->   initDataTranslasi()
                "DILATASI" ->    initDataDilatasi()
                "ROTASI" ->   initDataRotasi()
                "REFLEKSI" ->  initDataRefleksi()


            }
        }

        initRecyclerView()
        initClick()




    }

    private fun setCurrentItem(position: Int, smooth: Boolean) {
        if (smooth) binding?.rvtransform?.smoothScrollToPosition(position)
        else binding?.rvtransform?.scrollToPosition(
            position
        )
    }
    private fun getCurrentItem(): Int {
        return (binding?.rvtransform?.getLayoutManager() as LinearLayoutManager)
            .findFirstVisibleItemPosition()
    }
    private fun initRecyclerView (){
        with(binding?.rvtransform) {
            val layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
            this?.layoutManager = layoutManager
            this?.setHasFixedSize(true)
            this?.adapter = transformAdapter

        }
    }

    private fun initDataTranslasi (){
        val transform : List<Transform>
        transform = ArrayList()
        transform.add(Transform(R.drawable.translasi1))
        transform.add(Transform(R.drawable.translasi2))
        transform.add(Transform(R.drawable.translasi1))
        transform.add(Transform(R.drawable.translasi2))
        transformAdapter.setData(transform)
    }

    private fun initDataRotasi (){
        val transform : List<Transform>
        transform = ArrayList()
        transform.add(Transform(R.drawable.rotasi1))
        transform.add(Transform(R.drawable.rotasi2))
        transform.add(Transform(R.drawable.rotasi3))
        transformAdapter.setData(transform)
    }

    private fun initDataRefleksi (){
        val transform : List<Transform>
        transform = ArrayList()
        transform.add(Transform(R.drawable.refleksi1))
        transform.add(Transform(R.drawable.refleksi2))
        transform.add(Transform(R.drawable.refleksi3))
        transform.add(Transform(R.drawable.refleksi4))
        transformAdapter.setData(transform)
    }

    private fun initDataDilatasi (){
        val transform : List<Transform>
        transform = ArrayList()
        transform.add(Transform(R.drawable.dilatasi1))
        transform.add(Transform(R.drawable.dilatasi2))
        transform.add(Transform(R.drawable.dilatasi3))
        transformAdapter.setData(transform)
    }



    fun initClick (){
        binding?.next?.setOnClickListener {

            //  binding?.next?.setText(getCurrentItem().toString())
            val adapter  = binding?.rvtransform?.getAdapter()


            val position = getCurrentItem()
            val count = adapter!!.itemCount
            if (position < count - 1) setCurrentItem(position + 1, true)


        }

        binding?.prev?.setOnClickListener {

            val position = getCurrentItem()
            if (position > 0) setCurrentItem(position - 1, true)

        }


    }


}