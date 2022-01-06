package com.example.todolist

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(
    private val todoList : MutableList<ToDoModel>,
) : RecyclerView.Adapter<Adapter.ToDoViewHolder>()
{
    class ToDoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val chk : CheckBox = itemView.findViewById(R.id.chkbox)
        val title: TextView = itemView.findViewById(R.id.task)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        return ToDoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.task_card_view,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val curToDo = todoList[position]
        holder.title.text = curToDo.title
        holder.chk.isChecked = curToDo.isChecked
        toggleStrikeThrough(holder.title,curToDo.isChecked)
        holder.chk.setOnCheckedChangeListener { _, isChecked ->
            toggleStrikeThrough(holder.title,isChecked)
            curToDo.isChecked != curToDo.isChecked
        }
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    private fun toggleStrikeThrough(title : TextView, isChecked: Boolean){
    if(isChecked)
    {
        title.paintFlags = title.paintFlags or STRIKE_THRU_TEXT_FLAG
    }
    else
    {
        title.paintFlags = title.paintFlags and STRIKE_THRU_TEXT_FLAG
    }
    }

    fun addItem(toDo : ToDoModel){
        todoList.add(toDo)
        notifyDataSetChanged()
    }

    fun removeItem(position: Int)
    {
        todoList.removeAt(position)
        notifyDataSetChanged()
    }
}