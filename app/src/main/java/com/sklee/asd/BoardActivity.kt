package com.sklee.asd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_board.*

class BoardActivity : AppCompatActivity() {

    private val data = arrayListOf<Text>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = MyAdapter(data)

        add_button.setOnClickListener{
            add()
        }
    }

    private fun add() {
        val input = Text(editText.text.toString())
        data.add(input)
        recycler_view.adapter?.notifyDataSetChanged()
    }


}
data class Text(
    val text: String,
    var isDone: Boolean = false)

class MyAdapter(private val myDataset: List<Text>) :
    RecyclerView.Adapter<MyAdapter.myViewHolder>() {


    class myViewHolder(val view: View) : RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyAdapter.myViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return myViewHolder(view)
    }


    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val textView = holder.view.findViewById<TextView>(R.id.list_text)
        textView.text = myDataset[position].text
    }

    override fun getItemCount() = myDataset.size
}
