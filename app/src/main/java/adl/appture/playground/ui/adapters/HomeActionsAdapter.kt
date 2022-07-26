package adl.appture.playground.ui.adapters

import adl.appture.playground.R
import adl.appture.playground.domain.model.HomeCardEnum
import adl.appture.playground.domain.model.HomeCardModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class HomeActionsAdapter(
    private val cardsList: List<HomeCardModel>,
    private val listener: CardActionsListener
) : RecyclerView.Adapter<HomeActionsAdapter.HomeCardsViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeActionsAdapter.HomeCardsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_home_options_card, parent, false)
        return HomeCardsViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeActionsAdapter.HomeCardsViewHolder, position: Int) {
        cardsList[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int = cardsList.size

    inner class HomeCardsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val cardContainer = view.findViewById<ConstraintLayout>(R.id.cl_card_container)
        private val cardName = view.findViewById<TextView>(R.id.tv_card_name)

        fun bind(cardModel: HomeCardModel) {
            setupCardClick(cardModel.cardType)
            setCardName(cardModel.cardName)
            setCardColor(cardModel.cardColor)
        }

        private fun setupCardClick(cardType: HomeCardEnum) {
            cardContainer.setOnClickListener {
                listener.onCardClicked(cardType)
            }
        }

        private fun setCardName(name: String) {
            cardName.text = name
        }

        private fun setCardColor(color: Int) {
            cardContainer.setBackgroundColor(color)
        }
    }

    interface CardActionsListener {
        fun onCardClicked(cardType: HomeCardEnum)
    }

}