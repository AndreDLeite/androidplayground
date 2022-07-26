package adl.appture.components.adapters

import adl.appture.components.R
import adl.appture.components.customviews.ExpandableItemModel
import adl.appture.components.customviews.ExpandableItemUIState
import adl.appture.extensions.gone
import adl.appture.extensions.visible
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class HeadersListAdapter: RecyclerView.Adapter<HeadersListAdapter.HeaderViewHolder>() {

    private var headersList: List<ExpandableItemModel> = listOf()

    fun setList(list: List<ExpandableItemModel>) {
        headersList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_expandable_list, parent, false)
        return HeaderViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        headersList[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int = headersList.size

    inner class HeaderViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val headerContainer = view.findViewById<ConstraintLayout>(R.id.cl_expandable_topics_header)
        private val headerTitle = view.findViewById<TextView>(R.id.tv_expandable_topics_title)
        private val headerIcon = view.findViewById<ImageView>(R.id.apciv_expandable_topics_image)
        private val itemContainer = view.findViewById<ConstraintLayout>(R.id.cl_items_container)
        private val itemList = view.findViewById<RecyclerView>(R.id.rv_topics_items)

        fun bind(header: ExpandableItemModel) {
            setupHeaderContainerBehaviour(header.state)
            setupHeaderTitle(header.text)
            setupIcon(header.icon)
            setupItemList(header.items)
        }

        private fun setupHeaderTitle(title: String) {
            headerTitle.text = title
        }

        private fun setupIcon(icon: Int?) {
            icon?.let {
                headerIcon.setImageResource(icon)
            } ?: run {
                headerIcon.gone
            }
        }

        private fun setupHeaderContainerBehaviour(state: ExpandableItemUIState) {
            headerContainer.setOnClickListener {
                if(state == ExpandableItemUIState.Expanded) {
                    itemContainer.visible
                } else {
                    itemContainer.gone
                }
            }
        }

        private fun setupItemList(items: List<*>) {
            items.filterIsInstance<String>().also {
                itemList.adapter = TextListAdapter(it)
            }
        }
    }
}