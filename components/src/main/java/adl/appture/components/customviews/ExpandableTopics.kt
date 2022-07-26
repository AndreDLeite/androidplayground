package adl.appture.components.customviews

import adl.appture.components.R
import adl.appture.components.adapters.HeadersListAdapter
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class ExpandableTopics @JvmOverloads
constructor(context: Context, attrs: AttributeSet? = null, defStylesAttr: Int = 0) :
    ConstraintLayout(context, attrs, defStylesAttr) {

    private val headersListAdapter: HeadersListAdapter = HeadersListAdapter()

    private val rvExpandableTopics: RecyclerView
        get() = findViewById(R.id.rv_expandable_topics)

    init {
        LayoutInflater.from(context).inflate(R.layout.view_expandable_topics, this, true)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        rvExpandableTopics.adapter = headersListAdapter
    }

    fun setupList(list: List<ExpandableItemModel>) {
        headersListAdapter.setList(list)
    }

}

data class ExpandableItemModel(
    val text: String,
    val icon: Int?,
    val items: List<*>,
    var state: ExpandableItemUIState
) {
    fun changeState() {
        state = if(state == ExpandableItemUIState.Expanded) {
            ExpandableItemUIState.Retracted
        } else {
            ExpandableItemUIState.Expanded
        }
    }
}

sealed class ExpandableItemUIState {
    object Expanded: ExpandableItemUIState()
    object Retracted: ExpandableItemUIState()
}