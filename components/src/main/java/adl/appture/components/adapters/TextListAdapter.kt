package adl.appture.components.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TextListAdapter(private val textList: List<String>): RecyclerView.Adapter<TextListAdapter.TextListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextListViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: TextListViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    inner class TextListViewHolder(view: View): RecyclerView.ViewHolder(view) {

    }
}