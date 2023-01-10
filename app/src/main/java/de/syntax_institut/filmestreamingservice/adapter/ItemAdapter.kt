package de.syntax_institut.filmestreamingservice.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.syntax_institut.filmestreamingservice.R
import de.syntax_institut.filmestreamingservice.data.model.Movie

/**
 * Der Item Adapter weist den views im ViewHolder den Inhalt zu
 */
class ItemAdapter(
    private val context: Context,
    private val dataset: List<Movie>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    /**
     * der ViewHolder umfasst die View uns stellt einen Listeneintrag dar
     */
    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // TODO Schreibe hier deinen Code
        val textView = itemView.findViewById<TextView>(R.id.movieTitle_text)
        val imageView = itemView.findViewById<ImageView>(R.id.movie_Image)
    }

    /**
     * hier werden neue ViewHolder erstellt
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        // das itemLayout wird gebaut
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        // und in einem ViewHolder zurückgegeben
        return ItemViewHolder(itemView)
    }

    /**
     * hier findet der Recyclingprozess statt
     * die vom ViewHolder bereitgestellten Parameter erhalten die Information des Listeneintrags
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // TODO Schreibe hier deinen Code
        val movie = dataset[position]
        val text_View = holder.textView
        text_View.text = context.getString((movie.stringResource))

        val image_View = holder.imageView
        image_View.setImageResource(movie.imageRessource)
    }

    /**
     * damit der LayoutManager weiß, wie lang die Liste ist
     */
    override fun getItemCount(): Int {
        return dataset.size
    }
}
