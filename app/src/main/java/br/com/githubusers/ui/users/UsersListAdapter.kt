package br.com.githubusers.ui.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.domain.model.User
import br.com.githubusers.databinding.UserItemBinding
import br.com.githubusers.ui.extension.image

class UsersListAdapter(private val onClick: (String) -> Unit) : ListAdapter<User, UsersListAdapter.UsersViewHolder>(UsersDiffItemCallback()) {
    class UsersViewHolder(val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        return UsersViewHolder(
            UserItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.binding.userImage.image(currentList[position].avatarUrl)
        holder.binding.userLogin.text = currentList[position].login
        holder.binding.userContainer.setOnClickListener {
            onClick(currentList[position].login)
        }
    }
}

class UsersDiffItemCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}