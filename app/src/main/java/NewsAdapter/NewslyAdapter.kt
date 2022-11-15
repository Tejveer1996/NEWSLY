package NewsAdapter

import ModelClass.Article
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.example.newsly.MainActivity
import com.example.newsly.R
import com.example.newsly.detail_Activity


class NewslyAdapter( private val context: Context, private val articles: List<Article>) :
    Adapter<NewslyAdapter.ArticleViewHolder>() {


    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.newsImage)
        var title: TextView = itemView.findViewById(R.id.textView)
        var description: TextView = itemView.findViewById(R.id.newsDescription)
        var shareImage: ImageView = itemView.findViewById(R.id.imageView2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]
        holder.title.text = article.title
        holder.description.text = article.description

        Glide.with(context).load(article.urlToImage).into(holder.imageView)

        holder.shareImage.setOnClickListener {
            val message =
                "Latest News " + article.title + "\n" + article.description +"\n"+ article.urlToImage+"\n"+article.url
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"
            context.startActivity(Intent.createChooser(intent, "Select the app"))
        }
        holder.itemView.setOnClickListener{
            Toast.makeText(context,article.title,Toast.LENGTH_LONG).show()
            val intent = Intent(context,detail_Activity::class.java)
            intent.putExtra("URL",article.url)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return articles.size
    }
}