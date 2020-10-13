package com.google.codelabs.mdc.kotlin.shrine

import android.os.Build
import android.os.Bundle
import android.view.*
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.codelabs.mdc.kotlin.shrine.network.ProductEntry
import com.google.codelabs.mdc.kotlin.shrine.staggeredgridlayout.StaggeredProductCardRecyclerViewAdapter
import kotlinx.android.synthetic.main.shr_product_grid_fragment.*
import kotlinx.android.synthetic.main.shr_product_grid_fragment.view.*

class ProductGridFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.shr_product_grid_fragment, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.shr_toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, menuInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up the toolbar.
        (activity as AppCompatActivity).setSupportActionBar(view.app_bar)
        setHasOptionsMenu(true)

        //This listener is implemented by "us" it was already downloaded
       // app_bar.setNavigationOnClickListener(NavigationIconClickListener(activity!!, product_grid))
       // app_bar.setNavigationOnClickListener(NavigationIconClickListener(activity!!, view.product_grid, AccelerateDecelerateInterpolator()))
        customIconAndShowBackMenu()

        addShapeToToolBar()

        //setUpRecyclerView()
        setUpStaggeredRecyclerView()
    }

    private fun setUpRecyclerView(){
        // Set up the RecyclerView
        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)

        val adapter = ProductCardRecyclerViewAdapter(
                ProductEntry.initProductEntryList(resources))

        recycler_view.adapter = adapter

        val largePadding = resources.getDimensionPixelSize(R.dimen.shr_product_grid_spacing)
        val smallPadding = resources.getDimensionPixelSize(R.dimen.shr_product_grid_spacing_small)

        recycler_view.addItemDecoration(ProductGridItemDecoration(largePadding, smallPadding))
    }

    private fun setUpStaggeredRecyclerView(){
        recycler_view.setHasFixedSize(true)

        val gridLayoutManager = GridLayoutManager(context, 2, RecyclerView.HORIZONTAL, false)

        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (position % 3 == 2) 2 else 1
            }
        }

        recycler_view.layoutManager = gridLayoutManager

        val adapter = StaggeredProductCardRecyclerViewAdapter(
                ProductEntry.initProductEntryList(resources))
        recycler_view.adapter = adapter

        val largePadding = resources.getDimensionPixelSize(R.dimen.shr_staggered_product_grid_spacing_large)
        val smallPadding = resources.getDimensionPixelSize(R.dimen.shr_staggered_product_grid_spacing_small)

        recycler_view.addItemDecoration(ProductGridItemDecoration(largePadding, smallPadding))
    }

    private fun addShapeToToolBar(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            product_grid.background = context?.getDrawable(R.drawable.shr_product_grid_background_shape)
        }
    }

    private fun customIconAndShowBackMenu(){
        app_bar.setNavigationOnClickListener(NavigationIconClickListener(
                activity!!,
                product_grid,
                AccelerateDecelerateInterpolator(),
                ContextCompat.getDrawable(context!!, R.drawable.shr_branded_menu), // Menu open icon
                ContextCompat.getDrawable(context!!, R.drawable.shr_close_menu))) // Menu close icon
    }
}
